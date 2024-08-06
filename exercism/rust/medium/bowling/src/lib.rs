#[derive(Debug, PartialEq, Eq)]
pub enum Error {
    NotEnoughPinsLeft,
    GameComplete,
}

/// ボーリングスコア集計
/// - 現在のゲーム状況（True：終了している、False：ゲーム中）
/// - 現在のスコア（開始時点１フレームの１投目＝０）
/// - 現在のフレームの状態
///   - フレーム番号（１～１０）
///   - 次の投球回数（９フレームまで：１または２、１０フレーム：１～３）
///   - 残っているピンの本数（１～１０）
///   例１）２フレーム終了（フレーム番号＝３、次の投球回数＝１、残っているピンの本数＝１０）
///   例２）３フレーム１投目８本（フレーム番号＝３，次の投球回数＝２，残っているピンの本数＝２）
/// - 直前のフレームの結果
///   - 直近のストライクの回数（０～２）、スコア加算は現在含め直近３回分なので、最大２回まで保持すればよい
///   - スペアかどうか
pub struct BowlingGame {
    completed:  bool,
    score:      u16,
    frame:      u16,
    pitch:      u16,
    left_pins:  u16,
    strikes:    u16,
    spare:      bool
}

impl BowlingGame {
    pub const INITIAL_PINS: u16 = 10;
    pub const FINAL_FRAME: u16 = 10;

    /// ゲーム初期化
    pub fn new() -> Self {
        BowlingGame {
            completed:  false,
            score:      0,
            frame:      1,
            pitch:      1,
            left_pins:  Self::INITIAL_PINS,
            strikes:    0,
            spare:      false
        }
    }

    /// 投球結果反映
    /// - ゲーム終了している場合、エラーとする
    /// - ゲーム終了していない場合、スコアに倒した本数を加算する
    /// - １投目
    ///   - １０本の場合
    ///     - 連続ストライクの数が２未満の場合、１加算する(=strikes+1)
    ///     - 次のフレームに進む
    ///   - １０本未満の場合
    ///     - 残っている本数を算出する（10-倒した本数）
    ///     - 投球回数を１加算する(=pitch+1)
    /// - ２投目
    ///   - 倒した本数が残っている本数と同じ場合
    ///     - スペアを保持する(=true)
    ///   - 連続ストライクの数が１以上の場合、スコアに倒した本数を加算する
    ///   - 次のフレームに進む
    pub fn roll(&mut self, pins: u16) -> Result<(), Error> {
        if self.completed == true {
            return Err(Error::GameComplete);
        }
        println!("left pins = {}", self.left_pins);

        if pins > self.left_pins {
            return Err(Error::NotEnoughPinsLeft);
        }

        print!("score{}:{} = ", self.frame, self.pitch);

        match self.pitch {
            1 => {
                if self.spare == true {
                    self.score = self.score + pins;
                    self.spare = false;
                }
                if self.strikes > 0 {
                    self.score = self.score + self.strikes * pins;
                }
                if pins == Self::INITIAL_PINS {
                    if self.strikes < 2 {
                        self.strikes = self.strikes + 1;
                    }
                    if self.frame == Self::FINAL_FRAME {
                        self.pitch = self.pitch + 1;
                    } else {
                        self.next_frame()
                    }
                } else {
                    self.left_pins = self.left_pins - pins;
                    self.pitch = self.pitch + 1;
                }
            }
            2 => {
                if self.frame == Self::FINAL_FRAME {
                    if self.strikes > 0 {
                        self.score = self.score + (self.strikes - 1) * pins;
                        if pins < self.left_pins {
                            self.left_pins = self.left_pins - pins;
                        }
                        self.pitch = self.pitch + 1;
                    } else {
                        if self.left_pins == pins {
                            self.pitch = self.pitch + 1;
                            self.left_pins = Self::INITIAL_PINS;
                        } else {
                            self.completed = true;
                        }
                    }
                } else {
                    if self.left_pins == pins {
                        self.spare = true;
                    }
                    if self.strikes > 0 {
                        self.score = self.score + pins;
                        self.strikes = 0;
                    }
                    self.next_frame();
                }
            }
            3 => {
                if self.frame == Self::FINAL_FRAME {
                    if pins > self.left_pins {
                        return Err(Error::NotEnoughPinsLeft)
                    }
                    self.completed = true;
                } else {
                    return Err(Error::NotEnoughPinsLeft)
                }
            }
            _ => {
                return Err(Error::NotEnoughPinsLeft)
            }
        }

        self.score = self.score + pins;
        println!("{}", self.score);

        Ok(())
    }

    pub fn score(&self) -> Option<u16> {
        if self.completed == true {
            Option::from(self.score)
        } else {
            None
        }
    }

    fn next_frame(&mut self) {
        self.frame = self.frame + 1;
        self.pitch = 1;
        self.left_pins = Self::INITIAL_PINS;
    }
}
