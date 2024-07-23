use std::ops::Add;
/// 日本語の母音
pub const VOWEL: &str = "aiueo";

///
pub fn translate(input: &str) -> String {
    let mut output: String = "".to_string();
    println!("input = {:?}", input);

    // The case including space
    if input.contains(" ") == true {
        let mut results: Vec<String> = Vec::new();
        for new_input in input.split(' ') {
            let result = translate(new_input);
            results.push(result);
        }
        for cnt in 0..results.len() {
            output = output.add(results.get(cnt).unwrap());
            if cnt < results.len() - 1 {
                output = output.add(" ");
            }
        }
        return output;
    }

    // Rule 1
    for chr in VOWEL.chars() {
        if input.starts_with(chr) {
            output = input.to_string().add("ay");
            return output;
        }
    }

    // Rule 1
    if input.starts_with("xr") || input.starts_with("yt") {
        output = input.to_string().add("ay");
        return output;
    }

    // Rule 3
    let found = input.find("qu");
    if found.is_some() {
        let found_index = found.unwrap() + 1;
        output = input[found_index + 1..].to_string().add(&input[..found_index + 1]).to_string().add("ay");
        return output;
    }

    // Rule 2
    let mut found_index = input.len();
    for chr in VOWEL.chars() {
        let found= input.find(chr);
        if found.is_some() && found_index > found.unwrap() {
            found_index = found.unwrap();
        }
    }
    if found_index > 0 && found_index < input.len() {
        output = input[found_index..].to_string().add(&input[..found_index]).add("ay");
        return output;
    }

    // Rule 4
    let found= input.find('y');
    if found.is_some() {
        let found_index = found.unwrap();
        output = input[found_index..].to_string().add(&input[..found_index]).add("ay");
        return output;
    }

    println!("output = {:?}", output);
    output
}
