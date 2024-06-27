
/// 指定された番号まで素数を求める
/// - ０番目は２固定で返す
/// - ３から順に素数かどうかを判定する
///   - 素数であれば、素数配列に格納する
///     - 指定された番号が格納した素数配列の添え字であれば、その数字を目的の素数として返す
///   - 素数でなければ、次の数字の判定に進む
pub fn nth(n: u32) -> u32 {
    let mut primes = [0 ; 20000];
    let target :usize = n as usize;
    primes[0] = 2;

    if target == 0 {
        primes[target]
    } else {
        let mut num = 3;
        let mut primes_idx = 1;
        loop {
            let mut flag = true;
            for i in 2..num - 1{
                if num % i == 0 {
                    flag = false;
                    break;
                }
            }
            if flag == true {
                primes[primes_idx] = num;
                if primes_idx == target {
                    break;
                }
                primes_idx = primes_idx + 1;
            }
            num = num + 1;
        }
        primes[primes_idx]
    }
}
