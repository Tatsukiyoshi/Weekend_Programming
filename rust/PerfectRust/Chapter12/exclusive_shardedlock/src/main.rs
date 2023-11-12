use crate::exclusive_shardedlock::Calculator;

mod exclusive_shardedlock;

fn main() {
    println!("use_sharded_lock()");
    let c = Calculator::default();
    c.use_sharded_lock();
}
