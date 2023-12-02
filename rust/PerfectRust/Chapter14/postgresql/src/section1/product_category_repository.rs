use anyhow::Error;
use postgres::Transaction;
use postgres::types::Type;
use crate::section1::entities::{Product, ProductCategory};

/// ## 14-4.CRUD操作
/// ### リスト14.14 product_categoryテーブルをアクセスするRepository
pub struct ProductCategoryRepository<'a, 'b> (pub &'a mut Transaction<'b>);
impl ProductCategoryRepository<'_, '_> {
    /// ## 14-5.CRUD操作の実装
    /// ### リスト14.14 select_by_id_join_productメソッドの実装
    /// 引数 id: 商品カテゴリ番号
    /// 指定された主キーに一致するレコードをproductと結合して取得する
    pub fn select_by_id_join_product(&mut self, id: i32) -> Result<ProductCategory, Error> {
        let sql = format!("{}{}",
            "SELECT c.id AS c_id, c.name as c_name, p.id, p.name, p.price, p.category_id ",
            "FROM product_category JOIN product p ON c.id = p.category_id WHERE c.id = $1");

        // プレースホルダの型指定とプリベアード
        let stmt = self.0.prepare_typed(sql.as_str(), &[Type::INT4])?;
        let rows = self.0.query(&stmt, &[&id])?;
        if rows.is_empty() {
            return Err(Error::msg(
                format!("指定された値:{}に該当するレコードが存在しません。", id)));
        }
        // ProductCategoryの値を生成する
        let mut product_category = ProductCategory::new(0, String::from(""), None);
        // Productの値を格納するVecを生成する
        let mut products = Vec::<Product>::new();
        for row in rows {
            if product_category.get_id() == &0 {
                product_category.set_id(row.get("c_id"));
                product_category.set_name(row.get("c_name"));
            }
            // productテーブルの値をVecに格納する
            products.push(Product::new(row.get("id"), row.get("name"),
               row.get("price"), row.get("category_id"), None));
        }
        // productsフィールドにVecを格納する
        product_category.set_products(Some(products));
        Ok(product_category)
    }
}
