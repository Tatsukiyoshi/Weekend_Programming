use std::sync::{Arc, Barrier};
use std::thread::Builder;
use std::time::Duration;
use crossbeam::thread;
use crossbeam::sync::WaitGroup;

#[derive(Debug, Default)]
pub struct Summary;
impl Summary {
    /// ## 合計値を求めるスレッド
    /// ### 引数 合計を計算する値
    /// ### 戻り値 合計値(u64)
    #[allow(dead_code)]
    fn summary(&self, name: &str, values: Vec<u64>) -> u64 {
        let mut total: u64 = 0;
        for value in values {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
            println!("{} 値:{}", name, total);
        }
        total
    }

    /// ## 12-2.グリーンスレッド
    /// ### リスト12.6 合計値を求めるスレッドを実行するスレッド
    /// ### 引数 処理の名前
    /// ### 引数 合計を計算する値
    /// ### 戻り値 スレッドのハンドラ
    #[allow(dead_code)]
    pub fn summary_thread(&self){
        // スコープを設定
        thread::scope(|scope| {
            // スコープ付きスレッドの生成と実行
            let handle1 = scope.spawn( |_| self.summary("sum1", vec![10, 20, 30, 40, 50]));
            let handle2 = scope.spawn( |_| self.summary("sum2", vec![100, 200, 300, 400, 500]));

            // スレッドの終了待ち
            let total1 = handle1.join().unwrap_or_else(|error| panic!("{:?}", error));
            let total2 = handle2.join().unwrap_or_else(|error| panic!("{:?}", error));

            // 終了結果を出力する
            println!("total1の合計値{}", total1);
            println!("total2の合計値{}", total2);
        }).unwrap();
    }

    /// ### リスト12.7 ScopedThreadBuilder構造体の利用
    #[allow(dead_code)]
    pub fn use_builder(&self){
        thread::scope(|scope|{
            // スレッド名称を設定する
            let handle1 = scope.builder().name(String::from("sum1"))
                .stack_size(1024 * 3)   // スタックサイズを設定する
                .spawn(|_| {
                    self.summary(std::thread::current().name().unwrap(),
                        vec![10, 20, 30, 40, 50])
                }).unwrap_or_else(|error| panic!("{:?}", error));
            // スレッドの終了待ち
            let total1 = handle1.join().unwrap_or_else(|error| panic!("{:?}", error));

            // 終了結果を出力する
            println!("total1の合計値:{}", total1);
        }).unwrap();
    }

    #[allow(dead_code)]
    fn summary_a(values:Vec<u64>) -> u64 {
        let mut total: u64 = 0;
        for value in values {
            total = total + value;
            std::thread::sleep(Duration::from_secs(2));
        }
        total
    }

    /// ## 12-3.スレッド終了の同期化
    /// ### リスト12.8 Barrier構造体を利用した終了の同期化
    #[allow(dead_code)]
    pub fn use_barrier(&self){
        // スレッドのハンドルを格納するベクタ
        let mut handles = Vec::with_capacity(3);
        // ArcでラップしたBarrierを生成する
        let barrier = Arc::new(Barrier::new(3));
        let mut num: u64 = 0;
        while num <= 2 {
            // Arcのクローンを生成する
            let arc = Arc::clone(&barrier);
            handles.push(
                Builder::new().name(format!("{}{}", "summary", num)).stack_size(1024 * 5)
                    .spawn(move || {
                        let data: Vec<u64> = vec![10 + num, 20 + num, 30 + num, 40 + num, 50 + num];
                        let result = Self::summary_a(data);
                        // wait()メソッドで終了を待つ
                        let wresult = arc.wait();
                        println!("{} 終了:{}",
                            std::thread::current().name().unwrap(), wresult.is_leader());
                        result
                    }).unwrap_or_else(|error| panic!("{:?}", error))
            );
            num += 1;
        }
        for handle in handles {
            let thread = handle.thread().clone();
            let result = handle.join().unwrap_or_else(|error| panic!("{:?}", error));
            println!("{} 合計:{}", thread.name().unwrap(), result);
        }
    }

    /// ### リスト12.9 WaitGroup構造体を利用した終了の同期化
    #[allow(dead_code)]
    pub fn use_wait_group(&self){
        thread::scope(|scope|{
            let mut handles = Vec::with_capacity(3);
            let wait_group = WaitGroup::new();  // WaitGroupの生成
            let mut num: u64 = 0;
            while num <= 2 {
                let wg = wait_group.clone();
                handles.push(scope.builder().name(format!("{}{}", "summary", num))
                    .stack_size(1024 * 3)
                    .spawn(move |_| {
                        let result = self.summary(
                            std::thread::current().name().unwrap(),
                            vec![10 + num, 20 + num, 30 + num, 40 + num, 50 + num]
                        );
                        drop(wg);
                        result
                    }).unwrap_or_else(|error| panic!("{:?}", error))
                );
                num += 1;
            }
            wait_group.wait();  // すべてのWaitGroupがなくなるまで待機
            for handle in handles {
                let thread = handle.thread().clone();
                let result = handle.join()
                    .unwrap_or_else(|error| panic!("{:?}", error));
                println!("{} 合計:{}", thread.name().unwrap(), result);
            }
        }).unwrap();
    }
}

#[allow(dead_code)]
pub fn thread_controller_1(){
    let s = Summary::default();

    println!("summary_thread()");
    s.summary_thread();

    println!("use_builder()");
    s.use_builder();

    println!("use_barrier()");
    s.use_barrier();

    println!("use_wait_group()");
    s.use_wait_group();
}
