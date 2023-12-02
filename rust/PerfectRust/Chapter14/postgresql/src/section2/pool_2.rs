use std::sync::Mutex;
use std::time::Duration;
use once_cell::sync::Lazy;
use postgres::NoTls;
use r2d2::Pool;
use r2d2_postgres::PostgresConnectionManager;

// 接続文字列
#[allow(dead_code)]
static CONNECT_STR: &str = "host=localhost port=5432 dbname=sample_db user=postgres password=pgsuper";
#[allow(dead_code)]
/// ## 14-6.コネクションプール
/// ### リスト14.17 コネクションプールの生成
pub static SAMPLE_POOL2: Lazy<Mutex<Pool<PostgresConnectionManager<NoTls>>>> =
    Lazy::new(|| {
        let config = CONNECT_STR.parse().unwrap();
        // コネクションマネージャを生成する
        let manager = PostgresConnectionManager::new(config, NoTls);
        // コネクションプールを生成する
        let pool = r2d2::Pool::builder()
            .max_size(30) // 最大接続数
            .min_idle(Some(1)) // 最小アイドル接続数
            .connection_timeout(Duration::from_secs_f32(60.0))// タイムアウト時間
            .build(manager).unwrap(); // コネクションプールの生成
        Mutex::new(pool)
    });
