use std::sync::Arc;
use async_trait::async_trait;
use sea_orm::{DatabaseConnection, DatabaseTransaction, TransactionTrait};
use crate::service::infrastructure::user_repository_sea_orm::UserRepositorySeaOrm;
use crate::service::application::user_service::UserService;
use crate::service::domain::user::User;
use crate::service::domain::user_repository::UserRepository;
use crate::service::error::{AppError, Result};

/// ## 18-5 アプリケーションの構成
/// ### リスト18.30 UserServiceトレイトの実装
pub struct UserServiceImpl {
    // UserRepositoryの実装を保持するフィールド
    repository: Arc<dyn UserRepository<Transaction=DatabaseTransaction>>
}
impl UserServiceImpl {
    // インスタンス生成
    pub fn new() -> Arc<dyn UserService<Database=DatabaseConnection>> {
        // UserRepositoryの実装をフィールドに設定した結果を返す
        Arc::new(Self { repository: UserRepositorySeaOrm::new() })
    }
}
#[async_trait]
impl UserService for UserServiceImpl {
    type Database = DatabaseConnection;

    // ユーザを認証する
    async fn authenticate(&self, db: &Self::Database, user: &User) -> Result<User> {
        // トランザクションを開始する
        let tran = match db.begin().await {
            Ok(transaction) => transaction,
            Err(error) => return Err(AppError::from(error))
        };
        // ユーザ名で問い合わせする
        let opt_user = self.repository.select_by_name(&tran, &user.user_name).await?;
        match opt_user {
            Some(get_user) => {
                if user.password.eq(&get_user.password) {
                    Ok(get_user.clone())
                } else {
                    Err(AppError::AuthenticateError(String::from("パスワードが異なります。")))
                }
            },
            None => Err(AppError::AuthenticateError(String::from("存在しないユーザ名です。")))
        }
    }
}
