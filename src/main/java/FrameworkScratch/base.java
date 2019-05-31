package FrameworkScratch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver launchBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\noorh\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fs);
		String browserName = prop.getProperty("browser");
		//String pageUrl = prop.getProperty("url");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\MySelProject\\Libraries\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\MySelProject\\Libraries\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\MySelProject\\Libraries\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreeenShots(String result) throws Exception {
		File sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("C:\\Users\\noorh\\MyProject\\screenshots\\"+result+"screenshot.png"));

	}

}
