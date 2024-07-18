
/// Graph管理
/// - Graph に 属性がある（名前、値）
/// - Graph に 複数の Nodeがある
/// - Node に名前と属性がある（名前、価）
/// - Node にEdge(関係)があり、そのEdgeにも属性がある（名前、値）
pub mod graph {
    pub mod graph_items;
    use std::collections::HashMap;
    use graph_items::edge::Edge;
    use graph_items::node::Node;

    #[derive(Clone, Debug)]
    /// Graph
    /// - フィールド
    ///   - 属性（キーと値）
    ///   - Nodeの集合
    ///   - Edgeの集合
    /// - 複製(Clone)
    /// - デバッグ検証(Debug)
    pub struct Graph {
        pub attrs: HashMap<String, String>,
        pub nodes: Vec<Node>,
        pub edges: Vec<Edge>
    }

    impl Graph {
        /// Graphの初期化
        pub fn new() -> Self {
            Self {
                attrs: Default::default(),
                edges: vec![],
                nodes: vec![],
            }
        }

        /// Graphへの属性追加
        /// - 入力
        ///   - キーと値のペア
        /// - 出力
        ///   - 属性追加後のGraph
        pub fn with_attrs(&self, attrs: &[(&str, &str)]) -> Self {
            let mut tmp_graph = self.clone();

            for attr in attrs {
                tmp_graph.attrs.insert(attr.0.parse().unwrap(), attr.1.parse().unwrap());
            }

            tmp_graph
        }

        /// GraphへのEdge追加
        /// - 入力
        ///   - Edgeのベクタ
        /// - 出力
        ///   - Edge追加後のGraph
        pub fn with_edges(&self, edges: &Vec<Edge>) -> Self {
            let mut tmp_graph = self.clone();

            for edge in edges {
                tmp_graph.edges.push(edge.clone());
            }

            tmp_graph
        }

        /// GraphへのNode追加
        /// - 入力
        ///   - Nodeのベクタ
        /// - 出力
        ///   - Node追加後のGraph
        pub fn with_nodes(&mut self, nodes: &Vec<Node>) -> Self {
            let mut tmp_graph = self.clone();

            for node in nodes {
                tmp_graph.nodes.push(node.clone());
            }

            tmp_graph
        }

        /// Nodeの取得
        /// - 入力
        ///   - Nodeの名前
        /// - 出力
        ///   - 取得できた場合は、そのNodeを返却
        ///   - 取得できない場合は、Noneを返却
        pub fn node(&self, name: &str) -> Option<Node> {
            for node in self.nodes.clone() {
                if node.name == name {
                    return Some(node);
                }
            }

            None
        }
    }
}
