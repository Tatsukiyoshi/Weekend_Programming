/// ## 7-4 所有権
/// ### リスト7.15 代入による所有権の移動
#[allow(dead_code)]
pub fn ownership_1(){
    // 文字列を生成して変数xに代入
    let x = String::from("ABC");
    println!("x = {:?}", x);
    let y = x; // error[E0382]: borrow of moved value: `x`
    println!("x = {:?}", x);
    println!("y = {:?}", y);
}
