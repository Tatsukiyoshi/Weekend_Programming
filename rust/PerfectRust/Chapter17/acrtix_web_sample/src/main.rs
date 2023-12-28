mod handlers;

use actix_web::{App, HttpServer, middleware, web};
use actix_web::web::{resource, ServiceConfig};
use tera::Tera;
use handlers::handler_func;

/// ## 17-2.アプリケーションの基本構造
/// ### リスト17.2 main()関数の基本構造
/// ### リスト17.3 データとミドルウェアの追加
#[actix_web::main]
async fn main() -> std::io::Result<()> {
    // ロガーを初期化する
    env_logger::init_from_env(env_logger::Env::new().default_filter_or("info"));
    // HttpServerの起動
    // ### リスト17.6 route()メソッドを利用したマッピング
    // ### リスト17.7 scope()関数とroute()メソッドを利用したマッピング
    // ### リスト17.8 resource()関数とroute()メソッドを利用したマッピング
    // ### リスト17.9 configure()メソッドの利用
    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())    // ロギングミドルウェアの登録
            .app_data(web::Data::new(Tera::clone(&Default::default())))
            .configure(set_configure)   // パスとハンドラのマッピング
    }).bind("127.0.0.1:8080")?.run().await
}

/// ### リスト17.9 configure()メソッドの利用
fn set_configure(cfg: &mut ServiceConfig) -> () {
    cfg.service(
        web::scope("/sample")
            .service(
                resource("/calc/{value1}/{value2}")
                    .route(web::get().to(handler_func::calc_2))
                    .route(web::post().to(handler_func::calc_2))
            ));
}
