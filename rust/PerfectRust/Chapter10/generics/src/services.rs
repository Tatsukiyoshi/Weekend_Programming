use anyhow::Result;
use serde::de::DeserializeOwned;
use crate::traits_impl::{CsvReaderImpl, JsonReaderImpl};
use crate::traits::{CsvReader, JsonReader};
/// ## 10-5.抽象化
/// ### リスト10.17 トレイトを集約する構造体
pub struct ReadService<T> {
    // CsvReaderトレイト実装型フィールド
    csv_reader: Box<dyn CsvReader<T>>,
    // JsonReaderトレイト実装型フィールド
    json_reader: Box<dyn JsonReader<T>>
}

impl<T:DeserializeOwned + 'static> ReadService<T> {
    /// ### リスト10.18 new()関数とメソッドの実装
    /// ### コンストラクタ
    pub fn new() -> Self {
        Self {
            // CsvReader実装構造体のインスタンスをセットする
            csv_reader: Box::new(CsvReaderImpl::<T>::new()) as Box<dyn CsvReader<T>>,
            // JsonReader実装構造体のインスタンスをセットする
            json_reader: Box::new(JsonReaderImpl::<T>::new()) as Box<dyn JsonReader<T>>
        }
    }
    /// ### リスト10.18 new()関数とメソッドの実装
    /// ### CsvReaderのメソッドに処理を委譲する
    pub fn csv_read(&self, file_path: &str) -> Result<Vec<T>> {
        let result = self.csv_reader.read(file_path)?;
        Ok(result)
    }
    /// ### リスト10.18 new()関数とメソッドの実装
    /// ### JsonReaderのメソッドに処理を委譲する
    pub fn json_read(&self, file_path: &str) -> Result<Vec<T>> {
        let result = self.json_reader.read(file_path)?;
        Ok(result)
    }
}
