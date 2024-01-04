use std::collections::HashMap;
use serde::{de, Deserialize, Serialize};
use validator::{validate_length, validate_range, validate_required};
use crate::view::forms::validation_error::{AppValidator, ValidationError};

/// ## 18-2 validatorクレート
/// ### リスト18.8 関数を利用した検証の実装
/// リスト18.10 空の文字列の場合はNoneにする
pub fn empty_string_as_none<'de, T, D>(deserializer: D) -> Result<Option<T>, D::Error>
    where T: de::Deserialize<'de>, D: de::Deserializer<'de> {
    Ok(T::deserialize(deserializer).ok())
}

// 商品登録用構造体
#[derive(Deserialize, Serialize, Debug, Clone)]
pub struct ProductRegisterForm {
    pub name:           Option<String>,
    #[serde(deserialize_with="empty_string_as_none")]
    pub price:          Option<i32>,
    #[serde(deserialize_with="empty_string_as_none")]
    pub category_id:    Option<i32>
}
/// 入力値検証
impl AppValidator for ProductRegisterForm {
    fn validate_value(&self) -> anyhow::Result<(), ValidationError> {
        let mut errors: HashMap<String, String> = HashMap::new();
        // nameフィールドの検証：未入力と文字数チェック
        if !validate_length(self.name.as_ref().unwrap(), Some(4), Some(20), None) {
            errors.insert(String::from("name"),
            String::from("商品名は4文字以上20文字以内で入力して下さい。"));
        }
        // priceフィールドの検証：未入力と範囲チェック
        if !validate_required(&self.price) {
            errors.insert(String::from("price"), String::from("単価は入力必須です。"));
        } else {
            if !validate_range(self.price.unwrap(), Some(50), Some(100000)) {
                errors.insert(String::from("price"),
                String::from("単価は50～100000までで入力して下さい。"));
            }
        }
        // category_idフィールドの検証：未入力と範囲チェック
        if !validate_required(&self.category_id){
            errors.insert(String::from("category_id"),
            String::from("カテゴリは入力必須です。"));
        } else {
            if !validate_range(self.category_id.unwrap(), Some(1), Some(3)) {
                errors.insert(String::from("category_id"),
                String::from("不正なカテゴリが選択されました"));
            }
        }
        if errors.is_empty(){
            Ok(())
        } else {
            Err(ValidationError::from(errors))
        }
    }
}
