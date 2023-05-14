/// ## 4-2 浮動小数点型
/// ### リスト4.5 浮動小数点リテラル
#[allow(dead_code)]
pub fn floating_literal(){
    println!("a = {}", 10.5f32);
    println!("b = {}", -10.5f64);
    println!("c = {}", 10.5_f32);
    println!("d = {}", -10.5_f64);
}

/// ## 4-2 浮動小数点型
/// ### リスト4.6 浮動小数点型の定数
#[allow(dead_code)]
pub fn floating_constant(){
    println!("RADIX = {}", f32::RADIX);
    println!("MANTISSA_DIGITS = {}", f32::MANTISSA_DIGITS);
    println!("DIGITS = {}", f32::DIGITS);
    println!("EPSILON = {}", f32::EPSILON);
    println!("MIN = {}", f32::MIN);
    println!("MIN_POSITIVE = {}", f32::MIN_POSITIVE);
    println!("MIN_EXP = {}", f32::MIN_EXP);
    println!("MIN_10_EXP = {}", f32::MIN_10_EXP);
    println!("MAX = {}", f32::MAX);
    println!("MAX_EXP = {}", f32::MAX_EXP);
    println!("MAX_10_EXP = {}", f32::MAX_10_EXP);
    println!("NAN = {}", f32::NAN);
    println!("INFINITY = {}", f32::INFINITY);
    println!("NEG_INFINITY = {}", f32::NEG_INFINITY);
}

/// ## 4-2 浮動小数点型
/// ### リスト4.7 浮動小数点型の主なメソッド
/// #### foor()は、floor()の誤記
#[allow(dead_code)]
pub fn methods(){
    let x = 10.5_f64;
    println!("cbrt() = {}", x.cbrt());
    println!("ceil() = {}", x.ceil());
    // println!("foor() = {}", x.floor());
    println!("floor() = {}", x.floor());
}
