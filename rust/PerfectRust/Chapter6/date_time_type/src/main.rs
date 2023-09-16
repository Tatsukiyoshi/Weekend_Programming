use std::time::SystemTime;
use chrono::prelude::*;
use chrono_tz::Tz;

/// ## 6-2.日付・時間
/// ### リスト6.9 現在の日時を取得する
#[allow(dead_code)]
pub fn instantiate(){
    let now :DateTime<Utc> = Utc::now();
    println!("UTC日時 = {}", &now);

    let now :DateTime<Local> = Local::now();
    println!("ローカル日時 = {}", &now);
}

/// ### リスト6.10 フォーマット変換
#[allow(dead_code)]
pub fn format(){
    let now :DateTime<Utc> = Utc::now();
    let format_date = now.format("%Y年%m月%d日").to_string();
    println!("{:?}", &format_date);

    let now :DateTime<Local> = Local::now();
    let format_date_time = now.format("%Y年%m月%d日 %H時%M分%S秒").to_string();
    println!("{:?}", &format_date_time);
}

/// ### リスト6.11 文字列から日時に変換する
#[allow(dead_code)]
pub fn from_string(){
    // DateTime<T>変換メソッド
    let rfc2822_type = DateTime::parse_from_rfc2822("Sun, 10 Sep 2023 10:52:37 +0200");
    println!("{}", &rfc2822_type.unwrap());
    let rfc3339_type = DateTime::parse_from_rfc3339("2023-09-10T12:00:00-08:00");
    println!("{}", &rfc3339_type.unwrap());

    // nativeモジュールの変換機能
    let time_only = NaiveTime::parse_from_str("15:30:00", "%H:%M:%S");
    println!("{}", &time_only.unwrap());
    let date_only = NaiveDate::parse_from_str("2023年09月10日", "%Y年%m月%d日");
    println!("{}", &date_only.unwrap());
    let custom_format = NaiveDate::parse_from_str("09 2023 10", "%m %Y %d");
    println!("{}", &custom_format.unwrap());
}

/// ### リスト6.12 日時要素を取得する
#[allow(dead_code)]
pub fn get(){
    let now = Utc::now();

    // 年月日を取得する
    println!("y = {}, m = {}, d = {}", &now.year(), &now.month(), &now.day());

    // 時分秒、名の秒を取得する
    println!("h = {}, m = {}, s = {}, n = {}", &now.hour(), &now.minute(), &now.second(), &now.nanosecond());

    // 曜日を取得する
    let w = match &now.weekday(){
        Weekday::Mon => "月曜日",
        Weekday::Tue => "火曜日",
        Weekday::Wed => "水曜日",
        Weekday::Thu => "木曜日",
        Weekday::Fri => "金曜日",
        Weekday::Sat => "土曜日",
        Weekday::Sun => "日曜日"
    };
    println!("曜日 = {}", w);
}

/// ### リスト6.13 日時要素を変更する
#[allow(dead_code)]
pub fn change(){
    let now = Utc::now();
    println!("取得した日時 = {}", &now);
    let change = &now.with_day(25);
    println!("日を変更する = {}", &change.unwrap());
    let change = &now.with_month(10);
    println!("月を変更する = {}", &change.unwrap());
    let change = &now.with_year(2024);
    println!("年を変更する = {}", &change.unwrap());
}

/// ### リスト6.14 タイムゾーンを利用する
#[allow(dead_code)]
pub fn time_zone(){
    // Asia/Tokyoの日時を取得する
    let tokyo: DateTime<Tz> = Local::now().with_timezone(&chrono_tz::Asia::Tokyo);
    println!("東京 = {}", &tokyo);

    // America/Chicagoの日時を取得する
    let chicago: DateTime<Tz> = Local::now().with_timezone(&chrono_tz::America::Chicago);
    println!("シカゴ = {}", &chicago);

    // タイムゾーンに依存した形式に変換する
    let tokyo_n = tokyo.naive_local();
    let chicago_n = chicago.naive_local();
    println!("{}", &tokyo_n);
    println!("{}", &chicago_n);

    // 時差を計算する
    let duration :chrono::Duration = tokyo_n - chicago_n;
    println!("時差 = {}", &duration.num_hours());
    println!("時差（秒数） = {}", duration.num_seconds());
    println!("時差（ナノ秒） = {}", duration.num_nanoseconds().unwrap());
}

/// ### リスト6.15 UNIXエポックを取得する
#[allow(dead_code)]
pub fn unix_epoch(){
    let x = Local::now().timestamp();
    println!("Localで取得:{}", &x);
    let y = Utc::now().timestamp();
    println!("Utcで取得:{}", &y);
    let z = SystemTime::now().duration_since(SystemTime::UNIX_EPOCH);
    println!("SystemTimeで取得:{}", &z.unwrap().as_secs());
}

fn main() {
    instantiate();
    format();
    from_string();
    get();
    change();
    time_zone();
    unix_epoch();
}
