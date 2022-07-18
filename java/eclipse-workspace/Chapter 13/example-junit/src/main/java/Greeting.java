/**
 * 時間帯に応じたメッセージを出力するクラス
 */
public class Greeting {
	/**
	 * メッセージを出力する
	 * @param hour
	 * @return String
	 */
	public String getMessage(int hour) {
		/** メッセージ */
		String message;
		
		if(hour >= 5 && hour < 11) {
			message = "おはようございます";
		} else if(hour > 11 && hour < 17) {
			message = "こんにちは";
		} else {
			message = "こんばんは";
		}
		
		return message;
	}
}
