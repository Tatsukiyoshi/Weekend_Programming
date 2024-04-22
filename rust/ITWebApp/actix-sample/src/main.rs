/// ##	https://github.com/wateryinhare62/atmarkit_rust_adv
mod handler;

use std::io::Result;
use actix_web::{App, HttpServer, Responder, HttpResponse, get, 
	middleware::Logger};
use env_logger::Env;

#[actix_rt::main]
async fn main() -> Result<()> {
	// ログレベルの設定
	env_logger::init_from_env(Env::default().default_filter_or("info"));
	HttpServer::new(|| {
		App::new()
			.service(handler::index)	// handler登録
			.wrap(Logger::default())	// Loggerの追加
	})
	.bind("127.0.0.1:8000")?.run().await
}
