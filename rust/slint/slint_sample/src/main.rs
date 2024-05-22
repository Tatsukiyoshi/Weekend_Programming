slint::slint! {
    import { Button, VerticalBox } from "std-widgets.slint";

    export component App {
        in property <int> counter: 1;
        callback clicked <=> btn.clicked;
        VerticalBox {
            Text { text: "Hello World:" + counter; }
            btn := Button { text: "yay"; }
        }    
    }
}

fn main() {
    let app = App::new().unwrap();
    let weak = app.as_weak();
    app.on_clicked(move || {
        let app = weak.upgrade().unwrap();
        app.set_counter(app.get_counter() + 1);
    });
    app.run().unwrap();
}
