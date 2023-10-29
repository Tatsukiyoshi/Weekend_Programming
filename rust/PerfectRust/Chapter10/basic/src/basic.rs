use anyhow::Result; // 本書で説明なし

/// ## 10-1.トレイトの基本
/// ### リスト10.1 計算機能を表現したトレイト
/// ### リスト10.2 todo!()マクロ
pub trait Calculator {
    /// 計算処理メソッド
    fn calc(&self) -> Result<u64>{
        todo!("まだ実装されていません")
    }
}

/// ### リスト10.3 トレイトの実装
/// ### 四角形を表現した構造体
pub struct Rectangle {
    width:  u64,
    height: u64
}

/// 構造体にCalculatorトレイトを実装
impl Calculator for Rectangle {
    /// ### 面積を計算させる
    fn calc(&self) -> Result<u64> {
        Ok(self.height * self.width)
    }
}

/// ### リスト10.4 トレイトのメソッドを実行する
#[allow(dead_code)]
pub fn use_rectangle(){
    let r = Rectangle{width: 100, height: 50};
    let result = r.calc();
    println!("面積 = {}", result.unwrap());
}
