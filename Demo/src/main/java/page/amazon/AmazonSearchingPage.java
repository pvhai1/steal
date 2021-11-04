package page.amazon;

import static org.testng.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.api.internal.StringUtils;
import locator.amazon.AmazonSearchingLocator;
import object.Product;
import page.CommonPage;

public class AmazonSearchingPage extends CommonPage {

	public AmazonSearchingPage(WebDriver webDriver) {
		super(webDriver);
	}

	public List<Product> getListProductAfterSearching(String keyWord) {
		List<WebElement> listElement =  findListWebElementByXpath(String.format(AmazonSearchingLocator.xpathSpanProductName, keyWord));
		List<Product> productList = new ArrayList<>();
		for (WebElement elm : listElement) {
			scrollElementJS(elm);
			Product p = new Product();
			String productName = getText(elm);
			String website = "Amazon";
			WebElement elmPrice = findElementBy(String.format(AmazonSearchingLocator.xpathSpanPrice, productName), "xpath");
			if (elmPrice != null) {
				WebElement elmCurrency = findElementBy(String.format(AmazonSearchingLocator.xpathSpanCurrency, productName), "xpath");
				WebElement elmUrl = findElementBy(String.format(AmazonSearchingLocator.xpathLinkProduct, productName), "xpath");
				String price = getText(elmPrice);
				String currency = getText(elmCurrency);
				String linkUrl = getAttributeValue(elmUrl, "href");
				p.setWebSite(website);
				p.setProductName(productName);
				p.setPrice(price.replace(",", ""));
				p.setCurrency(currency);
				p.setLinkUrl(linkUrl);
				productList.add(p);
			}
		}
		return productList;
	}
	
}
