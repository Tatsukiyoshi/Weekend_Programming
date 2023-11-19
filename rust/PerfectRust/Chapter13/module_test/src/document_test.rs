use crate::target::Guest;
/// ## 13-4.ドキュメントテスト
/// ### リスト13.13 ドキュメントテストの記述
/// ### 年齢が10歳でキャンペーンでなければ500円であることを検証する
/// ```
/// use module_test::document_test::calc_fee_case01;
/// let result = calc_fee_case01();
/// assert_eq!(result, 500);
/// ```
pub fn calc_fee_case01() -> u32 {
    let guest = Guest::new(10, false);
    let result = guest.clone().calc_fee().unwrap();
    result
}
