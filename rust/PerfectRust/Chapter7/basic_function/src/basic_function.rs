/// ## 7-1 関数定義の基本
/// ### リスト7.1 基本的な関数の定義
#[allow(dead_code)]
pub fn print_message_1(){
    println!("基本的な関数定義");
}

/// ### リスト7.2 引数付き関数の定義
/// ### 引数 message:String 表示メッセージ
#[allow(dead_code)]
pub fn print_message_2(message: String){
    println!("{}", &message);
}

/// ### リスト7.4 ミュータブルな引数付き関数の定義
/// ### 引数 message:&mut String 表示メッセージ
#[allow(dead_code)]
pub fn print_message_3(message: &mut String){
    // 文字列の追加
    message.push_str("ミュータブルな引数付き関数");
    println!("追加結果 = {:?}", message);
}

/// ### リスト7.6 戻り値付き関数の定義
/// ### 引数 message:String 表示メッセージ
/// ### 戻り値 String
#[allow(dead_code)]
pub fn print_message_4(message: String) -> String {
    if message.eq(""){
        return String::from("引数が空です");
        // 処理途中なので、returnキーワードを使う
    }
    println!("{}", message);
    String::from("引数を出力しました")
    // 処理の最後なので、戻り値とみなされる
}
