use std::sync::Arc;
use sea_orm::DatabaseConnection;
use crate::service::application::user_service::UserService;
use crate::service::application::user_service_impl::UserServiceImpl;

/// ## 18-5 アプリケーションの構成
/// ### リスト18.31 ServiceProvider
pub trait Provider : Send + Sync {}
#[derive(Clone)]
pub struct ServiceProvider {
    // ユーザ認証サービス
    pub authenticate_service: Arc<dyn UserService<Database=DatabaseConnection>>
}
impl ServiceProvider {
    pub fn new() -> Arc<Self> {
        Arc::new(Self {
            authenticate_service: UserServiceImpl::new()
        })
    }
}
impl Provider for ServiceProvider {}
