package locator.ebay;

public class EbaySearchingLocator {
	
	public static String xpathSpanProductName = "//div[@id='srp-river-main']//h3[@class='s-item__title'][contains(text(), '%s')]";
	
	public static String xpathLinkProduct = "//div[@id='srp-river-main']//h3[@class='s-item__title'][contains(text(), '%s')]/../../a";
	
	public static String xpathPriceAndCurrency = "//div[@id='srp-river-main']//h3[@class='s-item__title'][contains(text(), '%s')]/../..//span[@class='s-item__price']";
	
	
}
