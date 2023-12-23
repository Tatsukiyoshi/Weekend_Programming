use anyhow::Result;
use async_trait::async_trait;
use sea_orm::DatabaseTransaction;
use crate::repository::repository::Repository;
use crate::models::product::Model;
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

    async fn select_all(&self, tran: &Self::T) -> Result<Vec<Self::M>> {
        todo!()
    }

    async fn select_by_id(&self, tran: &Self::T, id: i32) -> Result<Self::M> {
        todo!()
    }

    async fn select_by_name_like(&self, tran: &Self::T, keyword: &str) -> Result<Vec<Self::M>> {
        todo!()
    }

    async fn insert(&self, tran: &Self::T, row: &Self::M) -> Result<Self::M> {
        todo!()
    }

    async fn update_by_id(&self, tran: &Self::T, row: &Self::M) -> Result<Self::M> {
        todo!()
    }

    async fn delete_by_id(&self, tran: &Self::T, id: i32) -> Result<u64> {
        todo!()
    }
}
