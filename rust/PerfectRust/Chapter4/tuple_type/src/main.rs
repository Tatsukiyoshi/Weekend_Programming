mod tuple_type;

fn main() {
    println!("タプル型の宣言");
    tuple_type::declare();

    println!("インデックスの利用");
    let input = (20, 5);
    tuple_type::calc(input);

    println!("メソッド");
    tuple_type::methods();
}
