package page.ebay;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locator.amazon.AmazonSearchingLocator;
import locator.ebay.EbaySearchingLocator;
import object.Product;
import page.CommonPage;

public class EbaySearchingPage extends CommonPage {

	public EbaySearchingPage(WebDriver webDriver) {
		super(webDriver);
	}

	public List<Product> getListProductAfterSearching(String keyWord) {
		List<WebElement> listElement =  findListWebElementByXpath(String.format(EbaySearchingLocator.xpathSpanProductName, keyWord));
		List<Product> productList = new ArrayList<>();
		for (WebElement elm : listElement) {
			scrollElementJS(elm);
			Product p = new Product();
			String productName = getTextJs(elm).replace("New Listing", "").replace("NEW LISTING", "");
			String website = "Ebay";
			WebElement elmPriceAndCurrency = findElementBy(String.format(EbaySearchingLocator.xpathPriceAndCurrency, productName), "xpath");;
			WebElement elmUrl = findElementBy(String.format(EbaySearchingLocator.xpathLinkProduct, productName), "xpath");
				
			if (elmUrl == null) {
				System.out.println("elmUrl : " + productName);
				continue;
			}
			if (elmPriceAndCurrency == null) {
				System.out.println("elmPriceAndCurrency : " + productName);
				continue;
			}
			
			String priceAndCurrency = elmPriceAndCurrency.getText();
			String price = (priceAndCurrency.split(" ")[0]).replace(",", "");
			if (price.contains(".")) {
				price = price.split("\\.")[0];
			}
			String currency = priceAndCurrency.split(" ")[1];
			String linkUrl = getAttributeValue(elmUrl, "href");
				
			p.setWebSite(website);
			p.setProductName(productName);
			try {
				p.setPrice(price);
			} catch (NumberFormatException e) {
				System.out.println();
			}
			p.setCurrency(currency);
			p.setLinkUrl(linkUrl);
			productList.add(p);
			
		}
		return productList;
	}
	
}
