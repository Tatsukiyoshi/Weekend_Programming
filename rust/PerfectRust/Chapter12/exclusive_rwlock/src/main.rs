mod exclusive_rwlock;

fn main() {
    println!("use_rwlock()");
    let _ = exclusive_rwlock::Calculator::use_rwlock();
}
