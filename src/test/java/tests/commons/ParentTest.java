package tests.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class ParentTest {
	public RemoteWebDriver driver;
	private Properties properties = null;
	
	@BeforeClass
	public void parentSetUp() throws MalformedURLException {
		
		String os = System.getProperty("os.name");
		if (os.toUpperCase().contains("WINDOWS")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");	
		} else {
			System.setProperty("webdriver.chrome.driver", "/home/vf-root/AllDrivers/chromedriver");
		}
		
		driver = new ChromeDriver();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setJavascriptEnabled(true);
//		driver = new RemoteWebDriver(new URL("http://192.168.0.3:4444/wd/hub"), capabilities);
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
	
	/**
	 * Method to get data from properties file
	 * @param key
	 * @return
	 */
	public String getData(String key) {
		return properties.get(key).toString();
	}
	
	@AfterClass
	public void parentTearDown() {
		driver.quit();
	}
}
