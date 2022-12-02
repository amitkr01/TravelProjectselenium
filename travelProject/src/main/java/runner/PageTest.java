package runner;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObject.SearchPage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import resource.BaseTest;

public class PageTest extends BaseTest {
	private static Logger log = LogManager.getLogger(PageTest.class);
	@Test
	public void launchPage() throws InterruptedException {
		ExtentTest test = extent.createTest("Test the spicejet page", "check the ticket book proccess");
		test.info("driver initialized");
		log.info("launch driver");
		driver.get("https://www.spicejet.com/");
		
	//	driver.get(prop.getProperty("url"));
		
		 
		
		SearchPage page = new SearchPage(driver);
		test.info("check ticktek booking");
		test.pass("select origin place");
		log.info("select origin place");
		page.setOriginBox("del");
		test.pass("Select destination place");
		log.info("select destination");
		page.setdestination("pat");
		page.selpatna();
		test.pass("select date");
		page.setDate();
		test.pass("Search for available flight");
		log.info("search for available flight");
		page.searchflightbtn();
		test.pass("continue for detail");
		page.selcontinue();
		
//		Set<String> windowhandles= driver.getWindowHandles();
//		 Iterator<String> iterator = windowhandles.iterator();
//		 String parentWindow = iterator.next();
//		 String childWindow = iterator.next();
//		
//		driver.switchTo().window(childWindow);
	
		
		page.skiad();
		
		page.firsrName("Amit");
		page.lastName("Kumar");
		page.conNum("9128895000");
		page.emailid("a2kumar@gmail.com");
		page.city("patna");
		
		page.pfName("Amit");
		page.plName("Kumar");
		page.submit();
		
		
		
	
		
		
	}
	
}
