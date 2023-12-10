use postgres::{Client, NoTls, Config};
use anyhow::Result;
use crate::section1::params::ConnectParams;
/// ### リスト14.3 データベース接続機能の実装
pub struct PostgresSampleClient;
impl PostgresSampleClient {
    /// ## Client構造体のconnect関数を利用した接続
    /// ### リスト14.3 データベース接続機能の実装
    /// ### 引数 ConnectParams: 接続パラメータ構造体
    /// ### 戻り値 Client: 接続結果
    pub fn simple_connect(connect_params: ConnectParams) -> Result<Client> {
        let client = Client::connect(connect_params.connect_string().as_str(), NoTls)?;
        Ok(client)
    }
    /// ## Config構造体のconnectメソッドを利用した接続
    /// ### リスト14.3 データベース接続機能の実装
    /// ### 引数 ConnectParams: 接続パラメータ構造体
    /// ### 戻り値 Client: 接続結果
    pub fn config_connect(connect_params: ConnectParams) -> Result<Client> {
        let client = Config::new()
            .host(connect_params.get_host())
            .port(connect_params.get_port().clone())
            .dbname(connect_params.get_dbname())
            .user(connect_params.get_user())
            .password(connect_params.get_password())
            .connect(NoTls)?;
        Ok(client)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    /// ### データベース接続のテスト
    /// ### リスト14.4 データベース接続機能の実装
    fn connect_ok(){
        let params = ConnectParams::new(
            "localhost".to_owned(), 5432, "sample_db".to_owned(),
            "postgres".to_owned(), "pgsuper".to_owned()
        );
        match super::PostgresSampleClient::simple_connect(params.clone()) {
            Ok(client) => {
                println!("simple_connect:接続成功");
                let _ = client.close();
            }
            Err(error) => println!("{:?}", error.to_string())
        };
        match PostgresSampleClient::config_connect(params.clone()){
            Ok(client) => {
                println!("config_connect:接続成功");
                let _ = client.close();
            }
            Err(error) => println!("{:?}", error.to_string())
        };
    }
}
