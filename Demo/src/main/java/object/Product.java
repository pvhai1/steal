package object;

public class Product implements Comparable<Product> {

	private String webSite;
	private String productName;
	private String price;
	private String currency;
	private String linkUrl;
	
	public Product() {
		
	}

	public Product(String webSite, String productName, String price, String currency, String linkUrl) {
		super();
		this.webSite = webSite;
		this.productName = productName;
		this.price = price;
		this.currency = currency;
		this.linkUrl = linkUrl;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Override
	public int compareTo(Product o) {
		return (Double.valueOf(this.price)).compareTo((Double.valueOf(o.getPrice())));
	}

	
	
	
}
