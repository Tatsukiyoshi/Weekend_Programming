/// ## 7-5.参照
/// ### リスト7.22 参照の取得#
#[allow(dead_code)]
pub fn reference_1(){
    /*
        let x = Vec::<i32>::new();
        let y = &mut x; // 変数xのミュータブルな参照を代入する
        y.push(1);
        y.push(2);
        y.push(3);
        println!("{:?}", y);
    */
}

/// ### リスト7.23 参照の取得#
#[allow(dead_code)]
pub fn reference_2(){
    let mut x = Vec::<i32>::new();
    let y = &mut x; // 変数xのミュータブルな参照を代入する
    y.push(1);
    y.push(2);
    y.push(3);
    println!("{:?}", y);
}

/// ### リスト7.24 ミュータブルな参照は一つだけ
#[allow(dead_code)]
pub fn reference_3(){
    /*
        let mut x = Vec::<i32>::new();
        let y = &mut x; // 変数xのミュータブルな参照を代入する
        let z = &mut x; // 変数xのミュータブルな参照を代入する
        y.push(100);
        z.push(200);
        println!("{:?}", x);
    */
}

/// ### リスト7.25 参照は混在できない
#[allow(dead_code)]
pub fn reference_4(){
    /*
        let mut x = Vec::<i32>::new();
        let y = &mut x; // 変数xのミュータブルな参照を代入する
        let z = &x; // 変数xのミュータブルな参照を代入する
        y.push(100);
        println!("{:?}", x);
    */
}
