package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class SignInPage extends ParentPage {
	
	// Data Members
	@FindBy(id="j_username") WebElement emailIdTextbox;
	@FindBy(id="j_password") WebElement passwordTextbox;
	@FindBy(id="loginbtn") WebElement signInButton;
	
	// Constructor
	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// Page/Member functions
	public void enterEmailId(String emailId) {
		/*waitForElementToBeVisible(emailIdTextbox);
		emailIdTextbox.clear();
		emailIdTextbox.click();
		emailIdTextbox.sendKeys(emailId);*/
		enterText(emailIdTextbox, emailId);
	}
	
	public void enterPassword(String password) {
		enterText(passwordTextbox, password);
	}
	
	public void clickSignInButton() {
		click(signInButton);
	}
}
