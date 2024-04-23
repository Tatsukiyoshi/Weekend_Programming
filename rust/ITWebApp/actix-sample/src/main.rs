/// ##	https://github.com/wateryinhare62/atmarkit_rust_adv
mod handler;

use std::io::Result;
use actix_web::{App, HttpServer, Responder, HttpResponse, get, web,
				middleware::Logger};
use env_logger::Env;
use crate::handler::{create, destroy, edit, index, new, show, update};
use tera::Tera;

#[actix_rt::main]
async fn main() -> Result<()> {
	// ログレベルの設定
	env_logger::init_from_env(Env::default().default_filter_or("info"));
	HttpServer::new(|| {
		let tera = Tera::new("templates/**/*.html").unwrap();
		App::new()
			.app_data(web::Data::new(tera))
			.service(index)	// handler登録
			.service(new)
			.service(create)
			.service(show)
			.service(edit)
			.service(update)
			.service(destroy)
			.default_service(web::to(handler::not_found))
			.wrap(Logger::default())	// Loggerの追加
	})
	.bind("127.0.0.1:8000")?.run().await
}
