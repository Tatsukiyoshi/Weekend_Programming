
/**
 * 本クラス
 * @author taish
 *
 */
public class Book {
	/** 価格 */
	private double amount;
	
	public Book(double amount) {
		this.amount = amount;
	}
	
	/** 価格を参照する */
	public double getAmount() {
		return this.amount;
	}
	
	/** 価格を変更する */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
