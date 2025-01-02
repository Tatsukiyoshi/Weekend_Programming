mod data;

use log::info;
use actix_web::{Responder, HttpResponse, web, get, put, post, delete};
use actix_session::Session;
use serde::{Serialize, Deserialize};
use chrono::{DateTime, Local};
use tera::Context;
use actix_web_flash_messages::{
  FlashMessage, IncomingFlashMessages, Level,
};

/// ##  レスポンス生成
fn build_response(value: &Option<String>, response: &ApiResponse)
  -> impl Responder {
  if let Some(format) = value {
    match format.as_str() {
      "xml" => {
        HttpResponse::Ok().content_type("application/xml; charset=utf-8")
        .body(serde_xml_rs::to_string(&response).unwrap())
      },
      _ => HttpResponse::Ok().json(response),
    }
  } else {
    HttpResponse::Ok().json(response)
  }
}

/// ##  デフォルトページ
pub async fn not_found() -> impl Responder {
  HttpResponse::NotFound().body("Page Not found!")
}

/// ##  一覧表示
#[get("/posts")]
pub async fn index(tmpl: web::Data<tera::Tera>, messages: IncomingFlashMessages)
    -> impl Responder {
  info!("Called index");
  let posts = data::get_all();
  let mut context = Context::new();

  for message in messages.iter() {
    match message.level() {
      Level::Success => context.insert("success", &message.content()),
      Level::Error => context.insert("error", &message.content()),
      _ => (),
    }
  }
  context.insert("posts", &posts);
  let body_str = tmpl.render("index.html", &context).unwrap();
  HttpResponse::Ok().content_type("text/html; charset=utf-8").body(body_str)
}

/// ##  投稿表示
#[get("/posts/{id}")]
pub async fn show(tmpl: web::Data<tera::Tera>, info: web::Path<i32>, messages: IncomingFlashMessages)
                  -> impl Responder {
  info!("Called show");
  let info = info.into_inner();
  let post = data::get(info);
  let mut context = Context::new();
  for message in messages.iter() {
    match message.level() {
      Level::Success => context.insert("success", &message.content()),
      Level::Error => context.insert("error", &message.content()),
      _ => (),
    }
  }
  context.insert("post", &post);
  let body_str = tmpl.render("show.html", &context).unwrap();
  HttpResponse::Ok().content_type("text/html; charset=utf-8").body(body_str)
}

/// ##  投稿フォーム呼び出し
#[get("/posts/new")]
pub async fn new(tmpl: web::Data<tera::Tera>, session: Session) -> impl Responder {
  info!("Called new");
  let mut context = Context::new();
  // 投稿者名をセッションから取得
  let mut sender = "".to_string();
  if let Some(s) = session.get::<String>("sender").unwrap() {
    sender = s;
  } else {
    sender = "名無しさん".to_string();
  }
  let post = data::Message {id:0, sender:sender, content:"".to_string(), posted:"".to_string()};
  context.insert("action", "create");
  context.insert("post", &post);
  context.insert("button", "投稿");
  let body_str = tmpl.render("form.html", &context).unwrap();
  HttpResponse::Ok().content_type("text/html; charset=utf-8").body(body_str)
}

/// ##  データを受け取るための構造体
#[derive(Deserialize, Debug)]
pub struct CreateForm {
  id: i32,
  posted: String,
  sender: String,
  content: String,
}

/// ##  投稿登録
#[post("/posts/create")]
pub async fn create(params: web::Form<CreateForm>, session: Session) -> impl Responder {
  info!("Called create");
  let now: DateTime<Local> = Local::now();
  let mut message = data::Message {
    id: 0,
    posted: now.format("%Y-%m-%d %H:%M:%S").to_string(),
    sender: params.sender.clone(),
    content: params.content.clone()
  };
  message = data::create(message);
  if message.id == 0 {
    FlashMessage::error("投稿でエラーが発生しました。").send();
  } else {
    FlashMessage::success("投稿しました。").send();
  }
  let _ = session.insert("sender", params.sender.clone());  //  投稿者名をセッションに保存
  web::Redirect::to(format!("/posts/{}", message.id)).see_other()
}

