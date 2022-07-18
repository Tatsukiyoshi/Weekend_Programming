/** 
 * 特別割引を実行するクラス
 * @author taish
 *
 */
public class SpecialDiscountCommand extends Command {

	@Override
	public void execute() {
		double amount = book.getAmount();
		book.setAmount(amount * 0.7);
	}
}
