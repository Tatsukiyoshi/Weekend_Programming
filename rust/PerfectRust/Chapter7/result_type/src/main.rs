use crate::result_type::{method_1, method_2, method_3, method_4, use_div, value_setting};

mod result_type;

fn main() {
    value_setting();
    use_div();
    method_1();
    method_2();
    method_3();
    method_4();

    let r = match result_type::method_5(){
        Ok(r) => r,
        Err(error) => error
    };
    println!("{}", r);
}
