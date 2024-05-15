#![allow(non_snake_case)]
/// ##	https://github.com/wateryinhare62/atmarkit_rust_adv

mod data;

use dioxus::prelude::*;
use tracing::{Level, info};
use data::{ResponseContent};

fn main() {
  // Init logger
  dioxus_logger::init(Level::INFO).expect("failed to init logger");
	launch(app);
}

fn app() -> Element {
  info!("Called App");

  // https://dioxuslabs.com/learn/0.5/reference/use_resource
  let posts_source = use_resource(|| async move {
    data::call_index().await
  });

  rsx! {
    match &*posts_source.read_unchecked() {
      Some(Ok(res)) => {
        rsx! { div { "hello" } };
        match &res.result {
          ResponseContent::Items(items) => {
            rsx! {
              for item in items {
                div { "{serde_json::to_string(&item).unwrap()}" }
              }
            }
          },
          ResponseContent::Item(item) => 
            rsx!{ div { "{serde_json::to_string(&item).unwrap()}" } },
          ResponseContent::Reason(reason) => rsx!{ div { "{reason}" } },
          ResponseContent::None => { rsx!{ div {} } },
        }
      },
      Some(Err(err)) => rsx! { div { "初期データの読み込みに失敗しました：{err}" } },
      None => rsx! { div { "データを読み込んでいます..." } }
    }
  }
}
