package page.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.amazon.AmazonHomeLocator;
import locator.ebay.EbayHomeLocator;
import page.CommonPage;

public class EbayHomePage extends CommonPage {

	public EbayHomePage(WebDriver webDriver) {
		super(webDriver);
		
	}

	public void enterSearching(String keyword) {
		WebElement elm = findElementBy(EbayHomeLocator.idInputSearchBar, "id");
		enterText(elm, keyword + "\n");
	}
	
}
