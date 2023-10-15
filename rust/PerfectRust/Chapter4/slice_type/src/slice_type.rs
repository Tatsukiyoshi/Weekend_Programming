/// ## 4-7 スライス型
/// ### リスト4.20 スライスの取得
#[allow(dead_code)]
pub fn get(){
    // スライスを取得する文字列配列
    let str_array = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU"];
    println!("str_array = {:?}", str_array);

    let slice1: &[&str] = &str_array[3..=5];    // ３～５番目のスライスを取得する
    println!("slice1 = {:?}", slice1);

    // let slice2 = &str_array[0..2];
    let slice2 = &str_array[..2];               // 先頭から２つのスライスを取得する
    println!("slice2 = {:?}", slice2);

    let slice3 = &str_array[..];                // 配列全体のスライスを取得する
    println!("slice3 = {:?}", slice3);
}

/// ## 4-7 スライス型
/// ### リスト4.22 Range構造体の利用
#[allow(dead_code)]
pub fn range(){
    // スライスを取得する文字列配列
    let int_array = [1, 2, 3, 4, 5, 6, 7];
    // Range構造体を生成する
    let range = std::ops::Range{start: 1, end: 3};
    // スライスを取得する
    let slice = &int_array[range];
    println!("slice = {:?}", slice);
}

/// ## 4-7 スライス型
/// ### リスト4.23 マルチバイトの利用
/// ### リスト4.24 マルチバイトの利用
#[allow(dead_code)]
pub fn multibyte_slice(){
    let company_name = String::from("株式会社フルネス");
    // リスト4.23 不正な範囲指定
    // let slice = &company_name[1..3];
    // リスト4.24 正しい範囲指定
    let slice = &company_name[..12];
    println!("参照範囲 = {:?}, 大きさ={}", slice, slice.len());
    let slice = &company_name[12..];
    println!("参照範囲 = {:?}, 大きさ={}", slice, slice.len());
}

/// ## 4-7 スライス型
/// ### リスト4.25 ファットポインタを確認する
#[allow(dead_code)]
pub fn fat_pointer(){
    let int_array = [0, 1, 2, 3, 4, 5, 6];
    // 配列全体をスライスする
    let slice: &[i32] = &int_array[..];
    println!("参照範囲={:?}, ポインタ={:p}, 要素数={}", slice, slice, slice.len());
    // １番目から３番目のスライスを取得する
    let slice: &[i32] = &int_array[1..=3];
    println!("参照範囲={:?}, ポインタ={:p}, 要素数={}", slice, slice, slice.len());
}

/// ## 4-7 スライス型
/// ### リスト4.26 値の取得や状態を確認するメソッド
#[allow(dead_code)]
pub fn get_value_and_status(){
    let array = [100, 101, 102, 103, 104];
    let slice: &[i32] = &array[..];
    println!("first()    = {:?}", slice.first().unwrap());
    println!("last()     = {:?}", slice.last().unwrap());
    println!("get(2)     = {:?}", slice.get(2).unwrap());
    println!("is_empty() = {}", slice.is_empty());
    println!("len()      = {}", slice.len());
}

/// ## 4-7 スライス型
/// ### リスト4.27 ソートメソッド
#[allow(dead_code)]
pub fn sort(){
    let mut array = [103, 101, 100, 104, 102];
    let slice: &mut [i32] = &mut array[..];
    println!("slice     = {:?}", slice);
    slice.reverse();
    println!("reverse() = {:?}", slice);
    slice.sort();
    println!("sort()    = {:?}", slice);
}

/// ## 4-7 スライス型
/// ### リスト4.28 データ変換／加工メソッド
#[allow(dead_code)]
pub fn convert(){
    // let vec = vec!["abc", "def", "hij", "rst", "uvw", "xyz"];
    let vec = ["abc", "def", "hij", "rst", "uvw", "xyz"];
    let slice = &vec[..];
    println!("slice    = {:?}", slice);

    let chks = slice.chunks(3); // 指定サイズに分割したスライスを返す
    for chk in chks {
        println!("chunks() = {:?}", chk);
    }

    let joined = slice.join("/");   // 指定文字で連結した文字列を返す
    println!("join()   = {:?}", joined);

    let iterator = slice.iter();    // イテレータを返す
    println!("iter()   = {:#?}", iterator);

    let vector = slice.to_vec();    // ベクタを返す
    println!("to_vec() = {:?}", vector);

    let array = [100, 101, 102, 103, 104];
    let slice: &[i32] = &array[..];
    println!("slice    = {:?}", slice);

    // ４の倍数要素を除外したサブスライスのイテレータを返す
    let splits = slice.split(|value|{
        value % 4 == 0  // 要素は４の倍数か
    });

    // 除外したサブスライスのイテレータには、空のスライスも含まれるので、
    // 空のスライスを出力しないように抑止する
    for value in splits {
        if value.len() > 0 { 
            println!("split()  = {:?}", value);
        }
    }
}