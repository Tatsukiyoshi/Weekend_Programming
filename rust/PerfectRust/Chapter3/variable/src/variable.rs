/// ### リスト3.1 変数宣言
#[allow(dead_code)]
#[allow(unused_variables)]
pub fn declar_variables(){
    let x: i32 = 0; // 整数型変数を０で初期化して宣言
    let y = 100;    // 整数型変数を100で初期化して宣言（型推論）
}

/// ### リスト3.2 ミュータブルな変数の宣言
#[allow(dead_code)]
pub fn declar_mutable_variables(){
    let mut x = 100;    // 変更可能な変数を宣言
    x = x + 100;
    println!("x = {}", x);
}
