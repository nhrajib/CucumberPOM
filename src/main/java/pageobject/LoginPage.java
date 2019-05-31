package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.xpath("//input[@id='user_email']");
	By passwd = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@name='commit']");
	
	public WebElement setEmailID() {
		return driver.findElement(email);
	}
	
	public WebElement setPasswd() {
		return driver.findElement(passwd);
	}
	
	public WebElement LogInQCA() {
		return driver.findElement(login);
	}

}
