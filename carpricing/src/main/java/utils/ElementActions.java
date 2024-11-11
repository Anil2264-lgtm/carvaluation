package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public ElementActions(WebDriver driverObj){
		driver = driverObj;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	/**
	 * This method will attempt to return a WebElement
	 * @param loc
	 * @return
	 */
	public WebElement getWebElement(By loc) {
		return driver.findElement(loc);
	}
	
	/**
	 * This method will attempt to perform enter text action
	 * @param loc
	 * @param input
	 */
	public void enterText(By loc, String input) {
		getWebElement(loc).clear();
		getWebElement(loc).sendKeys(input);
	}
	
	/**
	 * This method will attempt to perform a click action
	 * @param loc
	 */
	public void performClick(By loc) {
		waitForClickable(loc);
		getWebElement(loc).click();
	}
	
	/**
	 * This method will attempt to perform a get action
	 * @param loc
	 * @return
	 */
	public String getText(By loc) {
		return getWebElement(loc).getText();
	}
	
	/**
	 * This method will attempt to perform a wait until page loads
	 */
	public void waitForPageLoad() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	/**
	 * This method will attempt to wait for an element to be clickable
	 * @param loc
	 */
	public void waitForClickable(By loc) {
		wait.until(ExpectedConditions.elementToBeClickable(loc));
	}
	
	/**
	 * This method will attempt to open a url on browser
	 * @param url
	 */
	public void openURL(String url) {
		driver.get(url);
	}
	

}
