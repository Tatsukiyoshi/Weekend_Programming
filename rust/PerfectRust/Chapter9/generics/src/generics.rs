use std::collections::LinkedList;

/// ## 9-4.ジェネリクス
/// ### 季節を表現する列挙型
#[derive(Debug)]
enum Season<T> {
    // u8:月数 T:期間
    Spring(u8, T),
    Summer(u8, T),
    Autumn(u8, T),
    Winter(u8, T)
}
impl<T> Season<T> {
    /// ### リスト9.10 月の文字列を取得する
    /// ### トレイト境界 IntoIterator
    pub fn get_months(&self) -> &T where T:std::iter::IntoIterator {
        match self {
            Self::Spring(_, months) => months,
            Self::Summer(_, months) => months,
            Self::Autumn(_, months) => months,
            Self::Winter(_, months) => months
        }
    }
}

/// ### リスト9.11 ジェネリクスを利用した列挙型の利用
#[allow(dead_code)]
pub fn use_generics(){
    // Vec<&str>で期間を指定する
    let spring = Season::Spring(3, vec!["3月", "4月", "5月"]);
    println!("春:{:?}", spring.get_months());

    // 配列で期間を指定する
    let summer = Season::Summer(3, ["6月", "7月", "8月"]);
    println!("夏:{:?}", summer.get_months());

    // LinkedListで期間を指定する
    let autumn = Season::Autumn(3, LinkedList::from(["9月", "10月", "11月"]));
    println!("秋:{:?}", autumn.get_months());
}
