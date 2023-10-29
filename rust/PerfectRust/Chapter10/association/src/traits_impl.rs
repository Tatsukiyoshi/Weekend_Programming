use std::path::PathBuf;
use std::fs::{File, read_to_string};
use std::io::BufReader;
use std::marker::PhantomData;
use csv::ReaderBuilder;
use anyhow::Result;
use serde::de::DeserializeOwned;
use crate::traits::{CsvReader, JsonReader};

/// ## 10-4.関連型トレイト(Association Type)
/// ### リスト10.14 関連型トレイトの実装
#[derive(Default)]
pub struct CsvReaderImpl<T> {
    phantom: PhantomData<T>
}
impl<T> CsvReader for CsvReaderImpl<T> where T:DeserializeOwned {
    type Entity = T;    // 関連型に構造体のジェネリック型を指定する
    /// ## 読み取り
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<Entity>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<Self::Entity>>{
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

/// ### リスト10.14 関連型トレイトの実装
#[derive(Default)]
pub struct JsonReaderImpl<T> {
    phantom: PhantomData<T>
}
impl<T> JsonReader for JsonReaderImpl<T> where T:DeserializeOwned {
    type Entity = T;
    // 関連型に構造体のジェネリック型を指定する
    /// ## 読み取り
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<Entity>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<Self::Entity>> {
        // PathBufを生成する
        let path_buf = PathBuf::from(file_path);
        // BufReaderを生成する
        let buf_reader = File::open(path_buf).map(|file| BufReader::new(file))?;
        // デシリアライズする
        let result = serde_json::from_reader(buf_reader)?;
        Ok(result)
    }
}
