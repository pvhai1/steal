package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Key;
import page.CommonPage;
import page.amazon.AmazonHomePage;
import page.amazon.AmazonSearchingPage;
import page.amazon.AmazonSettingPage;
import page.ebay.EbayHomePage;
import page.ebay.EbaySearchingPage;

public class TestInit {

	public WebDriver webDriver;
	protected CommonPage common;
	protected AmazonHomePage amazonHomePage;
	protected AmazonSearchingPage amazonSearchingPage;
	protected AmazonSettingPage amazonSettingPage;
	protected EbayHomePage ebayHomePage;
	protected EbaySearchingPage ebaySearchingPage;

	@BeforeSuite
	public void beforeSuite() {
		
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeClass
	public void beforeClass() {
		webDriver = WebDriverUtil.getWebDriver();
		common = new CommonPage(webDriver);
		amazonHomePage = new AmazonHomePage(webDriver);
		amazonSearchingPage = new AmazonSearchingPage(webDriver);
		amazonSettingPage = new AmazonSettingPage(webDriver);

		ebayHomePage = new EbayHomePage(webDriver);
		ebaySearchingPage = new EbaySearchingPage(webDriver);
		
		common.openUrl(Key.URL_AMAZON);
	}

	@BeforeMethod
	public void beforeMethod() {
		
	}

	@Test
	public void testRunner() {

	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		common.closeBrowser();
	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuite() {

	}

}
