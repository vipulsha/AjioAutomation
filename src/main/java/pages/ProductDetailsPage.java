package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.common.ParentPage;

public class ProductDetailsPage extends ParentPage {

	WebDriver driver;
	private static final String PRODUCT_COLOR_XPATH = "//div[@class='color-swatch']/a/img[@title='replaceWith']";
	private static final String PRODUCT_SIZE_XPATH = "//div[@class='size-swatch']/div[text()='replaceWith']";
	
	@FindBy(xpath="//span[text()='ADD TO BAG']") WebElement addToBagButton;
	@FindBy(xpath="//span[text()='GO TO BAG']") WebElement goToBagButton;
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectColor(String color) {
		click(By.xpath(getDynamicXpath(PRODUCT_COLOR_XPATH, "replaceWith", color.trim().toUpperCase())));
	}
	
	public void selectSize(String size) {
		click(By.xpath(getDynamicXpath(PRODUCT_SIZE_XPATH, "replaceWith", size.trim())));
	}
	
	public void clickAddToBag() {
		click(addToBagButton);
	}
	
	public ShoppingBagPage clickGoToBag() {
		click(goToBagButton);
		return new ShoppingBagPage(driver);
	}
	
	
}
