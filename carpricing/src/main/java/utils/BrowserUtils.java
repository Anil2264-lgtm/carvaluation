package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
	private static WebDriver driver;
	
	public WebDriver initBrowser(String browserName) {
		switch(browserName) {
		case "firefox":
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		//To add more browsers on demand
	return driver;	
	}
	
}
