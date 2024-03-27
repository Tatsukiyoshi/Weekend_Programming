use actix_web::{error, HttpResponse, Responder, web};
use serde::{Deserialize, Serialize};
use tera::Tera;

/// ## 17-6 Teraクレート
/// ### リスト17.20 リクエストパラメータ用構造体
#[derive(Debug, Serialize, Deserialize)]
pub struct CalcForm {
    pub value1: Option<String>,
    pub value2: Option<String>,
    pub opt: Option<String>
}
impl CalcForm {
    pub fn calc(&self) -> anyhow::Result<i32> {
        let func = |v: &String| -> i32 {
            if v.eq("") {
                return 0;
            } else {
                v.parse::<i32>().unwrap()
            }
        };
        let value1 = self.value1.as_ref().map_or_else(|| 0, |v|{ func(v) });
        let value2 = self.value2.as_ref().map_or_else(|| 0, |v|{ func(v) });
        let opt = self.opt.as_ref().map_or_else(|| 0, |v|{ func(v) });
        let result = match opt {
            1 => value1 + value2,
            2 => value1 - value2,
            3 => value1 * value2,
            4 => value1 / value2,
            5 => value1 % value2,
            _ => return Err(anyhow::Error::msg("Parameter Error."))
        };
        Ok(result)
    }
}
/// ### リスト17.19 GETリクエストへの応答
pub async fn calc_get(tera: web::Data<Tera>) -> impl Responder {
    let resp_body = tera.render(
        "pages/enter.html", &tera::Context::new())
        .map_err(|err| error::ErrorInternalServerError(err.to_string())).unwrap();
    HttpResponse::Ok().content_type(mime::TEXT_HTML).body(resp_body)
}

/// ### リスト17.23 POSTリクエストへの応答
pub async fn calc_post(form: web::Form<CalcForm>, tera: web::Data<Tera>) -> impl Responder {
    let mut context = tera::Context::new();
    let calc_form = form.into_inner();
    // 計算した結果をcontextに格納する
    match calc_form.calc() {
        Ok(result) => context.insert("result", &result),
        Err(err) => context.insert("result", &err.to_string())
    }
    // HTMLコンテンツを取得する
    let resp_body = tera.render(
        "pages/result.html", &context)
        .map_err(|err| error::ErrorInternalServerError(err.to_string())).unwrap();
    HttpResponse::Ok().content_type(mime::TEXT_HTML).body(resp_body)
}

#[cfg(test)]
mod tests {
    use crate::handlers::tera_handler::CalcForm;
    use actix_web::dev::ServiceResponse;
    use actix_web::{App, Error, test, web};
    use actix_web::web::resource;
    use tera::Tera;

    /// ## 17-7 リクエストハンドラのテスト
    /// ### リスト17.24 テスト用サービスの生成
    async fn test_service() -> impl actix_web::dev::Service<actix_http::Request,
        Response = ServiceResponse, Error = Error> {
        // teraを生成する
        let tera = Tera::new(concat!(env!("CARGO_MANIFEST_DIR"), "/views/**/*")).unwrap();
        // テスト用サービスを生成する
        let test_service = test::init_service(
            App::new()
                .app_data(web::Data::new(tera.clone()))
                .service(
                    web::scope("/sample")
                        .service(
                            resource("/calc_form")
                            .route(web::get().to(super::calc_get))
                            .route(web::post().to(super::calc_post)))
                )
        ).await;
        test_service
    }

    /// ### リスト17.25 GETリクエストのテスト
    #[actix_web::test]
    async fn test_get_request(){
        let test_service = test_service().await;
        let enter_request = test::TestRequest::get().uri("/sample/calc_form").to_request();
        // リクエストハンドラenter()を実行する
        let response = test::call_service(&test_service, enter_request).await;
        println!("{:?}", response.headers());
        println!("{:?}", response.response().body());
        assert_eq!(response.status(), actix_http::StatusCode::OK);
    }

    /// ### リスト17.25 POSTリクエストのテスト
    #[actix_web::test]
    async fn test_post_request() -> () {
        let test_service = test_service().await;
        // 入力データを準備する
        let calc_form = CalcForm{
            value1: Some("100".to_owned()),
            value2: Some("200".to_owned()),
            opt: Some("1".to_owned())
        };
        // CalcFormを格納したPostリクエストを生成する
        let answer_request = test::TestRequest::post()
            .uri("/sample/calc_form").set_form(&calc_form).to_request();
        // リクエストハンドラcalc_post()を実行する
        let response = test::call_service(&test_service, answer_request).await;
        println!("{:?}", response.headers());
        println!("{:?}", response.response().body());
        assert_eq!(response.status(), actix_http::StatusCode::OK);
    }
}
