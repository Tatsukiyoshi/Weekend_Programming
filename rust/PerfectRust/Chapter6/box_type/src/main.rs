use std::ops::Add;

/// ## 6-3.Box
/// ### リスト6.16 整数値のボックス化
#[allow(dead_code)]
pub fn instantiate(){
    // i32型整数をボックス化する
    let x = Box::new(100);
    let y = Box::new(200);
    println!("x + y = {}", x.add(*y));
    println!("x + y = {}", *x + *y);

    // &str型とString型をボックス化する
    let a = Box::new("ABCXYZ");
    let b = Box::new(String::from("XYZ"));
    // ボックス化された値のメソッドを利用する
    println!("contains() = {}", &a.contains(&b.as_str()));
}

fn main() {
    instantiate();
}
