use actix_web::{App, HttpServer, middleware, web};

/// ## 17-2.アプリケーションの基本構造
/// ### リスト17.2 main()関数の基本構造
/// ### リスト17.3 データとミドルウェアの追加
#[actix_web::main]
async fn main() -> std::io::Result<()> {
    // ロガーを初期化する
    env_logger::init_from_env(env_logger::Env::new().default_filter_or("info"));
    // HttpServerの起動
    HttpServer::new(move || {
        App::new()
            .wrap(middleware::Logger::default())    // ロギングミドルウェアの登録
            .service(
                web::scope("/sample") // 共通なパスを設定する
                    .service(handler_func::calc_1)  // リクエストハンドラを設定する
            )
    }).bind("127.0.0.1:8080")?.workers(2).run().await
}
