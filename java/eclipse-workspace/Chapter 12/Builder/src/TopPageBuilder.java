
public class TopPageBuilder implements Builder {
	private TopPage page;
	
	public TopPageBuilder() {
		this.page = new TopPage();
	}
	
	@Override
	public void createHeader() {
		this.page.setHeader("Header");
	}
	
	@Override
	public void createContents() {
		this.page.setContents("Contents");
	}
	
	@Override
	public void createFooter() {
		this.page.setFooter("Footer");
	}
	
	@Override
	public Page getResult() {
		return this.page;
	}
}
