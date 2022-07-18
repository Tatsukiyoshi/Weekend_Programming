
/**
 * 本の割引を実行するクラス
 * @author taish
 *
 */
public abstract class Command {
	/** 対象となる本 */
	protected Book book;
	
	/** 対象を設定する */
	public void setBook(Book book) {
		this.book = book;
	}
	
	/** 割引を実行する */
	public abstract void execute();
}
