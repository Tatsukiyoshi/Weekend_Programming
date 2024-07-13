#[derive(Debug, PartialEq, Eq)]
pub enum Error {
    NotEnoughPinsLeft,
    GameComplete,
}

/// ボーリングスコア集計
/// - 現在のフレームおよび投球回数
/// - 直前のフレームの結果
///   - 直近のストライクの回数（０～２）
///   - スペアかどうか
/// - 現在のフレームの結果
///   - 一投目の本数（Or 残りの本数）→スペア判定
pub struct BowlingGame {}

impl BowlingGame {
    pub fn new() -> Self {
        todo!();
    }

    pub fn roll(&mut self, pins: u16) -> Result<(), Error> {
        todo!("Record that {pins} pins have been scored");
    }

    pub fn score(&self) -> Option<u16> {
        todo!("Return the score if the game is complete, or None if not.");
    }
}
