package pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.common.ParentPage;

public class MyAccountPage extends ParentPage {

	// Data Members
	WebDriver driver;
	@FindBy(xpath = "//li[text()='ADDRESS BOOK']")
	WebElement addressBook;
	@FindBy(id = "viewAddNewAddressBook")
	WebElement addAddressLink;
	@FindBy(name = "postcode")
	WebElement pinCodeTextbox;
	@FindBy(name = "firstName")
	WebElement firstNameTextbox;
	@FindBy(name = "lastName")
	WebElement lastNameTextbox;
	@FindBy(name = "line1")
	WebElement addressLine1Textbox;
	@FindBy(name = "state")
	WebElement stateTextbox;
	@FindBy(name = "district")
	WebElement districtTextbox;
	@FindBy(name = "phone")
	WebElement phoneNoTextbox;
	@FindBy(id = "saveButton")
	WebElement saveButton;
	@FindBy(id = "resetButton")
	WebElement resetButton;
	@FindBy(id = "addAddressTypeHomeSpan")
	WebElement homeAddress;
	@FindBy(id = "addAddressTypeWorkSpan")
	WebElement workAddress;
	
	private final String ADDRESSES_XPATH = "//div[contains(@class,'fnl-my-addaddr')]//div[@class='fnl-ship-address']";
	private final String ADDRESS_NAME_XPATH = "./div[contains(@class,'fnl-ship-address-name')]";
	private final String ADDRESS_LINE1_XPATH = "./div[@class='fnl-ship-address-line1']";
	private final String CITY_STATE_XPATH = "./div[@class='fnl-ship-address-line3'][1]";
	private final String PINCODE_XPATH = "./div[@class='fnl-ship-address-line3'][2]";
	
	// Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	// Page Functions
	public void clickAddressBook() {
		click(addressBook);
	}

	public void clickAddAddressLink() {
		click(addAddressLink);
	}

	public void enterPinCode(String pinCode) {
		enterText(pinCodeTextbox, pinCode);
	}

	public void enterFirstName(String firstName) {
		enterText(firstNameTextbox, firstName);
	}

	public void enterLastName(String lastName) {
		enterText(lastNameTextbox, lastName);
	}

	public void enterAddressLine1(String addressLine1) {
		enterText(addressLine1Textbox, addressLine1);
	}

	public void enterState(String state) {
		enterText(stateTextbox, state);
	}

	public void enterDistrict(String district) {
		enterText(districtTextbox, district);
	}

	public void enterPhoneNo(String phoneNo) {
		enterText(phoneNoTextbox, phoneNo);
	}

	public void selectHomeAddress() {
		click(homeAddress);
	}

	public void selectWorkAddress() {
		click(workAddress);
	}

	public void clickSaveButton() {
		int cnt = 1;
		do {
			try {
				click(saveButton);
				waitForElementToBeInVisible(saveButton);
				break;
			} catch (Exception e) {}
			cnt++;
		} while(cnt<=2);
	}

	public void clickResetButton() {
		click(resetButton);
	}

	public boolean isAddressPresent(String firstName,String lastName, 
			String addressLine1,String pinCode,String district,String state,String addressType) {
		// Get all address elements
		List<WebElement> addresses = driver.findElements(By.xpath(ADDRESSES_XPATH));

		for(int i=0; i<addresses.size(); i++) {
			WebElement address = addresses.get(i);
			// Name & Address Type
			WebElement name = address.findElement(By.xpath(ADDRESS_NAME_XPATH));
			String addressName = name.getText();
			String firstNameTxt = "";
			String lastNameTxt = "";
			String addType = "";
			if (StringUtils.isNotBlank(addressName)) {
				String[] split = addressName.split("\n");
				String[] split2 = split[0].split(" ");
				firstNameTxt = split2[0];
				lastNameTxt = split2[1];
				addType = split[1]; 
			}

			if (!firstName.equals(firstNameTxt) || !lastName.equals(lastNameTxt)) 
				continue;

			// Address Line1
			WebElement addLine1 = address.findElement(By.xpath(ADDRESS_LINE1_XPATH));
			String addLine1Txt = addLine1.getText().trim();
			if (!addressLine1.equals(addLine1Txt))
				continue;

			// City & State
			WebElement cityState = address.findElement(By.xpath(CITY_STATE_XPATH));
			String cityStateTxt = cityState.getText();
			String[] split = cityStateTxt.split(",");
			String cityName = "";
			String stateName = "";
			if (StringUtils.isNotBlank(cityStateTxt)) {
				cityName = split[0].trim();
				stateName = split[1].trim();	
			}

			if (!cityName.equals(district.toUpperCase()) || !stateName.equals(state.toUpperCase())) 
				continue;

			// Pin code
			WebElement pinCodeElement = address.findElement(By.xpath(PINCODE_XPATH));
			String pinCodeTxt = pinCodeElement.getText();
			if(!pinCode.equals(pinCodeTxt))
				continue;
			else 
				return true;
		}
		return false;
	}
}
