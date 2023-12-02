use anyhow::Result;
use std::sync::Mutex;
use once_cell::sync::Lazy;
use tokio_postgres::{Client, Error, NoTls};
use crate::section1::params::ConnectParams;

// データベース接続情報
pub static CONNECT_PARAMS: Lazy<Mutex<ConnectParams>> =
    Lazy::new(|| {
        let params = ConnectParams::new(
            "localhost".to_owned(), 5432, "sample_db".to_owned(),
            "postgres".to_owned(), "pgsuper".to_owned());
        Mutex::new(params)
    });

/// ## 14-7.非同期実行
/// ### リスト14.21 データベース接続機能の実装
pub struct AsyncSimpleClient;
impl AsyncSimpleClient {
    /// ### リスト14.21 データベース接続機能の実装
    pub async fn connect() -> Result<Client, Error> {
        let params = CONNECT_PARAMS.lock().unwrap();
        // 接続要求を出す
        let (client, connection) =
            tokio_postgres::connect(
            params.connect_string().as_str(), NoTls).await?;
            tokio::spawn(async move {
                if let Err(e) = connection.await {
                    panic!("接続エラー: {}", e);
                }
            });
        Ok(client)
    }
}
