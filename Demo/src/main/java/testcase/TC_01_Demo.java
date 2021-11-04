package testcase;

import java.util.List;

import org.testng.annotations.Test;

import common.Key;
import object.Product;
import utils.ConsoleLog;
import utils.TestInit;

public class TC_01_Demo extends TestInit {

	@Test()
	public void testRunner() {
		String currencyUnit = "VND";
		String keyword = "iPhone 11";
		List<Product> amazonProductList;
		List<Product> ebayProductList;
		
		ConsoleLog.processing("Test Runner");
		ConsoleLog.writeTcNameAndFeature("Demo Feature", "TC_01_Demo");
		ConsoleLog.testStepDescription("Step 01", "Change currency unit : " + currencyUnit);
		amazonHomePage.clickFlagCountry();
		amazonSettingPage.selectCurrencyUnit(currencyUnit);
		
		ConsoleLog.testStepDescription("Step 02", "Enter searching on Amazon : " + keyword);
		amazonHomePage.enterSearching(keyword);
		
		ConsoleLog.testStepDescription("Step 03", "Get all products on Amazon after searching");
		amazonProductList = amazonSearchingPage.getListProductAfterSearching(keyword);
		
		ConsoleLog.testStepDescription("Step 04", "Open Ebay : " + Key.URL_EBAY);
		common.openUrl(Key.URL_EBAY);
		
		ConsoleLog.testStepDescription("Step 05", "Enter searching on Ebay : " + keyword);
		ebayHomePage.enterSearching(keyword);
		
		ConsoleLog.testStepDescription("Step 06", "Get all products on Amazon after searching");
		ebayProductList = ebaySearchingPage.getListProductAfterSearching(keyword);
		
		ConsoleLog.testStepDescription("Step 07", "Gen HTML File Data Statistics");
		common.genFileHtml(amazonProductList, ebayProductList);
		
		System.out.println();
	}
}
