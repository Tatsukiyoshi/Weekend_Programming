use core::ffi::CStr;

fn main() {
    const HOGE: &CStr = c"hoge";

    println!("Hello, world!");
    println!("{:?}", HOGE);
}
