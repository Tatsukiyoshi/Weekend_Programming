use std::error::Error;
use async_std::channel::unbounded;
use async_std::task;
use async_std::task::JoinHandle;
use crate::client::Client;
use crate::customer::Customer;
use crate::writer::SampleWriter;

/// ### リスト12.33 3つのタスクの生成と実行制御
#[allow(dead_code)]
pub async fn customer_controller(){
    let (csv_sender, csv_receiver) = unbounded::<Customer>();
    let (json_sender, json_receiver) = unbounded::<Customer>();
    let mut handles: Vec<JoinHandle<Result<String, Box<dyn Error + Send>>>> = Vec::new();
    handles.push(task::spawn(async {
        let writer = SampleWriter;
        writer.csv_writer(csv_receiver).await
    }));
    handles.push(task::spawn(async {
        let writer = SampleWriter;
        writer.json_writer(json_receiver).await
    }));
    handles.push(task::spawn( async {
        let client = Client;
        client.entry((csv_sender, json_sender)).await
    }));

    for handle in handles {
        match handle.await {
            Ok(result) => println!("{}", result),
            Err(error) => panic!("{:?}", error)
        }
    }
}
