use std::sync::Arc;
use actix_web::{HttpResponse, Responder, web};
use mime::APPLICATION_JSON;
use sea_orm::DatabaseConnection;
use crate::api::handlers::app_error::{ApiAppError, Result};
use crate::api::handlers::jwt::ApiClaims;
use crate::api::handlers::jwt::ClaimsResponse;
use crate::service::application::service_provider::ServiceProvider;
use crate::service::commons::dtos::UserDto;
use crate::service::commons::forms::LoginForm;
use crate::service::commons::jwt::{ClaimsGenerator, JwtEncoder, JwtEncoderImpl};
use crate::service::commons::validator::AppValidator;
use crate::service::domain::user::user::User;
/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.19 認証要求への応答
///
/// 認証 リクエストハンドラ
///
pub struct AuthenticateHandler;
impl AuthenticateHandler {
    // ログイン認証
    pub async fn authenticate(form: web::Json<LoginForm>,
                              pool: web::Data<Arc<DatabaseConnection>>,
                              provider: web::Data<Arc<ServiceProvider>>) -> Result<impl Responder> {

        // 入力値の検証
        match form.validate_value() {
            Ok(_) => (),
            Err(error) =>
                return Ok(HttpResponse::BadRequest().content_type(APPLICATION_JSON).json(error.errors))
        };
        // 認証処理
        let user: User = form.0.into();
        match provider.authenticate_service.authenticate(&pool, &user).await{
            Ok(user) => {
                // JWTトークンの生成
                let claims = ApiClaims::generate(&UserDto::convert(user));
                let token = JwtEncoderImpl::encode(&claims);
                Ok(HttpResponse::Ok().content_type(APPLICATION_JSON).json(
                    ClaimsResponse ::new("authenticate success" , token.as_str())))
            },
            Err(error) => Err(ApiAppError::from(error))
        }
    }
}