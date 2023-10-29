/// ## 8-3.型関連定数と型関連関数
/// ### リスト8.6 型関連定数
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
}

#[allow(dead_code)]
pub fn use_constant(){
    println!("ID_MIN = {}", Customer::ID_MIN);
    println!("ID_MAX = {}", Customer::ID_MAX);
}

#[allow(dead_code)]
pub fn use_new(){
    // インスタンスを生成する型関連関数の利用
    let customer = Customer::new(100, String::from("山田太郎"),
        String::from("東京都新宿区"), String::from("yamada@sample.com"));

    println!("id = {}", customer.id);
    println!("name = {}", customer.name);
    println!("address = {}", customer.address);
    println!("email = {}", customer.email);
}
