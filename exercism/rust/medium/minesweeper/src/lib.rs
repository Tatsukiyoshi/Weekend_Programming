pub fn annotate(minefield: &[&str]) -> Vec<String> {
    let mut result_field = minefield.clone();
    let result_len = minefield.len();
    let mut result = Vec::with_capacity(result_len);

    for i in 0..result_len {
        result.push(" ".repeat(minefield[0].as_bytes().len()));
    }

    for i in 0..result_len {
        let field = minefield[i].as_bytes();
        for j in 0..field.len() {
            if field[j] == u8::try_from('*').unwrap(){

            }
        }
    }

    println!("{:?}", result_field);
    result
}
