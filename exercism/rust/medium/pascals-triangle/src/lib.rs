pub struct PascalsTriangle {
    pub row_count_number: u32
}

impl PascalsTriangle {
    pub fn new(row_count: u32) -> Self {
        PascalsTriangle {
            row_count_number: row_count
        }
    }

    pub fn rows(&self) -> Vec<Vec<u32>> {
        let mut result: Vec<Vec<u32>> = Vec::new();

        for i in 0..self.row_count_number {
            match i as usize {
                0 => {
                    result.push(vec![1]);
                }
                1 => {
                    result.push(vec![1, 1]);
                }
                _ => {
                    let previous_vec = result.get((i - 1) as usize).unwrap();
                    let mut new_vec: Vec<u32> = Vec::new();
                    new_vec.push(1);
                    let previous_len = previous_vec.len();
                    for index in 0..previous_len - 1 {
                        let value1 = previous_vec.get(index).unwrap();
                        let value2 = previous_vec.get(index + 1).unwrap();
                        new_vec.push(value1 + value2);
                    }
                    new_vec.push(1);
                    result.push(new_vec);
                }
            }
        }

        result
    }
}
