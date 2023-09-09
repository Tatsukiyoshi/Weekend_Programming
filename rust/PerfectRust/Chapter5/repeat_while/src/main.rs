/// ## 5-4 whileループ
/// ### リスト5.12 while式
#[allow(dead_code)]
pub fn while_1(){
    let mut counter = 1;
    while counter < 5 {
        if counter % 2 == 0 {
            println!("counter's value {} is even number", counter);
        } else {
            println!("counter's value {} is odd number", counter);
        }
        counter += 1;
    }
}

/// ### リスト5.13 while-let式
#[allow(dead_code)]
pub fn while_2(){
    let x = ["ABC", "ABC", "ABC", "XYZ"];
    let mut counter = 0;

    // スライスの値が"ABC"の間繰り返す
    while let "ABC" = x[counter] {
        println!("x[{}] = {}", counter, x[counter]);
        counter += 1;
    }
}

fn main() {
    while_1();
    while_2();
}
