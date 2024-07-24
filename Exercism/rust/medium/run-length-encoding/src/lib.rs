use std::ops::Add;

/// 初期値用文字
pub const INIT_CHAR: char = '*';

/// 文字列を圧縮する
pub fn encode(source: &str) -> String {
    let mut input = source.chars();
    let mut encoded: String = "".to_string();
    let mut current_char: char = INIT_CHAR;
    let mut count = 1;

    loop {
        let char = input.next();
        println!("count = {:?}, current = {:?}", count, current_char);
        match char {
            Some(char) => {
                if char == current_char {
                    count = count + 1;
                } else {
                    if count > 1 {
                        encoded = encoded.add(count.to_string().as_str());
                    }
                    if current_char != INIT_CHAR {
                        encoded.push(current_char);
                    }
                    current_char = char;
                    count = 1;
                }
            },
            None => {
                if count > 1 {
                    encoded.push(char::from_digit(count, 10).unwrap());
                }
                if current_char != INIT_CHAR {
                    encoded.push(current_char);
                }
                break;
            }
        }
    }

    encoded
}

/// 文字列を復元する
pub fn decode(source: &str) -> String {
    let mut decoded: String = "".to_string();
    let mut count = 0;

    for char in source.chars() {
        match char {
            '0'..='9' => {
                count = count * 10 + char.to_digit(10).unwrap();
            },
            'A'..='Z' | 'a'..='z' | ' ' => {
                match count {
                    0 => decoded.push(char),
                    _ => {
                        for _cnt in 0..count {
                            decoded.push(char);
                        }
                        count = 0;
                    }
                }
            }
            _ => {}
        }
    }

    decoded
}
