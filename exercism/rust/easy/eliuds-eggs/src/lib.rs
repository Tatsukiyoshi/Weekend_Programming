/// 与えられた数を2進数に変換する中でビットが１であれば、
/// 卵があるという判定で卵の数をインクリメントする
pub fn egg_count(display_value: u32) -> usize {
    let mut dividend = display_value;
    let mut eggs = 0;
    loop {
        if dividend % 2 == 1 {
            eggs = eggs + 1;
        }
        if dividend < 2 {
            break;
        }
        dividend = dividend / 2;
    }
    eggs
}
