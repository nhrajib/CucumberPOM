package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.PortalPage;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.testng.Assert;

import FrameworkScratch.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver=launchBrowser();
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
    	if(lp.getPopUpSize().size()>0) {
    		lp.popUp().click();
    	}
		lp.clickLogin().click();
    }
    
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lg = new LoginPage(driver);
		lg.setEmailID().sendKeys(username);
		lg.setPasswd().sendKeys(password);
		lg.LogInQCA().click();
    }
    
    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {
        PortalPage pl = new PortalPage(driver);
        Assert.assertTrue(pl.findCourse().isDisplayed()); 
    }

    @And("^close browsers$")
    public void close_browsers() throws Throwable {
    	driver.close();
		driver=null;
    }

}