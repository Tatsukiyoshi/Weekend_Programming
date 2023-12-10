/// ## 9-3.構造体型バリアント
/// ### 形を表す列挙型
pub enum Shape
{
    Rectangle   {height: f64, width: f64},
    Triangle    {height: f64, bottom: f64},
    Circle      {radius: f64},
    Trapezium   {upper: f64, bottom: f64, height: f64}
}

impl Shape {
    /// ### リスト9.7 図形ごとの面積を計算して返す
    pub fn area(&self) -> f64 {
        match self {
            // 四角形の面接を求めて返す
            Self::Rectangle {height, width} => height * width,
            // 三角形の面積を求めて返す
            Self::Triangle {height, bottom} => bottom * height / 2.0,
            // 円の面積を求めて返す
            Self::Circle {radius} => radius * radius * std::f64::consts::PI,
            // 台形の面積を求めて返す
            Self::Trapezium {upper, bottom, height} => (upper + bottom) * height / 2.0
        }
    }
}

/// ### リスト9.9 値の省略
impl ToString for Shape {
    fn to_string(&self) -> String {
        match self {
            Self::Rectangle {..}    => "四角形です。",
            Self::Triangle {..}     => "三角形です。",
            Self::Circle {..}       => "円です。",
            Self::Trapezium {..}    => "台形です。"
        }.to_string()
    }
}

/// ### リスト9.8 構造体型バリアントの利用
#[allow(dead_code)]
pub fn use_struct(){
    let rectangle = Shape::Rectangle {height: 10.0, width: 5.5 };
    let triangle = Shape::Triangle {height: 10.0, bottom: 5.0 };
    let circle = Shape::Circle {radius: 3.5 };
    let trapezium = Shape::Trapezium {bottom: 5.0, upper: 3.0, height: 6.0 };
    println!("四角形の面積 = {}", rectangle.area());
    println!("三角形の面積 = {}", triangle.area());
    println!("円の面積 = {}", circle.area());
    println!("台形の面積 = {}", trapezium.area());
}
