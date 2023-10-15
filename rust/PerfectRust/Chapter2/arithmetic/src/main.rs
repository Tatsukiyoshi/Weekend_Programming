///! ２章　演算子
mod arithmetic;

fn main() {
    arithmetic::symbol();
    arithmetic::methods(10, 6);
    //arithmetic::overflow();
    arithmetic::ignore_overflow();
    arithmetic::check_option_overflow();
    arithmetic::check_boolean_overflow();
    arithmetic::return_max_overflow();
}
