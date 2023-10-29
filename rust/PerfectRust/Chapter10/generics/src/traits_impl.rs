use std::fs::File;
use std::io::BufReader;
use std::marker::PhantomData;
use std::path::PathBuf;
use anyhow::Result;
use serde::de::DeserializeOwned;
use crate::traits::JsonReader;

/// ### リスト10.7 ジェネリックトレイトの実装
#[derive(Default)]
pub struct JsonReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
}
impl<T> JsonReaderImpl<T> {
    /// ## 10-5.抽象化
    /// ### リスト10.16 コンストラクタ
    pub fn new() -> Self {
        Self{phantom: PhantomData}
    }
}
impl<T> JsonReader<T> for JsonReaderImpl<T> where T:DeserializeOwned {
    /// ### リスト10.11 JSONのデシリアライズ
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<T>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<T>>{
        // PathBufを生成する
        let path_buf = PathBuf::from(file_path);
        // BufReaderを生成する
        let buf_reader = File::open(path_buf).map(|file| BufReader::new(file))?;
        // デシリアライズする
        let result = serde_json::from_reader(buf_reader)?;
        Ok(result)
    }
}
