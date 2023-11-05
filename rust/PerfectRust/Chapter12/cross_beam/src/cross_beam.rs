use std::time::Duration;
use crossbeam::thread;

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
}

#[allow(dead_code)]
pub fn thread_controller_1(){
    let s = Summary::default();
    println!("summary_thread()");
    s.summary_thread();
    println!("use_builder()");
    s.use_builder();
}
