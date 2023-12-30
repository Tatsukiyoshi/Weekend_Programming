use std::fmt::Display;
use actix_web::{get, HttpResponse, Responder, web};
use log::info;
use sea_orm::{DatabaseConnection, TransactionTrait};
use serde::{Deserialize, Serialize};

/// ## 17-3 リクエストハンドラ
/// ### リスト17.5 アトリビュートの利用
#[get("/calc1/{value1}/{value2}")]
pub async fn calc_1(value: web::Path<(String, String)>) -> impl Responder {
    use mime;
    let val1 = value.0.parse::<i32>().unwrap();
    let val2 = value.1.parse::<i32>().unwrap();
    let result = format!("{} = {} + {}", val1 + val2, val1, val2);
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(result)
}

/// ## 17-4 リクエストエクストラクタ
/// ### リスト17.10 パラメータを受け取る構造体
#[derive(Debug, Serialize, Deserialize)]
pub struct AddCalc {
    pub value1: Option<String>, // 値１
    pub value2: Option<String>, // 値２
    pub answer: Option<String>  // 結果
}
impl AddCalc {
    // 加算処理
    pub fn calc(&mut self){
        let func = |v: &String| -> i32 {
            if v.eq("") {
                return 0;
            } else {
                v.parse::<i32>().unwrap()
            }
        };
        let value1 = self.value1.as_ref().map_or_else(|| 0, |v|{ func(v) });
        let value2 = self.value2.as_ref().map_or_else(|| 0, |v|{ func(v) });
        self.value1 = Some(value1.to_string());
        self.value2 = Some(value2.to_string());
        self.answer = Some((value1 + value2).to_string());
    }
}
impl Display for AddCalc {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        let str = format!("{} + {} = {}", self.value1.as_ref().unwrap(),
                          self.value2.as_ref().unwrap(), self.answer.as_ref().unwrap());
        write!(f, "{}", str)
    }
}

/// ### リスト17.11 Queryを利用するリクエストハンドラ
pub async fn calc_2(qvalue: web::Query<AddCalc>) -> impl Responder {
    let mut value = qvalue.into_inner();    // エクストラクタから値を取り出す
    value.calc(); // 計算処理を実行する
    info!("{:?}", value.to_string());    // ログに出力する
    // 計算結果のレスポンス
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(value.to_string())
}

/// ### リスト17.12 Formを利用するリクエストハンドラ
pub async fn calc_3(fvalue: web::Form<AddCalc>) -> impl Responder {
    let mut value = fvalue.into_inner();
    value.calc();
    info!("{:?}", value.to_string());
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(value.to_string())
}

/// ### リスト17.13 JSONを利用するリクエストハンドラ
pub async fn calc_4(jvalue: web::Json<AddCalc>) -> impl Responder {
    let mut value = jvalue.into_inner();
    value.calc();
    info!("{:?}", value.to_string());
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(value.to_string())
}

/// ### リスト17.15 Data型を利用するリクエストハンドラ
pub async fn use_pool(pool: web::Data<DatabaseConnection>,
    jvalue: web::Json<AddCalc>) -> impl Responder {
    let tran = match pool.begin().await {
        Ok(tran) => tran,
        Err(err) => {
            info!("{:?}", err.to_string());
            panic!()
        }
    };
    info!("トランザクション開始");
    let _ = tran.rollback().await;
    info!("トランザクションをロールバック");
    // calc4と同じ処理
    let mut value = jvalue.into_inner();
    value.calc();
    info!("{:?}", value.to_string());
    HttpResponse::Ok().content_type(mime::TEXT_PLAIN).body(value.to_string())
}

/// ## 17-6 レスポンス生成
/// ### リスト17.16 JSONボディの生成
pub async fn calc_5(jvalue: web::Json<AddCalc>) -> impl Responder {
    let mut value = jvalue.into_inner();
    value.calc();
    info!("{:?}", value.to_string());
    HttpResponse::Ok().content_type(mime::APPLICATION_JSON).json(value)
}
