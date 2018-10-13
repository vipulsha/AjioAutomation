package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class CheckoutPage extends ParentPage {

	@FindBy(xpath="//div[text()='Proceed to Payment']") WebElement proceedToPaymentButton;
	private static final String PAYMENT_OPTION_XPATH = "//div[@class='fnl-payment-name' and contains(text(),'replaceWith')]";
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickProceedToPayment() {
		click(proceedToPaymentButton);
	}
	
	public void selectPaymentOption(String paymentOption) {
		click(By.xpath(getDynamicXpath(PAYMENT_OPTION_XPATH, "replaceWith", paymentOption)));
	}
}
