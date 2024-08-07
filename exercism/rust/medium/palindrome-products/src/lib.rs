/// `Palindrome` is a newtype which only exists when the contained value is a palindrome number in base ten.
///
/// A struct with a single field which is used to constrain behavior like this is called a "newtype", and its use is
/// often referred to as the "newtype pattern". This is a fairly common pattern in Rust.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub struct Palindrome(u64);

impl Palindrome {
    /// Create a `Palindrome` only if `value` is in fact a palindrome when represented in base ten. Otherwise, `None`.
    pub fn new(value: u64) -> Option<Palindrome> {
        let input = value.to_string();
        let reverse_input = input.chars().rev().collect::<String>();

        if input == reverse_input {
            Some(Palindrome(value))
        } else {
            None
        }
    }

    /// Get the value of this palindrome.
    pub fn into_inner(self) -> u64
    {
        self.0
    }
}

/// 最小値と最大値を算出する
/// 最大値については、算出限界値を想定し、下回る時点で算出を中断する
pub fn palindrome_products(min: u64, max: u64) -> Option<(Palindrome, Palindrome)> {
    let mut smallest :Palindrome = Palindrome(0);
    let mut largest :Palindrome = Palindrome(0);

    'outer: for val1 in min..max + 1 {
        for val2 in min..max + 1 {
            let target_value = val1 * val2;
            let target = Palindrome::new(target_value);
            if target == None {
                continue;
            }
            if smallest.into_inner() == 0 {
                smallest = target.unwrap();
                if (max - min) / 2 + 1 > 4000 {
                    break 'outer;
                }
            }
            if smallest.into_inner() > target_value {
                smallest = target.unwrap();
            }
        }
    }

    let border = 10_i32.pow((min.to_string().len() + max.to_string().len() - 1) as u32);
    for val1 in (min..max + 1).rev() {
        'inner: for val2 in (val1..max + 1).rev() {
            let target_value = val1 * val2;
            let target = Palindrome::new(target_value);
            if target == None {
                continue;
            }
            if largest.into_inner() < target_value {
                largest = target.unwrap();
            }
            if target_value < border as u64 {
                break 'inner;
            }
        }
    }
    if smallest.into_inner() == 0 || largest.into_inner() == 0 {
        None
    } else {
        Some((smallest, largest))
    }
}
