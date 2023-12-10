use serde::Deserialize;
#[derive(Debug, Default, Deserialize)]
/// ## 10-3.メソッドの実装
/// ### リスト10.9 商品を表す構造体
pub struct Product {
    pub id: String,
    pub name: String,
    pub price: u32
}
