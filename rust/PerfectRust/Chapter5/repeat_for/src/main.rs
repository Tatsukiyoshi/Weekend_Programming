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

fn main() {
    for_1();
}
