/// かっこのバランスをチェックする
/// （取れていれば、True、取れていなければ、False）
/// - かっこの開始が出現した時点でそのかっこを結合／保持する
/// - かっこの終了が出現した時点で
///   - 直前に出現したかっこと対応していれば、かっこを除去する
///   - 対応しなければ、バランスが取れていないと判断する
pub fn brackets_are_balanced(string: &str) -> bool {
    let mut balance_ok = true;
    let target_chars = string.chars();
    let mut brackets_str= "".to_string();

    for char in target_chars {
        match char {
            '[' => {
                brackets_str.push('[');
            }
            '{' => {
                brackets_str.push('{');
            }
            '(' => {
                brackets_str.push('(');
            }
            ']' => {
                if brackets_str.ends_with("[") {
                    brackets_str.pop();
                } else {
                    balance_ok = false;
                }
            }
            '}' => {
                if brackets_str.ends_with("{") {
                    brackets_str.pop();
                } else {
                    balance_ok = false;
                }
            }
            ')' => {
                if brackets_str.ends_with("(") {
                    brackets_str.pop();
                } else {
                    balance_ok = false;
                }
            }
            _ => {

            }
        }
    }

    if balance_ok == false {
        balance_ok
    } else {
        if brackets_str == "".to_string() {
            true
        } else {
            false
        }
    }
}
