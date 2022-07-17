
public class MySQLFactory implements Factory {

	@Override
	public Connection getConnection() {
		return new MySQLConnection();
	}

	@Override
	public Configuration getConfiguration() {
		return new MySQLConfiguration();
	}
}
