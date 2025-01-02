#![allow(non_snake_case)]
/// ##	https://github.com/wateryinhare62/atmarkit_rust_adv
use dioxus::prelude::*;
use tracing::Level;

mod data;
use data::{Message, ResponseContent};

fn main() {
	// Init logger
	dioxus_logger::init(Level::INFO).expect("failed to init logger");
	launch(App);
}

type Posts = im_rc::HashMap<i32, Message>;

#[component]
fn App() -> Element {
	let posts_source = use_resource(|| data::call_index());
	let mut posts = use_signal(Posts::default);

	rsx! {
		match &*posts_source.read_unchecked() {
			Some(Ok(res)) => {
				if posts.read().is_empty() {
					match &res.result {
						ResponseContent::Items(items) => {
							for item in items {
								posts.write().insert(item.id, 
									Message {
										id: item.id,
										posted: item.posted.clone(),
										sender: item.sender.clone(),
										content: item.content.clone(),
									}
								);
							}
							rsx! { div { "データ読み込みを終了しました" } }
						},
						ResponseContent::Item(item) =>
							rsx! { div { "{serde_json::to_string(&item).unwrap()}" } },
						ResponseContent::Reason(reason) => rsx! { div { "{reason}" } },
						ResponseContent::None => rsx! { div {} },
					}
				} else {
					//rsx! { div { "ここに投稿データを表示します" } }
					let mut filtered_posts = posts.read()
						.iter()
						.map(|f| *f.0)
						.collect::<Vec<_>>();
					filtered_posts.sort_unstable_by(|a, b| b.cmp(a));
					rsx! {
						{
							filtered_posts.iter().map(|id| 
								rsx! { PostEntry { id: *id, set_posts: posts } }
							)
						}
					}
				}
			},
			Some(Err(err)) => rsx! { div { "初期データの読み込みに失敗しました：{err}" } },
			None => rsx! { div { "データを読み込んでいます..." } }
		}
	}
}

#[component]
fn PostEntry(id: i32, set_posts: Signal<Posts>) -> Element {
	let posts = set_posts.read();
	let post = &posts[&id];

	rsx! {
		div {
			class: "card mb-3",
			div {
				div {
					class: "card-header",
					"{post.sender} {post.posted}"
				}
				div {
					class: "card-body",
					p {
						class: "card-text",
						"{post.content}"
					}
				}
			}
		}
	}
}
