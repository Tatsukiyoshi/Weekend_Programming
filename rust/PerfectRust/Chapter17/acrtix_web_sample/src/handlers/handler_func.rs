use std::ops::Add;
use actix_web::{get, HttpResponse, Responder, web};
/// ## 17-3.リクエストハンドラ
/// ### リスト17.5 アトリビュートの利用
#[get("/calc1/{value1}/{value2}")]
pub async fn calc_1(value: web::Path<(String, String)>) -> impl Responder {
    use mime;
    let val1 = value.0.parse::<i32>().unwrap();
    let val2 = value.1.parse::<i32>().unwrap();
    let result = format!("{} = {} + {}", val1 + val2, val1, val2);
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(result)
}
