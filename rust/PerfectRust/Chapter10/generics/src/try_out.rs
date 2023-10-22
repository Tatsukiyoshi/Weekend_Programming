use crate::entities::Product;
use crate::r#trait::{CsvReader, JsonReader};
use crate::traits_impl::{CsvReaderImpl, JsonReaderImpl};

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