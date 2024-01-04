use actix_web::{HttpResponse, Responder, web};
use mime::APPLICATION_JSON;
use serde::{Deserialize, Serialize};
use crate::api::handlers::app_error::{ApiAppError, Result};
use crate::api::handlers::claims::ApiClaims;
use crate::api::handlers::jwt::ApiJwt;
use crate::view::forms::login_form::LoginForm;
use crate::view::handlers::jwt::{ClaimsGenerator, JwtEncoder};

/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.19 認証要求への応答
pub struct AuthenticateHandler;
impl AuthenticateHandler {
    // 認証リクエストハンドラ
    pub async fn authenticate(form: web::Json<LoginForm>) -> Result<impl Responder> {
        #[derive(Debug, Clone, Serialize, Deserialize)]
        struct ClaimsResponse {
            status: String,
            token: String
        }
        match provider.authenticate_service.execute(&pool, &form).await {
            Ok(user) => {   // 認証成功
                // トークンの生成
                let token = ApiJwt::encode(&ApiClaims::generate(&user));
                // トークンを送信する
                Ok(HttpResponse::Ok().content_type(APPLICATION_JSON)
                    .json(ClaimsResponse{status: String::from("authenticate success"), token} ))
            },
            Err(error) => Err(ApiAppError::from(error))
        }
    }
}
