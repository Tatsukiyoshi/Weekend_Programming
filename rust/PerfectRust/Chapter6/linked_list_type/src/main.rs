use std::collections::LinkedList;

/// ## 6-5.LinkedList<T>
/// ### リスト6.22 インスタンスの生成
#[allow(dead_code)]
pub fn instantiate(){
    // String型の格納するLinkedListを生成する
    let string_list: LinkedList<String> = LinkedList::new();
    println!("len() = {}", &string_list.len());
    println!("is_empty() = {}", &string_list.is_empty());
}

/// ### リスト6.23 要素を追加する
#[allow(dead_code)]
pub fn add(){
    // String型を格納するLinkedListを生成する
    let mut list_a: LinkedList<String> = LinkedList::new();
    list_a.push_back("ABC".to_owned());
    list_a.push_back("DEF".to_owned());
    println!("list_a = {:?}", &list_a);

    // String型を格納するLinkedListを生成する
    let mut list_b: LinkedList<String> = LinkedList::new();
    list_b.push_back("OPQ".to_owned());
    list_b.push_back("RST".to_owned());
    list_a.append(&mut list_b);
    println!("list_a = {:?}", &list_a);

    list_a.push_front("XYZ".to_string());
    println!("list_a = {:?}", &list_a);
}

/// ### リスト6.24 要素を変更する
#[allow(dead_code)]
pub fn change(){
    // u32型を格納するLinkedListを生成する
    let mut list_a = LinkedList::<u32>::new();
    // イテレータで要素を追加する
    list_a.extend(&[10, 20, 30, 40, 50, 60, 70, 80, 90]);
    // ミュータブルなイテレータを取得する
    for value in list_a.iter_mut(){
        if *value % 4 == 0 {
            *value *= 10;
        }
    }
    println!("list_a = {:?}", &list_a);

    match list_a.back_mut(){
        None => {}
        Some(x) => *x *= 5 // 最後の要素を取得して値を5倍する
    }
    println!("list_a = {:?}", &list_a);
}

/// ### リスト6.25 要素を削除する
#[allow(dead_code)]
pub fn remove(){
    // u32型を格納するLinkedListを生成する
    let mut list_a = LinkedList::<u32>::new();
    // イテレータで要素を追加する
    list_a.extend(&[10, 20, 30, 40, 50, 60, 70, 80, 90]);

    let r = list_a.pop_front();
    println!("削除した要素 = {}, 削除結果 = {:?}", &r.unwrap(), &list_a);
    let r = list_a.pop_back();
    println!("削除した要素 = {}, 削除結果 = {:?}", &r.unwrap(), &list_a);
    list_a.clear();
    println!("clear() = {:?}", &list_a);
}

fn main() {
    instantiate();
    add();
    change();
    remove();
}
