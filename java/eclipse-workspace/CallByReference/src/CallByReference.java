/**
 * @author taish
 *
 */
public class CallByReference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Entity entity = new Entity();
		entity.value = 1;
		callByReference(entity);
		System.out.println("呼び出し元 = " + entity.value);
	}

	private static void callByReference(Entity entity) {
		entity.value++;
		System.out.println("呼び出し先 = " + entity.value);
	}
}
