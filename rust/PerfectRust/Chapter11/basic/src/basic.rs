use std::env::current_dir;
use std::fs::File;
use std::io::ErrorKind;

/// ## 11-1.エラー型の基本
/// ### リスト11.1 変換種別を表す列挙型
#[derive(Debug, PartialEq, Eq)]
pub enum ValueConversion {
    Int,    // i32整数型に変換する
    Float   // f32浮動小数点型に変換する
}
/// ### リスト11.1 文字列を指定された型に変換する
/// ### 引数 value: 変換対象文字列
/// ### 引数 conv: 変換種別
#[allow(dead_code)]
fn parse_01(value: String, conv: ValueConversion){
    if conv == ValueConversion::Int {
        println!("{:?}", value.parse::<i32>());
    } else {
        println!("{:?}", value.parse::<f32>());
    }
}
/// ### リスト11.1 文字列を指定された型に変換する
/// ### 関数の利用
#[allow(dead_code)]
pub fn use_parse_01(){
    parse_01(String::from("123"), ValueConversion::Int);
    parse_01(String::from("123"), ValueConversion::Float);
    parse_01(String::from("ABC"), ValueConversion::Int);
    parse_01(String::from("ABC"), ValueConversion::Float);
}

/// ### リスト11.2 std::io::ErrorKind列挙型の利用
#[allow(dead_code)]
pub fn use_error_kind(){
    // 存在しないファイルパスの生成
    let file_path = current_dir()
        .map(|path_buf| path_buf.join("\\files\\sample.txt"))
        .map_err(|error| panic!("{}", error)).unwrap();
    // 存在しないファイルを開く
    let error = File::open(file_path).err().unwrap();
    // エラーの種類を出力する
    let result = match error.kind() {
        ErrorKind::NotFound => "指定されたファイルが見つかりません。",
        ErrorKind::PermissionDenied => "指定されたファイルへの操作権限がありません。",
        _ => "判別できないエラーが発生しました。"
    };
    println!("{}", result);
}
