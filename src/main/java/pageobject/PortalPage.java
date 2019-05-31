package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalPage {
	public WebDriver driver;
	public PortalPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By sbox = By.name("query");
	
	public WebElement findCourse() {
		return driver.findElement(sbox);
	}

}
