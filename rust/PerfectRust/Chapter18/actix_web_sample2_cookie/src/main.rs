mod view;
mod api;
mod service;

use actix_web::{App, HttpServer, middleware, web};
use actix_web::cookie::time::Duration;
use actix_session::config::BrowserSession;
use actix_session::SessionMiddleware;
use actix_session::storage::CookieSessionStore;
use actix_web::web::{resource, ServiceConfig};
use openssl::ssl::{SslAcceptor, SslAcceptorBuilder, SslFiletype, SslMethod};
use tera::Tera;
use crate::service::application::service_provider::ServiceProvider;
use crate::service::infrastructure::pool::Pool;
use crate::service::infrastructure::sea_orm::pool::PoolSeaOrm;
/// ## 18-1 actix-sessionクレート
/// ### リスト18.1 CookieSessionStoreを利用するSessionMiddlewareの生成と登録
#[actix_web::main]
async fn main() -> std::io::Result<()>{
    // ロガーの初期化
    env_logger::init_from_env(env_logger::Env::new().default_filter_or("info"));
    // ランダムな署名/暗号化キーを生成
    let key = actix_web::cookie::Key::generate();
    // Template Engine Teraを生成する
    let tera = Tera::new(concat!(env!("CARGO_MANIFEST_DIR"), "/views/**/*")).unwrap();
    // SeaORMのDatabaseConnectionの取得
    let pool = PoolSeaOrm::get().await.unwrap();
    // ServiceProviderの取得
    let provider = ServiceProvider::new();
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
            .app_data(web::Data::new(tera.clone())) // Teraの登録
            .app_data(web::Data::new(pool.clone()))// SeaORMのDatabaseConnectionの登録
            .app_data(web::Data::new(provider.clone()))        // ServiceProviderの登録
            .configure(set_config)   // サービスの登録
    }).bind_openssl("127.0.0.1:8081", create_ssl_acceptor_builder())?.run().await
}
/// ## 18-3 opensslクレート
/// ### リスト18.12 SslAcceptorBuilderの生成と機密鍵、シークレットキーの設定
// OpenSSL SslAcceptorBuilderの生成
fn create_ssl_acceptor_builder() -> SslAcceptorBuilder {
    // OpenSSL構造を管理し、暗号スイート、セッションオプションなどを構成する
    let mut builder: SslAcceptorBuilder =
    SslAcceptor::mozilla_intermediate_v5(SslMethod::tls_server()).unwrap();
    // 秘密鍵の設定
    builder.set_private_key_file("localhost-key.pem", SslFiletype::PEM).unwrap();
    // 証明書の設定
    builder.set_certificate_chain_file("localhost.pem").unwrap();
    builder
}
// パスとハンドラのマッピング定義
fn set_config(cfg: &mut ServiceConfig) -> () {
    use crate::view::handlers::{search::SearchHandler,register::RegisterHandler,
                                 authenticate::AuthenticateHandler,menu_error::{ErrorHandler,MenuHandler}};
    cfg.service(
        web::scope("/web_sample") // スコープを設定する
            .service(resource("/search/product")  // パスパターン設定する
                // パスパターンに対するハンドラを設定する
                .route(web::get().to(SearchHandler::enter))
                .route(web::post().to(SearchHandler::result)))
            .service(resource("/register/product")
                .route(web::get().to(RegisterHandler::enter))
                .route(web::post().to(RegisterHandler::confirm)))
            .service(resource("/register/product/register")
                .route(web::get().to(RegisterHandler::complete)))
            .service(resource("/register/product/finish")
                .route(web::get().to(RegisterHandler::finish)))
            .service(resource("/login")
                .route(web::get().to(AuthenticateHandler::enter))
                .route(web::post().to(AuthenticateHandler::authenticate)))
            .service(resource("/menu")
                .route(web::get().to(MenuHandler::menu)))
            .service(resource("/error")
                .route(web::get().to(ErrorHandler::error)))
    );
}
