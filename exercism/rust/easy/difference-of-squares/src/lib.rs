/// 1からnまでの合計の２乗を返す
pub fn square_of_sum(n: u32) -> u32 {
    let mut sum = 0;
    for i in 1..(n + 1){
        sum = sum + i;
    }
    sum.pow(2)
}

/// １からｎまでをそれぞれ２乗した値の合計を返す
pub fn sum_of_squares(n: u32) -> u32
{
    let mut sum = 0;
    for i in 1..(n + 1){
        sum = sum + i.pow(2);
    }
    sum
}

pub fn difference(n: u32) -> u32 {
    square_of_sum(n) - sum_of_squares(n)
}
