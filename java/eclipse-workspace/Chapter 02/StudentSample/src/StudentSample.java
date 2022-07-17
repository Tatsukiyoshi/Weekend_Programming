public class StudentSample {
	public static void main(String... args) {
		// murataインスタンスを作り、名前を設定する
		Student murata = new Student("村田");
		
		// 点数を設定する
		murata.score = 80;
		murata.printScore();
		
		// okadaインスタンスを作り、名前と点数を設定する
		Student okada = new Student("岡田", 90);
		okada.printScore();
	}
}
