use std::sync::Arc;
use async_trait::async_trait;
use sea_orm::{ColumnTrait, DatabaseTransaction, EntityTrait, QueryFilter};
use crate::service::domain::converter::Converter;
use crate::service::domain::user::user::User;
use crate::service::domain::user::username::UserName;
use crate::service::domain::user::user_repository::UserRepository;
use crate::service::error::{AppError, Result};
use crate::service::infrastructure::sea_orm::user_converter::UserConverterSeaOrm;
/// ## 18-5 アプリケーションの構成
/// ### リスト18.28 UserRepositoryトレイトの実装
pub struct UserRepositorySeaOrm;
impl UserRepositorySeaOrm {
    /// インスタンスを生成して、UserRepositoryトレイト型を返す
    pub fn new() -> Arc<dyn UserRepository<Transaction=DatabaseTransaction>> {
        Arc::new(Self{})
    }
}
#[async_trait]
impl UserRepository for UserRepositorySeaOrm {
    type Transaction = DatabaseTransaction;

    async fn select_by_name(&self, tran: &Self::Transaction, user_name: &UserName)
        -> Result<Option<User>> {
        let name: String = user_name.clone().try_into().unwrap(); // 検索値を取得する
        match crate::service::models::prelude::User::find()
            // UserNameに対応する列の値が存在したら、それを取得する
            .filter(crate::service::models::user::Column::UserName.contains(name.as_str()))
            .one(tran).await {
                Ok(option_model) => {
                    match option_model {
                        // データが取得できたら、ModelからUserに変換して返す
                        Some(model) => Ok(UserConverterSeaOrm::from_model(&model).ok()),
                        // 見つからない場合は、Noneを返す
                        None => Ok(None)
                    }
                },
                Err(error) => Err(AppError::from(error))
        }
    }
}
