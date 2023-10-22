use std::marker::PhantomData;
use anyhow::Result;
use serde::de::DeserializeOwned;
use crate::r#trait::{CsvReader, JsonReader};

/// ## 10-2 ジェネリックトレイト
/// ### リスト10.7 ジェネリックトレイトの実装
#[derive(Default)]
pub struct CsvReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
}

impl<T> CsvReader<T> for CsvReaderImpl<T> where T:DeserializeOwned {
    fn read(&self, file_path: &str) -> Result<Vec<T>>{
        todo!()
    }
}

/// ### リスト10.7 ジェネリックトレイトの実装
#[derive(Default)]
pub struct JsonReaderImpl<T>{
    phantom: PhantomData<T> // 幽霊フィールド
}

impl<T> JsonReader<T> for JsonReaderImpl<T> where T:DeserializeOwned {
    fn read(&self, file_path: &str) -> Result<Vec<T>>{
        todo!()
    }
}
