package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common.Key;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {
	public static WebDriver getWebDriver() {
		WebDriver webDriver = null;
		String timeout = Key.TIME_OUT;
		String browser = Key.BROWSER;
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			webDriver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
		webDriver.manage().deleteAllCookies();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeout)));
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(timeout)));
		return webDriver;
	}
}
