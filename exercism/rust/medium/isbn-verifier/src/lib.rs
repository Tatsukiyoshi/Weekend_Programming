pub const ISBN_SIZE: u32 = 10;

/// Determines whether the supplied string is a valid ISBN number
pub fn is_valid_isbn(isbn: &str) -> bool {
    let mut isbn_sum: i32  = 0;
    let mut isbn_len: u32 = 0;
    let mut isbn_digit_val: u32;
    let loop_cnt = isbn.len();
    let isbn_bytes = isbn.as_bytes();

    for idx in 0..loop_cnt {
        if isbn_bytes[idx] != u8::try_from('-').unwrap() {
            isbn_len = isbn_len + 1;
        }
    }
    println!("len = {}", isbn_len);
    if isbn_len != ISBN_SIZE {
        return false;
    }

    isbn_len = ISBN_SIZE;
    for idx in 0..loop_cnt {
        if isbn_bytes[idx] != u8::try_from('-').unwrap() {
            if isbn_len == 1 && isbn_bytes[idx] == u8::try_from('X').unwrap() {
                isbn_digit_val = 10;
            } else {
                isbn_digit_val = (isbn_bytes[idx] - u8::try_from('0').unwrap()) as u32;
                if isbn_digit_val > 9 {
                    return false;
                }
            }
            println!("{} * {}", isbn_digit_val, isbn_len);
            isbn_sum = isbn_sum + (isbn_digit_val * isbn_len) as i32;
            isbn_len = isbn_len - 1;
        }
    }
    println!("sum = {}", isbn_sum);
    isbn_sum % 11 == 0
}
