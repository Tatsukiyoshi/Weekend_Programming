use std::fs;
use serde::{Serialize, Deserialize};

#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct Message {
  pub id: i32,                // ID  
  pub posted: String,         // 投稿日時
  pub sender: String,         // 投稿者名
  pub content: String,        // 投稿内容
}

/// ##  データファイル名
static DATA_FILENAME: &str = "data.json";

pub fn get_all() -> Vec<Message> {
  let file = fs::read_to_string(DATA_FILENAME).unwrap();
  let mut json_data: Vec<Message> = serde_json::from_str(&file).unwrap();
  json_data.sort_by(|a, b| b.posted.cmp(&a.posted));
  json_data
}

/// ##  データ取得関数
pub fn get(id: i32) -> Message {
  let file = fs::read_to_string(DATA_FILENAME).unwrap();
  // let mut json_data: Vec<Message> = serde_json::from_str(&file).unwrap();
  let json_data: Vec<Message> = serde_json::from_str(&file).unwrap();
  let mut message = Message {id: 0, posted: "".to_string(),
    sender: "".to_string(), content: "".to_string()};
  if let Some(index) = json_data.iter().position(|item| item.id == id) {
    message = json_data[index].clone();
  }
  message
}

/// ##  データ処理関数
pub fn create(mut message: Message) -> Message {
  let file = fs::read_to_string(DATA_FILENAME).unwrap();
  let mut json_data: Vec<Message> = serde_json::from_str(&file).unwrap();
  let mut max = 0;
  for item in &json_data {
    max = std::cmp::max(item.id, max);
  }
  message.id = max + 1;
  json_data.push(message);
  let json_str = serde_json::to_string(&json_data).unwrap();
  let _ = fs::write(DATA_FILENAME, json_str);
  json_data.pop().unwrap()
}
