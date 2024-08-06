/// 入力値を文字列→各桁文字の配列にばらす
/// 各桁文字を10進数に戻し、各桁を入力値の桁数乗し、総和を算出する
/// 算出した総和が入力値と同じであれば、arnstrong数となる
pub fn is_armstrong_number(num: u32) -> bool {
    let num_string: String = num.to_string();
    let num_chars = num_string.chars();
    let mut sum = 0;

    for num_char in num_chars {
        let val = num_char.to_digit(10).unwrap().pow(num_string.len() as u32 as u32);
        sum = sum + val;
    }
    sum == num
}
