use std::fmt::{Display, Formatter};
use actix_http::StatusCode;
use actix_web::{HttpResponse, ResponseError};
use log::error;
use mime::APPLICATION_JSON;
use serde::{Deserialize, Serialize};
use thiserror::Error;
use crate::service::error::AppError;

pub type Result<T> = anyhow::Result<T , ApiAppError>;   // カスタムResult型
/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.20 エラーレスポンスの送信
/// エラー情報構造体
#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ApiErrorInfo {
    pub status:  String, // 状態
    pub message: String // メッセージ
}
impl ApiErrorInfo {
    pub fn new(_status: &str, _message: &str) -> Self {
        Self {status: _status.to_owned(), message: _message.to_owned() }
    }
}
/// WebAPIのエラー型
#[derive(Debug, Error)]
pub enum ApiAppError {
    NotAuthorizeError(ApiErrorInfo),    // 未認証エラー
    AuthenticateError(ApiErrorInfo),    // 認証エラー
    SearchError(ApiErrorInfo),  // 検索エラー
    RegisterError(ApiErrorInfo),    // 登録エラー
    InternalError(AppError) // 内部エラー
}
impl Display for ApiAppError {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "{}", self)
    }
}
/// 処理結果のエラー（サービス層からのエラー）をAPIのエラーに変換する
impl From<AppError> for ApiAppError {
    fn from(error: AppError) -> Self {
        match error {
            AppError::SearchError(msg) =>
                Self::SearchError(ApiErrorInfo::new("search error", msg.as_str())),
            AppError::RegisterError(msg) =>
                Self::RegisterError(ApiErrorInfo::new("register error", msg.as_str())),
            AppError::AuthenticateError(msg) =>
                Self::AuthenticateError(ApiErrorInfo::new("authenticate error", msg.as_str())),
            AppError::InternalError(..) => Self::InternalError(error)
        }
    }
}
/// ResponseErrorトレイトの実装
impl ResponseError for ApiAppError {
    // エラー内容ごとにレスポンスステータスを設定する
    fn status_code(&self) -> StatusCode {
        match self {
            ApiAppError::InternalError(..) => StatusCode::INTERNAL_SERVER_ERROR,
            ApiAppError::AuthenticateError(..) => StatusCode::BAD_REQUEST,
            ApiAppError::RegisterError(..) => StatusCode::BAD_REQUEST,
            ApiAppError::SearchError(..) => StatusCode::NOT_FOUND,
            ApiAppError::NotAuthorizeError(..) => StatusCode::UNAUTHORIZED
        }
    }
    // エラーレスポンスを生成する
    fn error_response(&self) -> HttpResponse {
        match self {
            // 内部エラー
            ApiAppError::InternalError(error) => {
                error!("{:?}", error);  // エラーログを出力する
                // エラー情報を生成する
                let info = ApiErrorInfo::new("stop service", "Service is down.");
                HttpResponse::InternalServerError().content_type(APPLICATION_JSON).json(info)
            },
            // 検索エラー
            ApiAppError::SearchError(info) => {
                HttpResponse::NotFound().content_type(APPLICATION_JSON).json(info)
            },
            // 登録・認証エラー
            ApiAppError::AuthenticateError(info) | ApiAppError::RegisterError(info) => {
                HttpResponse::BadRequest().content_type(APPLICATION_JSON).json(info)
            },
            // 無認可エラー
            ApiAppError::NotAuthorizeError(info) => {
                HttpResponse::Unauthorized().content_type(APPLICATION_JSON).json(info)
            }
        }
    }
}
