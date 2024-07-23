#[derive(Debug, PartialEq, Eq)]
pub enum Classification {
    Abundant,
    Perfect,
    Deficient,
}

pub fn classify(num: u64) -> Option<Classification> {
    let mut aquliot_sum = 0;

    if num == 0 {
        return None;
    }

    for value in 1..num {
        if num % value == 0 {
            aquliot_sum = aquliot_sum + value;
        }
    }

    if aquliot_sum == num {
        Some(Classification::Perfect)
    } else if aquliot_sum > num {
        Some(Classification::Abundant)
    } else {
        Some(Classification::Deficient)
    }
}
