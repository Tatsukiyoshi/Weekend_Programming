use dotenv::dotenv;
use std::env;
use std::time::Duration;
use anyhow::Result;
use sea_orm::{DatabaseConnection, Database, ConnectOptions};

/// ## 16-2.データベース接続
/// ### リスト16.2 コネクションプールの取得
pub struct SamplePool;
impl SamplePool {
    /// ## 16-2.データベース接続
    /// ### リスト16.2 コネクションプールの取得
    pub async fn get() -> Result<DatabaseConnection> {
        dotenv().ok();
        let database_url = env::var("DATABASE_URL")?;
        // 接続プールのオプションを設定する
        let mut options = ConnectOptions::new(database_url);
        options.max_connections(10)
            .min_connections(5)
            .connect_timeout(Duration::from_secs(10))
            .idle_timeout(Duration::from_secs(10))
            .max_lifetime(Duration::from_secs(10))
            .sqlx_logging(true);
        // 接続プールを取得して返す
        let conn = Database::connect(options).await?;
        Ok(conn)
    }
}
