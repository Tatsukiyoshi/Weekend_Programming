use crate::exclusive_mutex::Calculator;

mod exclusive_mutex;

fn main() {
    println!("use_mutex()");
    let _ = Calculator::use_mutex();
}
