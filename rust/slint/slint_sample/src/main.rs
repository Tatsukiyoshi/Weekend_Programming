slint::slint! {
    import { Button, VerticalBox } from "std-widgets.slint";

    export component App {
        property <int> counter: 1;
        VerticalBox {
            Text { text: "Hello World:" + counter; }
            Button { text: "yay"; clicked => { counter += 1; } }
        }    
    }
}

fn main() {
    App::new().unwrap().run().unwrap();
}
