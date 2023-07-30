mod static_val;

fn main() {
    let price: i32 = 100;
    println!("{}円の消費税込み金額 = {}円", price, static_val::calc_amount(price));
    static_val::calc_total(price);
}
