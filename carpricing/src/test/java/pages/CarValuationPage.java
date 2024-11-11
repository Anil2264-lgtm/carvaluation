package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementActions;

public class CarValuationPage {
	
	private WebDriver driver;
	private ElementActions eAct;
	
	public CarValuationPage(WebDriver driverObj){
		driver = driverObj;
		eAct = new ElementActions(driverObj);
	}
	
	private By acceptCookies = By.id("onetrust-accept-btn-handler");
	private By vehicleRegInput = By.id("vehicleReg");
	private By vehicleMileageInput = By.id("Mileage");
	private By submitButton = By.id("btn-go");
	private By carDetailsNumber = By.xpath("(//*[@id='vehicleImage'])[2]/..//*[contains(@class,'details-vrm')]");
	private By carDetailsManufacturer = By.xpath("(//*[@id='vehicleImage'])[2]/..//*[(text()='Manufacturer:')]/following-sibling::div");
	private By carDetailsModel = By.xpath("(//*[@id='vehicleImage'])[2]/..//*[(text()='Model:')]/following-sibling::div");
	private By carDetailsYear = By.xpath("(//*[@id='vehicleImage'])[2]/..//*[(text()='Year:')]/following-sibling::div");
	
	public void launchApplication() {
		eAct.openURL("https://www.webuyanycar.com/");
	}
	
	public void acceptAllCookies() {
		eAct.performClick(acceptCookies);
	}
	
	public void enterVehicleNumber(String vehicleNum) {
		eAct.enterText(vehicleRegInput, vehicleNum);
	}
	
	public void enterVehicleMileage(String mileage) {
		eAct.enterText(vehicleMileageInput, mileage);
	}
	
	public void clickGetCarValuation() {
		eAct.performClick(submitButton);
	}
	
	public void submitCarValuationDetails(String vehicleNum, String mileage) throws InterruptedException {
		eAct.waitForPageLoad();
		eAct.waitForClickable(submitButton);
		Thread.sleep(Duration.ofSeconds(3));
		enterVehicleNumber(vehicleNum);
		enterVehicleMileage(mileage);
		clickGetCarValuation();
		Thread.sleep(Duration.ofSeconds(3));
	}
	
	public String getCarNumber() {
		return eAct.getText(carDetailsNumber);
	}
	
	public String getCarManufacturer() {
		return eAct.getText(carDetailsManufacturer);
	}
	
	public String getCarModel() {
		return eAct.getText(carDetailsModel);
	}
	
	public String getCarManufacturedYear() {
		return eAct.getText(carDetailsYear);
	}
	
	public String getCarValuationDetails() {
		String actCarDetails = getCarNumber()+","+getCarManufacturer()+","+getCarModel()+","+getCarManufacturedYear();
		return actCarDetails;
	}

}
