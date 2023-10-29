use anyhow::Result;

/// ## 10-4.関連型トレイト(Association Type)
/// ### リスト10.13 CSV形式のファイルをデシリアライズする
/// ### T: 読み取り結果を格納する構造体
pub trait CsvReader {
    type Entity;    // 関連型
    /// ## 読み取り
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<Entity>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<Self::Entity>>;
}
/// ### リスト10.13 JSONファイルをデシリアライズする
/// ### T: 読み取り結果を格納する構造体
pub trait JsonReader {
    type Entity;    // 関連型
    /// ## 読み取り
    /// ### 引数 file_path: ファイルパス
    /// ### 戻り値 Result<Vec<Entity>> 読み取り結果
    fn read(&self, file_path: &str) -> Result<Vec<Self::Entity>>;
}
