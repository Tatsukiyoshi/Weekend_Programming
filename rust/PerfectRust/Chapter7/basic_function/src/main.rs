mod basic_function;

///
/// メイン関数
///
fn main() {
    // 引数付き関数の定義
    basic_function::print_message_2(String::from("引数付き関数"));

    let mut message = String::from("7-1-3 ");
    basic_function::print_message_3(&mut message);
    println!("関数利用後の文字列 = {:?}", &message);

    println!("{:?}", basic_function::print_message_4(String::new()));
    println!("{:?}", basic_function::print_message_4(String::from("戻り値付き関数")));
}
