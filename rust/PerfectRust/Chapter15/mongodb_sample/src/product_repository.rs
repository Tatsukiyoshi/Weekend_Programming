use anyhow::{Result, Error};
use mongodb::Collection;
use async_trait::async_trait;
use futures_util::StreamExt;
use mongodb::options::{FindOptions, UpdateModifications};
use mongodb::bson::doc;
use crate::connect::SampleMongoClient;
use crate::entities::Product;
use crate::repository::Repository;

/// productコレクションを操作するRepository
pub struct ProductRepository {
    collection: Collection<Product>
}

impl ProductRepository {
    // インスタンスを生成する
    pub fn new(sample_mongo_client: SampleMongoClient, collection_name: &str) -> Self {
        Self {
            collection: sample_mongo_client.get_database().collection(collection_name)
        }
    }
}

// 公開されているサンプルコードにしかない！
// Repositoryトレイト（Interface）に従って、ProductRepositoryを実装
#[async_trait]
impl Repository<Product, i32, bool> for ProductRepository{
    async fn select_all(&self) -> Result<Vec<Product>> {
        let find_options = FindOptions::builder().sort(doc! {"price": 1}).build();
        let mut cursor = self.collection.find(None, find_options).await?;
        let mut products = Vec::new();

        while let Some(product) = cursor.next().await {
            products.push(product?);
        }
        Ok(products)
    }

    /// ### リスト15.8 パラメータ検索
    async fn select_by_id(&self, id: i32) -> Result<Product> {
        let filter = doc! {"id": id};
        let product = self.collection.find_one(filter, None).await?
            .ok_or(Error::msg(format!("商品id:{}は存在しません", id)));
        product
    }

    /// ### リスト15.9 指定された商品を追加する
    async fn insert(&self, product: Product) -> Result<bool> {
        self.collection.insert_one(product, None).await.map(|_| Ok(true))?
    }

    /// ### リスト15.9 指定された複数の商品を一括追加する
    async fn insert_many(&self, products: Vec<Product>) -> Result<bool> {
        self.collection.insert_many(products.clone(), None).await.map(|ret| {
           if ret.inserted_ids.iter().count() == products.iter().count(){
               Ok(true)
           } else {
               Ok(false)
           }
        })?
    }

    /// ### リスト15.10 指定された商品を更新する
    async fn update_by_id(&self, product: Product) -> Result<bool> {
        let query = doc! {"product_id": product.get_id() };
        let update = UpdateModifications::Document(
            doc! {"$set": {"name": product.get_name(), "price": product.get_price()} }
        );
        let result = self.collection.update_one(query, update, None).await.map(|ret| {
            if ret.modified_count == 1 {
                true
            } else {
                false
            }
        })?;
        Ok(result)
    }

    /// ### リスト15.11 指定された商品を削除する
    async fn delete_by_id(&self, id: i32) -> Result<bool> {
        let filter = doc! { "product_id": id };
        let result = self.collection.delete_one(filter, None).await.map(|ret| {
            if ret.deleted_count == 1 {
                true
            } else {
                false
            }
        })?;
        Ok(result)
    }

    async fn count_documents(&self) -> Result<u64> {
        let count = self.collection.count_documents(None, None).await?;
        Ok(count)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use mongodb::bson::oid::ObjectId;
    use crate::entities::ProductCategory;

    #[tokio::test]
    async fn insert() -> Result<()> {
        // DB接続
        let client = SampleMongoClient::new("mongodb://localhost:27017", "rust_sample").await;
        let repository = ProductRepository::new(client.unwrap(), "product");
        // 追加する商品のカテゴリ
        let product_category: ProductCategory = ProductCategory::new(1, String::from("文房具"));
        // 追加する商品データ
        let new_id = ObjectId::new();
        let product: Product = Product::new(Option::from(new_id), 1, String::from("水性ボールペン(黒)"), 120, Option::from(product_category));
        // 商品データを追加する
        let result = repository.insert(product).await?;
        if result {
            assert!(true);
        } else {
            assert!(false);
        }
        Ok(())
    }

    #[tokio::test]
    async fn select_all() -> Result<()> {
        // DB接続
        let client = SampleMongoClient::new("mongodb://localhost:27017", "rust_sample").await;
        let repository = ProductRepository::new(client.unwrap(), "product");
        let result = repository.select_all().await;
        match result {
            Ok(products) => {
                println!("{}", products.iter().count());
                assert!(true);
            }
            _ => {}
        }
        Ok(())
    }
}