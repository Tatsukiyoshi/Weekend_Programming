mod life_time;

use crate::life_time::{life_time_1, life_time_2, life_time_3, life_time_4, life_time_5, push};

fn main() {
    life_time_1();
    life_time_2();
    println!("life_time_3() return {:?}", life_time_3());
    life_time_4();
    life_time_5();

    let mut z = vec![5, 6, 7];
    println!("z = {:?}", z);
    println!("push(z) = {:?}", push(&mut z));
}
