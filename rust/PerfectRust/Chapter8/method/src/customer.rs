/// ## 8-4.メソッド
/// ## 顧客を表す構造体
#[allow(dead_code)]
struct Customer {
    id: u32,
    name:   String,
    address:    String,
    email:  String
}

impl Customer {
    const ID_MIN: u32 = 1;
    const ID_MAX: u32 = 10000;

    /// ### リスト8.7 インスタンスを生成する型関連関数
    fn new(id: u32, name: String, address: String, email: String) -> Self {
        Self {id, name, address, email }
    }

    /// ### リスト8.9 nameフィールドの値を返すメソッド
    /// ### 引数 なし
    /// ### 戻り値 nameフィールドの値（クローン）
    #[allow(dead_code)]
    fn get_name(&self) -> String {
        self.name.clone()
    }

    /// ### リスト8.9 nameフィールドの値を返すメソッド
    /// ### 引数 nameフィールドの値
    /// ### 戻り値 なし
    #[allow(dead_code)]
    fn set_name(&mut self, name: String){
        self.name = name;
    }

    /// ### IDをチェックするメソッド
    /// ### 引数 なし
    /// ### 戻り値 ０：問題あり、１：問題なし
    fn check_id(&self) -> i32 {
        if self.id < Customer::ID_MIN || self.id > Customer::ID_MAX {
            return 0;
        } else {
            1
        }
    }
}

#[allow(dead_code)]
pub fn use_method(){
    let mut customer = Customer::new(100, String::from("山田太郎"),
        String::from("東京都新宿区"), String::from("yamada@sample.com"));
    customer.set_name(String::from("鈴木花子"));
    println!("name = {}", customer.get_name());
    println!("check = {}", customer.check_id());
}
