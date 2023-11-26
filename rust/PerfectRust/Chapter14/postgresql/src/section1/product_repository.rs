use anyhow::Error;
use postgres::Transaction;
use postgres::types::Type;
use crate::section1::entities::Product;
use crate::section1::repository::Repository;

/// ## 14-4.CRUD操作
/// ### リスト14.8 Repositoryトレイトの実装
/// ### productテーブルをアクセスするRepository
pub struct ProductRepository<'a, 'b>(pub &'a mut Transaction<'b>);
impl Repository<Product, i32, u64> for ProductRepository<'_, '_> {
    /// ## 14-5.CRUD操作の実装
    /// ### リスト14.9 select_allメソッドの実装
    fn select_all(&mut self) -> anyhow::Result<Vec<Product>> {
        println!("全件取得");
        // 利用するSQLステートメント
        let sql = "SELECT id, name, price, category_id FROM product";
        // 問い合わせの実行
        let rows = self.0.query(sql, &[])?;

        // 問い合わせ結果を取得してベクタに格納する
        let mut products = Vec::<Product>::new();
        for row in rows.iter() {
            // 各列の値を取り出して、Productに格納してからVecに格納する
            products.push(Product::new(
                row.get("id"), row.get("name"), row.get("price"),
                row.get("category_id"), None));
        }
        Ok(products)
    }

    /// ### リスト14.10 select_by_idメソッドの実装
    /// ### 引数 id: 商品番号
    fn select_by_id(&mut self, id: i32) -> anyhow::Result<Product> {
        println!("1件取得:{}", id);
        // 利用するSQLステートメント
        let sql = "SELECT id, name, price, category_id FROM product WHERE id = $1";
        // プレースホルダの型設定
        let stmt = self.0.prepare_typed(sql, &[Type::INT4])?;
        // 問い合わせの実行
        let result = self.0.query_opt(&stmt, &[&id])?;

        match result {
            Some(row) => Ok(Product::new(
                row.get("id"), row.get("name"), row.get("price"),
                row.get("category_id"), None
            )),
            None => Err(Error::msg(format!("指定された値:{}に該当するレコードが存在しません。", id)))
        }
    }
    /// ### リスト14.12 insertメソッドの実装
    /// ### 引数 row: 追加商品
    fn insert(&mut self, row: Product) -> anyhow::Result<u64> {
        println!("追加:{}", row.to_string());
        // 利用するSQLステートメントとプレースホルダの型設定
        let stmt = self.0.prepare_typed(
            "INSERT INTO product VALUES(nextval('product_seq'),$1,$2,$3)",
            &[Type::VARCHAR,Type::INT4,Type::INT4])?;
        let result = self.0.execute(&stmt,&[row.get_name(), row.get_price(), row.get_category_id()])?;
        Ok(result)
    }
}

impl ProductRepository<'_, '_> {
    /// ### リスト14.15 avg_by_priceメソッドの実装
    /// ### 戻り値 f64 単価の平均
    pub fn avg_by_price<'a>(&mut self) -> Result<f64, Error> {
        let row = self.0.query_one(
            "SELECT CAST(AVG(price) AS FLOAT) AS price_avg FROM product", &[])?;
        let result = row.get("price_avg");
        Ok(result)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::section1::transaction::TransactionUtil;
    use crate::section1::services::PostgreSQLService;

    #[test]
    // select_allメソッドのテスト
    fn select_all() -> Result<(), Error> {
        // Clientの取得
        let mut client = PostgreSQLService::create_client().unwrap();
        // トランザクションを開始する
        let mut transaction = TransactionUtil::start(&mut client, true)?;
        // ProductRepositoryを生成する
        let mut repository = ProductRepository(&mut transaction);
        let result = repository.select_all();
        match result {
            Ok(products) => {
                for product in products {
                    println!("{:?}", product.to_string());
                }
            },
            Err(error) => println!("{:?}", error.to_string())
        }
        Ok(())
    }

    #[test]
    // select_by_idメソッドのテスト
    fn select_by_id() -> Result<(), Error> {
        // Clientの取得
        let mut client = PostgreSQLService::create_client().unwrap();
        // トランザクションを開始する
        let mut transaction = TransactionUtil::start(&mut client, true)?;
        // ProductRepositoryを生成する
        let mut repository = ProductRepository(&mut transaction);
        // 存在する主キーでレコードを取得する
        let mut result = repository.select_by_id(1);
        match result {
            Ok(product) => println!("{:?}", product.to_string()),
            Err(_) => assert!(false)
        }
        // 存在しない主キーでレコードを取得する
        result = repository.select_by_id(1000);
        match result {
            Ok(_) => assert!(false),
            Err(error) => println!("{:?}", error.to_string())
        }
        Ok(())
    }

    #[test]
    fn insert() -> Result<(), Error> {
        let mut client = PostgreSQLService::create_client().unwrap();
        let mut transaction = TransactionUtil::start(&mut client, false)?;
        let mut repository = ProductRepository(&mut transaction);
        let product = Product::new(0, "商品-ABC".to_string(), 200, 1, None);
        let result = repository.insert(product);
        match result {
            Ok(count) => {
                let _ = TransactionUtil::commit(transaction)?;
                assert_eq!(count, 1);
            },
            Err(_) => {
                let _ = TransactionUtil::rollback(transaction)?;
                assert!(false)
            }
        }
        Ok(())
    }

    #[test]
    // avg_by_priceメソッドのテスト
    fn avg_by_price() -> Result<(), Error> {
        // Clientの取得
        let mut client = PostgreSQLService::create_client().unwrap();
        // トランザクションを開始する
        let mut transaction = TransactionUtil::start(&mut client, true)?;
        // ProductRepositoryを生成する
        let mut repository = ProductRepository(&mut transaction);
        let result = repository.avg_by_price();
        match result {
            Ok(avg) => println!("平均:{}", avg),
            Err(error) => println!("{:?}", error.to_string())
        }
        Ok(())
    }
}
