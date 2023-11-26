use postgres::Transaction;
use crate::section1::entities::Product;
use crate::section1::repository::Repository;

/// ## 14-4.CRUD操作
/// ### リスト14.8 Repositoryトレイトの実装
/// ### productテーブルをアクセスするRepository
pub struct ProductRepository<'a, 'b>(pub &'a mut Transaction<'b>);
impl Repository<Product, i32, u64> for ProductRepository<'_, '_> {

}
