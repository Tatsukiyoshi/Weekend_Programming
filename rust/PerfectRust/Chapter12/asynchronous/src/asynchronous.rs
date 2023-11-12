use std::time::Duration;
use async_std::task;
use async_std::task::*;

/// ## 12-8 async_stdクレート
/// ### リスト12.24 合計意を求める非同期関数
async fn calc_sum(values: Vec<u64>) -> u64 {
    let mut total: u64 = 0;
    for value in values {
        total += value;
        std::thread::sleep(Duration::from_secs(1));
        println!("値:{}", value);
    }
    total
}

/// ### リスト12.24 合計値を求める非同期関数
#[allow(dead_code)]
pub fn use_calc_sum_1(){
    block_on(async{
        let total = calc_sum(vec![10, 20, 30, 40, 50]).await;
        println!("合計:{}", total);
    });
}

/// リスト12.25 #[async_std:main]アトリビュート
#[allow(dead_code)]
pub async fn use_calc_sum_2(){
    let total = calc_sum(vec![10, 20, 30, 40, 50]).await;
    println!("合計:{}", total);
}

/// リスト12.27 spawn()関数の利用
#[allow(dead_code)]
pub async fn use_spawn(){
    let handle1 = task::spawn(async {
        calc_sum(vec![10, 20, 30, 40, 50, 60, 70, 80, 90, 100]).await
    });
    let handle2 = task::spawn( async {
        calc_sum(vec![10, 20, 30, 40, 50]).await
    });
    async {
        for i in 0..5 {
            println!("別な処理{}", i);
            std::thread::sleep(Duration::from_secs(1));
        }
    }.await;
    println!("合計1:{}", handle1.await);
    println!("合計2:{}", handle2.await);
}

/// リスト12.28 Builder構造体の利用
#[allow(dead_code)]
pub async fn use_builder(){
    let task1 = Builder::new().name(String::from("task1"))
        .spawn(async { calc_sum(vec![10, 20, 30, 40, 50]).await });
    let task2 = Builder::new().name(String::from("task2"))
        .spawn(async { calc_sum(vec![10, 20, 30, 40, 50]).await });
    match task1 {
        Ok(result) => println!("合計1:{}", result.await),
        Err(error) => panic!("{:?}", error)
    };
    match task2 {
        Ok(result) => println!("合計2:{}", result.await),
        Err(error) => panic!("{:?}", error)
    };
}
