use std::thread;
use std::thread::{Builder, JoinHandle};
use std::time::Duration;
#[derive(Debug, Default)]
pub struct Summary;

impl Summary {
    /// ## 12-1.シンプルなスレッド
    /// ### リスト12.5 合計値を求めるスレッドを実行するスレッド
    /// ### 引数 処理の名前
    /// ### 引数 合計を計算する値
    /// ### 戻り値 スレッドのハンドラ
    pub fn summary_thread(&self, name: String, values: Vec<u64>) -> JoinHandle<u64> {
        // スレッドの生成
        let join_handle = thread::spawn(move || {
            let mut total: u64 = 0;
            for value in values {   // 引数の合計値を求める
                total = total + value;
                thread::sleep(Duration::from_secs(2));  // 処理を２秒間停止する
                println!("{}の値:{}", name, total);
            }
            total
        });
        join_handle // 生成されたスレッドのハンドルを返す
    }
}

/// ## 12-1.シンプルなスレッド
/// ### リスト12.1 合計値を求めるスレッドを実行する関数
/// ### 引数 処理の名前
/// ### 引数 合計を計算する値
/// ### 戻り値 スレッドのハンドラ
#[allow(dead_code)]
fn summary_thread_1(name: String, values: Vec<u64>) -> JoinHandle<u64> {
    // スレッドの生成
    let join_handle = thread::spawn(move || {
       let mut total: u64 = 0;
        for value in values {
            total = total + value;
            thread::sleep(Duration::from_secs(2));
            println!("{}の値:{}", name, total);
        }
        total
    });
    join_handle // 生成されたスレッドのハンドルを返す
}

/// ### リスト12.2 スレッドの起動と終了待ち制御
pub fn thread_controller_1(){
    // 合計を求めるスレッドを起動
    let thd1 = summary_thread_1(String::from("thd1"), vec![10, 20, 30, 40, 50]);
    let thd2 = summary_thread_1(String::from("thd2"), vec![100, 200, 300, 400, 500]);

    // スレッドの終了待ち
    let result1 = thd1.join().map_err(|error| panic!("{:?}", error)).unwrap();
    let result2 = thd2.join().map_err(|error| panic!("{:?}", error)).unwrap();

    // 終了結果を出力する
    println!("thd1の合計値:{}", result1);
    println!("thd2の合計値:{}", result2);
}

/// ### リスト12.3 Builder構造体を利用したスレッドの生成
/// ### 引数 処理の名前
/// ### 引数 合計を計算する値
/// ### 戻り値 スレッドのハンドラ
#[allow(dead_code)]
fn summary_thread_2(name: String, values: Vec<u64>)
    -> std::thread::Result<JoinHandle<u64>> {
    let builder = Builder::new()
        .name(name)          // スレッドの名前を設定する
        .stack_size(1024 * 3); // スタックサイズを設定する
    let join_handle = builder.spawn(|| {
        let mut total: u64 = 0;
        for value in values {
            total = total + value;
            thread::sleep(Duration::from_secs(2));  // 処理を2秒間停止する
            println!("{}の値:{}", thread::current().name().unwrap(), total);
        }
        total
    });
    Ok(join_handle.unwrap())
}

/// ### リスト12.4 Builder構造体を利用したスレッドの起動と終了待ち制御
#[allow(dead_code)]
pub fn thread_controller_2(){
    // 合計を求めるスレッドを起動
    let thd1 = summary_thread_2(String::from("thd1"), vec![10, 20, 30, 40, 50]);
    let thd2 = summary_thread_2(String::from("thd2"), vec![100, 200, 300, 400, 500]);

    // スレッドの終了待ち
    let result1 = thd1.unwrap().join().map_err(|error| panic!("{:?}", error)).unwrap();
    let result2 = thd2.unwrap().join().map_err(|error| panic!("{:?}", error)).unwrap();

    // 終了結果を出力する
    println!("thd1の合計値:{}", result1);
    println!("thd2の合計値:{}", result2);
}

/// ### リスト12.5 スレッドを実行するスレッドの利用
#[allow(dead_code)]
pub fn thread_controller_3(){
    let s = Summary::default();
    let thd1 = s.summary_thread(String::from("thd1"), vec![10, 20, 30, 40, 50]);
    let thd2 = s.summary_thread(String::from("thd2"), vec![100, 200, 300, 400, 500]);

    // スレッドの終了待ち
    let result1 = thd1.join().map_err(|error| panic!("{:?}", error)).unwrap();
    let result2 = thd2.join().map_err(|error| panic!("{:?}", error)).unwrap();

    // 終了結果を出力する
    println!("thd1の合計値:{}", result1);
    println!("thd2の合計値:{}", result2);
}
