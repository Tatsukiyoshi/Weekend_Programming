/// Check a Luhn checksum.
/// １文字未満は、false(=invalid)
/// 空白は含まれている場合、許容する。
/// 一方、数字以外の文字が含まれている場合、false(=invalid)
/// ２文字以上は、以下の処理を行う
/// 右から２バイトごとにその桁の数字を２倍し、９を超えた場合は９を引く
/// 各桁の数字を合計し、１０で割り切れた場合は、true(=valid)とし、
/// 割り切れない場合は、false(=invalid)とする
pub fn is_valid(code: &str) -> bool {
    let mut code_copy = String::with_capacity(code.len());

    for code_char in code.chars() {
        match code_char {
            '0'..='9' => code_copy.push(code_char),
            ' ' =>{
                continue;
            }
            _ => {
                return false;
            }
        }
    }

    if code_copy.len() <= 1 {
        return false
    }

    let mut count = 1;
    let mut sum = 0;
    loop {
        let index = code_copy.len() - count;
        let part_char = code_copy.chars().nth(index).unwrap();
        let mut part_num: i32 = part_char.to_digit(10).unwrap() as i32;
        if count % 2 == 0 {
            part_num = part_num * 2;
            if part_num > 9 {
                part_num = part_num - 9;
            }
        }
        sum = sum + part_num;

        count = count + 1;
        if count > code_copy.len() {
            break;
        }
    }

    sum % 10 == 0
}
