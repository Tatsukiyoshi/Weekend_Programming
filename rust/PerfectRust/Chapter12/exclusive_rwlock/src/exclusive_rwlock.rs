use std::error::Error;
use std::ops::Div;
use std::sync::{Arc, mpsc, RwLock};
use std::sync::mpsc::{Receiver, Sender};
use std::thread;
use std::thread::Builder;
use std::time::Duration;

#[derive(Debug)]
pub struct Calculator;
impl Calculator {
    /// ## 12-5 標準ライブラリの排他制御
    /// ### リスト12.18 計算対象のデータを生成する
    #[allow(dead_code)]
    fn create_data(sender: (Sender<()>, Sender<()>), params: Arc<RwLock<Vec<u64>>>) -> Result<String, Box<dyn Error>> {
        {
            let mut vals = params.write().unwrap();
            println!("{:?}", params);
            for num in 1..6 {
                vals.push(num * 100);
            }
        }
        sender.0.send(()).unwrap_or_else(|error| panic!("{:?}", error));
        sender.1.send(()).unwrap_or_else(|error| panic!("{:?}", error));
        Ok(String::from("計算値の生成完了"))
    }
    /// ### リスト12.18 合計値を求める関数
    /// ### 引数 合計を計算する値
    /// ### 戻り値 合計値(u64)
    #[allow(dead_code)]
    fn calc_sum(receiver: Receiver<()>, params: Arc<RwLock<Vec<u64>>>) -> Result<String, Box<dyn Error>> {
        receiver.recv().unwrap_or_else(|error| panic!("{:?}", error));
        let values = params.read().unwrap();
        let mut total: u64 = 0;
        for value in values.iter() {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
            println!("{} 値:{}", thread::current().name().unwrap(), total);
        }
        Ok(total.to_string())
    }
    /// ### リスト12.18 平均値を求める関数
    /// ### 引数 平均を計算する値
    /// ### 戻り値 平均値(u64)
    #[allow(dead_code)]
    fn calc_avg(receiver: Receiver<()>, params: Arc<RwLock<Vec<u64>>>) -> Result<String, Box<dyn Error>> {
        receiver.recv().unwrap_or_else(|error| panic!("{:?}", error));
        let values = params.read().unwrap();
        let mut total: u64 = 0;
        for value in values.iter() {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
            println!("{} 値:{}", thread::current().name().unwrap(), total.div(values.iter().count() as u64));
        }
        Ok(total.div(values.iter().count() as u64).to_string())
    }
    /// ### リスト12.19 ３つの関数を実行する
    #[allow(dead_code)]
    pub fn use_rwlock() -> Result<(), Box<dyn Error>> {
        let (sum_sender, sum_receiver) = mpsc::channel::<()>();
        let (avg_sender, avg_receiver) = mpsc::channel::<()>();
        let params = Arc::new(RwLock::new(Vec::<u64>::new()));
        let mut handles = Vec::with_capacity(2);

        let builder = Builder::new().name(String::from("値生成スレッド")).stack_size(1024 * 3);
        let params_create = Arc::clone(&params);
        handles.push(builder.spawn(move || Self::create_data((sum_sender, avg_sender), params_create).unwrap())?);

        let builder = Builder::new().name(String::from("合計スレッド")).stack_size(1024 * 3);
        let params_sum = Arc::clone(&params);
        handles.push(builder.spawn(move || Self::calc_sum(sum_receiver, params_sum).unwrap())?);

        let builder = Builder::new().name(String::from("平均スレッド")).stack_size(1024 * 3);
        let params_avg = Arc::clone(&params);
        handles.push(builder.spawn(move || Self::calc_avg(avg_receiver, params_avg).unwrap())?);

        for handle in handles {
            let thread = handle.thread().clone();
            let result = handle.join().unwrap_or_else(|error| panic!("{:?}", error));
            println!("{} 結果:{}", thread.name().unwrap(), result);
        }
        Ok(())
    }
}
