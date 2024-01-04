use async_trait::async_trait;
use crate::service::domain::user::user::User;
use crate::service::error::Result;
/// ## 18-5 アプリケーションの構成
/// ### リスト18.29 UserServiceトレイト
#[async_trait]
pub trait UserService : Send + Sync {
    type Database;
    /// ユーザを認証する
    async fn authenticate(&self, _: &Self::Database, user: &User) -> Result<User>;
}
