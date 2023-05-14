mod array_type;

fn main() {
    println!("配列の宣言");
    array_type::declare();

    println!("配列の利用");
    array_type::use_array();

    println!("配列の主なメソッド");
    array_type::methods();

    println!("多次元配列");
    array_type::multidimensional();
}
