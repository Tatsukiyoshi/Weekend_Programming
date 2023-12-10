use std::fmt::Error;
use postgres::NoTls;
use r2d2::PooledConnection;
use r2d2_postgres::PostgresConnectionManager;
use crate::section2::pool_1::SAMPLE_POOL1;

/// ### リスト14.18 コネクションの取得
/// ### コネクションマネージャ
pub struct SamplePoolManager;
impl SamplePoolManager {
    /// ### リスト14.18 コネクションプールから接続を取得する
    pub fn client() -> Result<PooledConnection<PostgresConnectionManager<NoTls>>, Error> {
        // ロックを解除してプールを取得する
        let pool = SAMPLE_POOL1.lock().unwrap();
        println!("state {:?}", pool.state());
        // コネクションプールから接続を取得する
        let client = pool.get();
        Ok(client.unwrap())
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::thread;
    use crate::section1::repository::Repository;
    use crate::section1::transaction::TransactionUtil;
    use crate::section1::product_repository::ProductRepository;

    // コネクション取得テスト
    #[test]
    fn use_connection_pool() -> Result<(), Error>{
        let mut handles = Vec::with_capacity(3);
        // スレッドを３つ生成してコネクションを取得する
        for num in 0..3 {
            handles.push(thread::spawn(move || {
                let mut client = SamplePoolManager::client()?;
                let mut transaction =
                    TransactionUtil::start(&mut client, true)?;
                let mut repository = ProductRepository(&mut transaction);
                repository.select_by_id(num + 1)
            }));
        }
        for handle in handles {
            let result = handle.join().unwrap();
            println!("{}", result.unwrap().to_string());
        }
        Ok(())
    }
}
