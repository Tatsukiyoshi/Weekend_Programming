use std::collections::HashMap;

#[derive(Clone, Debug, PartialEq)]
/// Edge
/// - フィールド
///   - 関係を有するNodeの名前（始点、終点）
///   - 属性（キーと値）
/// - 複製(Clone)
/// - デバッグ検証(Debug)
/// - 比較(PartialEq)
pub struct Edge {
    node1: String,
    node2: String,
    attrs: HashMap<String, String>
}

impl Edge {
    /// Edgeの初期化
    pub fn new(_node1: &str, _node2: &str) -> Self {
        Self {
            node1: _node1.to_string(),
            node2: _node2.to_string(),
            attrs: Default::default()
        }
    }

    /// Edgeへの属性追加
    /// - 入力
    ///   - キーと値のペア
    /// - 出力
    ///   - 属性追加後のEdge
    pub fn with_attrs(&self, attrs: &[(&str, &str)]) -> Self {
        let mut tmp_edge = self.clone();

        for attr in attrs {
            tmp_edge.attrs.insert(String::from(attr.0), String::from(attr.1));
        }

        tmp_edge
    }

    /// 属性の取得
    /// - 入力
    ///   - 属性のキー名
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
