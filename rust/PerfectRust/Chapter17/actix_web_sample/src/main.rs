mod handlers;
mod pool;

use actix_web::{App, HttpServer, middleware, web};
use actix_web::web::{resource, ServiceConfig};
use tera::Tera;
use pool::SamplePool;
use handlers::{handler_func, tera_handler};

/// ## 17-2.アプリケーションの基本構造
/// ### リスト17.2 main()関数の基本構造
/// ### リスト17.3 データとミドルウェアの追加
/// ### リスト17.14 コネクションプールをData型で登録
#[actix_web::main]
async fn main() -> std::io::Result<()> {
    // ロガーを初期化する
    env_logger::init_from_env(env_logger::Env::new().default_filter_or("info"));
    // Template Engine Teraを生成する
    let tera = Tera::new(concat!(env!("CARGO_MANIFEST_DIR"), "/views/**/*")).unwrap();
    // SeaORMのコネクションプールの登録（16章参照）
    let pool = SamplePool::get().await.expect("接続プールを取得できません");
    // HttpServerの起動
    // ### リスト17.6 route()メソッドを利用したマッピング
    // ### リスト17.7 scope()関数とroute()メソッドを利用したマッピング
    // ### リスト17.8 resource()関数とroute()メソッドを利用したマッピング
    // ### リスト17.9 configure()メソッドの利用
    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())    // ロギングミドルウェアの登録
            .app_data(web::Data::new(tera.clone())) // Teraの登録
            .app_data(web::Data::new(pool.clone())) // SeaORMのコネクションプールの登録
            .configure(set_configure)   // パスとハンドラのマッピング
    }).bind("127.0.0.1:8080")?.run().await
}

/// ### リスト17.9 configure()メソッドの利用
fn set_configure(cfg: &mut ServiceConfig) -> () {
    cfg.service(
        web::scope("/sample")
            .service(handler_func::calc_1)
            .service(
                resource("/calc2")
                    .route(web::get().to(handler_func::calc_2))
                    .route(web::post().to(handler_func::calc_2))
            )
            .service(
                resource("/calc3")
                    .route(web::get().to(handler_func::calc_3))
                    .route(web::post().to(handler_func::calc_3))
            )
            .service(
                resource("/calc4")
                    .route(web::get().to(handler_func::calc_4))
                    .route(web::post().to(handler_func::calc_4))
            )
            .service(
                resource("/usepool")
                    .route(web::get().to(handler_func::use_pool))
                    .route(web::post().to(handler_func::use_pool))
            )
            .service(
                resource("/calc5")
                    .route(web::get().to(handler_func::calc_5))
                    .route(web::post().to(handler_func::calc_5))
            )
            .service(resource("/calc_form")
                .route(web::get().to(tera_handler::calc_get))
                .route(web::post().to(tera_handler::calc_post)))
    );
}
