use super::value_object::ValueObject;
use crate::service::error::{AppError, Result};

/// ## 18-5 アプリケーションの構成
/// ### リスト18.22 Username構造体
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct UserName(String);
impl ValueObject for UserName {}
impl TryFrom<String> for UserName {
    type Error = AppError;

    fn try_from(name: String) -> Result<Self> {
        if name.is_empty() {
            Err(AppError::from("ユーザー名が存在しません。".to_owned()))
        } else {
            Ok(Self(name))
        }
    }
}
impl TryInto<String> for UserName {
    type Error = AppError;

    fn try_into(self) -> Result<String> {
        Ok(self.0.clone())
    }
}
