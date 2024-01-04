use super::value_object::ValueObject;
use crate::service::error::{AppError, Result};

/// ## 18-5 アプリケーションの構成
/// ### リスト18.22 Password構造体
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct Password(String);
impl ValueObject for Password {}
impl TryFrom<String> for Password {
    type Error = AppError;

    fn try_from(password: String) -> Result<Self> {
        if password.is_empty() {
            Err(AppError::from("パスワードが存在しません。".to_owned()))
        } else {
            Ok(Self(password))
        }
    }
}
impl TryInto<String> for Password {
    type Error = AppError;

    fn try_into(self) -> Result<String> {
        Ok(self.0.clone())
    }
}
