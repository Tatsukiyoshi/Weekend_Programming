#[derive(Debug)]
pub struct Clock {
    hours:      i32,
    minutes:    i32
}

/// 比較メソッドの実装
impl PartialEq for Clock {
    fn eq(&self, others: &Clock) -> bool {
        self.hours == others.hours && self.minutes == others.minutes
    }
}

impl Clock {
    /// コンストラクタ
    /// - 時分それぞれのオーバーフロー対応
    /// - 時分それぞれのネガティブ対応
    pub fn new(hours: i32, minutes: i32) -> Self {
        let mut hours_tmp= hours;
        let mut minutes_tmp = minutes;

        println!("{}:{}", hours_tmp, minutes_tmp);

        if minutes_tmp < 0 {
            hours_tmp = hours_tmp + (minutes_tmp / 60 - 1);
            minutes_tmp = minutes_tmp % 60 + 60;
        }
        if hours_tmp < 0 {
            hours_tmp = hours_tmp % 24 + 24;
        }
        hours_tmp = (hours_tmp + minutes_tmp / 60) % 24;
        minutes_tmp = minutes_tmp % 60;
        Self { hours: hours_tmp, minutes: minutes_tmp }
    }

    /// 加算処理
    /// - オーバーフローは返り値の初期化で吸収
    pub fn add_minutes(&self, minutes: i32) -> Self {
        Clock::new(self.hours, self.minutes + minutes)
    }

    /// Display用の文字列変換メソッド
    pub fn to_string(&self) -> String {
        format!("{: >02}:{: >02}", self.hours, self.minutes)
    }
}
