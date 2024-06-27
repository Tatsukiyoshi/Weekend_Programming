/// 素因数分解
/// 被除数は引数、除数は２から開始する
/// 商が１になるまで以下を繰り返す
/// - 被除数を除数で割り、商と剰余を求める
/// - 剰余が０の場合、商を被除数とする、除数を素因数のリストに追加する
/// - 剰余が０でない場合、除数を１インクリメントする
pub fn factors(n: u64) -> Vec<u64> {
    let mut factor_list : Vec<u64> = Vec::with_capacity(100);
    let mut dividend = n;  // 被除数
    let mut divisor = 2;   // 除数
    let mut quotient;      // 商
    let mut reminder;      // 剰余

    loop {
        quotient = dividend / divisor;
        reminder = dividend % divisor;
        if reminder == 0 {
            dividend = quotient;
            factor_list.push(divisor);
            if quotient == 1 {
                break;
            }
        } else {
            divisor = divisor + 1;
            if quotient < 1 {
                break;
            }
        }
    }
    factor_list
}
