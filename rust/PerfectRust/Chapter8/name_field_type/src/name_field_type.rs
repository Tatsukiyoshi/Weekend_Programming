/// ## 8-1.名前付きフィールド型
/// ### リスト8.1 顧客を表す構造体
struct Customer {
    id: u32,
    name:   String,
    address:    String,
    email:  String
}

/// ### リスト8.2 インスタンスの生成
#[allow(dead_code)]
pub fn generate_1(){
    let customer = Customer {
        // Customer構造体のインスタンス生成とフィールドに初期値設定する
        id: 100,
        name:   String::from("山田太郎"),
        address:    String::from("東京都新宿区"),
        email:  String::from("yamada@sample.com")
    };
    // フィールドの内容を出力する
    println!("id = {}", customer.id);
    println!("name = {}", customer.name);
    println!("address = {}", customer.address);
    println!("email = {}", customer.email);

    let member1 = Member{
        id: customer.id,
        name: &*customer.name,
        address: &*customer.address,
        email:  &*customer.email
    };
    // フィールドの内容を出力する
    println!("id = {}", member1.id);
    println!("name = {}", member1.name);
    println!("address = {}", member1.address);
    println!("email = {}", member1.email);
}

/// ### リスト8.3 参照型フィールド
#[allow(dead_code)]
pub struct Member<'a>{
    id:         u32,
    name:       &'a str,
    address:    &'a str,
    email:      &'a str
}
