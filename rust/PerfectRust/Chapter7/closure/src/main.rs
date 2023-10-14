use crate::closure::{closure_sum, move_1, move_2, use_impl_where_1, use_impl_where_2};

mod closure;

fn main() {
    closure_sum();
    move_1();
    move_2();
    use_impl_where_1();
    use_impl_where_2();
}
