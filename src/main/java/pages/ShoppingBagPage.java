package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class ShoppingBagPage extends ParentPage {
	WebDriver driver;
	@FindBy(xpath="//button[text()='Proceed to shipping']") WebElement proceedToShippingButton;
	
	public ShoppingBagPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage clickProceedToShipping() {
		click(proceedToShippingButton);
		return new CheckoutPage(driver);
	}
}
