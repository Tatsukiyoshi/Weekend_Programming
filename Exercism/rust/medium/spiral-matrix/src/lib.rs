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
    let x = 0; // 周回数
    let mut data = 1; // マトリックスに埋める数値
    let mut work: Vec<u32> = Vec::new();

    //println!("size = {:?}", volume);
    // マトリックスサイズが０の場合、空を返す
    if size == 0 {
        return result;
    }

    // マトリックスの初期化
    result = Vec::with_capacity(volume * volume);

    // 上側
    for _column in 1..=volume {
        work.push(data);
        data = data + 1;
    }
    result.insert(x, work);

    // 右側
    for row in 1..=volume {
        let mut work = result.get(row - 1);
        //println!("row = {:?}, vector = {:?}", row, work);
        if work.is_none() {
            let mut vec_work: Vec<u32> = Vec::with_capacity(volume);
            for column in 1..=volume {
                if column == volume {
                    vec_work.insert(column - 1, data);
                } else {
                    vec_work.insert(column - 1, INITIAL_VALUE);
                }
            }
            result.insert(row - 1, vec_work);
            data = data + 1;
        }
    }

    // 下側
    let mut work = result.get_mut(volume - 1).unwrap();
    for column in (1..volume).rev() {
        let mut value = work.get_mut(column - 1).unwrap();
        if *value == INITIAL_VALUE {
            *value = data;
            data = data + 1;
        }
    }

    result
}
