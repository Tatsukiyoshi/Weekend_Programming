use std::fs::File;
use std::env;
use std::error::Error;
use csv::WriterBuilder;
use async_std::channel::Receiver;
use crate::customer::Customer;

pub struct SampleWriter;
impl SampleWriter {
    /// ## 12-9 タスク間通信
    /// ### リスト12.30 受信した顧客情報をCSVファイルに格納する
    /// ### 引数 receiver 顧客情報受信用レシーバ
    /// ### 戻り値 終了メッセージ
    pub async fn csv_writer(&self, receiver: Receiver<Customer>) -> Result<String, Box<dyn Error + Send>> {
        let mut customers: Vec<Customer> = Vec::new();
        loop {
            let customer = receiver.recv().await.unwrap();
            if customer.get_name() == "end" {
                break;
            }
            customers.push(customer);
        }
        let path = env::current_dir().map(|path| path.join("resources\\customer.csv") ).unwrap();
        let mut writer = WriterBuilder::new().from_path(path).unwrap();
        for customer in customers {
            writer.serialize(customer).unwrap();
        }
        Ok(String::from("csv_writer終了"))
    }
    /// ### リスト12.31 受信した顧客情報をJSONファイルに格納する
    /// ### 引数 receiver 顧客情報受信用レシーバ
    /// ### 戻り値 終了メッセージ
    pub async fn json_writer(&self, receiver: Receiver<Customer>) -> Result<String, Box<dyn Error + Send>> {
        let mut customers: Vec<Customer> = Vec::new();
        loop {
            let customer = receiver.recv().await.unwrap();
            if customer.get_name() == "end" {
                break;
            }
            customers.push(customer);
        }
        let path = env::current_dir().map(|path| path.join("resources\\customer.json") ).unwrap();
        let writer = File::create(path).map(|file| std::io::BufWriter::new(file)).unwrap();
        serde_json::to_writer(writer, &customers).unwrap();
        Ok(String::from("json_writer終了"))
    }
}
