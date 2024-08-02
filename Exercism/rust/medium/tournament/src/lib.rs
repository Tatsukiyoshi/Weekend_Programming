use std::collections::HashMap;
use std::str::FromStr;
use std::u32;

/// ヘッダ（結果出力用）
pub const RESULT_HEADER: &str = "Team                           | MP |  W |  D |  L |  P";

/// 試合結果のレポート生成
pub fn tally(match_results: &str) -> String {
    let mut result: String = "".to_string();
    let mut match_map = HashMap::new();

    for match_result in match_results.split("\n") {
        let mut win1: u32 = 0;
        let mut loss1: u32 = 0;
        let mut draw1: u32 = 0;
        let mut win2: u32 = 0;
        let mut loss2: u32 = 0;
        let mut draw2: u32 = 0;
        let formstr1: String;
        let formstr2: String;

        if match_result.find(";") == None {
            break;
        }
        let match_info: Vec<&str> = match_result.split(";").collect();

        for cnt in 0..=1 {
            if match_map.get(match_info[cnt]).is_none() {
                match_map.insert(match_info[cnt], "0,0,0");
            }
        }
        let str_result1 = match_map.get(match_info[0]).unwrap();
        let vec_result1: Vec<&str> = str_result1.split(",").collect();
        for vec1_index in 0..vec_result1.len() {
            match vec1_index {
                0 => {
                    win1 = u32::from_str(vec_result1.get(0).unwrap()).unwrap();
                },
                1 => {
                    loss1 = u32::from_str(vec_result1.get(1).unwrap()).unwrap();
                },
                2 => {
                    draw1 = u32::from_str(vec_result1.get(2).unwrap()).unwrap();
                }
                _ => {}
            }
        }
        let str_result2 = match_map.get(match_info[1]).unwrap();
        let vec_result2: Vec<&str> = str_result2.split(",").collect();
        for vec2_index in 0..vec_result2.len() {
            match vec2_index {
                0 => {
                    win2 = u32::from_str(vec_result2.get(0).unwrap()).unwrap();
                },
                1 => {
                    loss2 = u32::from_str(vec_result2.get(1).unwrap()).unwrap();
                },
                2 => {
                    draw2 = u32::from_str(vec_result2.get(2).unwrap()).unwrap();
                }
                _ => {}
            }
        }

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
        /*
        let str_result1 = match_map.get_mut(match_info[0]).unwrap();
        formstr1 = format!("{},{},{}", win1, loss1, draw1);
        *str_result1 = formstr1.as_str();

        let str_result2 = match_map.get_mut(match_info[1]).unwrap();
        formstr2 = format!("{},{},{}", win2, loss2, draw2);
        *str_result2 = formstr2.as_str();
        */
    }

    // 結果出力
    result += RESULT_HEADER;

    /*
    for match_key in match_map.keys() {
        println!("key = {:?}", match_key);
        println!("value = {:?}", match_map.get(match_key).unwrap());
    }
    */

    result
}
