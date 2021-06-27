
public class FooService extends AbstractBaseService {
	public FooService(String name) {
		super(name);
	}

	@Override
	public String Say() {
		return "Hello!";
	}
}
