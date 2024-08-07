// This annotation prevents Clippy from warning us that `School` has a
// `fn new()` with no arguments, but doesn't implement the `Default` trait.
//
// Normally, it's good practice to just do what Clippy tells you, but in this
// case, we want to keep things relatively simple. The `Default` trait is not the point
// of this exercise.
#[allow(clippy::new_without_default)]
pub struct School {
    students: Vec<Student>
}

impl School {
    /// Schoolの初期化
    pub fn new() -> School {
        Self { students: Vec::with_capacity(5) }
    }

    /// 学生の追加
    /// - 入力
    ///   - 学生の階級
    ///   - 学生の名前
    pub fn add(&mut self, grade: u32, student: &str) {
        let new_student = Student::new(grade, student.to_string());
        self.students.push(new_student);
    }

    /// 階級リストの取得
    /// - 入力
    ///   - なし
    /// - 出力
    ///   - 階級リスト（ベクタ）
    pub fn grades(&self) -> Vec<u32> {
        let mut result: Vec<u32> = Vec::with_capacity(5);
        for student in &self.students {
            let mut found = false;
            for grade in result.clone() {
                if student.grade == grade {
                    found = true;
                    continue;
                }
            }
            if found == false {
                result.push(student.grade);
            }
        }
        result.sort();

        result
    }

    // If `grade` returned a reference, `School` would be forced to keep a `Vec<String>`
    // internally to lend out. By returning an owned vector of owned `String`s instead,
    // the internal structure can be completely arbitrary. The tradeoff is that some data
    // must be copied each time `grade` is called.
    /// 学生リストの取得
    /// - 入力
    ///   - 階級
    /// - 出力
    ///   - 学生の名前リスト（ベクタ）
    pub fn grade(&self, grade: u32) -> Vec<String> {
        let mut result: Vec<String> = Vec::with_capacity(5);
        for student in self.students.clone() {
            if student.grade == grade {
                result.push(student.name);
            }
        }
        result.sort();

        result
    }
}

#[derive(Clone, Debug)]
/// Student
/// - 階級
/// - 名前
struct Student {
    grade: u32,
    name: String
}

impl Student {
    /// Studentの初期化
    /// - 入力
    ///   - 階級
    ///   - 名前
    pub fn new(grade: u32, name: String) -> Self {
        Self { grade: grade, name: name }
    }
}
