package runner;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MulBrowser {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chorme.driver", projectPath+"\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath+"\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
	}
	@Test
	public void test1() {
		driver.get("https://google.com");
		
	}
	
	@AfterTest
	public void closesetup() {
		driver.close();
	}

}
