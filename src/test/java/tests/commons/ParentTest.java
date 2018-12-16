package tests.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
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

import atu.testng.reports.ATUReports;

public class ParentTest {
	public RemoteWebDriver driver;
	private Properties properties = null;

	{
		System.setProperty("atu.reporter.config", Paths.get(".").toAbsolutePath().normalize().toString()+"\\ATUConfig\\atu.properties");
	}

	@BeforeClass
	public void parentSetUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String os = System.getProperty("os.name");

		// Code to check which browser is selected on Jenkins?
		String browser = System.getenv("Browser").toUpperCase();
		System.out.println("Selected browser: "+browser);

		// Set platform
		if (os.toUpperCase().contains("WINDOWS")) {
			capabilities.setPlatform(Platform.WINDOWS);
		} else {
			capabilities.setPlatform(Platform.LINUX);
		}

		switch (browser) {
		case "CHROME":
			if (os.toUpperCase().contains("WINDOWS")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");	
			} else {
				System.setProperty("webdriver.chrome.driver", "/home/vf-root/AllDrivers/chromedriver");
			}
			driver = new ChromeDriver();
			capabilities.setBrowserName("chrome");
			break;
		case "FF":
			if (os.toUpperCase().contains("WINDOWS")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");	
			} else {
				System.setProperty("webdriver.gecko.driver", "/home/vf-root/AllDrivers/geckodriver");
			}
			driver = new FirefoxDriver();
			capabilities.setBrowserName("firefox");
			break;
		case "IE":
			break;
		default:
			System.out.println("Incorrect browser selected");
			System.exit(0);
		}
		capabilities.setJavascriptEnabled(true);
		ATUReports.setWebDriver(driver);
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
