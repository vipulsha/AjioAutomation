package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class SignInPopUpPage extends ParentPage {

	@FindBy(id="j_username_popup") WebElement emailIdTextbox;
	@FindBy(id="j_password_popup") WebElement passwordTextbox;
	@FindBy(id="popupenter") WebElement signInButton;
	
	// Constructor
	public SignInPopUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// Page/Member functions
	public void enterEmailId(String emailId) {
		enterText(emailIdTextbox, emailId);
	}
	
	public void enterPassword(String password) {
		enterText(passwordTextbox, password);
	}
	
	public void clickSignInButton() {
		click(signInButton);
	}

}
