/// 値が偶数の場合、２で割った値を次の値とする
/// 値が奇数の場合、３倍して１加算した値を次の値とする
/// ただし、１の場合、終了とし、計算した回数を結果として返す
pub fn collatz(n: u64) -> Option<u64> {
    let mut val = n;
    let mut count = 0;

    if val <= 0 {
        return None;
    }

    while val != 1 {
        count = count + 1;

        if val % 2 == 0 {
            val = val / 2;
        } else {
            val = val * 3 + 1;
        }
    }
    Some(count)
}
