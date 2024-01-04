use super::value_object::ValueObject;
use crate::service::error::{AppError, Result};

/// ## 18-5 アプリケーションの構成
/// ### リスト18.22 UserId構造体
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct UserId(String);
impl ValueObject for UserId {}
impl TryFrom<String> for UserId {
    type Error = AppError;

    fn try_from(id: String) -> Result<Self> {
        if id.is_empty() {
            Err(AppError::from("ユーザーIDが存在しません。".to_owned()))
        } else if id.chars().count() != 36 {
            Err(AppError::from("ユーザーIDは36文字です。".to_owned()))
        } else {
            Ok(Self(id))
        }
    }
}
impl TryInto<String> for UserId {
    type Error = AppError;

    fn try_into(self) -> Result<String> {
        Ok(self.0.clone())
    }
}
