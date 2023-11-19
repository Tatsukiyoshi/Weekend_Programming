use std::fmt::{Debug, Display, Formatter};

/// ## 13-1.テストの基本
/// ### リスト13.1 サンプルターゲット
/// ### サンプルコードで利用するエラー列挙型
#[derive(Debug, Eq, PartialEq)]
pub enum SampleError {
    Msg(String)
}
impl Display for SampleError {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        match self {
            SampleError::Msg(msg) => write!(f, "{}", msg)
        }
    }
}
#[derive(Debug, Clone)]
pub struct Guest {
    age:        u32,    // 年齢
    campaign:   bool    // true: キャンペーン中
}
impl Display for Guest {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "年齢:{} キャンペーン:{}", self.age, self.campaign)
    }
}
impl Guest {
    /// ### インスタンス生成
    pub fn new (_age: u32, _campaign: bool) -> Self {
        Self {age: _age, campaign: _campaign}
    }
    /// ### 観覧金額を計算する
    /// ### 戻り値: Result<u32, SampleResult>
    pub fn calc_fee(self) -> Result<u32, SampleError> {
        let fee = match self.age {
            0..=4       => 0,
            5..=12      => 500,
            13..=17     => 700,
            18..=64     => 1000,
            65..=120    => 600,
            _           => return Err(SampleError::Msg(String::from("年齢が不正です。")))
        };
        Ok(self.calc_campaign_fee(fee))
    }
    /// ### キャンペーン中であれば10％引きにする
    fn calc_campaign_fee(&self, mut fee: u32) -> u32 {
        if self.campaign && fee != 0 {
            fee = fee * 90 / 100;
        }
        fee
    }
}
///
/// cargo testが実行される
///
#[cfg(test)]
/// ### リスト13.2 テストモジュール
mod tests {
    use super::*;   // 親モジュールの参照宣言

    /// ## 13-3.テストドライバの実装
    /// ### リスト13.6 assert!()マクロの利用
    /// ### 年齢が10歳でキャンペーンでなければ500円であることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case01() {
        let guest = Guest::new(10, false);
        let result = guest.clone().calc_fee().unwrap();
        assert!(result == 500, "{}", &guest);
    }
    /// ### リスト13.6 assert!()マクロの利用
    /// ### 年齢が10歳でキャンペーンの場合、450円であることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case_campaign01() {
        let guest = Guest::new(10, true);
        let result = guest.clone().calc_fee().unwrap();
        assert!(result == 450, "{}", &guest);
    }
    /// ### リスト13.7 assert_eq!()マクロの利用
    /// ### 年齢が15歳でキャンペーンでなければ700円であることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case02() {
        let guest = Guest::new(15, false);
        let result = guest.clone().calc_fee().unwrap();
        assert_eq!(result, 700, "{}", &guest);
    }
    /// ### 年齢が15歳でキャンペーンの場合、630円であることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case_campaign02() {
        let guest = Guest::new(15, true);
        let result = guest.clone().calc_fee().unwrap();
        assert_eq!(result, 630, "{}", &guest);
    }
    /// ### リスト13.8 assert_ne!()マクロの利用
    /// ### 年齢が18歳でキャンペーンでなければ700円でないことを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case03() {
        let guest = Guest::new(18, false);
        let result = guest.clone().calc_fee().unwrap();
        assert_ne!(result, 700, "{}", &guest);
    }
    /// ### 年齢が18歳でキャンペーンの場合、630円でないことを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case_campaign03() {
        let guest = Guest::new(18, true);
        let result = guest.clone().calc_fee().unwrap();
        assert_ne!(result, 630, "{}", &guest);
    }
    /// ### リスト13.9 エラーを検証する
    /// ### 年齢が125歳でSampleErrorとなることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_fee_case_wrong_age() {
        let guest = Guest::new(125, false);
        let result = guest.clone().calc_fee().unwrap_err();
        let expected_error = SampleError::Msg(String::from("年齢が不正です。"));
        assert_eq!(result, expected_error, "{}", &guest);
    }
    /// ### リスト13.10 非公開メソッドの検証
    /// ### 金額が1000円の場合、割引額が900円であることを検証する
    #[test] // テストモジュールであることを表すアトリビュート
    fn calc_campaign_fee_case01() {
        let guest = Guest::new(0, true);
        let result = guest.clone().calc_campaign_fee(1000);
        assert_eq!(result, 900, "{}", &guest);
    }
    /// ### リスト13.11 #[should_panic]アトリビュートの利用
    /// ### 年齢が125歳でSampleErrorが返されることを検証する
    #[test]
    #[should_panic(expected="不正な年齢が指定されました。")]
    fn calc_fee_case_should_panic(){
        let guest = Guest::new(125, false);
        match guest.calc_fee(){
            Ok(result) => assert_ne!(result, 700),
            Err(_) => panic!()
        }
    }
    /// ### リスト13.12 dbg!()マクロの利用
    #[test]
    fn use_dbg(){
        let guest = Guest::new(0, true);
        dbg!(&guest);
        let result = guest.calc_campaign_fee(1000);
        assert_eq!(result, 900);
    }
}
