use std::error::Error;
use std::ops::Div;
use std::sync::{Arc, Mutex};
use std::thread;
use std::thread::Builder;
use std::time::Duration;

#[derive(Debug)]
pub struct Calculator;
impl Calculator {
    /// ## 12-5 標準ライブラリの排他制御
    /// ### リスト12.16 合計値を求める関数
    /// ### 引数 合計を計算する値
    /// ### 戻り値 合計値(u64)
    #[allow(dead_code)]
    fn calc_sum(params: Arc<Mutex<Vec<u64>>>) -> u64 {
        let mut total: u64 = 0;
        {
            let values = params.lock().unwrap_or_else(|error| panic!("{:?}", error));
            println!("calc_sum {:?}", params);
            for value in values.iter() {
                total = total + value;
                thread::sleep(Duration::from_secs(2));
                println!("{} 値:{}", thread::current().name().unwrap(), total);
            }
        }
        println!("summary {:?}", params);
        total
    }
    /// ### リスト12.16 平均値を求める関数
    /// ### 引数 平均を計算する値
    /// ### 戻り値 平均値(u64)
    #[allow(dead_code)]
    fn calc_avg(params: Arc<Mutex<Vec<u64>>>) -> u64 {
        let mut total: u64 = 0;
        let mut count: u64 = 0;
        {
            let values = params.lock().unwrap_or_else(|error| panic!("{:?}", error));
            println!("calc_avg {:?}", params);
            count = values.iter().count() as u64;
            for value in values.iter() {
                total = total + value;
                thread::sleep(Duration::from_secs(2));
                println!("{} 値:{}", thread::current().name().unwrap(), total);
            }
        }
        println!("average {:?}", params);
        total.div(count)
    }

    /// ### リスト12.17 ２つの関数を実行する
    /// 本来は、Result<()>ではなく、Result<(), Box<dyn Error>>とすべき
    /// pub fn use_mutex() -> Result<()>{
    pub fn use_mutex() -> Result<(), Box<dyn Error>>{
        let values: Vec<u64> = vec![10, 20, 30, 40, 50];
        let params = Arc::new(Mutex::new(values));
        let mut handles = Vec::with_capacity(2);

        let builder = Builder::new().name(String::from("合計スレッド")).stack_size(1024 * 3);
        let _params = Arc::clone(&params);
        handles.push(builder.spawn(move || Self::calc_sum(_params))?);

        let builder = Builder::new().name(String::from("平均スレッド")).stack_size(1024 * 3);
        let _params = Arc::clone(&params);
        handles.push(builder.spawn(move || Self::calc_avg(_params))?);

        for handle in handles {
            let thread = handle.thread().clone();
            let result = handle.join().unwrap();
            println!("{} 結果:{}", thread.name().unwrap(), result);
        }
        Ok(())
    }
}
