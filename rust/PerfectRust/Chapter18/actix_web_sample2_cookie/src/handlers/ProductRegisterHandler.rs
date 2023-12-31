use actix_session::Session;
use actix_web::Responder;
use serde::de::Error;
use crate::handlers::error::WebAppError;
use crate::helpers::SessionHelper;

/// ## 18-1 actix-sessionクレート
/// ### リスト18.4 Session操作ヘルパの利用

// 商品登録リクエストハンドラ
pub struct ProductRegisterHandler;

impl ProductRegisterHandler {
    // 商品入力画面要求への応答
    pub async fn enter(_claims: WebClaims, session: Session) -> Result<impl Responder, dyn Error> {
        // セッションから商品カテゴリを取得
        let session_categories =
        SessionHelper::SessionHelper::get::<Vec<CategoryDto>>(&session, "categories")?;
        let categories = match session_categories {
            Some(categories) => categories,
            None => {
                let categories =
                match provider.register_service.categories(&pool).await {
                    Ok(categories) => categories,
                    Err(error) => return Err(WebAppError::InternalError(error.to_string()))
                };
                // セッションに商品カテゴリを登録
                SessionHelper::SessionHelper::insert::<Vec<CategoryDto>>(&session, "categories", &categories)?;
                categories
            }
        };
    }
}
