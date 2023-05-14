mod str_type;

fn main() {
    println!("文字列リテラル");
    str_type::declare();
    println!("文字列の連結");
    str_type::binding();
    println!("文字列の変換");
    str_type::convert();
    println!("文字列の検査");
    str_type::check();
    println!("文字列の取得");
    str_type::get();
    println!("文字列の生成／置換");
    str_type::repeat_replace();
    println!("文字列の大文字／小文字変換");
    str_type::case_converion();
}
