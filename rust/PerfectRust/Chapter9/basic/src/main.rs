use crate::basic::{use_fmt, use_repr, use_season};

mod basic;

fn main() {
    println!("use_season");
    use_season();

    println!("use_fmt");
    use_fmt();

    println!("use_repr");
    use_repr();
}
