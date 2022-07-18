
public class DiscountStrategy implements Strategy {

	@Override
	public void discount(Book book) {
		double amount = book.getAmount();
		book.setAmount(amount * 0.9);
	}

}
