slint::include_modules!();

fn main() -> Result<(), slint::PlatformError> {
    let ui = Example::new().unwrap();

    ui.run()
}
