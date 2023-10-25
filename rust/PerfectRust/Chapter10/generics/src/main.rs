use crate::try_out::{use_generics_method, use_service_method};

mod traits;
mod traits_impl;
mod entities;
mod try_out;
mod services;
mod sub;

fn main() {
    println!("use_generics_method()");
    use_generics_method();

    println!("use_service_method()");
    use_service_method();
}
