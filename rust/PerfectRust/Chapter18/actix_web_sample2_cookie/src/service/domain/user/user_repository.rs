use async_trait::async_trait;
use crate::service::domain::user::user::User;
use crate::service::domain::user::username::UserName;
use crate::service::error::Result;
/// ## 18-5 アプリケーションの構成
/// ### リスト18.25 ユーザを扱うRepositoryトレイト
#[async_trait]
pub trait UserRepository : Send + Sync {
    type Transaction;
    // 指定されたユーザ名で問い合わせする
    async fn select_by_name(&self, _: &Self::Transaction, user_name: &UserName)
    -> Result<Option<User>>;
}
