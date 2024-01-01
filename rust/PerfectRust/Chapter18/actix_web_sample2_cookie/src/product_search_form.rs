/// ## 18-2 validatorクレート
/// ### リスト18.9 任意の関数の割り当て
use std::borrow::Cow;
use serde::Deserialize;
use crate::validation_error::ValidationError;

/// 商品検索用構造体
#[derive(Deserialize, Validate, Debug)]
pub struct ProductSearchForm {
    // 検証にkeyword_check()関数を利用する
    #[validate(required, custom="keyword_check")]
    pub keyword: Option<String>
}
/// 検索キーワードの未入力チェック
fn keyword_check(keyword: &str) -> Result<(), ValidationError> {
    if keyword.is_empty() {
        let mut error = ValidationError::new("required");
        // メッセージを設定する
        error.message = Some(Cow::Borrowed("検索キーワードは必須です。"));
        return Err(error);
    }
    Ok(())
}
