use actix_session::Session;
use serde::de::DeserializeOwned;
use serde::Serialize;
use crate::view::handlers::error::{Result, WebAppError};

/// ## 18-1 actix-sessionクレート
/// ### リスト18.3 Session操作ヘルパ
pub struct SessionHelper;

impl SessionHelper {
    // 指定された値をSessionに登録する
    pub fn insert<T: Serialize>(session: &Session, key: &str, value: &T) -> Result<()> {
        match session.insert(key, value) {
            Ok(()) => Ok(()),
            Err(error) => Err(WebAppError::InternalError(error.to_string()))
        }
    }
    // Sessionに登録された値を削除する
    pub fn remove(session: &Session, key: &str) -> () {
        match session.remove(key) {
            Some(_) => (),
            None => ()
        }
    }
    // Sessionから指定された値を取得する
    pub fn get<T: DeserializeOwned>(session: &Session, key: &str) -> Result<Option<T>> {
        match session.get(key) {
            Ok(value) => Ok(value),
            Err(error) => Err(WebAppError::InternalError(error.to_string()))
        }
    }
}
