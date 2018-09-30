package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class ShoppingBagPage extends ParentPage {

	WebDriver driver;
	 
	@FindBy(id="shippingbuttontop") WebElement proceedToShoppingButton;
	
	public ShoppingBagPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage clickProceedToShopping() {
		click(proceedToShoppingButton);
		return new CheckoutPage(driver);
	}
}
