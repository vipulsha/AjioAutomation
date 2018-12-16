package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import pages.common.ParentPage;

public class UserHomePage extends ParentPage {
	// Data Members
	@FindBy(xpath="//span[@class='sentence-case']") WebElement welcomeMessage;
	@FindBy(linkText="My Account") WebElement myAccountLink;
	@FindBy(linkText="Sign Out") WebElement signOutLink;
	
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
		ATUReports.add("Clicked on My Account link", LogAs.PASSED, null);
	}
	
	public void clickSignOutLink() {
		click(signOutLink);
		ATUReports.add("Clicked on Signout link", LogAs.PASSED, null);
	}
}
