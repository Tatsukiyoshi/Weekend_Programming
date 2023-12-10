/// ## 7-10.クロージャ
/// ### リスト7.51 基本的なクロージャ
#[allow(dead_code)]
pub fn closure_sum(){
    let sum = |values: &Vec<i32>| {
        let mut sum = 0;
        for value in values.iter(){
            sum += value;
        }
        sum
    };
    let values = vec![1, 2, 3, 4, 5];
    println!("sum = {}", sum(&values));
}

/// ### リスト7.52 moveによる所有権の移動
#[allow(dead_code)]
pub fn move_1(){
    let values = vec![1, 2, 3, 4, 5];
    let sum = || {
        let mut sum = 0;
        for value in values.iter(){
            sum += value;
        }
        sum
    };
    println!("sum = {}", sum());
    println!("values = {:?}", values);
}

/// ### リスト7.53 moveによる所有権の移動
#[allow(dead_code)]
pub fn move_2(){
    /* error[E0382]: borrow of moved value: `values`
    let values = vec![1, 2, 3, 4, 5];
    let sum = move || {
        let mut sum = 0;
        for value in values.iter(){
            sum += value;
        }
        sum
    };
    println!("sum = {}", sum());
    println!("values = {:?}", values);
    */
}

/// ### リスト7.55 クロージャを返す関数
#[allow(dead_code)]
pub fn impl_1(values: Vec<i32>) -> impl Fn() -> i32 {
    move || {
        let mut sum = 0;
        for value in values.iter(){
            sum += value;
        }
        sum
    }
}

/// ### リスト7.56 クロージャを受け取る関数
#[allow(dead_code)]
pub fn where_1<F>(f: F) where F:Fn() -> i32 {
    let sum = f();
    println!("sum = {}", sum);
}

/// ### リスト7.57 関数を実行する
#[allow(dead_code)]
pub fn use_impl_where_1(){
    let values = vec![1, 2, 3, 4, 5];
    let f = impl_1(values); // クロージャを返す関数
    where_1(f);                             // クロージャを実行する関数
}

/// ### リスト7.58 引数付きクロージャ
#[allow(dead_code)]
pub fn impl_2() -> impl Fn(Vec<i32>) -> i32 {
    move |values: Vec<i32>| {
        let mut sum = 0;
        for value in values.iter(){
            sum += value;
        }
        sum
    }
}

#[allow(dead_code)]
pub fn where_2<F>(f: F) where F:Fn(Vec<i32>) -> i32 {
    let values = vec![1, 2, 3, 4, 5];
    let sum = f(values);
    println!("sum = {}", sum);
}

#[allow(dead_code)]
pub fn use_impl_where_2(){
    let f = impl_2();
    where_2(f);
}
