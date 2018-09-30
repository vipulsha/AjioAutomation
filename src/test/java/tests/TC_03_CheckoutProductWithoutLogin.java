package tests;

import org.testng.annotations.Test;

import pages.CategoryHomePage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultsPage;
import pages.ShoppingBagPage;
import tests.commons.ParentTest;

public class TC_03_CheckoutProductWithoutLogin extends ParentTest {
	
	@Test
	public void verifyProductCheckoutWithoutLogin() {
		HomePage homePage = new HomePage(driver);
		CategoryHomePage categoryHomePage = homePage.clickOnCategory("SHOP MEN");
		SearchResultsPage searchResultsPage = categoryHomePage.searchProduct("Denim Jeans");
		ProductDetailsPage productDetailsPage = searchResultsPage.clickOnProduct("Denim Jeans with Frayed Hems");
		productDetailsPage.selectColor("BLUE");
		productDetailsPage.selectSize("32");
		productDetailsPage.clickAddToBag();
		ShoppingBagPage shoppingBagPage = productDetailsPage.clickGoToBag();
		CheckoutPage checkoutPage = shoppingBagPage.clickProceedToShopping();
		checkoutPage.clickProceedToPayment();
		
	}
	
}
