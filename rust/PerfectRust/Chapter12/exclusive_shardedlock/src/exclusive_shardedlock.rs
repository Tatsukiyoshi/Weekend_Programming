use std::ops::Div;
use std::sync::Arc;
use std::time::Duration;
use crossbeam::thread;
use crossbeam::channel::{bounded, Sender, Receiver};
use crossbeam::sync::ShardedLock;

#[derive(Debug, Default)]
pub struct Calculator;
impl Calculator {
    /// ## 12-6 crossbeamクレートの排他制御
    /// ### リスト12.20 計算対象のデータを生成する
    fn create_data(&self, sender: (Sender<()>, Sender<()>), params: Arc<ShardedLock<Vec<u64>>>) -> String {
        {
            let mut vals = params.write().unwrap_or_else(|error| panic!("{:?}", error));
            println!("{:?}", params);
            for num in 1..6 {
                vals.push(num * 100);
            }
        }
        sender.0.send(()).unwrap_or_else(|error| panic!("{:?}", error));
        sender.1.send(()).unwrap_or_else(|error| panic!("{:?}", error));
        String::from("計算値の生成完了")
    }

    /// ### リスト12.20 合計値を求める関数
    /// ### 引数 合計を求める値
    /// ### 戻り値 合計値(u64)
    fn calc_sum(&self, receiver: Receiver<()>, params: Arc<ShardedLock<Vec<u64>>>) -> String {
        receiver.recv().unwrap_or_else(|error| panic!("{:?}", error));
        let values = params.read().unwrap_or_else(|error| panic!("{:?}", error));
        let mut total: u64 = 0;
        for value in values.iter() {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
            println!("{} 値:{}", std::thread::current().name().unwrap(), total);
        }
        total.to_string()
    }

    /// ### リスト12.20 平均値を求める関数
    /// ### 引数 平均値を求める値
    /// ### 戻り値 平均値(u64)
    fn calc_avg(&self, receiver: Receiver<()>, params: Arc<ShardedLock<Vec<u64>>>) -> String {
        receiver.recv().unwrap_or_else(|error| panic!("{:?}", error));
        let values = params.read().unwrap_or_else(|error| panic!("{:?}", error));
        let mut total: u64 = 0;
        for value in values.iter() {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
            println!("{} 値:{}", std::thread::current().name().unwrap(), total.div(values.iter().count() as u64));
        }
        total.div(values.iter().count() as u64).to_string()
    }

    /// ### リスト12.21 ３つの関数を実行する
    pub fn use_sharded_lock(&self){
        thread::scope(|scope| {
            let (sum_sender, sum_receiver) = bounded::<()>(5);
            let (avg_sender, avg_receiver) = bounded::<()>(5);
            let params = Arc::new(ShardedLock::new(Vec::<u64>::new()));
            let mut handles = Vec::with_capacity(3);

            let params_create = Arc::clone(&params);
            handles.push(scope.builder().name(String::from("値生成スレッド")).stack_size(1024 * 3)
                .spawn(|_| self.create_data((sum_sender, avg_sender), params_create))
                .unwrap_or_else(|error| panic!("{:?}", error))
            );

            let params_sum = Arc::clone(&params);
            handles.push(scope.builder()
                .name(String::from("合計スレッド")).stack_size(1024 * 3)
                .spawn(|_| self.calc_sum(sum_receiver, params_sum))
                .unwrap_or_else(|error| panic!("{:?}", error)));

            let params_avg = Arc::clone(&params);
            handles.push(scope.builder()
                .name(String::from("平均スレッド")).stack_size(1024 * 3)
                .spawn(|_| self.calc_avg(avg_receiver, params_avg))
                .unwrap_or_else(|error| panic!("{:?}", error))
            );

            for handle in handles {
                let thread = handle.thread().clone();
                let result = handle.join().unwrap_or_else(|error| panic!("{:?}", error));
                println!("{} {}", thread.name().unwrap(), result);
            }
        }).unwrap();
    }
}
