package pages.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
	WebDriverWait wait = null;
	WebDriver driver;
	private static final int TIMEOUTS = 30;
	
	public ParentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUTS);
	}
	
	/**
	 * Method to click on element
	 * @param element
	 */
	public void click(Object element) {
		waitForElementToBeClickable(element).click();
	}
	
	/**
	 * Method to enter text in a element
	 * @param element
	 * @param text
	 */
	public void enterText(Object element, String text) {
		WebElement e = waitForElementToBeVisible(element);
//		e.clear();
		e.click();
		e.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public WebElement waitForElementToBeClickable(Object byOrWebElement) {
		if (byOrWebElement instanceof WebElement) {
			return wait.until(ExpectedConditions.elementToBeClickable((WebElement)byOrWebElement));
		} else if (byOrWebElement instanceof By) {
			return wait.until(ExpectedConditions.elementToBeClickable((By) byOrWebElement));
		} else {
			return null;
		}
	}
	
	public WebElement waitForElementToBeVisible(Object byOrWebElement) {
		if (byOrWebElement instanceof WebElement) {
			return wait.until(ExpectedConditions.visibilityOf((WebElement)byOrWebElement));
		} else if (byOrWebElement instanceof By) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated((By) byOrWebElement));
		} else {
			return null;
		}
	}
	
	public boolean waitForElementToBeInVisible(Object byOrWebElement) {
		if (byOrWebElement instanceof WebElement) {
			return wait.until(ExpectedConditions.invisibilityOf((WebElement)byOrWebElement));
		} else if (byOrWebElement instanceof By) {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated((By) byOrWebElement));
		} else {
			return false;
		}
	}
	
	public List<WebElement> findElements(By by) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public WebElement waitForChildElement(WebElement parentElement, By byOfChild) {
		return waitForElementToBeVisible(parentElement).findElement(byOfChild);
	}
	
	public String getDynamicXpath(String rawXpath,String replaceText,String withText) {
		return rawXpath.replace(replaceText, withText);
	}
	
	public List<WebElement> waitForElementsToBeVisible(Object byOrWebElement) {
		if (byOrWebElement instanceof WebElement) {
			return wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) byOrWebElement));
		} else if (byOrWebElement instanceof By) {
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By)byOrWebElement));
		} else {
			return null;
		}
	}
	
	public void clickThroughJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) (driver);
		executor.executeScript("arguments[0].click()", element);
	}
}
