use crate::service::domain::value_object::ValueObject;
use crate::service::error::{AppError, Result};
/// ## 18-5 アプリケーションの構成
/// ### リスト18.22 Mail構造体
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct Mail(String);
impl ValueObject for Mail {}
impl TryFrom<String> for Mail {
    type Error = AppError;

    fn try_from(mail: String) -> Result<Self> {
        if mail.is_empty() {
            Err(AppError::from("メールアドレスが存在しません。".to_owned()))
        } else {
            Ok(Self(mail))
        }
    }
}
impl TryInto<String> for Mail {
    type Error = AppError;

    fn try_into(self) -> Result<String> {
        Ok(self.0.clone())
    }
}
impl ToString for Mail{
    fn to_string(&self) -> String {
        self.0.clone()
    }
}
