use crate::service::domain::converter::Converter;
use crate::service::domain::user::User;
use crate::service::models::user::Model;
use crate::service::error::Result;

/// ## 18-5 アプリケーションの構成
/// リスト18.27 UserとModelの相互変換
pub struct UserConverterSeaOrm;
impl Converter<User, Model> for UserConverterSeaOrm {
    fn from_entity(entity: &User) -> Result<Model> {
        let id = 0;
        let user_id = entity.user_id.clone().try_into().unwrap();
        let user_name = entity.user_name.clone().try_into().unwrap();
        let password = entity.password.clone().try_into().unwrap();
        let mail = entity.mail.clone().try_into().unwrap();
        let model = Model{id, user_id, user_name, password, mail};
        Ok(model)
    }

    fn from_model(model: &Model) -> Result<User> {
        let user =
            User::build(model.user_id.to_owned(), model.user_name.to_owned(),
                model.password.to_owned(), model.mail.to_owned());
        Ok(user)
    }
}
