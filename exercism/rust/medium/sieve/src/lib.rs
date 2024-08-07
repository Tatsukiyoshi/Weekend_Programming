use std::collections::HashMap;

// error[E0308] expected integer, found '&u64'
// for divisor in 2..number {
// ...
// }
// => type of divisor is u64, and prefix number with '*'

/// 素数リスト（ベクタ）の作成
/// - 入力
///   - 上限値（指定された値までに含まれる素数のリストを作成する）
/// - 出力
///   - 作成した素数リスト（ベクタ）
pub fn primes_up_to(upper_bound: u64) -> Vec<u64> {
    let mut primes: Vec<u64> = Vec::new();
    let mut numbers: HashMap<u64, bool> = HashMap::new();

    // 素数マップ（作業用）の初期化
    for number  in 2..=upper_bound {
        numbers.insert(number, true);
    }

    // 順番に素数かどうかをチェックし、素数マップ（作業用）を更新する
    // 素数だった場合、その倍数は素数でないとして、素数マップ（作業用）を更新する
    for number in 2..=upper_bound {
        println!("number = {:?}", number);

        match numbers.get(&number) {
            // 既に素数ではないと確定している場合は、次の数へ
            Some(false) => {
                continue;
            },
            // まだ、素数と確定していない場合
            Some(true) => {
                // 自身より小さい数で割り切れるかを確認する
                let mut prime_flag = true;
                for divisor in 2..number {
                    if number % divisor == 0 {
                        prime_flag = false;
                        numbers.insert(number, false);
                        break;
                    }
                }
                // 素数と確定した場合、その倍数は素数ではないと確定
                if prime_flag == true {
                    let mut multiply = 2;
                    let mut key_number = number * multiply;
                    loop {
                        if key_number > upper_bound {
                            break;
                        }
                        numbers.insert(key_number, false);
                        multiply = multiply + 1;
                        key_number = number * multiply;
                    }
                }
            }
            None => {}
        }
    }

    // 素数マップ（作業用）をもとに素数リストを作成する
    for (number, flag) in numbers {
        if flag == true {
            primes.push(number);
        }
    }

    // 素数リストが順不同になっているので、ソートする
    primes.sort();
    primes
}
