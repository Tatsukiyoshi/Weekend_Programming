

/**
 * 生徒の点数を扱うクラス
 */
public class Student {
	/** 名前 */
	String name;
	
	/** 点数 */
	int score;
	
	/** 最高点 */
	static final int MAX_SCORE = 100;
	
	/** 名前と点数を指定してインスタンスを生成します
	 * @param name　名前
	 * @param score 点数
	 */
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	/** 名前を指定してインスタンスを生成します
	 * @param name 名前
	 */
	Student(String name){
		this(name, 0);
	}

	/** 点数を標準出力に表示します
	 */
	void printScore() {
		System.out.println(name + "さんは" + MAX_SCORE + "点満点中、" + score + "点です。");
	}
	
	/** 名前を取得します
	 */
	public String getName() {
		return this.name;
	}
	
	/** 点数を取得します
	 */
	public int getScore() {
		return this.score;
	}
}
