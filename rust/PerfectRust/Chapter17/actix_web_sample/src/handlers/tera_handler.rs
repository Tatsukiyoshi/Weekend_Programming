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
