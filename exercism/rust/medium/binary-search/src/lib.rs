/// 二分木探索
/// 探索範囲の中央値と比較し、中央値と一致するまで繰り返す
/// - 中央値より大きい場合、その中央値より大きい数の集合を次の探索範囲とする
/// - 中央値より小さい場合、その中央値より小さい数の集合を次の探索範囲とする
pub fn find(array: &[i32], key: i32) -> Option<usize> {
    let mut found = None;

    if array.len() == 0 {
        return found;
    }

    let mut middle;
    let mut end = array.len() - 1;
    let mut start = 0;

    loop {
        middle = start + (end - start) / 2;
        if array[middle] == key {
            found = Some(middle);
            break;
        } else {
            if start == end {
                break;
            }
            if array[middle] > key {
                if middle == 0 {
                    end = middle;
                } else {
                    end = middle - 1;
                }
            } else {
                start = middle + 1;
            }
        }
    }
    found
}
