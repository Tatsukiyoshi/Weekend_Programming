//n:x,y
//1:0,0 Y = Y + 1
//2:0,1 Y = Y + 1
//3:0,2 X = X + 1 (Y = Max)
//4:1,2 X = X + 1
//5:2,2 Y = Y - 1 (X = Max)
//6:2,1 Y = Y - 1
//7:2,0 X = X - 1 (Y = 0)
//8:1,0 Y = Y + 1 (X = Max / 2)
//9:1,1           (Y = Max / 2)
/// 初期値
pub const INITIAL_VALUE: u32 = 0;

/// 渦巻のようにマトリックスを埋めていく
/// マトリックスのサイズが０の場合、空を返す
/// - 入力
///   - マトリックスのサイズ
/// - 出力
///   - マトリックス
pub fn spiral_matrix(size: u32) -> Vec<Vec<u32>> {
    let volume: usize = size as usize;
    let mut result: Vec<Vec<u32>> = Vec::new();
    let mut data = 1; // マトリックスに埋める数値
    let mut start = 1;
    let mut end = volume;

    // マトリックスサイズが０の場合、空を返す
    if size == 0 {
        return result;
    }

    // マトリックスの初期化
    result = Vec::with_capacity(volume * volume);

    loop {
        // 上側
        if start == 1 {
            let mut vec_work: Vec<u32> = Vec::new();
            for _column in start..=end {
                vec_work.push(data);
                data += 1;
            }
            result.insert(start - 1, vec_work);
        } else {
            let work = result.get_mut(start - 1).unwrap();
            for column in start..=end {
                let value = work.get_mut(column - 1).unwrap();
                if *value == INITIAL_VALUE {
                    *value = data;
                    data += 1;
                }
            }
        }

        // 右側
        for row in start..=end {
            let work = result.get_mut(row - 1);
            if work.is_none() {
                let mut vec_work: Vec<u32> = Vec::with_capacity(volume);
                for column in start..=end {
                    if column == end {
                        vec_work.insert(column - 1, data);
                    } else {
                        vec_work.insert(column - 1, INITIAL_VALUE);
                    }
                }
                result.insert(row - 1, vec_work);
                data += 1;
            } else {
                let value = work.unwrap().get_mut(end - 1).unwrap();
                if *value == INITIAL_VALUE {
                    *value = data;
                    data += 1;
                }
            }
        }

        // 下側
        let work = result.get_mut(end - 1).unwrap();
        for column in (start..end).rev() {
            let value = work.get_mut(column - 1).unwrap();
            if *value == INITIAL_VALUE {
                *value = data;
                data += 1;
            }
        }

        // 左側
        for row in (start..end).rev() {
            let work = result.get_mut(row - 1).unwrap();
            let value = work.get_mut(start - 1).unwrap();
            if *value == INITIAL_VALUE {
                *value = data;
                data += 1;
            }
        }

        if start != end {
            start += 1;
        }
        if start == end {
            break;
        }
        end -= 1;
    }

    result
}