/// ##  編集モードでの呼び出し
#[get("/posts/{id}/edit")]
pub async fn edit(tmpl: web::Data<tera::Tera>, info: web::Path<i32>) -> impl Responder {
  info!("Called edit");
  let info = info.into_inner();
  let post = data::get(info);
  let mut context = Context::new();
  context.insert("action", "update");
  context.insert("post", &post);
  context.insert("button", "更新");
  let body_str = tmpl.render("form.html", &context).unwrap();
  HttpResponse::Ok().content_type("text/html; charset=utf-8").body(body_str)
}

/// ##  投稿更新
#[post("/posts/update")]
pub async fn update(params: web::Form<CreateForm>) -> impl Responder {
  info!("Called update");
  let message = data::Message {
    id: params.id,
    posted: params.posted.clone(),
    sender: params.sender.clone(),
    content: params.content.clone()
  };
  data::update(&message);
  FlashMessage::success("更新しました。").send();
  web::Redirect::to(format!("/posts/{}", message.id)).see_other()
  //web::Redirect::to("/posts").see_other()
}

/// ##  投稿削除
#[get("/posts/{id}/delete")]
pub async fn destroy(info: web::Path<i32>) -> impl Responder {
  info!("Called destroy");
  let info = info.into_inner();
  data::remove(info);
  FlashMessage::success("削除しました。").send();
  web::Redirect::to("/posts").see_other()
}

/// ##  レスポンス構造体
#[derive(Serialize, Debug)]
enum ResponseContent {
  Items(Vec<data::Message>),
  Item(data::Message),
  Reason(String),
  None,
}

#[derive(Serialize, Debug)]
struct ApiResponse {
  status: String,
  result: ResponseContent,
}

/// ##  クエリーパラメータ構造体
#[derive(Deserialize)]
struct Queries {
  format: Option<String>,
}

/// ##  デフォルトページAPI
pub async fn api_not_found() -> impl Responder {
  let response = ApiResponse {
    status: "Error".to_string(),
    result: ResponseContent::Reason("API not found".to_string()),
  };
  HttpResponse::Ok().json(response)
}

/// ##  一覧表示API
#[get("/posts")]
pub async fn api_index(query: web::Query<Queries>) -> impl Responder {
  info!("Called index API");
  let param = query.into_inner();
  let posts = data::get_all();
  let mut ary = Vec::new();
  for item in &posts {
    ary.push(item.clone());
  }
  let response = ApiResponse {
    status: "OK".to_string(),
    result: ResponseContent::Items(ary),
  };
  build_response(&param.format, &response)
}

/// ##  投稿表示API
#[get("/posts/{id}")]
pub async fn api_show(info: web::Path<i32>, query: web::Query<Queries>) -> impl Responder {
  info!("Called show API");
  let info = info.into_inner();
  let param = query.into_inner();
  let post = data::get(info);
  let response = ApiResponse {
    status: "OK".to_string(),
    result: ResponseContent::Item(post),
  };
  build_response(&param.format, &response)
}

/// ##  投稿登録API
#[post("/posts/create")]
pub async fn api_create(params: web::Json<data::Message>) -> impl Responder {
  info!("Called create API");
  let now: DateTime<Local> = Local::now();
  let mut message = data::Message {
    id: 0,
    posted: now.format("%Y-%m-%d %H:%M:%S").to_string(),
    sender: params.sender.clone(),
    content: params.content.clone()
  };
  message = data::create(message);
  let response = ApiResponse {
    status: "OK".to_string(),
    result: ResponseContent::Item(message),
  };
  HttpResponse::Ok().json(response)
}

/// ##  投稿更新API
#[put("/posts/update")]
pub async fn api_update(params: web::Json<data::Message>, query: web::Query<Queries>) -> impl Responder {
  info!("Called update API");
  let message = data::Message {
    id: params.id,
    posted: params.posted.clone(),
    sender: params.sender.clone(),
    content: params.content.clone()
  };
  data::update(&message);
  let response = ApiResponse {
    status: "OK".to_string(),
    result: ResponseContent::Item(message),
  };
  HttpResponse::Ok().json(response)
}

/// ##  投稿削除API
#[delete("/posts/{id}/delete")]
pub async fn api_destroy(info: web::Path<i32>, query: web::Query<Queries>) -> impl Responder {
  info!("Called destroy API");
  let info = info.into_inner();
  let param = query.into_inner();
  data::remove(info);
  let response = ApiResponse {
    status: "OK".to_string(),
    result: ResponseContent::None,
  };
  build_response(&param.format, &response)
}
