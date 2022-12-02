package pageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {
	
	static WebDriver driver = null;
	
	By origin = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input");
	By destination = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input");
	By selpatna = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]");
	By date = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]");
	By flightsearch = By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div");
	By noflight = By.xpath("//*[contains(text(),'Unfortunately, there are no flights available.')]");
	By conti = By.xpath("//*[@id=\"replacedbutton\"]");
	By skipad = By.xpath("//*[@id='continue2']");
	
	By fName = By.xpath("//*[@data-testid='first-inputbox-contact-details']");
	By lName = By.xpath("//*[@data-testid='last-inputbox-contact-details']");
	By cNum = By.xpath("//*[@data-testid='contact-number-input-box']");
	By email = By.xpath("//*[@data-testid='emailAddress-inputbox-contact-details']");
	By city = By.xpath("//*[@data-testid='city-inputbox-contact-details']");
	
	By pfname = By.xpath("//*[@data-testid='traveller-0-first-traveller-info-input-box']");
	By plname = By.xpath("//*[@data-testid='traveller-0-last-traveller-info-input-box']");
	
	By fcont= By.xpath("//*[@data-testid='traveller-info-continue-cta']");
	
	
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setOriginBox(String txt) {
		driver.findElement(origin).sendKeys(txt);
	}
	public void setdestination(String txt) {
		driver.findElement(destination).sendKeys(txt);
	}
	public void selpatna() {
		driver.findElement(selpatna).click();
	}
	
	public void setDate() {
		driver.findElement(date).click();
		
	}
	public void searchflightbtn() {
		driver.findElement(flightsearch).click();
	}
	
	public void selcontinue() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement noFlight = driver.findElement(noflight);
	
		//Unfortunately, there are no flights available.
		//Modify Search
		
//		if() {
//			
//		}
//		else {
//			driver.findElement(conti).click();
//		}
		driver.findElement(conti).click();
	}
	
	public void skiad()   {
		driver.findElement(skipad).click();
			
	}
	
	public void firsrName(String fnam) {
		driver.findElement(fName).sendKeys(fnam);
	}
	
	public void lastName(String lnam) {
		driver.findElement(lName).sendKeys(lnam);
	}
	public void conNum(String num) {
		driver.findElement(cNum).sendKeys(num);
	}
	
	public void emailid(String ema) {
		driver.findElement(email).sendKeys(ema);
	}
	public void city(String cit) {
		driver.findElement(city).sendKeys(cit);
	}
	
	public void pfName(String pfnam) {
		driver.findElement(pfname).sendKeys(pfnam);
	}
	public void plName(String plnam) {
		driver.findElement(plname).sendKeys(plnam);
	}
	public void submit() {
		driver.findElement(fcont).click();
	}
	
	
	
}
