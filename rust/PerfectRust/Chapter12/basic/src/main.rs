use crate::basic::{thread_controller_1, thread_controller_2, thread_controller_3};

mod basic;

fn main() {
    println!("thread_controller_1()");
    thread_controller_1();

    println!("thread_controller_2()");
    thread_controller_2();

    println!("thread_controller_3()");
    thread_controller_3();
}
