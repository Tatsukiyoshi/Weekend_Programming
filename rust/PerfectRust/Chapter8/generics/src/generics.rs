#[derive(Debug, Clone)]
struct Customer<T> {
    id: T,
    name: String,
    address: String,
    email: String
}
impl<T> Customer<T>{
    /// ## 8-6.ジェネリックス
    /// ### リスト8.17 ジェネリック型の利用
    /// ### 引数 顧客番号:id, 氏名:name, 住所:address, メールアドレス:email
    #[allow(dead_code)]
    fn new(id: T, name: String, address: String, email: String) -> Self {
        Self {id, name, address, email}
    }

    /// ### リスト8.19 idの値を変更するメソッド
    /// ### 引数 変更する値
    #[allow(dead_code)]
    fn change_id(&mut self, value: T){
        self.id = value;
    }
}

/// ### リスト8.18 インスタンス生成
#[allow(dead_code)]
pub fn use_new(){
    // idフィールドをu64型にしたcustomerの生成
    let customer = Customer::<u64>::new(100, String::from("山田太郎"),
        String::from("東京都新宿区"), String::from("yamada@sample.com"));
    println!("{:?}", customer);
}

/// ### リスト8.20 メソッド
#[allow(dead_code)]
pub fn use_change_id(){
    let mut customer = Customer::<u64>::new(100, String::from("山田太郎"),
        String::from("東京都新宿区"), String::from("yamada@sample.com"));
    customer.change_id(200);
    println!("{:?}", customer);
}
