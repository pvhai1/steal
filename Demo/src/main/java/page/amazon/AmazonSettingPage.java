package page.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.amazon.AmazonSettingLocator;
import page.CommonPage;

public class AmazonSettingPage extends CommonPage {

	public AmazonSettingPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void clickSaveSetting() {
		WebElement btnSave = findElementBy(AmazonSettingLocator.idSpanSave, "id");
		click(btnSave, 2 * 1000);
	}
	
	public void selectCurrencyUnit(String unit) {
		WebElement ddlCurrencyUnit = findElementBy(AmazonSettingLocator.xpathSpanCurrencyUnit, "xpath");
		click(ddlCurrencyUnit);
		WebElement optionCurrency = findElementBy(String.format(AmazonSettingLocator.xpathOptionCurrencyUnit, unit), "xpath");
		scrollElementJS(optionCurrency);
		click(optionCurrency);
		clickSaveSetting();
	}
	
	
	
}
