use std::fs::{File, read_to_string};
use std::io::BufReader;
use std::marker::PhantomData;
use std::path::PathBuf;
use anyhow::Result;
use csv::ReaderBuilder;
use serde::de::DeserializeOwned;
use crate::traits::{CsvReader, JsonReader};

/// ## 10-2 ジェネリックトレイト
/// ### リスト10.7 ジェネリックトレイトの実装
#[derive(Default)]
pub struct CsvReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
}

impl<T> CsvReader<T> for CsvReaderImpl<T> where T:DeserializeOwned {
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

/// ### リスト10.7 ジェネリックトレイトの実装
#[derive(Default)]
pub struct JsonReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
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
