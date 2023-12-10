use crate::asynchronous::{use_builder, use_spawn};

mod asynchronous;

#[async_std::main]
async fn main() {
    println!("use_calc_sum_2()");
    asynchronous::use_calc_sum_2().await;
    println!("use_spawn()");
    use_spawn().await;
    println!("use_builder()");
    use_builder().await;
}
