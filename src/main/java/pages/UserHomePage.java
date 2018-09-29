package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class UserHomePage extends ParentPage {
	// Data Members
	@FindBy(xpath="//span[@class='sentence-case']") WebElement welcomeMessage;
	@FindBy(linkText="MY ACCOUNT") WebElement myAccountLink;
	@FindBy(linkText="SIGN OUT") WebElement signOutLink;
	
	// Constructor
	public UserHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// Member functions/Page Functions
	public String getWelComeMessage() {
		String message = "";
		try {
			message = getText(welcomeMessage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return message;
	}
	
	public void clickMyAccountLink() {
		click(myAccountLink);
	}
	
	public void clickSignOutLink() {
		click(signOutLink);
	}
}
