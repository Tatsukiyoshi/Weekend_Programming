/// ## 4-8 文字列型
/// ### リスト4.29 文字列リテラル
#[allow(dead_code)]
pub fn declar(){
    let str = "Hello Rust.";
    println!("value = {:?}, ptr = {:p}, len = {}", str, str, str.len());
}

/// ## 4-8 文字列型
/// ### リスト4.30 文字列の連結(単純な連結はコンパイルできない)
/// ### リスト4.31 文字列の連結(連結にはString型のクローン生成が必要)
#[allow(dead_code)]
pub fn binding(){
    let str_a = "Hello";
    let str_b = "Rust.";
    println!("str_a: value = {}, ptr = {:p}, len = {}", str_a, str_a, str_a.len());
    println!("str_b: value = {}, ptr = {:p}, len = {}", str_b, str_b, str_b.len());

    // 単純な連結は不可
    // let str_c = str_a + str_b;
    // 連結には文字列型のクローンを生成する必要あり(to_owned())
    let str_c = str_a.to_owned() + " " + str_b;
    println!("str_c: value = {}, ptr = {:p}, len = {}", str_c, &str_c, str_c.len());
}

/// ## 4-8 文字列型
/// ### リスト4.32 データ変換メソッド
#[allow(dead_code)]
pub fn convert(){
    let str_value = "ABCDEF";
    println!("str_value  = {}", str_value);

    let result = str_value.as_bytes();  // 文字列をバイトスライスに変換した結果を返す
    println!("as_bytes() = {:?}", &result);

    let result = str_value.bytes();     // 文字列をバイトコードのイテレータに変換した結果を返す
    println!("bytes()    = {:#?}", result);

    let result = str_value.chars();     // 文字列を文字のイテレータに変換した結果を返す
    println!("chars()    = {:#?}", result);

    let str_value = "123";
    let result = str_value.parse::<i32>().unwrap(); // 文字列を整数に変換した結果を返す
    println!("parse()    = {:?}", result);
}

/// ## 4-8 文字列型
/// ### リスト4.33 値を調べるメソッド
#[allow(dead_code)]
pub fn check(){
    let str_value = "山田太郎";
    println!("str_value             = {:?}", str_value);
    let result = str_value.contains("田");
    println!("contains('田')        = {}", result);
    let result = str_value.find("田");
    println!("find('田')            = {:?}", result);
    let str_other = "山本山太郎";
    println!("str_other             = {:?}", str_other);
    let result = str_other.find("山");
    println!("find('山')            = {:?}", result);
    let str_value = "sample.txt";
    println!("str_value             = {:?}", str_value);
    let result = str_value.ends_with(".txt");
    println!("ends_with('.txt')     = {}", result);
    let result = str_value.starts_with("sample");
    println!("starts_with('sample') = {}", result);
    let result = str_value.is_empty();
    println!("is_empty()            = {}", result);
}

/// ## 4-8 文字列型
/// ### リスト4.34 値を取得するメソッド
#[allow(dead_code)]
pub fn get(){
    let str_value = "ABC\r\nDEF\r\nXYZ\r\n";
    let result = str_value.lines(); // 改行単位で文字列を取得する
    for row in result {
        println!("lines()    = {:?}", row);
    }
    let str_value = "ABCDEFXYZ";
    let result = str_value.get(0..=3).unwrap(); // 先頭から４番目の要素を取得する
    println!("get(0..=3) = {:?}", result);
    let result = str_value.get(0..).unwrap();   // 先頭からすべての要素を取得する
    println!("get(0..)   = {:?}", result);
}

/// ## 4-8型
/// ### リスト4.35 値を生成、置換するメソッド
#[allow(dead_code)]
pub fn repeat_replace(){
    // 指定された回数、文字列を生成した結果を返す
    let str_value = "ABCDEFXYZ";
    let result = str_value.repeat(3);
    println!("repeat(3) = {:?}", result);
    // 文字列を置き換える
    let result = str_value.replace("ABC", "BCA");
    println!("replace() = {:?}", result);
}

/// ## 4-8 文字列型
/// ### リスト4.36 大文字／小文字変換、トリミング、分割メソッド
#[allow(dead_code)]
pub fn case_converion(){
    let str_value = "ABCDEFXYZ";
    let lower_value = str_value.to_lowercase();     // 小文字変換する
    println!("to_lowercase() = {:?}", lower_value);
    let upper_value = lower_value.to_uppercase();   // 大文字変換する
    println!("to_uppercase() = {:?}", upper_value);
    let str_value = " Hello Rust ";
    let result = str_value.trim();                  // 前後のホワイトスペースをトリミングする
    println!("trim()         = {:?}", result);
    let str_value = "ABC,DEF,XYZ";
    let result = str_value.split(",");              // 指定の文字で分割する
    let mut i: i32 = 0;
    for value in result {
        println!("split({})       = {:?}", i, value);
        i = i + 1;
    }
}
