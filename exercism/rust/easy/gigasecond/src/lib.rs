use std::ops::Add;
use time::{Duration, PrimitiveDateTime as DateTime};

/// 10億秒を加算する（加算する引数はDurationで）
pub fn after(start: DateTime) -> DateTime {
    let after_date: DateTime = start.add(Duration::seconds(1000000000));
    after_date
}
