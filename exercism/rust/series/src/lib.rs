/// 入力された数字列の先頭から順に、指定された桁数の数字列を切り出し、
/// 切り出された複数の数字列をベクタ配列で返す
pub fn series(digits: &str, len: usize) -> Vec<String> {
    let mut results_count = 1;
    if len <= digits.len() {
        results_count = digits.len() - len + 1;
    }
    let mut result: Vec<String> = Vec::with_capacity(results_count);

    for i in 0..results_count {
        if len <= digits.len() {
            let str = digits[i..(i + len)].to_string();
            result.push(str);
        }
    }

    result
}
