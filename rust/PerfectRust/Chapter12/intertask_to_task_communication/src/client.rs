use std::error::Error;
use async_std::channel::Sender;
use crate::customer::Customer;

pub struct Client;
impl Client {
    /// ### リスト12.32 入力された顧客情報をWriterに送信する
    /// ### 引数 receiver 顧客情報送信用センダー
    /// ### 戻り値 終了メッセージ
    pub async fn entry(&self, sender: (Sender<Customer>, Sender<Customer>)) -> Result<String, Box<dyn Error + Send>> {
        loop {
            let name = enter_data("氏名を入力してください");
            let email = enter_data("メールアドレスを入力してください");
            let customer = Customer::new(name.clone(), email.clone());

            let _ = sender.0.send(customer.clone()).await;
            let _ = sender.1.send(customer).await;
            if name == "end" {
                break;
            }
        }
        Ok(String::from("Client終了"))
    }
}

/// 入力されたデータを取得する
fn enter_data(message: &str) -> String {
    println!("{}" , message);
    let mut name = String::new();
    std::io::stdin().read_line(&mut name).ok();
    name.trim().to_string()
}
