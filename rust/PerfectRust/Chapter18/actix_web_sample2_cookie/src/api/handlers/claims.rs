use std::future::Future;
use std::pin::Pin;
use actix_http::Payload;
use actix_web::{FromRequest, HttpRequest};
use chrono::Duration;
use serde::{Deserialize, Serialize};
use crate::api::handlers::app_error::{ApiAppError, ApiErrorInfo, Result};
use crate::api::handlers::jwt::ApiJwt;
use crate::web::handlers::jwt::{ClaimsGenerator, JwtDecoder};

/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.16 Claims実装

// トークン生成用のClaims
#[derive(Debug, Serialize, Deserialize)]
pub struct ApiClaims {
    iat:        i64,    // 取得日時
    exp:        i64,    // 有効期限
    sub:        String, // リソースオーナーの識別子
    user_id:    String, // ユーザーID（Uuid）
    user_name:  String  // ユーザ名
}
impl ClaimsGenerator<UserDto> for ApiClaims {
    fn generate(_: &UserDto) -> Self {
        let now = chrono::Utc::now();
        let iat = now.timestamp();
        Self {
            iat, // 日時の設定
            exp: (now + Duration::minutes(5)).timestamp(), // 有効期限を5分に設定
            sub: String::from("M.Furukawa"), // オーナー識別子を設定
            user_id: user.user_id.clone(), // ユーザIDを設定
            user_name: user.user_name.clone() // ユーザ名
        }
    }
}

/// ### リスト18.18 リクエスト応答の前処理
impl FromRequest for ApiClaims {
    type Error = ApiAppError;
    type Future = Pin<Box<dyn Future<Output = Result<Self>>>>;

    fn from_request(req: &HttpRequest, _payload: &mut Payload) -> Self::Future {
        let request = req.clone();
        Box::pin(async move {
            let decoder = ApiJwt::default();
            // リクエストヘッダを解析する
            let token = decoder.parse_header(&request)?;
            // 解析結果に問題がなければトークンをデコードする
            match decoder.decode(token.as_str()) {
                // デコードに成功したらClaimsを返す
                Ok(token_data) => Ok(token_data.claims),
                // エラーを返す
                Err(error) => Err(ApiAppError::NotAuthorizeError(ApiErrorInfo::new(
                    "authorization error", error.to_string().as_str())))
            }
        })
    }
}
