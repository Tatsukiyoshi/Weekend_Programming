use std::sync::Arc;
use actix_web::{Responder, web, HttpResponse};
use mime::APPLICATION_JSON;
use sea_orm::DatabaseConnection;
use crate::api::handlers::app_error::ApiAppError;
use crate::api::handlers::jwt::ApiClaims;
use crate::service::application::service_provider::ServiceProvider;
use crate::service::commons::forms::ProductSearchForm;
use crate::service::commons::validator::AppValidator;
use crate::service::domain::product::product_name::ProductName;
use crate::api::handlers::app_error::Result;
///
/// 商品検索 リクエストハンドラ
///
pub struct ProductSearchHandler;
impl ProductSearchHandler {
    pub async fn search(_claims: ApiClaims ,
                        form: web::Json<ProductSearchForm> ,
                        pool: web::Data<Arc<DatabaseConnection>>,
                        provider: web::Data<Arc<ServiceProvider>>) -> Result<impl Responder>{
        // 入力値の検証
        match form.validate_value() {
            Ok(_) => (),
            Err(error) =>
                return Ok(HttpResponse::BadRequest().content_type(APPLICATION_JSON).json(error.errors))
        };
        let keyword:ProductName = form.0.into();
        // 商品キーワード検索
        match provider.product_servcie.by_keyword(&pool, &keyword).await{
            Ok(products) =>  Ok(HttpResponse::Ok().content_type(APPLICATION_JSON).json(products)) ,
            Err(error) => {
                let api_error = ApiAppError::from(error);
                Err(api_error)
            }
        }

    }
}
