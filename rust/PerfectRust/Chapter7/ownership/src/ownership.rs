/// ## 7-4 所有権
/// ### リスト7.15 代入による所有権の移動
#[allow(dead_code)]
pub fn ownership_1(){
    // 文字列を生成して変数xに代入
    let x = String::from("ABC");
    println!("x = {:?}", x);
    //let y = x; // error[E0382]: borrow of moved value: `x`
    println!("x = {:?}", x);
    // println!("y = {:?}", y);
}

/// ### リスト7.16 代入による所有権の移動
#[allow(dead_code)]
pub fn ownership_2(){
    // 文字列を生成して変数xに代入
    let x = String::from("ABC");
    println!("x = {:?}", x);
    let y = &x;
    println!("x = {:?}", x);
    println!("y = {:?}", y);
}

/// ### リスト7.17 代入による所有権の移動
#[allow(dead_code)]
pub fn ownership_3(){
    // 文字列を生成して変数xに代入
    let x = String::from("ABC");
    println!("x = {:?}", x);
    let y = x.clone();
    println!("x = {:?}", x);
    println!("y = {:?}", y);
}

/// ### リスト7.19 引数渡しによる所有権の移動
#[allow(dead_code)]
fn print_message(message: &String){
    println!("message = {:?}", message);
}

#[allow(dead_code)]
pub fn ownership_4(){
    let x = String::from("ABC");
    //print_message(x);  // error[E0382]: borrow of moved value: `x`
    println!("x = {:?}", x);
}

#[allow(dead_code)]
pub fn ownership_5(){
    let x = String::from("ABC");
    print_message(&x);
    println!("x = {:?}", x);
}

/// ### リスト7.20 リターンによる所有権の移動
#[allow(dead_code)]
fn message() -> String {
    let r = String::from("good morning");
    r
}

#[allow(dead_code)]
pub fn ownership_6(){
    let x = message();
    println!("x = {:?}", x);
}

/// ### リスト7.21 スコープ
#[allow(dead_code)]
pub fn ownership_7(){
    {
        let x = String::from("ABC");
        println!("x = {:?}", x);
    }
    //let y = &x; // error[E0425]: cannot find value `x` in this scope
    //println!("y = {:?}", y);
}
