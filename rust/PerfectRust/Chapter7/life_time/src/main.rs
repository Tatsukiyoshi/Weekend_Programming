mod life_time;

use crate::life_time::{life_time_1, life_time_2, life_time_3, life_time_4};

fn main() {
    life_time_1();
    life_time_2();
    println!("life_time_3() return {:?}", life_time_3());
    life_time_4();
}
