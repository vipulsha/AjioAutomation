package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import pages.common.ParentPage;

public class HomePage extends ParentPage {
	
	// Data Members
	WebDriver driver;
	@FindBy(xpath="//*[text()='Sign In / Join AJIO']")  WebElement signInJoinAjioLink;
//	@FindBy(linkText="Join Ajio") WebElement joinJioLink;
	private static final String CATEGORY_XPATH = "//a[@href='replaceWith']";
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// Page functions ==> Member functions
	public void clickSignInJoinAjioLink() {
		click(signInJoinAjioLink);
		ATUReports.add("Clicked on SignIn Ajio Link", LogAs.PASSED, null);
	}
	
/*	public void clickRegistrationButton() {
		click(joinJioLink);
	}
*/	
	public void signIn(String emailId, String password) {
		this.clickSignInJoinAjioLink();
		SignInPage signInPage = new SignInPage(this.driver);
		signInPage.enterEmailId(emailId);
		signInPage.clickContinueButton();
		signInPage.enterPassword(password);
		signInPage.clickStartShoppingButton();
	}
	
	public CategoryHomePage clickOnCategory(String categoryName) {
		categoryName = categoryName.trim().toUpperCase();
		String finalXpath = null;
		switch (categoryName) {
		case "SHOP SALE":
			finalXpath = CATEGORY_XPATH.replace("replaceWith", "/shop/sale");	
			break;
		case "SHOP MEN":
			finalXpath = CATEGORY_XPATH.replace("replaceWith", "/shop/men");	
			break;
		case "SHOP WOMEN":
			finalXpath = CATEGORY_XPATH.replace("replaceWith", "/shop/women");	
			break;
		case "SHOP KIDS":
			finalXpath = CATEGORY_XPATH.replace("replaceWith", "/shop/kids");	
		}
		click(By.xpath(finalXpath));
		return new CategoryHomePage(driver);
	}
	
	
}
