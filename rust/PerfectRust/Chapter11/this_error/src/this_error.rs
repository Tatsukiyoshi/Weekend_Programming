use thiserror::Error;
use std::str::FromStr;
use num_traits::NumOps;
use std::num::{ParseFloatError, ParseIntError};

/// ## 11-3.外部クレートの利用
/// ### リスト11.9 #[from]アトリビュートの利用
#[derive(Debug, Error)]
pub enum SampleError {
    #[error(transparent)]
    IntError(#[from] ParseIntError),
    #[error(transparent)]
    FloatError(#[from] ParseFloatError)
}

/// ### リスト11.9 #[from]アトリビュートの利用
/// ### 引数をジェネリックスで指定された型に変換する
/// ### 引数 value: 変換対象文字列
/// ### 戻り値 Result<T. SampleError>
#[allow(dead_code)]
fn parse_03<T: NumOps + FromStr>(value: String) -> Result<T, SampleError>
    where SampleError: From<<T as FromStr>::Err> {
    let result = value.parse::<T>().map_err(|error| SampleError::from(error) )?;
    Ok(result)
}

#[allow(dead_code)]
pub fn use_parse_03(){
    let result = parse_03::<i32>(String::from("123")).unwrap();
    println!("{:?}", result);
    let result = parse_03::<i32>(String::from("ABC")).err().unwrap();
    println!("{:?}", result.to_string());
    let result = parse_03::<f32>(String::from("123")).unwrap();
    println!("{:?}", result);
    let result = parse_03::<f32>(String::from("ABC")).err().unwrap();
    println!("{:?}", result.to_string());
}

// Result型のエイリアス
type SampleResult<T> = anyhow::Result<T, anyhow::Error>;

/// ### リスト11.10 anyhow::Errorの利用
/// ### 引数をジェネリックスで指定された型に変換する
/// ### 引数 value: 変換対象文字列
/// ### 戻り値 SampleResult<T>
#[allow(dead_code)]
fn parse_04<T: NumOps + FromStr>(value: String) -> SampleResult<T>
    where SampleError: From<<T as FromStr>::Err> {
    let result = value.parse::<T>().map_err(|error| {
        // contextに格納する情報を生成する
        let context = format!("指定された値:{}は変換できませんでした", value);
        // SampleErrorを生成する
        let err = SampleError::from(error);
        // SampleErrorとcontextを設定したanyhow::Errorを返す
        anyhow::Error::new(err).context(context)
    })?;
    Ok(result)
}

#[allow(dead_code)]
pub fn use_parse_04(){
    let result = parse_04::<i32>(String::from("ABC")).err().unwrap();
    println!("result = {:?}", result);
    println!("result.source().unwrap() = {:?}", result.source().unwrap());
}
