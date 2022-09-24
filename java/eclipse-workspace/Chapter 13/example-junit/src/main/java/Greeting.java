/**
 * メッセージを出力するクラス
 */
public class Greeting {
	/**
	 * コンストラクタ
	 */
	public Greeting() {}
	
	/**
	 * 時間帯（朝／昼／晩）に応じたメッセージを出力する
	 * @param hour 時間
	 * @return メッセージ
	 */
	public String getMessage(int hour) {
		/** メッセージ */
		String message;
		
		if(hour >= 5 && hour < 11) {
			message = "おはようございます";
		} else if(hour >= 11 && hour < 17) {
			message = "こんにちは";
		} else {
			message = "こんばんは";
		}
		
		return message;
	}
}
