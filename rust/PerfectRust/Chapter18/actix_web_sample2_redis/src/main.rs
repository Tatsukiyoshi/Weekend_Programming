use actix_session::config::PersistentSession;
use actix_web::{App, HttpServer, middleware};
use actix_session::SessionMiddleware;
use actix_session::storage::RedisSessionStore;
use actix_web::cookie::time::Duration;

/// ## 18-1 actix-sessionクレート
/// ### リスト18.1 CookieSessionStoreを利用するSessionMiddlewareの生成と登録
#[actix_web::main]
async fn main() -> std::io::Result<()>{
    // ランダムな署名/暗号化キーを生成
    let key = actix_web::cookie::Key::generate();
    // RedisSessionStoreを生成する
    let redis_store = RedisSessionStore::new("redis://127.0.0.1:6379").await.unwrap();
    // サーバー実行
    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())    // ロギングミドルウェアの登録
            // セッションミドルウェアの登録
            .wrap(
                SessionMiddleware::builder(
                    redis_store.clone(), key.clone())
                    .session_lifecycle(
                        // ライフサイクルをPersistentSessionに設定する（有効期間を5分にする）
                        PersistentSession::default().session_ttl(Duration::minutes(5))
                    )
                    .cookie_name("rsessionid".to_string()).build()
            )
    }).bind("127.0.0.1:8080")?.run().await
}
