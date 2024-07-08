use std::collections::HashSet;

/// 入力：文字列および候補文字列セット
/// 出力：アナグラムとなる文字列セット
/// - 文字列を文字にばらす
/// - 候補文字列を構成する文字が、入力文字列を構成する文字と同じかを判定する
///   - 構成する文字が同じであれば、アナグラム（入力文字列を並び替えた文字列）であると判定し、出力にセットする
///   - 構成する文字が異なる場合、アナグラムではないと判定し、出力にセットしない
pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let inputs = word.to_lowercase();
    let mut results: HashSet<&str> = HashSet::with_capacity(possible_anagrams.len());

    for possible_anagram in possible_anagrams {
        let mut inputs_copy = inputs.as_str();
        let mut anagram_flg = true;
        let mut tmp;

        if inputs_copy.len() != possible_anagram.len() {
            continue;
        }
        // println!("{} : {}", inputs_tmp, possible_anagram);
        if possible_anagram.to_lowercase().eq(inputs_copy) {
            continue;
        }

        for target_char in possible_anagram.to_lowercase().chars() {
            let pos = inputs_copy.find(target_char);
            match pos {
                None => {
                    anagram_flg = false;
                }
                _ => {
                    tmp = inputs_copy.replacen(target_char, "*", 1);
                    inputs_copy = tmp.as_str();
                }
            }
            if anagram_flg == false {
                break;
            }
            // println!("{}", inputs_copy);
        }
        if anagram_flg == true {
            results.insert(possible_anagram);
        }
    }
    results
}
