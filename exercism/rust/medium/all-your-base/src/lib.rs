#[derive(Debug, PartialEq, Eq)]
pub enum Error {
    InvalidInputBase,
    InvalidOutputBase,
    InvalidDigit(u32),
}

///
/// Convert a number between two bases.
///
/// A number is any slice of digits.
/// A digit is any unsigned integer (e.g. u8, u16, u32, u64, or usize).
/// Bases are specified as unsigned integers.
///
/// Return the corresponding Error enum if the conversion is impossible.
///
///
/// You are allowed to change the function signature as long as all test still pass.
///
///
/// Example:
/// Input
///   number: &[4, 2]
///   from_base: 10
///   to_base: 2
/// Result
///   Ok(vec![1, 0, 1, 0, 1, 0])
///
/// The example corresponds to converting the number 42 from decimal
/// which is equivalent to 101010 in binary.
///
///
/// Notes:
///  * The empty slice ( "[]" ) is equal to the number 0.
///  * Never output leading 0 digits, unless the input number is 0, in which the output must be `[0]`.
///    However, your function must be able to process input with leading 0 digits.
///
/// 進数変換
/// - 入力が10進数の場合、指定された進数へ変換する
/// - 入力が10進数でない場合、10進数に変換の上、指定された進数へ変換する
/// - 入力に不正な値が含まれている場合（ｎ進数なのに、桁にｎ以上の数値がある等）、エラー（Error型）を返す
/// - 入力または出力の基数が１未満の場合、エラー（Error型）を返す
pub fn convert(number: &[u32], from_base: u32, to_base: u32) -> Result<Vec<u32>, Error> {
    let mut inputs: u32 = 0;
    let mut result: Vec<u32> = Vec::with_capacity(10);

    if from_base <= 1 {
        return Err(Error::InvalidInputBase);
    }

    if to_base <= 1 {
        return Err(Error::InvalidOutputBase);
    }

    for i in 0..number.len() {
        if number[i] >= from_base {
            return Err(Error::InvalidDigit(number[i]));
        }
        inputs = inputs + number[i] * from_base.pow((number.len() - i - 1) as u32);
    }

    loop {
        result.insert(0,inputs % to_base);
        inputs = inputs / to_base;
        if inputs < to_base {
            if inputs > 0 {
                result.insert(0, inputs);
            }
            break;
        }
    }
    Ok(result)
}
