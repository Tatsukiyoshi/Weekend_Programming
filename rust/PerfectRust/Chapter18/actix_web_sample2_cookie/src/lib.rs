pub mod handlers;
pub mod helpers;

use crate::handlers::error::WebAppError;
pub type Result<T> = anyhow::Result<T , WebAppError>;
