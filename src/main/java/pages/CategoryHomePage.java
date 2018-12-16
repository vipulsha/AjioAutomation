package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import pages.common.ParentPage;

public class CategoryHomePage extends ParentPage {

	WebDriver driver;
	@FindBy(name="searchVal") WebElement searchTextbox;
	@FindBy(className="rilrtl-button") WebElement searchIcon;
	
	public CategoryHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchResultsPage searchProduct(String text) {
		enterText(searchTextbox, text);
		ATUReports.add("Entered test in search textbox", text, LogAs.PASSED, null);
		click(searchIcon);
		ATUReports.add("Clicked on Search button", LogAs.PASSED, null);
		return new SearchResultsPage(driver);
	}
}
