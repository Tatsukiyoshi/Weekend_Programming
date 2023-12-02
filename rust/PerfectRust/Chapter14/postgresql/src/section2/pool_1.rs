use std::sync::Mutex;
use once_cell::sync::Lazy;
use postgres::NoTls;
use r2d2::Pool;
use r2d2_postgres::PostgresConnectionManager;

// 接続文字列
#[allow(dead_code)]
static CONNECT_STR: &str = "host=localhost port=5432 dbname=sample_db user=postgres password=pgsuper";
#[allow(dead_code)]
/// ## 14-6.コネクションプール
/// ### リスト14.16 コネクションプールの生成
pub static SAMPLE_POOL1: Lazy<Mutex<Pool<PostgresConnectionManager<NoTls>>>> =
    Lazy::new(|| {
        let config = CONNECT_STR.parse().unwrap();
        // コネクションマネージャを生成する
        let manager = PostgresConnectionManager::new(config, NoTls);
        // コネクションプールを生成する
        let pool = r2d2::Pool::new(manager).unwrap();
        Mutex::new(pool)    // コネクションプールをMutexでラップする
    });
