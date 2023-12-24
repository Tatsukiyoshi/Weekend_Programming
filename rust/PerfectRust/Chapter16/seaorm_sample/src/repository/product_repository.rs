use anyhow::{Error, Result};
use async_trait::async_trait;
use sea_orm::{ActiveModelTrait, ColumnTrait, DatabaseTransaction, EntityTrait, IntoActiveModel, QueryFilter, QueryOrder};
use sea_orm::ActiveValue::Set;
use crate::models::prelude::Product;
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
}
