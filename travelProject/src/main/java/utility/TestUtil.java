package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import resource.BaseTest;

public class TestUtil extends BaseTest {
	
	public void getscreenshot() throws IOException {
		
		Date currentDate = new Date();
		String screenshotfilename = currentDate.toString().replace(" ", "-").replace(":", "-");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//"+screenshotfilename+".png"));
		
	}

}
