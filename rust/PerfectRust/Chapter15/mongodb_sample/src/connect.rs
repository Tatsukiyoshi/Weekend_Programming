use anyhow::Error;
use lombok::{Getter, GetterMut};
use mongodb::{Client, Database};

/// ## 15-2.データベース接続
/// ### リスト15.2 データベース接続機能の実装
#[derive(Debug, Getter, GetterMut)]
pub struct SampleMongoClient {
    client:     Client,
    database:   Database
}
impl SampleMongoClient {
    /// ## Client構造体のbarabse()メソッドを利用した接続
    /// ### リスト15.2 データベース接続機能の実装
    /// ### 引数 uri: 接続URI
    /// ### 戻り値 name: 接続データベース名
    pub async fn new(uri: &str, name: &str) -> Result<Self, Error> {
        // MongoDBに接続してClientを取得する
        let cli = Client::with_uri_str(uri).await?;
        let db = cli.database(name);
        let instance = Self{client: cli, database: db};
        Ok(instance)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    // データベースハンドルの取得テスト
    #[tokio::test]
    async fn new_test() -> Result<(), Error> {
        let sample_client = SampleMongoClient::new("mongodb://localhost:27017", "sample").await;
        match sample_client {
            Ok(sc) => {
                println!("{:?}", sc.get_client());
                assert!(true);
            },
            Err(error) => {
                println!("{:?}", error);
                assert!(false);
            }
        }
        Ok(())
    }
}
