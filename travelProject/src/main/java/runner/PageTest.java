package runner;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObject.SearchPage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import resource.BaseTest;

public class PageTest extends BaseTest {
	
	@Test
	public void launchPage() {
		ExtentTest test = extent.createTest("Test the spicejet page", "check the ticket book proccess");
		test.info("driver initialized");
		
		//driver.get("https://www.spicejet.com/");
		
		driver.get(prop.getProperty("url"));
		
		 
		
		SearchPage page = new SearchPage(driver);
		test.info("check ticktek booking");
		test.pass("select origin place");
		page.setOriginBox("del");
		test.pass("Select destination place");
		page.setdestination("pat");
		page.selpatna();
		test.pass("select date");
		page.setDate();
		test.pass("Search for avlalible flight");
		page.searchflightbtn();
		test.pass("continue for detail");
		page.selcontinue();
		
		Set<String> windowhandles= driver.getWindowHandles();
		 Iterator<String> iterator = windowhandles.iterator();
		 String parentWindow = iterator.next();
		 String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		page.skiad();
		
		
		
	//	page.selcontinue();
		
		
	}
	
}
