package tests.commons;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ParentTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void parentSetUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "E:\\Software\\geckodriver.exe");
//		driver = new FirefoxDriver();
		//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com");
	}
	
	@AfterClass
	public void parentTearDown() {
		driver.quit();
	}
}
