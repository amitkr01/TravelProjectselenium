package runner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObject.SearchPage;

public class SearchPageTest {
	static WebDriver driver = null;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extentreport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@Test
	public void driverinit() throws IOException {
		ExtentTest test = extent.createTest("Test the spicejet page", "check the ticket book proccess");
		test.info("driver initialized");

		String projectPath = System.getProperty("user.dir");
		
		System.out.println(projectPath);

		System.setProperty("webdriver.chorme.driver", projectPath +"\\driver\\chromedriver.exe");


		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.get("https://www.spicejet.com/");

		SearchPage page = new SearchPage(driver);
		test.info("check ticktek booking");
		page.setOriginBox("del");
		page.setdestination("pat");
		page.selpatna();
		page.setDate();
		page.searchflightbtn();
		page.selcontinue();
		page.skiad();
		page.selcontinue();
		
		Date currentDate = new Date();
		String screenshotfilename = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+screenshotfilename+".png"));
				
				



	}

	@AfterTest
	public void teardowntest() {
		driver.close();
		driver.quit();


	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
