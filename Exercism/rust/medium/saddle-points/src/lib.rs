/// 鞍点を探す
pub fn find_saddle_points(input: &[Vec<u64>]) -> Vec<(usize, usize)> {
    let mut points: Vec<(usize, usize)> = Vec::new();
    let mut founded = false;
    let mut saddle_column= 0;

    for row1 in 0..input.len() {
        let mut largest = 0;
        for column1 in 0..input[row1].len() {
            let value: &u64 = input[row1].get(column1).unwrap();
            if value > &largest {
                largest = *value;
                saddle_column = column1;
                founded = true;
            }
        }
        if founded == false {
            continue;
        }
        let smallest = input[row1].get(saddle_column).unwrap();
        for row2 in 0..input.len() {
            let value = input[row2].get(saddle_column).unwrap();
            if value < smallest {
                founded = false;
            }
        }
        if founded == true {
            points.push((row1, saddle_column));
        }
    }
    points
}
