use crate::entities::Product;
use crate::services::ReadService;
use crate::sub::{CsvReader, CsvReaderImpl};
use crate::traits::JsonReader;
use crate::traits_impl::JsonReaderImpl;

/// ## 10-3.メソッドの実装
/// ### リスト10.12 メソッドの実行
#[allow(dead_code)]
pub fn use_generics_method(){
    // ファイルパスを生成する
    let csv_path = concat!(env!("CARGO_MANIFEST_DIR"), "\\resources\\products.csv");
    let json_path = concat!(env!("CARGO_MANIFEST_DIR"), "\\resources\\products.json");
    // インスタンスを生成する
    let csv_method = CsvReaderImpl::<Product>::default();
    let json_method = JsonReaderImpl::<Product>::default();
    // メソッドを実行する
    let csv_result = csv_method.read(csv_path).unwrap();
    let json_result = json_method.read(json_path).unwrap();
    // 結果を出力する
    println!("<<CSV>>");
    for result in csv_result{
        println!("{:?}", result);
    }
    println!("<<JSON>>");
    for result in json_result{
        println!("{:?}", result);
    }
}

/// ## 10-5.抽象化
/// ### リスト10.19 メソッドの実行
#[allow(dead_code)]
pub fn use_service_method(){
    // ファイルパスを生成する
    let csv_path = concat!(env!("CARGO_MANIFEST_DIR"), "\\resources\\products.csv");
    let json_path = concat!(env!("CARGO_MANIFEST_DIR"), "\\resources\\products.json");
    // ReadServiceのインスタンスを生成する
    let service = ReadService::<Product>::new();
    // メソッドを実行する
    let csv_result = service.csv_read(csv_path).unwrap();
    let json_result = service.json_read(json_path).unwrap();
    // 結果を出力する
    println!("<<CSV>>");
    for result in csv_result{
        println!("{:?}", result);
    }
    println!("<<JSON>>");
    for result in json_result{
        println!("{:?}", result);
    }
}
