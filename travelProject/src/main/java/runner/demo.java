package runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;

public class demo {
	
	
	public static void main(String[] args) {
	 WebDriver driver = null;
	
	 
	
	//	WebDriverManager.chomedriver().setup();
       // WebDriver driver = new ChromeDriver();
	
	String projectPath = System.getProperty("user.dir");
	
	System.setProperty("webdriver.gecko.driver", projectPath+"\\driver\\geckodriver.exe");
	FirefoxOptions options = new FirefoxOptions();
	options.setProfile(new FirefoxProfile());
	options.addPreference("dom.webnotifications.enabled", false);
	
	driver = new FirefoxDriver(options);
	
//	System.setProperty("webdriver.chorme.driver", projectPath +"\\driver\\chromedriver.exe");
//	ChromeOptions option = new ChromeOptions();
//	option.addArguments("--disable-notifications");
//	option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//	
//	driver = new ChromeDriver(option);
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("window.scroll(0,500)", "");
	
	driver.get("https://www.spicejet.com/");
	
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input")).sendKeys("del");
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input")).sendKeys("pat");
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]/div[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div")).click();
	driver.findElement(By.xpath("//*[@id=\"replacedbutton\"]")).click();
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElement(By.xpath("//*[@id='continue2']")).click();
	driver.findElement(By.id("continue2")).click();
	
	
	
	driver.close();
	
	} 
	
	

}
