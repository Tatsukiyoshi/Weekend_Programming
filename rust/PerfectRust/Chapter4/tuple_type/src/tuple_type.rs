/// ## 4-6 タプル型
/// ### リスト4.17 タプル型の宣言
#[allow(dead_code)]
pub fn declare(){
    // タプル型変数を宣言する
    let x:(i32, &str, bool) = (100, "Hello", true);
    // 変数a, b, cで値を受け取る
    // let (a, b, c) = (100, "Hello", true);
    let (a, b, c) = x;
    // 変数l, mで値を受け取る
    let (l, _, m) = x;

    println!("x = {:?}", x);
    // NG:値を要素ごとに受け取っているので、フォーマット指定(:?)は不要。
    // println!("a = {:?}, b = {:?}, c = {:?}", a, b, c);
    // println!("l = {:?}, m = {:?}", l, m);
    println!("a = {}, b = {}, c = {}", a, b, c);
    println!("l = {}, m = {}", l, m);
}

/// ## 4-6 タプル型
/// ### リスト4.18 インデックスの利用
#[allow(dead_code)]
pub fn calc(value: (i32, i32)){
    let mut result = value.0 + value.1;
    println!("{} + {} = {}", value.0, value.1, result);
    result = value.0 - value.1;
    println!("{} - {} = {}", value.0, value.1, result);
    result = value.0 * value.1;
    println!("{} * {} = {}", value.0, value.1, result);
    result = value.0 / value.1;
    println!("{} / {} = {}", value.0, value.1, result);
    result = value.0 % value.1;
    println!("{} % {} = {}", value.0, value.1, result);
}

/// ## 4-6 タプル型
/// ### リスト4.19 メソッド
#[allow(dead_code)]
pub fn methods(){
    let a: (i32, i32, i32) = (100, 200, 300);
    let b: (i32, i32, i32) = (200, 200, 300);
    println!("a = {:?}", a);
    println!("b = {:?}", b);
    println!("clone() = {:?}", a.clone());              // 値を複製する
    println!("cmp() = {:?}", a.cmp(&b));                // 値を比較する
    println!("eq() = {}", a.eq(&a));                    // 値が等価かどうかを判定する
    println!("max() in (a, b) = {:?}", a.max(b));       // 値を比較して大きい方の値を返す
    println!("a is max()? = {}", a.eq(&(a.max(b))));
    println!("min() in (a, b) = {:?}", a.min(b));       // 値を比較して小さい方の値を返す
    println!("a is min()? = {}", a.eq(&(a.min(b))));
}
