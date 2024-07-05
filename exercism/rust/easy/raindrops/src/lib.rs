/// ３で割り切れる場合、"Pling"を出力する
/// ５で割り切れる場合、”Plang”を出力する
/// ７で割り切れる場合、”Plong”を出力する
/// どれでも割り切れない場合、その数字を文字列に変換する
pub fn raindrops(n: u32) -> String {
    let mut result: String = "".to_string();

    if n % 3 == 0 {
        result = "Pling".to_string();
    }
    if n % 5 == 0 {
        result.push_str("Plang");
    }
    if n % 7 == 0 {
        result.push_str("Plong");
    }

    if result == "".to_string() {
        result = n.to_string();
    }

    result
}
