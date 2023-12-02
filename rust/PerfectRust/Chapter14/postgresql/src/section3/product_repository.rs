use anyhow::Result;
use tokio_postgres::Transaction;
use async_trait::async_trait;
use crate::section1::entities::Product;
use crate::section3::repository::AsyncRepository;
/// ## 14-7.非同期実行
/// ### リスト14.24 AsyncRepositoryトレイトの実装
/// ### ProductテーブルにアクセスするRepository
pub struct ProductRepository<'a, 'b> {
    transaction: &'a mut Transaction<'b>
}
impl <'a, 'b> ProductRepository<'a, 'b>{
    /// ### リスト14.24 AsyncRepositoryトレイトの実装
    /// ### インスタンスの生成
    pub fn new(_tran: &'a mut Transaction<'b>) -> Self {
        Self { transaction: _tran }
    }
}
#[async_trait]
impl AsyncRepository<Product, i32, bool> for ProductRepository<'_, '_> {
    /// ### リスト14.24 AsyncRepositoryトレイトの実装
    /// ### 全件取得
    async fn select_all(&mut self) -> Result<Vec<Product>> {
        let sql = "SELECT id, name, price, category_id FROM product";
        let rows = self.transaction.query(sql, &[]).await?;
        let mut products = Vec::<Product>::new();
        for row in rows.iter() {
            products.push(Product::new(row.get("id"), row.get("name"), row.get("price"), row.get("category_id"), None));
        }
        Ok(products)
    }
    /// ### １件取得（未実装）
    async fn select_by_id(&mut self, id: i32) -> Result<Product> {
        todo!()
    }
    /// ### 追加（未実装）
    async fn insert(&mut self, row: Product) -> Result<()> {
        todo!()
    }
    /// ### 更新（未実装）
    async fn update_by_id(&mut self, id: i32) -> Result<bool> {
        todo!()
    }
    /// ### 削除（未実装）
    async fn delete_by_id(&mut self, id: i32) -> Result<bool> {
        todo!()
    }
}

#[cfg(test)]
pub mod tests {
    use super::*;
    use anyhow::Result;
    use crate::section3::connect::AsyncSimpleClient;
    use crate::section3::transaction::AsyncTransactionUtil;

    // select_all()メソッドのテスト
    #[tokio::test]
    async fn select_all() -> Result<()> {
        // データベース接続
        let mut client = AsyncSimpleClient::connect().await?;
        // トランザクションの開始
        let mut transaction = AsyncTransactionUtil::start(&mut client, true).await?;
        // ProductRepositoryの生成
        let mut repository = ProductRepository::new(&mut transaction);
        let products = repository.select_all().await?;  // 問い合わせの実行
        for product in products {
            println!("{:?}", product.to_string());
        }
        Ok(())
    }
}
