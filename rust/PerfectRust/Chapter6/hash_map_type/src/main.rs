use std::collections::HashMap;

/// ## 6-6.HashMap<K, V, S>
/// リスト6.26 インスタンスの生成
#[allow(dead_code)]
pub fn instantiate(){
    // キーがi32型、値がString型のHashMapを生成する
    let map_x: HashMap<i32, String> = HashMap::new();
    // キーがi32型、値がi32型のHashMapを生成する
    let map_y: HashMap<i32, i32> = HashMap::with_capacity(5);

    println!("map_x = {:?}, map_x.len() = {}", &map_x, &map_x.len());
    println!("map_y = {:?}, map_y.len() = {}", &map_y, &map_y.len());
}

/// ### リスト6.27 要素を追加する
#[allow(dead_code)]
pub fn add(){
    // キーがi32型、値が&str型のHashMapを生成する
    let mut map_x: HashMap<i32, &str> = HashMap::new();
    // extend()メソッドでペアを追加する
    map_x.extend([(1, "ABC"), (2, "DEF"), (10, "XYZ")]);
    println!("extend() = {:?}", &map_x);

    // キーがi32型、値が&str型のHashMapを生成する
    let mut map_x: HashMap<i32, &str> = HashMap::new();
    // insert()メソッドでペアを追加する
    map_x.insert(1, "あいうえお");
    map_x.insert(2, "かきくけこ");
    map_x.insert(3, "さしすせそ");
    println!("insert() = {:?}", &map_x);

    // vec!マクロを利用する
    let map_x: HashMap<i32, &str> = vec![(1, "ABC"), (2, "DEF")].into_iter().collect();
    println!("vec! = {:?}", &map_x);
}

/// ### リスト6.28 要素の取得と変更
#[allow(dead_code)]
pub fn get_and_change(){
    // キーがi32型、値が&str型のHashMapを生成する
    let mut map_x: HashMap<i32, &str> = HashMap::new();
    map_x.extend([(1, "ABC"), (2, "DEF"), (10, "XYZ")]);

    let v = map_x.get(&100);
    println!("get() = {:?}", &v);

    let p_iter = map_x.iter();
    for (k, v) in p_iter {
        println!("key = {}. value = {}", &k, &v);
    }

    // キーがi32型、値が&str型のHashMapを生成する
    let mut map_x: HashMap<i32, &str> = HashMap::new();
    map_x.extend([(1, "ABC"), (2, "DEF"), (10, "XYZ")]);
    println!("変更前 = {:?}", &map_x);

    if let Some(v) = map_x.get_mut(&2){
        *v = "あいうえお";
    }
    println!("変更後 = {:?}", &map_x);

    // キーがi32型、値がi32型のHashMapを生成する
    let mut map_y: HashMap<i32, i32> =
        vec![(1, 10), (2, 11), (3, 12), (4, 13)].into_iter().collect();
    println!("変更前 = {:?}", &map_y);

    let p_iter = map_y.iter_mut();
    for (_, v) in p_iter{
        if *v % 2 == 0 {
            *v *= 10;
        }
    }
    println!("変更後（valueが偶数の場合、valueを10倍） = {:?}", &map_y);

    let p_iter = map_y.iter_mut();
    for (k, v) in p_iter{
        if *k % 2 == 0 {
            *v *= 5;
        }
    }
    println!("変更後（keyが偶数の場合、valueを5倍） = {:?}", &map_y);
}

/// ### リスト6.29 要素の削除
#[allow(dead_code)]
pub fn remove(){
    // キーがi32型、値が&str型のHashMapを生成する
    let mut map_x: HashMap<i32, &str> = HashMap::new();
    map_x.extend([(1, "ABC"), (2, "DEF"), (10, "XYZ")]);
    println!("削除前 = {:?}", &map_x);

    let v: String = match map_x.remove(&2){
        None => "指定されたキーのペアが見つかりません".to_string(),
        Some(x) => format!("値:{}が削除されました。", &x)
    };
    println!("削除結果 = {}", &v);
    println!("削除後 = {:?}", &map_x);
    map_x.clear();
    println!("clear() = {:?}", &map_x);
}

fn main() {
    instantiate();
    add();
    get_and_change();
    remove();
}
