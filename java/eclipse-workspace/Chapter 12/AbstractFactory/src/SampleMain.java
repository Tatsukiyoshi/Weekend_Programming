
public class SampleMain {

	public static void main(String[] args) {
		String env = "PostgreSQL";
		
		Factory factory = createFactory(env);
		Connection connection = factory.getConnection();
		Configuration configuration = factory.getConfiguration();
	}

	private static Factory createFactory(String env) {
		switch(env) {
		case "PostgreSQL":
			return new PostgreSQLFactory();
		case "MySQL":
			return new MySQLFactory();
		default:
			throw new IllegalArgumentException(env);
		}
	}
}
