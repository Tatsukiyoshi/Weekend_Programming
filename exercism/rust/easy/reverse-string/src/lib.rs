pub fn reverse(input: &str) -> String {
    /// 文字列を文字の配列にばらし、配列の逆転を行った後、再度文字列に戻す
    let reverse: String = input.chars().rev().collect::<String>();
    reverse
}
