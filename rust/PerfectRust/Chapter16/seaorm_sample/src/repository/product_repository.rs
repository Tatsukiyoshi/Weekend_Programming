use anyhow::{Error, Result};
use async_trait::async_trait;
use sea_orm::{ActiveModelTrait, ColumnTrait, ConnectionTrait, DatabaseTransaction, DbBackend, EntityTrait, IntoActiveModel, QueryFilter, QueryOrder, Statement};
use sea_orm::ActiveValue::Set;
use crate::models::prelude::{Product, ProductCategory};
use crate::models::{product, product_category};
use crate::models::product::Model;
use crate::repository::repository::Repository;

/// ## 16-4. CRUD操作の準備
/// ### リスト16.7 productテーブルにアクセス構造体
pub struct ProductRepository;
impl ProductRepository {
    pub fn new() -> Self {
        Self
    }
}
#[async_trait]
impl Repository for ProductRepository {
    type T = DatabaseTransaction;
    type M = Model;

    /// ### 16-5. CRUD操作の実装
    /// ### リスト16.8 全件取得
    async fn select_all(&self, tran: &Self::T) -> Result<Vec<Self::M>> {
        let result = Product::find().all(tran).await?;
        Ok(result)
    }

    /// ### リスト16.10 主キー問い合わせ
    async fn select_by_id(&self, tran: &Self::T, id: i32) -> Result<Self::M> {
        let result = Product::find_by_id(id).one(tran).await?;
        match result {
            Some(r) => Ok(r),
            None => Err(Error::msg(format!("id:{}に一致する商品は存在しません。", id)))
        }
    }

    /// ### リスト16.11 部分一致検索
    async fn select_by_name_like(&self, tran: &Self::T, keyword: &str) -> Result<Vec<Self::M>> {
        use crate::models::product;
        let results = Product::find()
            .filter(product::Column::Name.contains(keyword))
            .order_by_asc(product::Column::Name)
            .all(tran).await?;
        Ok(results)
    }

    /// ### リスト16.12 レコードの追加
    async fn insert(&self, tran: &Self::T, row: Self::M) -> Result<Self::M> {
        // ActiveModelを取得する
        let new_product = row.into_active_model();
        let insert_result = new_product.insert(tran).await?;
        Ok(insert_result)
    }

    /// ### リスト16.14 レコードの更新
    async fn update_by_id(&self, tran: &Self::T, row: Self::M) -> Result<Self::M> {
        // 更新対象を取得する
        let target = Product::find_by_id(row.id).one(tran).await?;
        if target.is_none() {
            return Err(Error::msg(format!("id:{}に一致する商品は存在しません。", row.id)))
        }
        // ActiveModelを取得する
        let mut update_row = target.unwrap().into_active_model();
        // 値を変更する
        update_row.name = Set(row.name);
        update_row.price = Set(row.price);
        update_row.category_id = Set(row.category_id);
        let update_result = update_row.update(tran).await?;
        Ok(update_result)
    }

    /// ### リスト16.15 レコードの削除
    async fn delete_by_id(&self, tran: &Self::T, id: i32) -> Result<u64> {
        let target = Product::find_by_id(id).one(tran).await?;
        if target.is_none() {
            return Err(Error::msg(format!("id:{}に一致する商品は存在しません。", id)))
        }
        // ActiveModelを取得する
        let delete_row = target.unwrap().into_active_model();
        let delete_result = delete_row.delete(tran).await?;
        Ok(delete_result.rows_affected)
    }

    /// ### リスト16.17 1:1結合
    async fn select_by_id_join_product_category(&self, tran: &DatabaseTransaction, id: i32)
        -> Result<Vec<(product::Model, Option<product_category::Model>)>> {
        let product_and_category = Product::find_by_id(id)
            .find_also_related(ProductCategory)
            .all(tran).await?;
        Ok(product_and_category)
    }

    /// ### リスト16.18 問い合わせの実装
    async fn select_by_id_stmt(&self, tran: &DatabaseTransaction, id: i32) -> Result<Model> {
        let stmt = Statement::from_sql_and_values(
            DbBackend::Postgres,    // データベースの種類を設定する
            // 利用するSQLステートメントを設定
            "SELECT id, name, price, category_id FROM product WHERE id = $1",
            vec![id.into()]);   // プレースホルダにマッピングする値を設定する
        let result = Product::find().from_raw_sql(stmt).one(tran).await?;
        match result {
            Some(r) => Ok(r),
            None => Err(Error::msg(format!("id:{}に一致する商品が見つかりません。", id)))
        }
    }

    /// ### リスト16.19 更新系SQLの実行
    async fn insert_stmt(&self, tran: &DatabaseTransaction, row: Model) -> Result<u64> {
        let stmt = Statement::from_sql_and_values(
            DbBackend::Postgres,    // データベースの種類を設定
            // 利用するSQLステートメントを設定
            "INSERT INTO product (name, price, category_id) VALUES ($1, $2, $3)",
            // プレースホルダにマッピングする値を設定する
            vec![row.name.into(), row.price.into(), row.category_id.into()]);
        let result = tran.execute(stmt).await?;
        Ok(result.rows_affected())
    }
}

mod tests {
    use anyhow::{Error, Result};
    use sea_orm::TransactionTrait;
    use crate::models::product::Model;
    use crate::pool::SamplePool;
    use crate::repository::product_repository::ProductRepository;
    use crate::repository::repository::Repository;

