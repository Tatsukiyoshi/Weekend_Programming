use crate::task_controller::customer_controller;

mod customer;
mod writer;
mod client;
mod task_controller;

#[tokio::main]
async fn main() {
    async {
        customer_controller().await;
    }.await;
}
