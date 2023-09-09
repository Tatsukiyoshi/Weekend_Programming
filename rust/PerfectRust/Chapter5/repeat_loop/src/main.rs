/// ## 5-5 loop式
/// ### リスト5.14 キー入力された駅名を返す
#[allow(dead_code)]
fn enter_station() -> String {
    println!("Please input name of station.");

    // ミュータブルなStringを生成する
    let mut input = String::new();

    // キーボード入力された値を取得する
    std::io::stdin().read_line(&mut input).ok();

    // トリミングした結果を返す
    input.trim().to_owned()
}

/// ### リスト5.14 loop式の利用
#[allow(dead_code)]
pub fn loop_1(){
    // 駅名の配列
    let stations = ["Shinagawa", "Osaki", "Gotanda", "Meguro", "Ebisu", "Shibuya"];
    loop {
        let station = enter_station();  // キー入力された駅名を取得
        if station.eq("end") {          // loop式を抜ける
            println!("It's ended.");
            break;
        }
        if ! stations.contains(&station.as_str()) { // 入力された駅名が存在しない
            println!("Station:{} doesn't exist.", &station);
            continue;
        }

        let mut count = 1;
        for s in stations {
            if s.ne(&station) { // 入力された駅名と異なる場合
                count += 1;
                continue;
            } else {            // 入力された駅名の場合
                break;
            }
        }
        println!("Station:{} is {}th station.", &station, count);
    }
}

fn main() {
    loop_1();
}
