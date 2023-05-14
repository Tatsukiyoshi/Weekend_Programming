mod character_type;

fn main() {
    println!("文字型リテラル");
    character_type::char_literal();

    println!("文字型の定数");
    character_type::char_constant();

    println!("文字型のメソッド");
    character_type::methods();
}
