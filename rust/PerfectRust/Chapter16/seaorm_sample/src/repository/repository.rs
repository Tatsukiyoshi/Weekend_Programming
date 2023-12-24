use anyhow::Result;
use async_trait::async_trait;
use sea_orm::DatabaseTransaction;
use crate::models::{product, product_category};
use crate::models::product::Model;

/// ## 16-4.CRUD操作の準備
/// ### リスト16.6 Repositoryトレイト
#[async_trait]
pub trait Repository {
    type T; // トランザクション型
    type M; // モデル型
    async fn select_all(&self, tran: &Self::T) -> Result<Vec<Self::M>>;
    async fn select_by_id(&self, tran: &Self::T, id: i32) -> Result<Self::M>;
    async fn select_by_name_like(&self, tran: &Self::T, keyword: &str) -> Result<Vec<Self::M>>;
    async fn insert(&self, tran: &Self::T, row: Self::M) -> Result<Self::M>;
    async fn update_by_id(&self, tran: &Self::T, row: Self::M) -> Result<Self::M>;
    async fn delete_by_id(&self, tran: &Self::T, id: i32) -> Result<u64>;
    async fn select_by_id_join_product_category(&self, tran: &DatabaseTransaction, id: i32)
                                                -> Result<Vec<(product::Model, Option<product_category::Model>)>>;
    /// ### リスト16.18 問い合わせの実装
    async fn select_by_id_stmt(&self, tran: &DatabaseTransaction, id: i32) -> Result<Model>;
    /// ### リスト16.19 更新系SQLの実行
    async fn insert_stmt(&self, tran: &DatabaseTransaction, row: Model) -> Result<u64>;
}
