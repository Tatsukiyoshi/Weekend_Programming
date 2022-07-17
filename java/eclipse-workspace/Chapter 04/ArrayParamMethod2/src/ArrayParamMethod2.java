
public class ArrayParamMethod2 {
	// 可変長引数によるメソッド
	static void log(String message, String... args) {
		System.out.println(message);
		System.out.println("パラメータ：");
		for(String arg : args) {
			System.out.println(arg);
		}
	}
	
	// 呼び出し側で配列をnewする必要なし
	public static void main(String[] args) {
		log("ユーザを登録しました", "userName", "Ken");
		log("エラーが発生しました", "Cannot load file");
		log("処理を終了しました");
	}
}
