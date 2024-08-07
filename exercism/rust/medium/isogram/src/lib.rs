/// 出現済みの文字が出現したら、isogramではないと判定する
/// なお、大小文字は等価とみなす
pub fn check(candidate: &str) -> bool {
    let mut read: String = "".to_string();
    let input = candidate.chars();

    for char in input {
        println!("{}", char);
        if char == '-' || char == ' ' {
            continue;
        }
        let schar = char.to_ascii_lowercase();
        if read.find(schar) == None {
            read.push(schar);
        } else {
            return false;
        }
    }
    true
}
