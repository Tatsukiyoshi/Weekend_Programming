mod helpers;
mod handlers;
mod validation_error;
mod login_form;
mod product_regist_form;
mod product_search_form;

use actix_web::{App, HttpServer, middleware};
use actix_web::cookie::time::Duration;
use actix_session::config::BrowserSession;
use actix_session::SessionMiddleware;
use actix_session::storage::CookieSessionStore;

/// ## 18-1 actix-sessionクレート
/// ### リスト18.1 CookieSessionStoreを利用するSessionMiddlewareの生成と登録
#[actix_web::main]
async fn main() -> std::io::Result<()>{
    // ランダムな署名/暗号化キーを生成
    let key = actix_web::cookie::Key::generate();
    // サーバー実行
    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())    // ロギングミドルウェアの登録
            // セッションミドルウェアの登録
            .wrap(
                SessionMiddleware::builder(
                    CookieSessionStore::default(), key.clone())
                    .session_lifecycle(
                        // ライフサイクルをBrowserSessionに設定する（有効期間を5分にする）
                        BrowserSession::default().state_ttl(Duration::minutes(5))
                    )
                    .cookie_name("rsessionid".to_string()).build()
            )
    }).bind("127.0.0.1:8080")?.run().await
}
