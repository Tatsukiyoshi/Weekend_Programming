
public class ArrayParamMethod1 {

	// 配列を引数に指定するメソッド
	static void log(String message, String[] args) {
		System.out.println(message);
		System.out.println("パラメータ：");
		for(String arg : args) {
			System.out.println(arg);
		}
	}
	
	// 呼び出し側でnewする必要あり
	public static void main(String[] args) {
		log("ユーザを登録しました", new String[] {"userName", "Ken"});
		log("エラーが発生しました", new String[] {"Cannot load file"});
		log("処理を終了しました", new String[0]);
	}
}
