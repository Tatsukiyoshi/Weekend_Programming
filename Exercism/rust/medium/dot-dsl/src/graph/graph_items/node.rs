use std::collections::HashMap;

#[derive(Clone, Debug, PartialEq)]
/// Node
/// - フィールド
///   - 名前
///   - 属性（キーと値）
/// - 複製(Clone)
/// - デバッグ検証(Debug)
/// - 比較(PartialEq)
pub struct Node {
    pub name: String,
    pub attrs: HashMap<String, String>
}

impl Node {
    /// Nodeの初期化
    pub fn new(_name: &str) -> Self {
        Self {
            name: _name.to_string(),
            attrs: Default::default()
        }
    }

    /// Nodeへの属性追加
    /// - 入力
    ///   - キーと値のペア
    /// - 出力
    ///   - 属性追加後のNode
    pub fn with_attrs(&self, attr: &[(&str, &str)]) -> Self {
        let mut tmp_node = self.clone();

        tmp_node.attrs.insert(String::from(attr[0].0), String::from(attr[0].1));

        tmp_node
    }

    /// 属性の取得
    /// - 入力
    ///   - キーの名前
    /// - 出力
    ///   - 属性が取得できた場合、キーに対応する値を返却
    ///   - 属性が取得できない場合、Noneを返却
    pub fn attr(&self, key: &str) -> Option<&str> {
        // Iterate over references to attrs
        for attr in &self.attrs {
            if attr.0 == key {
                // Return a reference to the existing value
                return Some(attr.1);
            }
        }

        None
    }
}
