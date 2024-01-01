use std::collections::HashMap;

use serde::{Deserialize, Serialize};

use crate::validation_error::{AppValidator, ValidationError};

/// ## 18-2 validatorクレート
/// ### リスト18.7 検証定義と実装
// 認証データ用構造体
#[derive(Debug, Clone, Deserialize, Serialize, Validate)]
pub struct LoginForm {
    #[validate(length(min = 6, max = 20, message = "ユーザ名は6文字以上20文字以内で入力してください"))]
    pub name: Option<String>,       // ユーザ名
    #[validate(length(min = 6, max = 20, message = "ユーザ名は6文字以上20文字以内で入力してください"))]
    pub password: Option<String>    // パスワード
}
impl AppValidator for LoginForm {
    fn validate_value(&self) -> anyhow::Result<(), ValidationError> {
        // エラーメッセージを格納するHashMap
        let mut error_messages: HashMap<String, String> = HashMap::new();
        // フィールドごとのエラーを取得するクロージャ
        let mut get_errors = |validation_errors: ValidationErrors, field: &str| {
            match validation_errors.field_errors().get(field) {
                Some(errors) => {
                    for error in errors.deref() {
                        error_messages.insert(String::from(field),
                        error.message.as_ref().unwrap().to_string());
                    }
                },
                None => ()
            };
        };
        match self.validate() {
            Ok(_) => Ok(()),
            Err(validation_errors) => {
                // nameとpasswordのエラーを取得する
                get_errors(validation_errors.clone(), "name");
                get_errors(validation_errors.clone(), "password");
                Err(ValidationError::from(error_messages))
            }
        }
    }
}
