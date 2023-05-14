mod pointer_type;

fn main() {
    println!("ポインタ型の宣言");
    pointer_type::declare();
    println!("値の変更");
    pointer_type::mut_declare();
    println!("可変ポインタ");
    pointer_type::variable_pointer();
}
