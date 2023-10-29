/// ## 8-4.メソッド
/// ## 会員を表す構造体
#[allow(dead_code)]
pub struct Member<'a>{
    id:         u32,
    name:       &'a str,
    address:    &'a str,
    email:      &'a str
}

impl<'a> Member<'a>{
    /// インスタンスの生成
    fn new(id: u32, name: &'a str, address: &'a str, email: &'a str) -> Self {
        Self { id, name, address, email}
    }
    /// nameフィールドの値を返すメソッド
    /// ### 引数 なし
    /// ### 戻り値 nameフィールドの値（クローン）
    #[allow(dead_code)]
    fn get_name(&self) -> &str {
        // warning: call to `.clone()` on a reference in this situation does nothing
        // self.name.clone()
        self.name
    }
    /// nameフィールドの値を変更するメソッド
    /// ### 引数 nameフィールドの値
    /// ### 戻り値 なし
    #[allow(dead_code)]
    fn set_name(&mut self, name: &'a str) -> () {
        self.name = name;
    }
}

/// ### リスト8.10 ライフタイム注釈
#[allow(dead_code)]
pub fn use_method(){
    let mut customer = Member::new(100, "山田太郎", "東京都新宿区", "yamada@sample.com");
    println!("name(before) = {}", customer.get_name());
    customer.set_name("鈴木花子");
    println!("name(after) = {}", customer.get_name());
}
