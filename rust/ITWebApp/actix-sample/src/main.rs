/// ##	https://github.com/wateryinhare62/atmarkit_rust_adv
mod handler;

use std::io::Result;
use actix_web::{App, HttpServer, Responder, HttpResponse, get, web,
				middleware::Logger};
use actix_web::cookie::{Key};
use actix_session::storage::CookieSessionStore;
use actix_session::SessionMiddleware;
use actix_web_flash_messages::FlashMessagesFramework;
use actix_web_flash_messages::storage::SessionMessageStore;
use env_logger::Env;
use crate::handler::{create, destroy, edit, index, new, show, update};
use tera::Tera;

fn build_cookie_session_middleware(key: Key)
								   -> SessionMiddleware<CookieSessionStore> {
	SessionMiddleware::builder(CookieSessionStore::default(), key).build()
}

#[actix_rt::main]
async fn main() -> Result<()> {
	//	ログレベルの設定
	env_logger::init_from_env(Env::default().default_filter_or("info"));
	//	クッキーのキー生成
	let key = Key::generate();
	//	メッセージストアおよびフレームワークインスタンス生成
	let message_store = SessionMessageStore::default();
	let message_framework = FlashMessagesFramework::builder(message_store).build();
	HttpServer::new(move || {
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
			.wrap(message_framework.clone())
			.wrap(build_cookie_session_middleware(key.clone()))
	})
	.bind("127.0.0.1:8000")?.run().await
}
