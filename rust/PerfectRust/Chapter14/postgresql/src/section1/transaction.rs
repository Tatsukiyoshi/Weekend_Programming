use postgres::{Client, Transaction};
use anyhow::Result;
/// ## 14-3.トランザクション制御
/// ### リスト14.5 トランザクション制御機能の実装
pub struct TransactionUtil; // トランザクション制御構造体
impl TransactionUtil {
    /// ## トランザクションを開始する
    /// ### 引数 client: データベース接続
    /// ### 引数 mode: モード（true: 読取専用トランザクション）
    /// ### 戻り値 Transaction: 開始したトランザクション
    pub fn start<'a>(client: &'a mut Client, mode: bool) -> Result<Transaction<'a>> {
        let transaction = client.build_transaction().read_only(mode).start()?;
        Ok(transaction)
    }
    /// ## トランザクションをコミットする
    /// ### 引数 transaction: コミット対象のトランザクション
    pub fn commit(transaction: Transaction) -> Result<()> {
        transaction.commit()?;
        Ok(())
    }
    /// ## トランザクションをロールバックする
    /// ### 引数 transaction: ロールバック対象のトランザクション
    pub fn rollback(transaction: Transaction) -> Result<()> {
        transaction.rollback()?;
        Ok(())
    }
}
