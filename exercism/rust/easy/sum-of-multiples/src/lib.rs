use std::cmp::Ordering;

/// 達成したレベル（limit）と得たアイテムの基準値（factors）をもとに
/// ポイントを計算する
/// 各基準値の倍数のうち、レベル以下の値の集合を求める
/// 求めた集合を重複のないよう結合する
/// 結合した集合の値を集計する
pub fn sum_of_multiples(limit: u32, factors: &[u32]) -> u32 {
    let mut variables: Vec<u32> = Vec::with_capacity(limit as usize);
    let mut points: u32 = 0;

    for factor in factors {
        if factor.cmp(&0) == Ordering::Equal {
            continue;
        }

        let mut i = 1;
        loop {
            let multiple = factor * i;
            if multiple >= limit {
                break;
            }
            if variables.contains(&multiple) == false {
                variables.push(multiple);
            }
            i = i + 1;
        }
    }
    for variable in variables {
        points = points + variable;
    }

    points
}
