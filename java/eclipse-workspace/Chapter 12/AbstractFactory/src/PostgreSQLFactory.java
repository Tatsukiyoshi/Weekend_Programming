
public class PostgreSQLFactory implements Factory {

	@Override
	public Connection getConnection() {
		return new PostgreSQLConnection();
	}

	@Override
	public Configuration getConfiguration() {
		return new PostgreSQLConfiguration();
	}
}
