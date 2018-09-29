package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
	WebDriverWait wait = null;
	WebDriver driver;
	
	public ParentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	
	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}
	
	public void enterText(WebElement element, String text) {
		WebElement e = waitForElementToBeVisible(element);
		e.clear();
		e.click();
		e.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean waitForElementToBeInVisible(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
