use std::collections::BTreeMap;

pub fn transform(h: &BTreeMap<i32, Vec<char>>) -> BTreeMap<char, i32> {
    let mut outputs: BTreeMap<char, i32> = BTreeMap::new();
    for map in h {
        for word in map.1 {
            outputs.insert(word.to_string().to_lowercase().parse().unwrap(), *map.0);
        }
    }
    outputs
}
