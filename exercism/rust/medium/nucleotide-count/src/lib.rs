use std::collections::HashMap;

pub const INITIAL_COUNT: usize = 0;

pub fn count(nucleotide: char, dna: &str) -> Result<usize, char> {
    println!("input: {}, {}", nucleotide, dna);
    let result = nucleotide_counts(dna);

    match result {
        Ok(..) => {
            let binding = result.unwrap();
            if binding.len() == 0 {
                Ok(0)
            } else {
                let count = binding.get(&nucleotide);
                match count {
                    Some(..) => Ok(*count.unwrap()),
                    None => Err(nucleotide)
                }
            }
        }
        Err(e) => {
            Err(e)
        }
    }
}

pub fn nucleotide_counts(dna: &str) -> Result<HashMap<char, usize>, char> {
    let mut result: HashMap<char, usize> = HashMap::new();
    let dna_chars = dna.chars();
    let mut err_char = '*';

    result.extend([('A', INITIAL_COUNT), ('C', INITIAL_COUNT), ('G', INITIAL_COUNT), ('T', INITIAL_COUNT)]);
    for char in dna_chars {
        println!("char = {}", char);
        if char == 'A' || char == 'C' || char == 'G' || char == 'T' {
            match result.get_key_value(&char) {
                Some((key, value)) => {
                    result.insert(*key, value + 1);
                }
                None => {
                    result.insert(char, 1);
                }
            }
            println!("{:?}", result);
        } else {
            err_char = char;
        }
    }
    if err_char == '*' {
        Ok(result)
    } else {
        Err(err_char)
    }
}
