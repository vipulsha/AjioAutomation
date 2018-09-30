package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class SearchResultsPage extends ParentPage {
	
	WebDriver driver;
	
	@FindBy(name="searchVal") WebElement searchTextbox;
	private static final String PRODUCT_NAME_XPATH = "//div[@class='name'  and text()='replaceWith']"; 
			
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductDetailsPage clickOnProduct(String productName) {
		click(By.xpath(getDynamicXpath(PRODUCT_NAME_XPATH, "replaceWith", productName)));
		return new ProductDetailsPage(driver);
	}

	
	
}
