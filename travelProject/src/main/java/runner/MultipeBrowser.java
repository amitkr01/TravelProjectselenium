package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultipeBrowser {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user-dir");
		System.out.println(projectPath);

		//System.setProperty("webdriver.gecko.driver", projectPath+"\\driver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.ie.driver", projectPath+"\\driver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://google.com");
		
		driver.close();
	}

}
