use std::env::current_dir;
use std::fs::File;

/// ## 11-4.パニック
/// ### リスト11.11 expect()メソッド
#[allow(dead_code)]
pub fn use_expect(){
    // 存在しないファイルパスを生成する
    let file_path = current_dir()
        .map(|path_buf| path_buf.join("\\files\\param.txt"))
        .map_err(|error| panic!("{}", error)).unwrap();
    // 存在しないファイルを開く
    let _file = File::open(file_path).expect("ファイルが存在しないので、処理を終了します。");
}
