use anyhow::Error;
use sea_orm::{DatabaseTransaction, EntityTrait};
use crate::models::{product, product_category};
use crate::models::prelude::{Product, ProductCategory};

pub struct ProductCategoryRepository;

impl ProductCategoryRepository {
    pub fn new() -> Self {
        Self
    }

    /// ### リスト16.16 １：Ｎ結合
    pub async fn select_by_id_join_product(&self, tran: &DatabaseTransaction, id: i32)
       -> Result<Vec<(product_category::Model, Vec<product::Model>)>, Error> {
        let category_and_product = ProductCategory::find_by_id(id)
            .find_with_related(Product)
            .all(tran).await?;
        Ok(category_and_product)
    }
}

mod tests {
    use anyhow::Error;
    use sea_orm::TransactionTrait;
    use crate::pool::SamplePool;
    use crate::repository::product_category_repository::ProductCategoryRepository;

    #[tokio::test]
    async fn select_by_id_join_product() -> Result<(), Error> {
        // デバッグログを出力する
        env_logger::builder().filter_level(log::LevelFilter::Debug).init();
        // 接続プールを取得する
        let pool = SamplePool::get().await?;
        // トランザクションを開始する
        let transaction = pool.begin().await?;
        // ProductRepositoryを生成する
        let repository = ProductCategoryRepository::new();

        let records = repository.select_by_id_join_product(&transaction, 1).await?;
        for record in records {
            println!("{:?}", record);
        }
        Ok(())
    }
}