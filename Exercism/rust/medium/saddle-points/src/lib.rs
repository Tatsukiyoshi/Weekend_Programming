/// 鞍点を探す
/// 同一行に複数の最大値がある場合の想定が必要
pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    let mut points: Vec<(usize, usize)> = Vec::new();
    let mut founded = false;
    let mut saddle_columns: Vec<i32> = Vec::new();

    println!("input = {:?}", input);
    for row1 in 0..input.len() {
        // 行単位で行内の最大値となる列を見つける
        let mut largest;

        if input[row1].get(0).is_none() == true {
            break;
        }
        largest = input[row1].get(0).unwrap();

        for column1 in 0..input[row1].len() {
            let value: &u64 = input[row1].get(column1).unwrap();
            if value >= largest {
                if value > largest {
                    largest = value;
                    saddle_columns.clear();
                }
                saddle_columns.push(column1 as i32);
            }
        }

        println!("row = {} -> {:?}", row1, saddle_columns);

        // 行内の最大値が同一列の最小値か？
        for idx in 0..saddle_columns.len() {
            founded = true;
            let saddle_column: usize = *saddle_columns.get(idx).unwrap() as usize;
            for row2 in 0..input.len() {
                println!("{} : {}", input[row2].get(saddle_column).unwrap(), input[row1].get(saddle_column).unwrap());
                if input[row2].get(saddle_column).unwrap() < input[row1].get(saddle_column).unwrap() {
                    founded = false;
                    break;
                }
            }
            if founded == true {
                points.push((row1, saddle_column));
            }
        }
        saddle_columns.clear();
    }
    points
}
