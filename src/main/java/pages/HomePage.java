package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class HomePage extends ParentPage {
	
	// Data Members
	WebDriver driver;
	@FindBy(linkText="SIGN IN")  WebElement signInLink;
	@FindBy(linkText="Join Ajio") WebElement joinJioLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// Page functions ==> Member functions
	public void clickSignInLink() {
		click(signInLink);
	}
	
	public void clickRegistrationButton() {
		click(joinJioLink);
	}
	
	public void signIn(String emailId, String password) {
		this.clickSignInLink();
		SignInPage signInPage = new SignInPage(this.driver);
		signInPage.enterEmailId(emailId);
		signInPage.enterPassword(password);
		signInPage.clickSignInButton();
	}


}
