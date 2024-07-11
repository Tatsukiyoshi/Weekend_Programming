use convert_case::{Case, Casing};

/// 単語に分割し、各単語の頭文字をつなげて返す（返す文字列はすべて大文字）
/// 分割は、空白またはハイフンで行う
/// - 分割前にTitle Case（単語の先頭が大文字）へ揃える
/// - 単語に下線がついている場合は、除去すること
pub fn abbreviate(phrase: &str) -> String {
    let inputs = phrase.to_case(Case::Title);
    let mut result: String = "".to_string();
    let splited: Vec<&str> = inputs.split(&[' ', '-']).collect();

    for word in splited {
        if word.len() <= 0 {
            continue;
        }

        let tmp= word.trim_matches('_');
        let tmp2 = tmp.as_bytes();
        result.push(char::from(tmp2[0]));
    }

    result.to_uppercase()
}
