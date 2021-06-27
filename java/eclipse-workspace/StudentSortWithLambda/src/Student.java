

/**
 * 生徒の点数を扱うクラス
 */
public class Student {
	/** 名前 */
	private String name;
	
	/** 点数 */
	private int score;
	
	/** 名前と点数を指定してインスタンスを生成します
	 * @param name　名前
	 * @param score 点数
	 */
	Student(String name, int score){
		this.name = name;
		this.score = score;
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
	
	@Override
	public String toString()
	{
		return name + ":" + score;
	}
}
