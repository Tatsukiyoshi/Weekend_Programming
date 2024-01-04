use actix_session::Session;
use actix_web::Responder;
use crate::view::handlers::error::{Result, WebAppError};
use crate::view::handlers::session_helper;

/// ## 18-1 actix-sessionクレート
/// ### リスト18.4 Session操作ヘルパの利用
// 商品登録リクエストハンドラ
pub struct ProductRegisterHandler;

impl ProductRegisterHandler {
    // 商品入力画面要求への応答
    pub async fn enter(_claims: WebClaims, session: Session) -> Result<impl Responder> {
        // セッションから商品カテゴリを取得
        let session_categories =
            session_helper::SessionHelper::get::<Vec<CategoryDto>>(&session, "categories")?;
        let categories = match session_categories {
            Some(categories) => categories,
            None => {
                let categories =
                    match provider.register_service.categories(&pool).await {
                        Ok(categories) => categories,
                        Err(error) => return Err(WebAppError::InternalError(error.to_string()))
                    };
                // セッションに商品カテゴリを登録
                session_helper::SessionHelper::insert::<Vec<CategoryDto>>(&session, "categories", &categories)?;
                categories
            }
        };
    }
}
