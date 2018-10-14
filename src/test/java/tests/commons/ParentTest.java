package tests.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParentTest {
	
	public static WebDriver driver;
	private Properties properties = null;
	
	@BeforeClass
	public void parentSetUp() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com");
	}
	
	@BeforeMethod
	public void parentBeforeMethod(Method method) {
		String testName = method.getName();
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\DataRepository\\"+testName+".properties";
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getData(String key) {
		return properties.get(key).toString();
	}
	
	@AfterClass
	public void parentTearDown() {
		driver.quit();
	}
}
