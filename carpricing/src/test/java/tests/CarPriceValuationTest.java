package tests;
import org.junit.Test;
import org.junit.BeforeClass;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.CarValuationPage;
import utils.BrowserUtils;
import utils.FileUtils;

public class CarPriceValuationTest {

FileUtils file = new FileUtils();
private static BrowserUtils browser = new BrowserUtils();
private static CarValuationPage carValuationPage;
	
private static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() {
		driver = browser.initBrowser("firefox");
		carValuationPage = new CarValuationPage(driver);
	}
	
	@Test
	public void verifyCarEvaluationDetails() throws InterruptedException {
		//Attempting to launch CarEvaluation WebSite
		carValuationPage.launchApplication();
		carValuationPage.acceptAllCookies();
		//Attempting to extract car numbers from a text file
		String fileContent = file.readTextFile("car_input");
		List<String> carRegistrations = file.extractPatternMatcher(fileContent);
        System.out.println("Extracted car registrations:");
        carRegistrations.forEach(System.out::println);
    	String outputFileContent = file.readTextFile("car_output");
        for(int i =0; i<carRegistrations.size(); i++) {
        	//Attempting to iterate through each car number and assert the valuation details
        	carValuationPage.submitCarValuationDetails(carRegistrations.get(i), "2000");
        	String actCarValuation = carValuationPage.getCarValuationDetails();
        	Assert.assertTrue(outputFileContent.contains(actCarValuation));
        } 
	}
	
	@AfterClass
	 public static void closeBrowser(){
		 driver.quit();
	 }
	

}
