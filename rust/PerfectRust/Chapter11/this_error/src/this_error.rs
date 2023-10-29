use thiserror::Error;
use std::num::{ParseFloatError, ParseIntError};

/// ## 11-3.外部クレートの利用
/// ### リスト11.8 thiserrorを利用した独自エラー型
#[derive(Debug, Error)]
pub enum SampleError {
    #[error("整数変換エラー:{0}")]
    IntError(String),
    #[error("浮動小数点変換エラー:{0}")]
    FloatError(String)
}

/// ParseIntErrorを受け取って、IntErrorバリアントにメッセージをセットする
impl From<ParseIntError> for SampleError {
    fn from(value: ParseIntError) -> Self {
        Self::IntError(value.to_string())
    }
}

/// ParseFloatErrorを受け取って、FloatErrorバリアントにメッセージをセットする
impl From<ParseFloatError> for SampleError {
    fn from(value: ParseFloatError) -> Self {
        Self::FloatError(value.to_string())
    }
}
