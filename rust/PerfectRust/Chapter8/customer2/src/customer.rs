/// ## 顧客を表す構造体
#[allow(dead_code)]
#[derive(Debug, Clone)] // トレイトを追加
struct Customer {
    id: u32,
    name: String,
    address: String,
    email: String
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

impl Drop for Customer {
    /// ### リスト8.13 Dropトレイト
    fn drop(&mut self){
        println!("{}のインスタンスを破棄します", self.name);
    }
}

impl Default for Customer {
    /// ### リスト8.14 Defaultトレイト
    fn default() -> Self {
        Self {id: 0, name: String::from(""),
            address: String::from(""), email: String::from("") }
    }
}

impl TryFrom<&Vec<&str>> for Customer {
    type Error = String;
    // エラーの場合の型を指定する
    /// ### リスト8.16 TryFromトレイト
    /// ### 引数 文字列スライスベクタの参照
    fn try_from(value: &Vec<&str>) -> Result<Self, Self::Error> {
        // 文字列を整数に変換する
        let new_id = match value[0].parse::<u32>() {
            Ok(value) => value,
            Err(error) => return Err(error.to_string())
        };
        // インスタンス生成
        Ok(Self {id: new_id, name: value[1].to_owned(),
            address: value[2].to_owned(), email: value[3].to_owned()})
    }
}

/// ## 8-5.ユーティリティトレイト
/// ### リスト8.11 Debugトレイト
#[allow(dead_code)]
pub fn use_debug(){
    let customer = Customer::new(100, String::from("山田太郎"),
                                 String::from("東京都新宿区"), String::from("yamada@sample.com"));
    println!("{:?}", customer);
}

/// ### リスト8.12 Cloneトレイト
#[allow(dead_code)]
pub fn use_clone(){
    let customer = Customer::new(100, String::from("山田太郎"),
                                 String::from("東京都新宿区"), String::from("yamada@sample.com"));
    println!("customerの複製 = {:?}", customer.clone());
}

/// ### リスト8.13 Dropトレイト
#[allow(dead_code)]
pub fn use_drop(){
    let customer_1 = Customer::new(100, String::from("山田太郎"),
                                   String::from("東京都新宿区"), String::from("yamada@sample.com"));
    println!("{:?}", customer_1);
    let mut customer_2 = customer_1.clone();
    customer_2.set_name(String::from("田中次郎"));
    println!("{:?}", customer_2);
}

/// ### リスト8.14 Defaultトレイト
#[allow(dead_code)]
pub fn use_default(){
    let customer = Customer::default();
    println!("default = {:?}", customer);
}

/// ### リスト8.16 TryFromトレイト
#[allow(dead_code)]
pub fn use_try_from(){
    let value = vec!["ABC", "山田太郎", "東京都新宿区", "yamada@sample.com"];
    let customer = Customer::try_from(&value);
    if customer.is_ok(){
        println!("try_from() = {:?}", customer.unwrap());
    } else {
        println!("try_from() = {:?}", customer.unwrap_err());
    }
}
