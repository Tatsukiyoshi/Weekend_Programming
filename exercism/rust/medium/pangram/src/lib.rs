/// Determine whether a sentence is a pangram.
pub fn is_pangram(sentence: &str) -> bool {
    let input = sentence.to_lowercase();
    let mut unused: String = "".to_string();

    for ch in 'a'..='z' {
        if input.contains(ch) == false {
            unused.push(ch);
        }
    }

    unused == "".to_string()
}
