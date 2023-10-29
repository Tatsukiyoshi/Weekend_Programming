/// ## 7-2 関数型
/// ### リスト7.8 加算関数
fn add(x: i32, y: i32) -> i32{
    x + y
}

type Calc = fn(i32, i32) -> i32;    // i32型引数を2つ受け取り、i32型の結果を返す関数の型

/// ### リスト7.8 関数を変数に代入して利用
#[allow(dead_code)]
pub fn use_function_1(){
    let func = add;  // 変数funcにadd関数を代入
    let r = func(10, 20); // 変数を利用してadd関数を呼び出す
    println!("x + y = {}", &r);
}

/// ### リスト7.9 typeキーワードを利用する
/// 引数 func:Calc Calc型関数
#[allow(dead_code)]
fn use_calc_type(func: Calc, x: i32, y: i32) -> i32 {
    func(x, y)  // 引数で渡された関数の呼び出し結果を返す
}

#[allow(dead_code)]
pub fn use_function_2(){
    let calc: Calc = add;   // Calc型変数にadd関数を代入
    let r = use_calc_type(calc, 10, 20);
    println!("x + y = {}", &r);
}

/// ### リスト7.10 関数型を返す
/// ### 戻り値 Calc
#[allow(dead_code)]
fn return_calc_type() -> Calc {
    add // add関数を返す
}

#[allow(dead_code)]
pub fn use_function_3(){
    let calc: Calc = return_calc_type();
    // let r = calc(10, 20);
    let r = use_calc_type(calc, 10, 20);
    println!("x + y = {}", &r);
}
