use anyhow::Result;
use serde::de::DeserializeOwned;
use std::fs::read_to_string;
use std::marker::PhantomData;
use std::path::PathBuf;
use csv::ReaderBuilder;

/// ## 10-6 サブトレイト
/// ### リスト10.20 SendとSyncトレイトの追加
/// ### T: 読み取り結果を格納する構造体
pub trait CsvReader<T>: Send + Sync where T:DeserializeOwned {
    /// ## 読み取り
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<T>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<T>>;
}
/// ## 10-6 サブトレイト
/// ### リスト10.21 トレイトの実装
#[derive(Default)]
pub struct CsvReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
}
impl<T> CsvReaderImpl<T> {
    /// ### リスト10.16 コンストラクタ
    pub fn new() -> Self {
        Self{phantom: PhantomData}
    }
}
impl<T> CsvReader<T> for CsvReaderImpl<T> where Self: Send + Sync, T:DeserializeOwned {
    /// ### リスト10.10 CSVをデシリアライズする
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<T>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<T>>{
        // PathBufを生成する
        let path_buf = PathBuf::from(file_path);
        // 文字列データを読み取る
        let string_data = read_to_string(path_buf)?;
        // バイナリ形式に変換する
        let mut reader =
            ReaderBuilder::new().delimiter(b',').from_reader(string_data.as_bytes());
        // データを指定された型に変換する
        let rows = reader.deserialize::<T>();
        let mut result = Vec::<T>::new();
        for row in rows{
            result.push(row?);
        }
        Ok(result)
    }
}
