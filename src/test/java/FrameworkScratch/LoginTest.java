package FrameworkScratch;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class LoginTest extends base {
	
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void Initialize() throws Exception {
		driver=launchBrowser();
		//driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void homeURL(String username,String password, String text) throws Exception {	
		driver.get(prop.getProperty("url"));
		//this is home page
		LandingPage lp = new LandingPage(driver);
		lp.clickLogin().click();		
		
		//this is log in page
		LoginPage lg = new LoginPage(driver);
		lg.setEmailID().sendKeys(username);
		lg.setPasswd().sendKeys(password);
		log.info(text);
		//System.out.println(text);
		lg.LogInQCA().click();		
	}
	
		@DataProvider
		public Object[][] getData() {
			//Rows stands for how many data types test should run
			//Column stands for how many values per each test
			Object[][] data=new Object[2][3];
			//0th row 
			data[0][0]="uftlab@gmail.com";
			data[0][1]="almuft12";
			data[0][2]="Unrestricted User";
			//1st row
			data[1][0]="restricted@gmail.com";
			data[1][1]="123456";
			data[1][2]="Restricted User";
			
			return data;
		}
		
		@AfterTest
		public void closeBrowser() {
			driver.close();
			driver=null;
		}
}
