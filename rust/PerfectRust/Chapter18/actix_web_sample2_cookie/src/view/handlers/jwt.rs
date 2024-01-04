use jsonwebtoken::{DecodingKey, EncodingKey, TokenData, Validation};
use serde::de::DeserializeOwned;
use serde::Serialize;

/// ## 18-4 jsonwebtokenクレート
/// ### リスト18.15 トークンのエンコードとデコード
pub const JWT_SECRET_KEY: &str = "app-secret";
pub const JWT_HEADER_KEY: &str = "Authorization";
pub const JWT_COOKIE_KEY: &str = "Authorization";

// Claimsの生成
pub trait ClaimsGenerator<T> {
    fn generate(_: &T) -> Self;
}
// トークンエンコード
pub trait JwtEncoder {
    // トークン生成
    fn encode<T: Serialize>(claims: &T) -> String {
        // Headerの生成
        let mut header = jsonwebtoken::Header::default();
        header.typ = Some(String::from("JWT")); // typeの設定
        header.alg = jsonwebtoken::Algorithm::HS256;    // アルゴリズムの設定
        // HeaderとClaimsでトークンを生成
        jsonwebtoken::encode(&header, &claims, &EncodingKey::from_secret(JWT_SECRET_KEY.as_ref())).unwrap()
    }
}

// トークンデコード
pub trait JwtDecoder<T: DeserializeOwned, E, R> {
    // ヘッダーの解析
    fn parse_header(&self, request: &R) -> Result<String, E>;
    // トークンの検証とデコード
    fn decode(&self, token: &str) -> Result<TokenData<T>, jsonwebtoken::errors::Error> {
        match jsonwebtoken::decode::<T> (
            // シークレットキーでデコード
            token, &DecodingKey::from_secret(JWT_SECRET_KEY.as_ref()),
            &Validation::default()) {
            Ok(token) => Ok(token),
            Err(error) => Err(error)
        }
    }
}
