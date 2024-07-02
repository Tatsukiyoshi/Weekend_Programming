pub fn plants(diagram: &str, student: &str) -> Vec<&'static str> {
    let children: [&str; 12] = ["Alice", "Bob", "Charlie", "David", "Eve", "Fred",
        "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"];
    let mut diagram_vec:Vec<&str> = Vec::with_capacity(2);
    let mut plants_vec:Vec<&str> = Vec::with_capacity(4);
    let mut child_pos = 0;

    diagram_vec = diagram.split('\n').collect();

    for pos in 0..children.len(){
        if student == children[pos] {
            child_pos = pos;
            break;
        }
    }

    for j in 0..2 {
        for i in 0..2 {
            let plant_pos = child_pos * 2 + i;
            let plant_str = diagram_vec[j].chars().nth(plant_pos).unwrap();

            let plant: &str = match plant_str {
                'G' => {
                    "grass"     // "Grass"
                }
                'C' => {
                    "clover"    // "Clover"
                }
                'R' => {
                    "radishes"  // "Radish"
                }
                'V' =>{
                    "violets"   // "Violet"
                }
                _ => {
                    ""
                }
            };
            plants_vec.push(plant);
        }
    }
    plants_vec
}
