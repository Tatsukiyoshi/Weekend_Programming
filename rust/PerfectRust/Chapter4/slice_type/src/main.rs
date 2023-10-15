mod slice_type;

fn main() {
    println!("スライスの取得");
    slice_type::get();
    println!("Range構造体の利用");
    slice_type::range();
    println!("マルチバイトの利用");
    slice_type::multibyte_slice();
    println!("ファットポインタの確認");
    slice_type::fat_pointer();
    println!("スライスの値取得");
    slice_type::get_value_and_status();
    println!("ソートメソッド");
    slice_type::sort();
    println!("データ加工／変換");
    slice_type::convert();
}
