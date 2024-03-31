#![cfg_attr(
  all(not(debug_assertions), target_os = "windows"),
  windows_subsystem = "windows"
)]

use tauri::Manager;
use tauri::{
  menu::{MenuBuilder, CheckMenuItemBuilder, PredefinedMenuItem},
  tray::{ClickType, TrayIconBuilder},
};

// Create the command:
// This command must be async so that it doesn't run on the main thread.
#[tauri::command]
async fn close_splashscreen(window: tauri::WebviewWindow) {
  println!("Closing SplashScreen.");
  // Close splashscreen
  if let Some(splashscreen) = window.get_webview_window("splashscreen") {
    println!("Close SplashScreen.");
    splashscreen.close().unwrap();
  }
}

// Register the command:
#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
  tauri::Builder::default()
    .invoke_handler(tauri::generate_handler![close_splashscreen])
    .setup(|app| {
      // Change the window visibility and Exit the application From system tray.
      // Menu item as follows:
      //  1. "Show" : Toggle Switch for the visibility of the main window
      //  2. Separator
      //  3. "Quit" : To exit this application
      let show = CheckMenuItemBuilder::new("Show").build(app)?;
      let tray_menu = MenuBuilder::new(app)
        .item(&show)
        .item(&PredefinedMenuItem::separator(app)?)
        .item(&PredefinedMenuItem::quit(app, None)?)
        .build()?;
      let tray = TrayIconBuilder::new()
        .menu(&tray_menu)
        // Set Icon for System Tray
        .icon(tauri::image::Image::from_bytes(include_bytes!("../icons/icon.ico"))?)
        .on_menu_event(move |app, event|  {
            // "Show" : toggle the check of the visibility of the main window
            // "Quit" : exit this application
            if event.id() == show.id() {
              if show.is_checked().unwrap() {
                println!("show is checked");
              } else {
                println!("show is not checked");
              }
            }
        })
        .on_tray_icon_event(|tray, event| {
            // System tray event handling (left-click, right-click, double-click)
            if event.click_type == ClickType::Left {
              let app = tray.app_handle();
              if let Some(webview_window) = app.get_webview_window("main") {
                let _ = webview_window.show();
                let _ = webview_window.set_focus();
              }
            }
            //if event.click_type == ClickType::Right {
            //  println!("system tray received a right click");
            //}
            //if event.click_type == ClickType::Double {
            //  println!("system tray received a double click");
            //}
        })
        .build(app)?;
      let splashscreen_window = app.get_webview_window("splashscreen").unwrap();

      // we perform the initialization code on a new task so the app doesn't freeze
      tauri::async_runtime::spawn(async move {
        // initialize your app here instead of sleeping :)
        println!("Initializing...");
        std::thread::sleep(std::time::Duration::from_secs(2));
        println!("Done initializing.");

        // After it's done, close the splashscreen and display the main window
        splashscreen_window.close().unwrap();
      });
      Ok(())
    })
    .on_window_event(|window, event| match event {
      tauri::WindowEvent::CloseRequested { api, .. } => {
        window.hide().unwrap();
        api.prevent_close();
      }
      _ => {}
    })
    .build(tauri::generate_context!())
    .expect("failed to run app")
    .run(|_app_handle, event| match event {
      tauri::RunEvent::ExitRequested { api, .. } => {
        api.prevent_exit();
      }
      _ => {}
    });
}
