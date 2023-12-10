use crate::customer::{use_clone, use_debug, use_default, use_drop, use_from};

mod customer;

fn main() {
    use_debug();
    use_clone();
    use_drop();
    use_default();
    use_from();
}
