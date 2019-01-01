package tests.commons;

import java.net.MalformedURLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ParentTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void parentSetUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swap\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com");
		System.out.println("Ajio site is launching");
	}
	
	@AfterClass
	public void parentTearDown() {
		driver.quit();
	}
}
