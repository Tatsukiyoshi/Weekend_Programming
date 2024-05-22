slint::include_modules!();

/// ### Slint App Main
/// https://releases.slint.dev/1.6.0/docs/rust/slint/
fn main() {
    let app = App::new().unwrap();
    let weak = app.as_weak();
    app.on_clicked(move || {
        let app = weak.upgrade().unwrap();
        app.set_counter(app.get_counter() + 1);
    });
    app.run().unwrap();
}
