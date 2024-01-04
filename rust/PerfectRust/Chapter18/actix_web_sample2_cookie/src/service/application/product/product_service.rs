use async_trait::async_trait;
use crate::service::domain::product::product::Product;
use crate::service::domain::product::product_name::ProductName;
use crate::service::error::Result;
///
/// ## 商品サービス Trait
///
#[async_trait]
pub trait ProductService : Send + Sync {
    type Database;
    /// ## キーワード検索
    async fn by_keyword(&self , db:&Self::Database , keyword: &ProductName) -> Result<Vec<Product>>;
    /// ## 新商品の登録
    async fn register(&self , db:&Self::Database , product: &Product) -> Result<Product>;
}
