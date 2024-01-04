use actix_web::HttpRequest;
use crate::api::handlers::app_error::{ApiAppError, ApiErrorInfo, Result};
use crate::api::handlers::claims::ApiClaims;
use crate::view::handlers::jwt::{JWT_HEADER_KEY, JwtDecoder, JwtEncoder};

/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.17 トークンの取得
#[derive(Default)]
pub struct ApiJwt;
impl JwtEncoder for ApiJwt{}
impl JwtDecoder<ApiClaims, ApiAppError, HttpRequest> for ApiJwt {
    fn parse_header(&self, request: &HttpRequest) -> Result<String> {
        // 認可情報ヘッダーの取得
        let header_value = match request.headers().get(JWT_HEADER_KEY) {
            Some(header) => header,
            None => return Err(ApiAppError::NotAuthorizeError(ApiErrorInfo::new(
                "authorization error", "Authorization header not found.")))
        };
        let token = header_value.to_str().unwrap(); // トークンの取得
        let mut split_token = token.split_whitespace();
        match split_token.next() {
            Some(schema_type) => {
                if schema_type != "Bearer" {
                    return Err(ApiAppError::NotAuthorizeError(ApiErrorInfo::new(
                        "authorization error", "invalid schema type.")))
                }
            }
            None => return Err(ApiAppError::NotAuthorizeError(ApiErrorInfo::new(
                "authorization error", "invalid schema type.")))
        };
        match split_token.next() {
            Some(jwt_token) => Ok(jwt_token.to_string()),
            None => Err(ApiAppError::NotAuthorizeError(ApiErrorInfo::new(
                "authorization error", "JWT token not found.")))
        }
    }
}
