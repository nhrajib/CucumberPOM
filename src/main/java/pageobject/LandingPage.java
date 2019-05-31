package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
		
	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//a[contains(text(),'Home')]");
	By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public WebElement clickLogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigation() {
		return driver.findElement(navbar);
	}
	
	public List<WebElement> getPopUpSize() {
		return driver.findElements(popup);
	}
	
	public WebElement popUp() {
		return driver.findElement(popup);
	}

}
