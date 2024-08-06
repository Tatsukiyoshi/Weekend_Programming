use std::collections::HashMap;

/// Compute the Scrabble score for a word.
pub fn score(word: &str) -> u64 {
    let values: HashMap<char, u64> = HashMap::from([
        ('A', 1), ('E', 1), ('I', 1), ('O', 1), ('U', 1),
        ('L', 1), ('N', 1), ('R', 1), ('S', 1), ('T', 1),
        ('D', 2), ('G', 2),
        ('B', 3), ('C', 3), ('M', 3), ('P', 3),
        ('F', 4), ('H', 4), ('V', 4), ('W', 4), ('Y', 4),
        ('K', 5),
        ('J', 8), ('X', 8),
        ('Q', 10), ('Z', 10)
    ]);
    let mut scrabble_score: u64 = 0;

    println!("inputs = {:?}", word);
    let input = word.to_ascii_uppercase();
    println!("inputs = {:?}", input);

    for char in input.chars() {
        println!("input = {:?}", char);
        let value = values.get(&char);
        match value {
            Some(value) => {
                println!("input {:?} -> {:?}", char, value);
                scrabble_score = scrabble_score + value;
            },
            _ => {}
        }
    }

    scrabble_score
}
