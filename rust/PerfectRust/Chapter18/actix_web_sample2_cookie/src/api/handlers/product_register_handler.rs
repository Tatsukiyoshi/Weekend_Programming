use std::sync::Arc;
use actix_web::{HttpResponse, Responder, web};
use mime::APPLICATION_JSON;
use sea_orm::DatabaseConnection;
use crate::api::handlers::app_error::{ApiAppError, Result};
use crate::api::handlers::jwt::ApiClaims;
use crate::service::application::service_provider::ServiceProvider;
use crate::service::commons::forms::ProductRegisterForm;
use crate::service::commons::validator::AppValidator;
use crate::service::domain::product::product::Product;
/// ## 18-1 actix-sessionクレート
/// ### リスト18.4 Session操作ヘルパの利用
///
/// 商品登録 リクエストハンドラ
///
pub struct ProductRegisterHandler;
impl ProductRegisterHandler {
    pub async fn register(_claims: ApiClaims ,
                          form: web::Json<ProductRegisterForm> ,
                          pool: web::Data<Arc<DatabaseConnection>>,
                          provider: web::Data<Arc<ServiceProvider>>) -> Result<impl Responder>{
        // 入力値の検証
        match form.validate_value() {
            Ok(_) => (),
            Err(error) =>
                return Ok(HttpResponse::BadRequest().content_type(APPLICATION_JSON).json(error.errors))
        };
        // 商品を永続化する
        let product: Product = form.0.into();
        let mut new_product = match provider.product_servcie.register(&pool, &product).await{
            Ok(new_product) =>  new_product ,
            Err(error) => return Err(ApiAppError::from(error))
        };
        match provider.category_service.category(&pool, &new_product.category.unwrap().category_id).await{
            Ok(category) => {
                new_product.category = Some(category);
                Ok(HttpResponse::Ok().content_type(APPLICATION_JSON).json(new_product))
            },
            Err(error) => return Err(ApiAppError::from(error))
        }
    }
}
