package page.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.amazon.AmazonHomeLocator;
import page.CommonPage;

public class AmazonHomePage extends CommonPage {

	public AmazonHomePage(WebDriver webDriver) {
		super(webDriver);
		
	}

	public void enterSearching(String keyword) {
		WebElement elm = findElementBy(AmazonHomeLocator.idInputSearchBar, "id");
		enterText(elm, keyword + "\n");
	}
	
	public void hoverToFlagCountry() {
		WebElement flagCountry =  findElementBy(AmazonHomeLocator.idLinkFlagCountry, "id");
		hoverToElement(flagCountry);
	}
	
	public void clickFlagCountry() {
		WebElement flagCountry =  findElementBy(AmazonHomeLocator.idLinkFlagCountry, "id");
		click(flagCountry);
	}
	
	public void clickChangeButtonCurrencyUnit() {
		WebElement buttonChangeCurrency = findElementBy(AmazonHomeLocator.xpathLinkChangeCurrency, "xpath");
		click(buttonChangeCurrency);
	}
	
	public void changeCurrencyUnit() {
		hoverToFlagCountry();
		clickChangeButtonCurrencyUnit();
	}
	
	
	
}
