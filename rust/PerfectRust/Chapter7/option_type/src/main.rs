mod option_type;

use crate::option_type::{declare, method_1, method_2, method_3, method_4, use_div};

fn main() {
    declare();
    use_div(10, 5);
    use_div(100, 0);
    method_1();
    method_2();
    method_3();
    method_4();

    let r = match option_type::method_5(){
        Some(r) => r,
        None => "計算できません。".to_owned()
    };
    println!("{}", r);
}
