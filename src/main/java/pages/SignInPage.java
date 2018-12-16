package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import pages.common.ParentPage;

public class SignInPage extends ParentPage {
	
	// Data Members
	@FindBy(name="username") WebElement emailIdTextbox;
	@FindBy(id="pwdInput") WebElement passwordTextbox;
	@FindBy(id="loginbtn") WebElement signInButton;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueButton;
	@FindBy(xpath="//input[@value='START SHOPPING']") WebElement startShoppingButton;
	
	
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
		ATUReports.add("Entered email id", emailId, LogAs.PASSED, null);
	}
	
	public void enterPassword(String password) {
		enterText(passwordTextbox, password);
		ATUReports.add("Entered password", password, LogAs.PASSED, null);
	}
	
	public void clickSignInButton() {
		click(signInButton);
		ATUReports.add("Clicked on SignIn button", LogAs.PASSED, null);
	}
	
	public void clickContinueButton() {
		click(continueButton);
		ATUReports.add("Clicked on Continue button", LogAs.PASSED, null);
	}
	
	public void clickStartShoppingButton() {
		click(startShoppingButton);
		ATUReports.add("Clicked on Start Shopping button", LogAs.PASSED, null);
	}
}
