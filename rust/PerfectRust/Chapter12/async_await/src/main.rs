use std::time::Duration;

/// ## 12-7 非同期実行
/// ### リスト12.22 合計値を求める非同期関数
async fn calc_sum(values: Vec<u64>) -> u64 {
    let mut total: u64 = 0;
    for value in values {
        total += value;
        std::thread::sleep(Duration::from_secs(1));
        println!("{}", value);
    }
    total
}

#[tokio::main]
async fn main() {
    async {
        let total = calc_sum(vec![10, 20, 30, 40, 50]).await;
        println!("total = {}", total);
    }.await;
}
