/// ## 7-6.ライムタイム
/// ### リスト7.26 ライフタイムの基本
#[allow(dead_code)]
pub fn life_time_1(){
    let x = vec![1, 2, 3];
    let a = String::from("ABC");
    let y = &x;
    let b = &a;

    println!("y = {:?}", y);
    println!("b = {:?}", b);
    println!("b = {:?}", b);
    println!("プログラム終了");
}

/// ### リスト7.27 参照を別な変数に代入する
#[allow(dead_code)]
pub fn life_time_2(){
    let a = String::from("ABC");
    let b = &a;
    let c = b;

    println!("c = {:?}", c);
    println!("プログラム終了");
}

/// ### リスト7.28 値の参照を返す関数
#[allow(dead_code)]
pub fn life_time_3() /* -> &String */ {
    /* missing life specifier
    let x = String::from("ABC");
    &x
    */
}

/// ### リスト7.29 引数の参照を返す関数
#[allow(dead_code)]
/*
fn compare(value1: &String, value2: &String) -> &String {
    // 参照で受け取った２つの文字列の長さを比較する
    if value1.len() > value2.len(){
        value1
    } else {
        value2
    }
}
*/

#[allow(dead_code)]
pub fn life_time_4(){
    /*
    let a = String::from("ABC");
    let b = String::from("DEF");
    let r = compare(&a, &b);
    println!("compare({:?}. {:?} = {:?}", a, b, r);
    */
}
