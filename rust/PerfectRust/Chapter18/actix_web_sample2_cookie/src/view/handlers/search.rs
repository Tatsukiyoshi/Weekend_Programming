use std::sync::Arc;
use actix_web::{Responder, web};
use sea_orm::DatabaseConnection;
use tera::Tera;
use crate::service::application::service_provider::ServiceProvider;
use crate::service::commons::dtos::ProductDto;
use crate::service::commons::forms::ProductSearchForm;
use crate::service::commons::validator::AppValidator;
use super::error::Result;
use super::error::WebAppError;
use super::jwt::WebClaims;
use super::view_helper::UiHelper;
///
/// 商品検索 リクエストハンドラ
///
pub struct SearchHandler;
impl SearchHandler{
    // HTML PATH
    const VIEW_PATH: &'static str = "pages/search/search.html";
    ///
    /// キーワード入力画面要求 GET
    ///
    pub async fn enter(_claims: WebClaims , tera: web::Data<Tera>) -> Result<impl Responder> {
        Ok(UiHelper::create_resp(&tera, &tera::Context::new(), Self::VIEW_PATH))
    }
    ///
    /// 検索要求　POST
    ///
    pub async fn result(_claims: WebClaims,
                        form: web::Form<ProductSearchForm>,
                        tera: web::Data<Tera>,
                        pool: web::Data<Arc<DatabaseConnection>>,
                        provider: web::Data<Arc<ServiceProvider>>) -> Result<impl Responder> {
        // 入力値の検証
        let _ = match form.validate_value() {
            Ok(_) => (),
            Err(error) => {
                let mut context = tera::Context::new();
                context.insert("notfound", &error.errors["keyword"]);
                return Ok(UiHelper::create_resp(&tera, &context, Self::VIEW_PATH));
            }
        };
        // 商品キーワード検索
        let mut context = tera::Context::new();
        let product_name = form.into_inner().into();
        match provider.product_servcie.by_keyword(&pool, &product_name).await{
            Ok(results) => {
                let view_dto = ProductDto::converts(results);
                context.insert("results" , &view_dto);
            },
            Err(error) => context.insert("notfound" , &WebAppError::error_message(error)?)
        };
        Ok(UiHelper::create_resp(&tera, &context, Self::VIEW_PATH))
    }
}
