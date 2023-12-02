use anyhow::Error;
use postgres::Client;
use crate::section1::connect::PostgresSampleClient;
use crate::section1::params::ConnectParams;

pub struct PostgreSQLService;
impl PostgreSQLService{
    pub(crate) fn create_client() -> Result<Client, Error> {
        let params = ConnectParams::new(
            "localhost".to_owned(), 5432, "sample_db".to_owned(),
            "postgres".to_owned(), "pgsuper".to_owned());
        PostgresSampleClient::simple_connect(params.clone())
    }
}
