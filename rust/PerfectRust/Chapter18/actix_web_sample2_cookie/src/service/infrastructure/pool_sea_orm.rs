use std::env;
use std::sync::Arc;
use std::time::Duration;
use async_trait::async_trait;
use dotenv::dotenv;
use sea_orm::{ConnectOptions, Database, DatabaseConnection};
use crate::service::error::{AppError, Result};

/// ## 18-5 アプリケーションの構成
/// ### リスト18.26 コネクションプール取得トレイト
#[async_trait]
pub trait Pool<T> {
    async fn get() -> Result<Arc<T>>;
}

/// ## 18-5 アプリケーションの構成
/// ### リスト18.26 SeaORMのコネクションプール取得
pub struct PoolSeaOrm;
#[async_trait]
impl Pool<DatabaseConnection> for PoolSeaOrm {
    async fn get() -> Result<Arc<DatabaseConnection>> {
        dotenv().expect(".envファイルが見つかりません。");
        let database_url = env::var("DATABASE_URL").expect("DATABASE_URLが取得できません。");
        let mut opt = ConnectOptions::new(database_url);
        opt.max_connections(100)
            .min_connections(5)
            .connect_timeout(Duration::from_secs(8))
            .idle_timeout(Duration::from_secs(8))
            .max_lifetime(Duration::from_secs(8))
            .sqlx_logging(true);
        match Database::connect(opt).await {
            Ok(connection) => Ok(Arc::new(connection)),
            Err(error) => Err(AppError::from(error))
        }
    }
}
