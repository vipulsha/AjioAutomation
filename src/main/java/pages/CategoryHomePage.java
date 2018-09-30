package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
		click(searchIcon);
		return new SearchResultsPage(driver);
	}
}