    /// ## 16-5.CRUD操作の実装
    /// ### リスト16.9 select_all()メソッドのテスト
    #[tokio::test]
    async fn select_all() -> Result<()> {
        // デバッグログを出力する
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        // 接続プールを取得する
        let pool = SamplePool::get().await?;
        // トランザクションを開始する
        let transaction = pool.begin().await?;
        // ProductRepositoryを生成する
        let repository = ProductRepository::new();
        // すべてのレコードを取得する
        let records = repository.select_all(&transaction).await?;
        for record in records {
            println!("{:?}", record);
        }
        Ok(())
    }

    /// ### select_by_id()メソッドのテスト
    #[tokio::test]
    async fn select_by_id() -> Result<()> {
        // デバッグログを出力する
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        // 接続プールを取得する
        let pool = SamplePool::get().await?;
        // トランザクションを開始する
        let transaction = pool.begin().await?;
        // ProductRepositoryを生成する
        let repository = ProductRepository::new();
        // 指定したidのレコードが存在する
        let record = repository.select_by_id(&transaction, 1).await?;
        assert_eq!(record.id, 1);
        println!("{:?}", record);
        // 指定したidのレコードが存在しない
        let expected = Error::msg(format!("id:{}に一致する商品は存在しません。", 100)).to_string();
        let errmsg = repository.select_by_id(&transaction, 100).await.unwrap_err().to_string();
        println!("{:?}", errmsg);
        assert_eq!(errmsg, expected);
        Ok(())
    }

    /// ### select_by_name_like()メソッドのテスト
    #[tokio::test]
    async fn select_by_name_like() -> Result<()> {
        // デバッグログを出力する
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        // 接続プールを取得する
        let pool = SamplePool::get().await?;
        // トランザクションを開始する
        let transaction = pool.begin().await?;
        // ProductRepositoryを生成する
        let repository = ProductRepository::new();
        // 部分一致検索（蛍光ペンは4件ある）
        let keyword = String::from("蛍光ペン");
        let records = repository.select_by_name_like(&transaction, keyword.as_str()).await?;
        assert_eq!(records.len(), 4);
        for record in records {
            println!("{:?}", record);
        }
        Ok(())
    }

    /// ### リスト16.13 insert()メソッドのテスト
    #[tokio::test]
    async fn insert() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();
        let new_product = Model{id: 0, name: Some("商品ーLMNO".to_owned()), price: Some(200), category_id: Some(1)};
        let result = repository.insert(&transaction, new_product.clone()).await?;
        assert_eq!(new_product, result);
        println!("{:?}", result);
        transaction.rollback().await?;
        Ok(())
    }

    /// ### update_by_id()メソッドのテスト
    #[tokio::test]
    async fn update_by_id() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();

        // 指定したidのレコードを更新する
        let update_product = Model{id: 1, name: Some("商品ーLMNO".to_owned()), price: Some(200), category_id: Some(1)};
        let result = repository.update_by_id(&transaction, update_product.clone()).await?;
        assert_eq!(update_product, result);
        println!("{:?}", result);

        // 指定したidのレコードが存在しない
        let expected = Error::msg(format!("id:{}に一致する商品は存在しません。", 100)).to_string();
        let update_err_product = Model{id: 100, name: Some("商品ーLMNO".to_owned()), price: Some(200), category_id: Some(1)};
        let errmsg = repository.update_by_id(&transaction, update_err_product).await.unwrap_err().to_string();
        println!("{:?}", errmsg);
        assert_eq!(errmsg, expected);
        transaction.rollback().await?;
        Ok(())
    }

    /// ### delete_by_id()メソッドのテスト
    #[tokio::test]
    async fn delete_by_id() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();

        // 指定したidのレコードを更新する
        let delete_count = repository.delete_by_id(&transaction, 1).await?;
        assert_eq!(1, delete_count);
        println!("{:?}件削除しました。", delete_count);

        // 指定したidのレコードが存在しない
        let expected = Error::msg(format!("id:{}に一致する商品は存在しません。", 100)).to_string();
        let errmsg = repository.delete_by_id(&transaction, 100).await.unwrap_err().to_string();
        println!("{:?}", errmsg);
        assert_eq!(errmsg, expected);
        transaction.rollback().await?;
        Ok(())
    }

    /// select_by_id_join_product_category()メソッドのテスト
    #[tokio::test]
    async fn select_by_id_join_product_category() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();

        let product = repository.select_by_id_join_product_category(&transaction, 1).await?;
        println!("{:?}", product);
        Ok(())
    }

    /// select_by_id_stmt()メソッドのテスト
    #[tokio::test]
    async fn select_by_id_stmt() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();

        let result = repository.select_by_id_stmt(&transaction, 10).await?;
        println!("{:?}", result);
        Ok(())
    }

    /// ### insert_stmt()メソッドのテスト
    #[tokio::test]
    async fn insert_stmt() -> Result<()> {
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        let pool = SamplePool::get().await?;
        let transaction = pool.begin().await?;
        let repository = ProductRepository::new();
        let new_product = Model{id: 0, name: Some("商品ーLMNO".to_owned()), price: Some(200), category_id: Some(1)};
        let inserted_count = repository.insert_stmt(&transaction, new_product).await?;
        assert_eq!(1, inserted_count);
        println!("{:?}件追加しました。", inserted_count);
        transaction.rollback().await?;
        Ok(())
    }
}
