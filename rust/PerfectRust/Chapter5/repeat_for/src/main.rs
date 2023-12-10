/// ## 5-3 forループ
/// ### リスト5.9 カウンタのインクリメントを利用したfor式
#[allow(dead_code)]
pub fn for_1(){
    println!("Loop from 0 to 4");
    for i in 0..5 {
        print!("i = {} ", i);        
    }
    print!("\n");
    println!("Loop from 0 to 5");
    for i in 0 ..= 5 {
        print!("i = {} ", i);
    }
}

/// ### リスト5.10 カウンタのデクリメントを利用したfor式
#[allow(dead_code)]
pub fn for_2(){
    println!("Loop from 4 to 0");
    for i in (0..5).rev() {
        print!("i = {} ", i);        
    }
    print!("\n");
    println!("Loop from 5 to 0");
    for i in (0 ..= 5).rev() {
        print!("i = {} ", i);
    }
}

/// ### リスト5.11 要素集合から値を取得する
#[allow(dead_code)]
pub fn for_3(){
    let values = vec![100, 200, 300, 400, 500];
    let mut result :i32 = 0;

    for value in values {
        result += value;
    }
    println!("result = {}", result);
}

fn main() {
    for_1();
    println!("");
    for_2();
    println!("");
    for_3();
}
