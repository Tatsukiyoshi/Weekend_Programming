use std::fmt::Display;
use std::fmt::Formatter;

/// ## 9-1.基本的な列挙型
/// ### 季節を表す列挙型
#[repr(u32)]
#[derive(Debug)]
pub enum Season {
    Spring = 100,
    Summer = 200,
    Autumn,
    Winter
}

impl Display for Season {
    /// ### リスト9.3 任意のフォーマットで値を出力する
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        match *self {
            Self::Spring => write!(f, "Spring(春) : {}", Self::Spring as u32),
            Self::Summer => write!(f, "Summer(夏) : {}", Self::Summer as u32),
            Self::Autumn => write!(f, "Autumn(秋) : {}", Self::Autumn as u32),
            Self::Winter => write!(f, "Winter(冬) : {}", Self::Winter as u32)
        }
    }
}

/// ### リスト9.2 列挙型の利用
#[allow(dead_code)]
pub fn use_season(){
    let summer = Season::Summer;
    let winter = Season::Winter;
    println!("{:?}", summer);
    println!("{:?}", winter);

    // 整数値に変換する
    let summer_num = Season::Summer as u8;
    let winter_num = Season::Winter as u8;
    println!("Summer = {:?}", summer_num);
    println!("Winter = {:?}", winter_num);
}

/// ### リスト9.3 Displayトレイトの実装
#[allow(dead_code)]
pub fn use_fmt(){
    println!("{}", Season::Spring);
    println!("{}", Season::Autumn);
}

/// ### リスト9.4 値の変更
#[allow(dead_code)]
pub fn use_repr(){
    println!("{}", Season::Spring);
    println!("{}", Season::Summer);
    println!("{}", Season::Autumn);
    println!("{}", Season::Winter);
}
