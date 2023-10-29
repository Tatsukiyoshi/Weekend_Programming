/// ## 5-2.パターンマッチング
/// ### リスト5.4 match式
#[allow(dead_code)]
pub fn branch_1(){
    let x = 10;

    match x { // 単純なmatch式
        1 => println!("Value is 1."),
        2 => println!("Value is 2."),
        _ => println!("Value is invalid.")
    }
    match x { // 複数の処理をするmatch式
        1 => {
            let y = 100;
            println!("y = {}", y);
        },
        2 => {
            let y = 200;
            println!("y = {}", y);
        },
        _ => {
            let y = 300;
            println!("y = {}", y);
        }
    }
}

/// ### リスト5.5 match式
#[allow(dead_code)]
pub fn branch_2() {
    let x = "山田太郎";
    match x {
        "山田太郎" => println!("It's Yamada Taro."),
        "鈴木花子" => println!("It's Suzuki Hanako."),
        _ => println!("Who?")
    }
}

/// ### リスト5.6 match-let式
#[allow(dead_code)]
pub fn branch_3(){
    // 引数を10倍にした結果を返すクロージャ
    let calc = |x :u32|{x * 10};

    let y = 3;
    let result = match y {
        1 => calc(10),
        2 => calc(20),
        3 => calc(30),
        _ => calc(0)
    };

    println!("result = {}", result);
}

/// ### リスト5.7 RangeとOR演算子
#[allow(dead_code)]
pub fn branch_4(){
    let calc = |x :u32|{ x * 10 };
    let value = 50;
    let result = match value {
        1 ..= 3 => calc(10),                // 1～3
        4 ..= 6 => calc(20),                // 4～6
        7 ..= 9 => calc(30),                // 7～9
        10 | 20 | 30 => calc(40),           // 10 または 20 または 30
        21 ..= 25 | 31 ..= 35 => calc(50),  // 21～25 または 31～35
        _ => calc(0)                        // どのパターンにも一致しない
    };

    println!("result = {}", result);
}

/// ### リスト5.8 ガードの利用
#[allow(dead_code)]
pub fn branch_5(){
    let value = (10, 25);
    let result = match value {
        (x, y) if x == 0 && y == 0 => "x and y are 0.",
        (x, y) if x % 2 == 0 && y % 2 == 0 => "x and y are even number.",
        (x, y) if x % 2 != 0 && y % 2 != 9 => "x and y are odd number.",
        _ => "It's not match any pattern."
    };
    println!("result = {}", result);
}

fn main() {
    branch_1();
    branch_2();
    branch_3();
    branch_4();
    branch_5();
}
