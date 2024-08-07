/// 定数：million
pub const MILLION: u64 = 1000000;
/// 定数：billion
pub const BILLION: u64 = 1000000000;

// 定数：trillion
pub const TRILLION: u64 = 1000000000000;

/// 定数：quadrillion
pub const QUADRILLION: u64 = 1000000000000000;
/// 定数：quintillion
pub const QUINTILLION: u64 = 1000000000000000000;
pub fn encode(n: u64) -> String {
    let base_english: Vec<&str> = vec!["zero", "one", "two", "three", "four",
                                       "five", "six", "seven", "eight", "nine"];
    let xteen: Vec<&str> = vec!["ten", "eleven", "twelve", "thirteen", "fourteen",
                                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"];
    let xty: Vec<&str> = vec!["twenty", "thirty", "forty" /* "fourty"でもいいはず */,
                              "fifty", "sixty", "seventy", "eighty", "ninety"];

    let encoded_str: &str = match n {
        // under ten
        0..=9 => {
            base_english.get(n as usize).unwrap()
        },
        // under twenty
        10..=19 => {
            let idx = n % 10;
            xteen[idx as usize]
        },
        // under hundred
        20..=99 => {
            let quotient = n / 10;
            let first_half = xty[(quotient - 2) as usize];
            let reminder = n % 10;

            if reminder == 0 {
                first_half
            } else {
                &*(first_half.to_owned() + "-" + base_english[reminder as usize])
            }
        },
        // under thousand
        100..=999 => {
            let quotient = n / 100;
            let reminder = n % 100;
            if reminder == 0 {
                &*(base_english[quotient as usize].to_owned() + " hundred")
            } else {
                &*(base_english[quotient as usize].to_owned() + " hundred " + &*encode(reminder))
            }
        },
        // under million
        1000..=999999 => {
            let quotient = n / 1000;
            let reminder = n % 1000;
            if reminder == 0 {
                &*(encode(quotient) + " thousand")
            } else {
                &*(encode(quotient) + " thousand " + &*encode(reminder))
            }
        },
        // under billion
        MILLION..=999999999 => {
            let quotient = n / MILLION;
            let reminder = n % MILLION;
            if reminder == 0 {
                &*(encode(quotient) + " million")
            } else {
                &*(encode(quotient) + " million " + &*encode(reminder))
            }
        },
        // under trillion
        BILLION..=999999999999 => {
            let quotient = n / BILLION;
            let reminder = n % BILLION;
            if reminder == 0 {
                &*(encode(quotient) + " billion")
            } else {
                &*(encode(quotient) + " billion " + &*encode(reminder))
            }
        },
        // under quadrillion
        TRILLION..=999999999999999 => {
            let quotient = n / TRILLION;
            let reminder = n % TRILLION;
            if reminder == 0 {
                &*(encode(quotient) + " trillion")
            } else {
                &*(encode(quotient) + " trillion " + &*encode(reminder))
            }
        },
        // under quintillion
        QUADRILLION..=999999999999999999 => {
            let quotient = n / QUADRILLION;
            let reminder = n % QUADRILLION;
            if reminder == 0 {
                &*(encode(quotient) + " quadrillion")
            } else {
                &*(encode(quotient) + " quadrillion " + &*encode(reminder))
            }
        },
        // under max of u64
        QUINTILLION..=18446744073709551615 => {
            let quotient = n / QUINTILLION;
            let reminder = n % QUINTILLION;
            if reminder == 0 {
                &*(encode(quotient) + " quintillion")
            } else {
                &*(encode(quotient) + " quintillion " + &*encode(reminder))
            }
        }, // quintillion
    };

    String::from(encoded_str)
}
