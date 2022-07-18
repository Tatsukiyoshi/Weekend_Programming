
public class SampleMain {

	public static void main(String[] args) {
		// 500円のコミック
		Book comic = new Book(500);
		
		// 2500円の技術書
		Book technicalBook = new Book(2500);
		
		// 割引価格計算用コマンド
		Command discountCommand = new DiscountCommand();
		
		// 特別割引価格計算用コマンド
		Command specialDiscountCommand = new SpecialDiscountCommand();
		
		// コミックに割引を適用
		discountCommand.setBook(comic);
		discountCommand.execute();
		System.out.println("割引後金額は、" + comic.getAmount() + "円");
		
		// 技術書に割引を適用
		discountCommand.setBook(technicalBook);
		discountCommand.execute();
		System.out.println("割引後金額は、" + technicalBook.getAmount() + "円");

		// 技術書にさらなる特別割引を適用
		specialDiscountCommand.setBook(technicalBook);
		specialDiscountCommand.execute();
		System.out.println("割引後金額は、" + technicalBook.getAmount() + "円");
	}
}
