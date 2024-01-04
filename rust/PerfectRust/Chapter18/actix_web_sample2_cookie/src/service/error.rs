use sea_orm::DbErr;
use thiserror::Error;
/// ## 18-5 アプリケーションの構成
/// ### リスト18.33 Result型
pub type Result<T> = anyhow::Result<T, AppError>;
/// ## 18-5 アプリケーションの構成
/// ### リスト18.33 サービス層（ドメイン層、インフラストラクチャ層、アプリケーション層で利用するエラー型
#[derive(Debug, Error)]
pub enum AppError {
    #[error("検索エラー:{0}")]
    SearchError(String),    // 検索処理エラー
    #[error("登録エラー:{0}")]
    RegisterError(String),  // 登録処理エラー
    #[error("認証エラー:{0}")]
    AuthenticateError(String),  // 認証エラー
    #[error(transparent)]
    InternalError(anyhow::Error)    // 永続化層のエラー、ドメインルールエラー
}
// SeaOrmのエラーをラップした内部エラーを生成する
impl From<DbErr> for AppError {
    fn from(err: DbErr) -> Self {
        AppError::InternalError(anyhow::Error::new(err))
    }
}
// メッセージをラップした内部エラーを生成する
impl From<String> for AppError {
    fn from(msg: String) -> Self {
        AppError::InternalError(anyhow::Error::msg(msg))
    }
}
