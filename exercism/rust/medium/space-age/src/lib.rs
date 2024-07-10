// The code below is a stub. Just enough to satisfy the compiler.
// In order to pass the tests you can add-to or change any of this code.

#[derive(Debug)]
pub struct Duration {
    secs: u64
}

impl From<u64> for Duration {
    fn from(s: u64) -> Self
    {
        Duration {secs: s}
    }
}

pub trait Planet {
    const YEARS_ON_SECONDS: f64 = 31557600.00;
    const CONVERSION_TO_EARTH_YEARS: f64;
    fn years_during(d: &Duration) -> f64 {
        d.secs as f64 / Self::YEARS_ON_SECONDS / Self::CONVERSION_TO_EARTH_YEARS
    }
}

pub struct Mercury;
pub struct Venus;
pub struct Earth;
pub struct Mars;
pub struct Jupiter;
pub struct Saturn;
pub struct Uranus;
pub struct Neptune;

/// 水星
impl Planet for Mercury {
    const CONVERSION_TO_EARTH_YEARS: f64 = 0.2408467;
}

/// 金星
impl Planet for Venus {
    const CONVERSION_TO_EARTH_YEARS: f64 = 0.61519726;
}

/// 地球
impl Planet for Earth {
    const CONVERSION_TO_EARTH_YEARS: f64 = 1.0;
}

/// 火星
impl Planet for Mars {
    const CONVERSION_TO_EARTH_YEARS: f64 = 1.8808158;
}

/// 木星
impl Planet for Jupiter {
    const CONVERSION_TO_EARTH_YEARS: f64 = 11.862615;
}

/// 土星
impl Planet for Saturn {
    const CONVERSION_TO_EARTH_YEARS: f64 = 29.447498;
}

/// 天王星
impl Planet for Uranus {
    const CONVERSION_TO_EARTH_YEARS: f64 = 84.016846;
}

/// 海王星
impl Planet for Neptune {
    const CONVERSION_TO_EARTH_YEARS: f64 = 164.79132;
}
