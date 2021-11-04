package page;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import object.Product;


public class CommonPage {

	public WebDriver webDriver;
	Actions action;

	public CommonPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		action = new Actions(webDriver);
	}

	/*******************************************/
	/******************* WAIT ******************/
	/*******************************************/

	public void sleepTime(int millisSeconds) {
		try {
			Thread.sleep(millisSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fluentWait(WebElement elm) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elm));
		if (!element.isDisplayed()) {
			System.err.println("Timeout to wait element display");
		}
	}

	public void fluentWait(WebElement elm, int waitTime, int pollTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(waitTime))
				.pollingEvery(Duration.ofSeconds(pollTime)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elm));
		if (!element.isDisplayed()) {
			System.err.println("Timeout to wait element display");
		}
	}

	public void fluentWaitInvisibility(WebElement elm, int waitTime) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitTime));
		Boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(elm));
		if (!isInvisible) {
			System.err.println("Timeout to wait element hidden");
		}
	}

	public void fluentWaitClickable(WebElement elm, int waitTime, int pollTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver).withTimeout(Duration.ofSeconds(waitTime))
				.pollingEvery(Duration.ofSeconds(pollTime)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elm));
		if (!element.isDisplayed()) {
			System.err.println("Timeout to wait element can be  clickable");
		}
	}

	/********************************************/
	/****************** ACTION ******************/
	/********************************************/

	private WebElement findById(String id) {
		WebElement elm = webDriver.findElement(By.id(id));
		return elm;
	}
	
	private WebElement findByClassName(String className) {
		WebElement elm = webDriver.findElement(By.className(className));
		return elm;
	}
	
	private WebElement findByCssSelector(String cssSelector) {
		WebElement elm = webDriver.findElement(By.cssSelector(cssSelector));
		return elm;
	}
	
	private WebElement findByLinkText(String linkText) {
		WebElement elm = webDriver.findElement(By.linkText(linkText));
		return elm;
	}
	
	private WebElement findByName(String name) {
		WebElement elm = webDriver.findElement(By.name(name));
		return elm;
	}
	
	private WebElement findByPartialLinkText(String partialLinkText) {
		WebElement elm = webDriver.findElement(By.partialLinkText(partialLinkText));
		return elm;
	}
	
	private WebElement findByTagName(String tagName) {
		WebElement elm = webDriver.findElement(By.tagName(tagName));
		return elm;
	}
	
	private WebElement findByXpath(String xpath) {
		WebElement elm = webDriver.findElement(By.xpath(xpath));
		return elm;
	}

	public WebElement findElementBy(String locator, String locatorType) {
		WebElement elm = null;
		try {
			switch (locatorType) {
				case "xpath":
					elm = findByXpath(locator);
					break;
				case "id":
					elm = findById(locator);
					break;
				case "className":
					elm = findByClassName(locator);
					break;
				case "cssSelector":
					elm = findByCssSelector(locator);
					break;
				case "linkText":
					elm = findByLinkText(locator);
					break;
				case "name":
					elm = findByName(locator);
					break;
				case "partialLinkText":
					elm = findByPartialLinkText(locator);
					break;
				case "tagName":
					elm = findByTagName(locator);
					break;
			}
		} catch (NoSuchElementException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
		return elm;
	}
	
	public List<WebElement> findListWebElementByXpath(String xpath) {
		List<WebElement> elmList = webDriver.findElements(By.xpath(xpath));
		return elmList;
	}
	
	public void scrollPosition(int y1, int y2) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("scroll(" + y1 + ", " + y2 + ")");
	}

	public void scrollElementJS(WebElement elm) {
		fluentWait(elm);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elm);
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickByJs(WebElement element) {
		scrollElementJS(element);
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);
		sleepTime(2 * 1000);
	}

	public void clickByJs(WebElement element, int millisSeconds) {
		scrollElementJS(element);
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", element);
		sleepTime(millisSeconds);
	}

	public void click(WebElement elm) {
		scrollIntoView(elm);
		elm.click();
		sleepTime(1000);
	}
	
	public void click(WebElement elm, int millisSeconds) {
		scrollIntoView(elm);
		elm.click();
		sleepTime(millisSeconds);
	}

	public void enterText(WebElement elm, String text) {
		scrollElementJS(elm);
		elm.clear();
		elm.sendKeys(text);
		sleepTime(1000);
	}

	public void enterText(WebElement elm, String text, int millisSeconds) {
		scrollElementJS(elm);
		elm.clear();
		elm.sendKeys(text);
		sleepTime(millisSeconds);
	}

	public String getText(WebElement elm) {
		if (elm == null) {
			return null;
		}
		scrollElementJS(elm);
		String text = elm.getText();
		return text;
	}

	public String getTextJs(WebElement element){
	    return (String) ((JavascriptExecutor) webDriver).executeScript(
	        "return jQuery(arguments[0]).text();", element);
	}
	
	public void hoverToElement(WebElement element) {
		action.moveToElement(element).build().perform();
		sleepTime(2 * 1000);
	}

	public void refreshPage() {
		webDriver.navigate().refresh();
		sleepTime(10 * 1000);
	}

	public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getCssValue(WebElement elm, String css) {
		String color = elm.getCssValue(css);
		return color;
	}

	public int getXLocationElement(WebElement elm) {
		Point location = elm.getLocation();
		int x = location.getX();
		return x;
	}

	public int getYLocationElement(WebElement elm) {
		Point location = elm.getLocation();
		int y = location.getY();
		return y;
	}

	public List<String> getListTextFromListElement(List<WebElement> listWebElement) {
		List<String> listText = new ArrayList<String>();
		try {
			for (WebElement webElement : listWebElement) {
				scrollElementJS(webElement);
				listText.add(webElement.getText());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (StaleElementReferenceException e) {
			refreshPage();
			sleepTime(5 * 1000);
			for (WebElement webElement : listWebElement) {
				listText.add(webElement.getText());
			}
		}
		return listText;
	}

	public void dragAndDrop(WebElement elm01, WebElement elm02, int milliseconds) {
		Actions builder = new Actions(webDriver);
		Action dragAndDrop = builder.clickAndHold(elm01).moveToElement(elm02).release(elm02).build();
		dragAndDrop.perform();
		sleepTime(milliseconds);
	}

	public void clickOnCheckBox(WebElement elm, boolean isChecked) {
		boolean checked = elm.isSelected();
		if (isChecked) {
			if (!checked) {
				elm.click();
			}
		} else {
			if (checked) {
				elm.click();
			}
		}
		sleepTime(1000);
	}

	public void clickOnRadioButton(WebElement elm) {
		boolean checked = elm.isSelected();
		if (!checked) {
			clickByJs(elm, 2 * 1000);
		}
	}

	public String convertListToString(List<String> lists) {
		StringBuilder listString = new StringBuilder();
		for (String s : lists) {
			listString.append(s).append("\t");
		}
		return listString.toString();
	}

	public void openUrl(String url) {
		webDriver.get(url);
	}

	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	public void closeBrowser() {
		webDriver.close();
	}

	public void genFileHtml(List<Product> amazonList, List<Product> ebayList) {
//		int i = 0;
		String bootstrap = "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>";
		String startStatement = "<html><head>" + bootstrap + "</head><body><h1>Data Statistics</h1><table class=\"table table-striped\"><thead><tr><th>Website</th>"
				+ "<th>Product Name</th><th style=\"text-align:right\">Price</th><th style=\"text-align:right\">Currency</th></tr><tbody>";
		String bodyStatement = "";
		String endStatement = "</tbody></thead></table></body></html>";
		
		List<Product> commonList = new ArrayList<Product>();
		commonList.addAll(amazonList);
		commonList.addAll(ebayList);
		
		Collections.sort(commonList);
		
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);

		String folder = System.getProperty("user.dir") + "/DataStatistics";
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(folder + "/report.html", false));
			writer.write(startStatement);
			String trStart = "";
			for (Product p : commonList) {
//				if (i == 0)
//					trStart = "<tr class=\"success\">";
//				if (i == 1)
//					trStart = "<tr class=\"danger\">";
//				if (i == 2)
//					trStart = "<tr class=\"info\">";
//				if (i == 3)
//					trStart = "<tr class=\"warning\">";
//				if (i == 4) 
//					trStart = "<tr class=\"active\">";
				
				String td01 = "<td>" + p.getWebSite() + "</td>";
				String td02 = "<td><a href=\"" + p.getLinkUrl() + "\">" + p.getProductName() + "</a></td>";
				String td03 = "<td align='right' style='color:red; font-weight:bold;'>" +  decimalFormat.format(Long.valueOf(p.getPrice())) + "</td>";
				String td04 = "<td align='right'>" + p.getCurrency() + "</td>";
				String trEnd = "</tr>";
				bodyStatement = trStart + td01 + td02 + td03 + td04 + trEnd;
				writer.write(bodyStatement);
//				i++;
//				if (i == 4)
//					i = 0;
			}
			
			writer.write(endStatement);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		
		
	}
	
	
	/*******************************************/
	/****************** CHECK ******************/
	/*******************************************/

	public boolean isDisplayed(WebElement elm) {
		boolean result = elm.isDisplayed();
		return result;
	}

	public boolean isCorrectFormat(WebElement elm, String format) {
		scrollElementJS(elm);
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(getAttributeValue(elm, "value"));
		boolean result = matcher.matches();
		return result;
	}

	public boolean checkRadioIsSelected(WebElement ele) {
		return ele.isSelected();
	}

	public boolean checkListValueIsCorrect(List<WebElement> listElements, String... values) {
		int count = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < listElements.size(); j++) {
				if (values[i].equals(listElements.get(j).getText())) {
					count++;
				}
			}
		}
		if (count == values.length) {
			return true;
		}
		return false;
	}

}
