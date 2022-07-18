
/**
 * 通常割引を実行するクラス
 * @author taish
 *
 */
public class DiscountCommand extends Command {
	
	@Override
	public void execute() {
		double amount = book.getAmount();
		book.setAmount(amount * 0.9);
	}
}
