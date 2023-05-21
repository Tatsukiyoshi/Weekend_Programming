#   Splashscreen
Webページが読み込みに時間がかかったり、メインウィンドウを表示する前に初期処理を実行する必要がある場合、スプラッシュスクリーンによって、ユーザの起動体験を改善できる。

##  Setup
まず、実行環境のディレクトリにsplashscreen.html（スプラッシュスクリーンのためのHTMLコード）を作る。

```json
"windows": [
    {
        "title": "Tauri App",
        "width": 800,
        "height": 600,
        "resizable": true,
        "fullscreen": false,
    +   "visible": false // Hide the main window by default
    },
    // Add the splashscreen window
    + {
    +   "width": 400,
    +   "height": 200,
    +   "decorations": false,
    +   "url": "splashscreen.html",
    +   "label": "splashscreen"
    + }
]
```

さて、アプリケーション起動時には、メインウィンドウを非表示にして、スプラッシュスクリーンを表示するようにします。続けて、メインウィンドウが準備できたら、スプラッシュスクリーンを閉じる手段を準備する必要があります。何を待っているかによって、スプラッシュスクリーンを閉じる手段は決まる。

##  Waiting for Webpage
Webコンテンツを待っているのであれば、フロントエンドからスプラッシュスクリーンを閉じるコマンドを準備したいでしょう。

```rust
use tauri::Manager;
// Create the command:
// This command must be async so that it doesn't run on the main thread.
#[tauri::command]
async fn close_splashscreen(window: tauri::Window) {
  // Close splashscreen
  if let Some(splashscreen) = window.get_window("splashscreen") {
    splashscreen.close().unwrap();
  }
  // Show main window
  window.get_window("main").unwrap().show().unwrap();
}

// Register the command:
fn main() {
  tauri::Builder::default()
    // Add this line
    .invoke_handler(tauri::generate_handler![close_splashscreen])
    .run(tauri::generate_context!())
    .expect("failed to run app");
}
```
２つの方法のうち、いずれかでプロジェクトへインポートできる。

```js
// With the Tauri API npm package:
import { invoke } from '@tauri-apps/api/tauri'
```

または

```js
// With the Tauri global script:
const invoke = window.__TAURI__.invoke
```

最後にイベントリスナに追加する。（または閉じたいときにinvokeを使って呼び出すだけです）:)

```js
document.addEventListener('DOMContentLoaded', () => {
  // This will wait for the window to load, but you could
  // run this function on whatever trigger you want
  invoke('close_splashscreen')
})
```

##  Waiting for Rust
サーバサイドでのRustコードの実行を待っているのであれば、setup関数ハンドラに置いて、Appインスタンスからアクセスできるようにする。

```rust
use tauri::Manager;
fn main() {
  tauri::Builder::default()
    .setup(|app| {
      let splashscreen_window = app.get_window("splashscreen").unwrap();
      let main_window = app.get_window("main").unwrap();
      // we perform the initialization code on a new task so the app doesn't freeze
      tauri::async_runtime::spawn(async move {
        // initialize your app here instead of sleeping :)
        println!("Initializing...");
        std::thread::sleep(std::time::Duration::from_secs(2));
        println!("Done initializing.");

        // After it's done, close the splashscreen and display the main window
        splashscreen_window.close().unwrap();
        main_window.show().unwrap();
      });
      Ok(())
    })
    .run(tauri::generate_context!())
    .expect("failed to run app");
}
```
