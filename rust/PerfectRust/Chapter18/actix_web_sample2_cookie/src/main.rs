mod web;
mod api;
mod service;

use actix_web::{App, HttpServer, middleware};
use actix_web::cookie::time::Duration;
use actix_session::config::BrowserSession;
use actix_session::SessionMiddleware;
use actix_session::storage::CookieSessionStore;
use openssl::ssl::{SslAcceptor, SslAcceptorBuilder, SslFiletype, SslMethod};

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
    }).bind_openssl("127.0.0.1:8080", create_ssl_acceptor_builder())?.run().await
}

/// ## 18-3 opensslクレート
/// ### リスト18.12 SslAcceptorBuilderの生成と機密鍵、シークレットキーの設定

// OpenSSL SslAcceptorBuilderの生成
fn create_ssl_acceptor_builder() -> SslAcceptorBuilder {
    // OpenSSL構造を管理し、暗号スイート、セッションオプションなどを構成する
    let mut builder: SslAcceptorBuilder =
    SslAcceptor::mozilla_intermediate_v5(SslMethod::tls_server()).unwrap();
    // 秘密鍵の設定
    builder.set_private_key_file("local-key.pem", SslFiletype::PEM).unwrap();
    // 証明書の設定
    builder.set_certificate_chain_file("local.pem").unwrap();
    builder
}
