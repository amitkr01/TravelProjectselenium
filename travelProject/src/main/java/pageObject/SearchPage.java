package pageObject;

import java.util.Set;

import org.openqa.selenium.By;
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
	
	By conti = By.xpath("//*[@id=\"replacedbutton\"]");
	By skipad = By.xpath("//*[@id='continue']");
	
	
	
	
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
		driver.findElement(conti).click();
	}
	
	public void skiad() {
		WebElement element = driver.findElement(skipad);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(element).click().perform();
		
		
		
		//driver.findElement(skipad).click();
		
			
		
	}
	
}
