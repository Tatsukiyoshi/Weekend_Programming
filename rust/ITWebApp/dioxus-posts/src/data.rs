use serde::{Serialize, Deserialize};

static BASE_API_URL: &str = "http://localhost:8000/api/posts";

#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct Message {
    pub id: i32,
    pub posted: String,
    pub sender: String,
    pub content: String,
}

#[derive(Serialize, Deserialize, Debug)]
pub enum ResponseContent {
    Items(Vec<Message>),
    Item(Message),
    Reason(String),
    None,   
}

#[derive(Serialize, Deserialize, Debug)]
pub struct ApiResponse {
    pub status: String,
    pub result: ResponseContent,
}

pub async fn call_index() -> Result<ApiResponse, reqwest::Error> {
    let url = format!("{}", BASE_API_URL);
    reqwest::Client::new()
        .get(&url)
        .fetch_mode_no_cors()
        .send()
        .await
        .unwrap()
        .json::<ApiResponse>()
        .await
}
