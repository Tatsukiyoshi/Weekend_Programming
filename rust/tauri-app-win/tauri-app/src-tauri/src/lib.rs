#![cfg_attr(
  all(not(debug_assertions), target_os = "windows"),
  windows_subsystem = "windows"
)]

use tauri::Manager;
use tauri::{
  menu::{MenuBuilder, MenuItemBuilder, PredefinedMenuItem},
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
  // here `"quit".to_string()` defines the menu item id, and the second parameter is the menu item label.
  //let quit: CustomMenuItem = CustomMenuItem::new("quit".to_string(), "Quit");
  //let hide: CustomMenuItem = CustomMenuItem::new("show".to_string(), "Show");
  //let tray_menu: SystemTrayMenu = 
  //  SystemTrayMenu::new()
  //    .add_item(quit)
  //    .add_native_item(SystemTrayMenuItem::Separator)
  //    .add_item(hide);
  tauri::Builder::default()
  .invoke_handler(tauri::generate_handler![close_splashscreen])
  .setup(|app| {
      // Change the window visibility and Exit the application From system tray.
      // Menu item as follows:
      // 1. "Show" or "Hide" : To change the visibility of the main window
      // 2. Separator
      // 3. "Quit" : To exit this application
      let toggle = MenuItemBuilder::with_id("toggle", "Toggle").build(app);
      let tray_menu = MenuBuilder::new(app).items(&[&toggle]).build();
      let tray = TrayIconBuilder::new()
        .menu(&tray_menu)
        .on_menu_event(move |app, event| match event.id().as_ref() {
            // "Show" : show the main window and change the caption from "Show" to "Hide"
            // "Hide" : hide the main window and change the caption from "Hide" to "Show"
            // "Quit" : exit this application
            "toggle" => {
                println!("toggle clicked");
            }
            _ => (),
        })
        .on_tray_icon_event(|tray, event| {
            // 左クリック、右クリック、ダブルクリックの各イベント
            if event.click_type == ClickType::Left {
              println!("system tray received a left click");
            }
            if event.click_type == ClickType::Right {
              println!("system tray received a right click");
            }
            if event.click_type == ClickType::Double {
              println!("system tray received a double click");
            }
        })
        .build(app)?;
      let splashscreen_window = app.get_webview_window("splashscreen").unwrap();
      // Set Icon for System Tray
      app.tray_handle().set_icon(tauri::Icon::Raw(include_bytes!("../icons/icon.ico").to_vec())).unwrap();
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
    //.system_tray(SystemTray::new().with_menu(tray_menu))
    //.on_system_tray_event(|app, event| match event {
    //  SystemTrayEvent::LeftClick {
    //    position: _,
    //    size: _,
    //    ..
    //  } => {
    //    println!("system tray received a left click");
    //  }
    //  SystemTrayEvent::RightClick {
    //    position: _,
    //    size: _,
    //    ..
    //  } => {
    //    println!("system tray received a right click");
    //  }
    //  SystemTrayEvent::DoubleClick {
    //    position: _,
    //    size: _,
    //    ..
    //  } => {
    //    println!("system tray received a double click");
    //  }
    //  SystemTrayEvent::MenuItemClick { id, .. } => {
    //    let item_handle = app.tray_handle().get_item(&id);
    //    match id.as_str() {
    //      "quit" => {
    //        std::process::exit(0);
    //      }
    //      "show" => {
    //        let window = app.get_webview_window("main").unwrap();
    //        if window.is_visible().unwrap(){
    //          window.hide().unwrap();
    //          item_handle.set_title("Show").unwrap();
    //        } else {
    //          window.show().unwrap();
    //          item_handle.set_title("Hide").unwrap();
    //        }
    //      }
    //      _ => {}
    //    }
    //  }
    //  _ => {}
    //})
    .on_window_event(|event| match event.event() {
      tauri::WindowEvent::CloseRequested { api, .. } => {
        event.window().hide().unwrap();
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
