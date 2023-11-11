use crate::messaging_crossbeam::execute;

mod messaging_crossbeam;
mod stations;
mod station;

fn main() {
    println!("execute()");
    execute();
}
