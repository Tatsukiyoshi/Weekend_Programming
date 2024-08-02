use std::collections::HashMap;
use std::str::FromStr;

/// ヘッダ（結果出力用）
pub const RESULT_HEADER: &str = "Team                           | MP |  W |  D |  L |  P";

/// 試合結果のレポート生成
pub fn tally(match_results: &str) -> String {
    let mut result: String = "".to_string();
    let mut match_map: HashMap<&str, String> = HashMap::new();

    for match_result in match_results.split("\n") {
        if match_result.find(";") == None {
            break;
        }
        let match_info: Vec<&str> = match_result.split(";").collect();

        for cnt in 0..=1 {
            if match_map.get(match_info[cnt]).is_none() {
                match_map.insert(match_info[cnt], "0,0,0,0,0".to_string());
            }
        }
        // 集計済の試合結果を勝ち点、試合数、勝ち数、引き分け数、負け数に分解する
        // （当初、冗長だったコードをCopilotを活用して、サブルーチン化）
        let str_result1 = match_map.get(match_info[0]).unwrap();
        let (_point1, _match1, mut win1, mut draw1, mut loss1)
            = parse_match_results(str_result1);

        let str_result2 = match_map.get(match_info[1]).unwrap();
        let (_point2, _match2, mut win2, mut draw2, mut loss2)
            = parse_match_results(str_result2);

        // 試合結果のカウント
        match match_info[2] {
            "win" => {
                win1 += 1;
                loss2 += 1;
            },
            "loss" => {
                loss1 += 1;
                win2 += 1;
            },
            "draw" => {
                draw1 += 1;
                draw2 += 1;
            },
            _ => {}
        }

        // 試合結果の格納
        let str_result1 = match_map.get_mut(match_info[0]).unwrap();
        let match1 = win1 + loss1 + draw1;
        let point1 = win1 * 3 + draw1;
        let formstr1 = format!("{},{},{},{},{}", point1, match1, win1, draw1, loss1);
        *str_result1 = formstr1;

        let str_result2= match_map.get_mut(match_info[1]).unwrap();
        let match2 = win2 + loss2 + draw2;
        let point2 = win2 * 3 + draw2;
        let formstr2 = format!("{},{},{},{},{}", point2, match2, win2, draw2, loss2);
        *str_result2 = formstr2;
    }

    // 勝ち点のみのマップを作成し、ソートする
    // ソートは、勝ち点の降順とする
    // ただし、同数の場合は、チーム名のアルファベット順とする
    // https://yiskw713.hatenablog.com/entry/rust-hashmap-sort
    // https://dottrail.codemountains.org/rust-vec-sort-by/
    let mut match_point_map: HashMap<&str, i32> = HashMap::new();
    for match_key in match_map.keys() {
        let match_result = match_map.get(match_key);
        if match_result.is_none() {
            break;
        }
        let (points, _matches, _wins, _draws, _losses)
            = parse_match_results(match_result.unwrap());
        match_point_map.insert(match_key, points);
    }
    let mut points_vec: Vec<(&&str, &i32)> = match_point_map.iter().collect();
    points_vec.sort_by(|a, b|
        if a.1 != b.1 { (-a.1).cmp(&(-b.1)) } else { a.0.cmp(b.0) } );

    // 勝ち点のみのマップの順に結果を出力する
    result += RESULT_HEADER;

    for index in 0..points_vec.len() {
        let match_key = points_vec[index].0;
        let match_result = match_map.get(match_key);
        if match_result == None {
            break;
        }
        let (points, matches, wins, draws, losses)
            = parse_match_results(match_result.unwrap());
        let format_result
            = format!("\n{:30} |{:3} |{:3} |{:3} |{:3} |{:3}", match_key, matches, wins, draws, losses, points);
        println!("{:?}", format_result);
        result += format_result.as_str();
    }
    result
}

/// 中間形式（文字列）からの各データ抽出
/// - 入力
///   - 中間形式（文字列）
/// - 出力
///   - 勝ち点、試合数、勝利数、引き分け数、負け数
fn parse_match_results(str_result: &str) -> (i32, i32, i32, i32, i32) {
    let vec_result: Vec<&str> = str_result.split(",").collect();
    let points = i32::from_str(vec_result.get(0).unwrap_or(&"0")).unwrap_or_default();
    let matches = i32::from_str(vec_result.get(1).unwrap_or(&"0")).unwrap_or_default();
    let wins = i32::from_str(vec_result.get(2).unwrap_or(&"0")).unwrap_or_default();
    let draws = i32::from_str(vec_result.get(3).unwrap_or(&"0")).unwrap_or_default();
    let losses = i32::from_str(vec_result.get(4).unwrap_or(&"0")).unwrap_or_default();
    (points, matches, wins, draws, losses)
}
