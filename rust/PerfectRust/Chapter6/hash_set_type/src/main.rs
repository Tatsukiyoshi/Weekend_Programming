use std::collections::HashSet;

/// ## 6-7.HashSet<T, S>
/// ### リスト6.30 インスタンスの生成
#[allow(dead_code)]
pub fn instantiate(){
    let set_a = HashSet::<i32>::new();
    let set_b: HashSet<&str> = HashSet::with_capacity(5);
    let set_c: HashSet<i32> = vec![10, 20, 30].into_iter().collect();

    println!("len() = {}, set_a = {:?}", &set_a.len(), &set_a);
    println!("len() = {}, set_b = {:?}", &set_b.len(), &set_b);
    println!("len() = {}, set_c = {:?}", &set_c.len(), &set_c);
}

/// ### リスト6.31 要素の追加と削除
#[allow(dead_code)]
pub fn add_and_remove(){
    let mut set_a: HashSet<_> = vec![10, 20, 30].into_iter().collect();
    set_a.extend([50, 60, 70]);
    println!("extend() = {:?}", &set_a);

    let x = set_a.insert(100);
    if x {
        println!("insert() = {:?}", &set_a);
    } else {
        println!("要素を追加できませんでした。");
    }

    let x = set_a.remove(&100);
    if x {
        println!("remove() = {:?}", &set_a);
    } else {
        println!("要素を削除できませんでした。");
    }

    set_a.retain(|&v| v % 4 == 0);  // 4の倍数となる要素以外を削除する
    println!("retain() = {:?}", &set_a);
}

/// ### リスト6.32 要素の取得
#[allow(dead_code)]
pub fn get(){
    let set_a: HashSet<_> = vec![10, 20, 30].into_iter().collect();
    let r: String = match set_a.get(&10){
        None => "要素は存在しません".to_string(),
        Some(x) => format!("要素{}を取得しました。", &x)
    };
    println!("取得結果 = {}", r);

    let iter_a = set_a.iter();
    for v in iter_a {
        println!("{}", &v);
    }
}

/// ### リスト6.33 集合演算
#[allow(dead_code)]
pub fn set_operation(){
    let set_a: HashSet<_> = vec![10, 20, 30, 50, 60].into_iter().collect();
    let set_b: HashSet<_> = vec![30, 40, 50, 70, 80].into_iter().collect();

    let x = set_a.union(&set_b);
    println!("和集合 = {:?}", x);

    let x = set_a.intersection(&set_b);
    println!("積集合 = {:?}", x);

    let x = set_a.difference(&set_b);
    println!("差集合 = {:?}", x);

    let x = set_a.symmetric_difference(&set_b);
    println!("対称差集合 = {:?}", x);
}

fn main() {
    instantiate();
    add_and_remove();
    get();
    set_operation();
}
