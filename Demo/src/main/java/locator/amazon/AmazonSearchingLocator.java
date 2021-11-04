package locator.amazon;

public class AmazonSearchingLocator {
	
	public static String xpathSpanProductName = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), '%s')]";
	
	public static String xpathLinkProduct = "//span[contains(text(), '%s')]/../../a";
	
	public static String xpathSpanCurrency = "//span[contains(text(), '%s')]/../../../..//span[@class='a-price-symbol']";
	
	public static String xpathSpanPrice = "//span[contains(text(), '%s')]/../../../..//span[@class='a-price-whole']";
	
}
