package FrameworkScratch;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.LandingPage;

public class ValidateTitle extends base{
	
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void Initialize() throws Exception {
		driver=launchBrowser();
		log.info("Browser is Invoked");
		driver.get(prop.getProperty("url"));
		log.info("Home Page Open Successfully.");
	}
	
	@Test
	public void homeURL() throws IOException {		
		//this is home page
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Title Validation Successfull.");
		Assert.assertTrue(lp.getNavigation().isDisplayed());
		log.info("Top Navigation is Displayed!");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
	}

}
