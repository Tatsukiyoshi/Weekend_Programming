use std::sync::mpsc;
use std::sync::mpsc::{Receiver, Sender};
use std::thread;
use crate::station::{enter_station, Station};
use crate::stations::Stations;

#[allow(dead_code)]
pub struct Client;
impl Client {
    /// ## 12-4 スレッド間通信
    /// ### リスト12.10 Providerに検索要求を出し、結果を受け取るメソッド
    /// ### 引数 Providerへの送信チャネル p_sender: Sender<String>
    /// ### 引数 Clientの受信チャネル c_receiver: Receiver<String>
    #[allow(dead_code)]
    pub fn search_request(p_sender: Sender<String>, c_receiver: Receiver<String>){
        loop {
            let entry_name = enter_station("駅名を入力してください");

            p_sender.send(entry_name.clone())
                .unwrap_or_else(|error| println!("{:?}", error));
            if entry_name == "end" {
                break;
            }
            c_receiver.recv().and_then(|result| {
                println!("{:?}", result);
                Ok(())
            }).unwrap_or_else(|error| println!("{:?}", error));
        }
        println!("Client 終了");
    }
}

#[allow(dead_code)]
pub struct Provider;
impl Provider {
    /// ### リスト12.11 受信した駅名で検索した結果を送信するメソッド
    /// ### 引数 Clientへの送信チャネル c_sender: Sender<String>
    /// ### 引数 Providerの受信チャネル p_receiver: Receiver<String>
    #[allow(dead_code)]
    pub fn search_service(c_sender: Sender<String>,
        p_receiver: Receiver<String>) {
        let stations = Stations::<Station>::new();
        loop {
            let entry_name = p_receiver.recv()
                .unwrap_or_else(|error| panic!("{:?}", error));
            if entry_name == "end" {
                break;
            }
            let result = match stations.search_by_name(entry_name){
                Some(station) => station.get_message(),
                None => String::from("該当する駅が見つかりません")
            };
            c_sender.send(result).unwrap_or_else(|error| panic!("{:?}", error));
        }
        println!("Provider 終了");
    }
}

/// ### リスト12.12 通信の確認
#[allow(dead_code)]
pub fn execute(){
    let (c_sender, c_receiver) = mpsc::channel::<String>();
    let (p_sender, p_receiver) = mpsc::channel::<String>();
    let p_handle = thread::spawn(move || Provider::search_service(c_sender, p_receiver));
    let c_handle = thread::spawn(move || Client::search_request(p_sender, c_receiver));

    p_handle.join().unwrap_or_else(|error| panic!("{:?}", error));
    c_handle.join().unwrap_or_else(|error| panic!("{:?}", error));
}
