package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	
	public static WebDriver driver = null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public Properties prop;
	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		htmlReporter = new ExtentHtmlReporter("extentreport2.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.chorme.driver", projectPath +"\\driver\\chromedriver.exe");
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "\\src\\main\\java\\resource\\data.properties");
		
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		browserName.equals("chrome");
		
			System.setProperty("webdriver.chrome.driver" ,projectPath +"\\driver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			
			driver = new ChromeDriver(option);
			
		
	

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
	}
	@AfterSuite
	public void closeBrowser() {
		
		driver.close();
		extent.flush();
		
	}

}
