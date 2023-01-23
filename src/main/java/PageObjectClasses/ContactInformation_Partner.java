package PageObjectClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class ContactInformation_Partner {

	private WebDriver driver;

	public ContactInformation_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//h4[contains(@class, 'page-heading')]")
	private WebElement pageHeadingElement;

	@FindBy(xpath = "//input[@name = 'dba']")
	private WebElement dbaFieldElement;

	@FindBy(xpath = "//input[@name = 'address1']")
	private WebElement blaAddressLine1;

	@FindBy(xpath = "//input[@name = 'address2']")
	private WebElement blaAddressLine2;
	
	@FindBy(xpath = "//input[@name = 'zip']")
	private WebElement blaZip;

	@FindBy(xpath = "//label[text() = 'Country']//following-sibling::div[1]")
	private WebElement countryDropdownElement;
	
	@FindBy(xpath = "//label[text() = 'State']//following-sibling::div[1]")
	private WebElement stateDropdownElement;
	
	@FindBy(xpath = "//label[text() = 'City']//following-sibling::div[1]")
	private WebElement cityDropdownElement;
	
	@FindBy(xpath = "//input[@name = 'primaryName']")
	private WebElement primaryNameElement;
	
	@FindBy(xpath = "//input[@name = 'primaryTitle']")
	private WebElement primaryTitleElement;
	
	@FindBy(xpath = "//input[@name = 'primaryPhoneNumber']")
	private WebElement primaryPhoneNumberElement;
	
	@FindBy(xpath = "//input[@name = 'primaryAlternativePhoneNumber']")
	private WebElement primaryAlternativePhoneNumberElement;
	
	@FindBy(xpath = "//input[@name = 'primaryEmail']")
	private WebElement primaryEmailElement;
	
	@FindBy(xpath = "//input[@name = 'secondaryName']")
	private WebElement secondaryNameElement;
	
	@FindBy(xpath = "//input[@name = 'secondaryTitle']")
	private WebElement secondaryTitleElement;
	
	@FindBy(xpath = "//input[@name = 'secondaryPhoneNumber']")
	private WebElement secondaryPhoneNumberElement;
	
	@FindBy(xpath = "//input[@name = 'secondaryAlternativePhoneNumber']")
	private WebElement secondaryAlternativePhoneNumberElement;
	
	@FindBy(xpath = "//input[@name = 'secondaryEmail']")
	private WebElement secondaryEmailElement;
	
	@FindBy(xpath = "//input[@name = 'authorizedName']")
	private WebElement authorizedNameElement;
	
	@FindBy(xpath = "//input[@name = 'authorizedTitle']")
	private WebElement authorizedTitleElement;
	
	@FindBy(xpath = "//button[text() = 'Next']")
	private WebElement nextButtonElement;
	
	@FindBy(xpath = "//button[text() = 'Back']")
	private WebElement backButtonElement;
	
	@FindBy(xpath = "//a[contains(@class, 'signout')]")
	private WebElement signoutElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-footer')]/button[3]")
	private WebElement confirmButtonElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-content')]")
	private WebElement dialogBoxElement;
	
	@FindBy(xpath = "//h2[contains(@class, 'modal-heading')]")
	private WebElement dialogBoxHeadingElement;
	
	
	private final String dropdownPattern = "//div[contains(@id, 'option')]";

	public boolean validatePageHeading(String pageHeading) {
		try {
			return pageHeadingElement.getText().contains(pageHeading);
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - validatePageHeading");
			return false;
		}
	}
	
	public boolean clickButton(boolean Back, boolean Next) {
		try {
			WebElement element = null;
			if (Next) {
				element = nextButtonElement;
			} else if (Back) {
				element = backButtonElement;
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - clickButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean navigateBack() {
		try {
			driver.navigate().back();
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - navigateBack");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param value (String) 1 - generalInfo, 2 - ContactInfo, 3 - OtherInfo, 4 - T&C 
	 * @return
	 */
	public boolean navigateTo(String value) {
		try {
			String pattern = "//span[text() = '" + value + "']//parent::a";
			driver.findElement(By.xpath(pattern)).click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - navigateTo");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean signoutAction() {
		try {
			signoutElement.click();
			if (dialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().contains("Sign Out")) {
				confirmButtonElement.click();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - signoutAction");
			System.err.println(e);
			return false;
		}
	}
	
	public boolean fillBusinessLocationAddress(String address1, String address2, String country,
			String state, String city, String zipcode) {
		try {
			if (address1 != null) setAddress1(address1);
			if (address2 != null) setAddress2(address2);
			if (country != null) selectCountryfromDropdown(country);
			if (state != null) selectStatefromDropdown(state);
			if (city != null) selectCityfromDropdown(city);
			if (zipcode != null) setZipCode(zipcode);
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - fillBusinessLocationAddress");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validateBusinessLocationAddress(String address1, String address2, String country,
			String state, String city, String zipcode) {
		try {
			boolean flag = true;
			System.out.println("Starting Validation: ");
			if (address1 != null && flag) {
				flag = blaAddressLine1.getAttribute("value").contains(address1);
				System.out.println("Validated Address 1");
			}
			
			if (address2 != null && flag) {
				flag = blaAddressLine2.getAttribute("value").contains(address2);
				System.out.println("Validated Address 2");
			}
			
			if (country != null && flag) {
				countryDropdownElement.click();
				flag = countryDropdownElement.getText().contains(country);
				System.out.println("Validated Country");
			}
			
			if (state != null && flag) {
				stateDropdownElement.click();
				flag = stateDropdownElement.getText().contains(state);
				System.out.println("Validated State");
			}
			
			if (city != null && flag) {
				cityDropdownElement.click();
				flag = cityDropdownElement.getText().contains(city);
				System.out.println("Validated City");
			}
			
			if (zipcode != null && flag) {
				blaZip.click();
				flag = blaZip.getAttribute("value").contains(zipcode);
				System.out.println("Validated ZipCode");
				System.out.println("==============================");
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - validateBusinessLocationAddress");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillPrimaryContactInformation(String name, String title, String PhoneNumber,
			String AltPhoneNumber, String email) {
		try {
			if (name != null) setPrimaryName(name);
			if (title != null) setPrimaryTitle(title);
			if (PhoneNumber != null) setPrimaryPhoneNumber(PhoneNumber);
			if (AltPhoneNumber != null) setPrimaryAltPhoneNumber(AltPhoneNumber);
			if (email != null) setPrimaryEmail(email);
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - fillPrimaryContactInformation");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillSecondaryContactInformation(String name, String title, String PhoneNumber,
			String AltPhoneNumber, String email) {
		try {
			if (name != null) setSecondaryName(name);
			if (title != null) setSecondaryTitle(title);
			if (PhoneNumber != null) setSecondaryPhoneNumber(PhoneNumber);
			if (AltPhoneNumber != null) setSecondaryAltPhoneNumber(AltPhoneNumber);
			if (email != null) setSecondaryEmail(email);
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - fillSecondaryContactInformation");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillAuthorizedSignatory(String name, String title) {
		try {
			if (name != null) setAuthorizedName(name);
			if (title != null) setAuthorizedTitle(title);
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - fillAuthorizedSignatory");
			e.printStackTrace();
			return false;
		}
	}

	public boolean setDBA(String value) {
		try {
			if (dbaFieldElement.isEnabled()) {
				dbaFieldElement.click();
				Utility.clearField(driver, dbaFieldElement);
				dbaFieldElement.sendKeys(value);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - setDBA");
			e.printStackTrace();
			return false;
		}
	}

	public boolean setAddress1(String value) {
		try {
			if (blaAddressLine1.isEnabled()) {
				blaAddressLine1.click();
				Utility.clearField(driver, blaAddressLine1);
				blaAddressLine1.sendKeys(value);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - setAddress1");
			e.printStackTrace();
			return false;
		}
	}

	public boolean setAddress2(String value) {
		try {
			if (blaAddressLine2.isEnabled()) {
				blaAddressLine2.click();
				Utility.clearField(driver, blaAddressLine2);
				blaAddressLine2.sendKeys(value);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - setAddress2");
			e.printStackTrace();
			return false;
		}
	}

	public boolean selectCountryfromDropdown(String country) {
		try {
			countryDropdownElement.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable((By.xpath(dropdownPattern))));
			List<WebElement> options = driver.findElements(By.xpath(dropdownPattern));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(country)) {
					option.click();
					WaitClass.waitForTime(2000);
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - selectCountryfromDropdown");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean selectStatefromDropdown(String state) {
		try {
			stateDropdownElement.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable((By.xpath(dropdownPattern))));
			List<WebElement> options = driver.findElements(By.xpath(dropdownPattern));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(state)) {
					option.click();
					WaitClass.waitForTime(2000);
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - selectStatefromDropdown");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean selectCityfromDropdown(String city) {
		try {
			cityDropdownElement.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable((By.xpath(dropdownPattern))));
			List<WebElement> options = driver.findElements(By.xpath(dropdownPattern));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(city)) {
					option.click();
					WaitClass.waitForTime(2000);
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_Partner and Method - selectCityfromDropdown");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setZipCode(String zipcode) {
		try {
			if (blaZip.isEnabled()) {
				blaZip.click();
				Utility.clearField(driver, blaZip);
				blaZip.sendKeys(zipcode);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setZipCode");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setPrimaryName(String name) {
		try {
			if (primaryNameElement.isEnabled()) {
				primaryNameElement.click();
				Utility.clearField(driver, primaryNameElement);
				primaryNameElement.sendKeys(name);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setPrimaryName");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setPrimaryTitle(String title) {
		try {
			if (primaryTitleElement.isEnabled()) {
				primaryTitleElement.click();
				Utility.clearField(driver, primaryTitleElement);
				primaryTitleElement.sendKeys(title);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setPrimaryTitle");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setPrimaryPhoneNumber(String number) {
		try {
			if (primaryPhoneNumberElement.isEnabled()) {
				primaryPhoneNumberElement.click();
				Utility.clearField(driver, primaryPhoneNumberElement);
				primaryPhoneNumberElement.sendKeys(number);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setPrimaryPhoneNumber");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setPrimaryAltPhoneNumber(String number) {
		try {
			if (primaryAlternativePhoneNumberElement.isEnabled()) {
				primaryAlternativePhoneNumberElement.click();
				Utility.clearField(driver, primaryAlternativePhoneNumberElement);
				primaryAlternativePhoneNumberElement.sendKeys(number);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setPrimaryAltPhoneNumber");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setPrimaryEmail(String email) {
		try {
			if (primaryEmailElement.isEnabled()) {
				primaryEmailElement.click();
				Utility.clearField(driver, primaryEmailElement);
				primaryEmailElement.sendKeys(email);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setPrimaryEmail");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setSecondaryName(String name) {
		try {
			if (secondaryNameElement.isEnabled()) {
				secondaryNameElement.click();
				Utility.clearField(driver, secondaryNameElement);
				secondaryNameElement.sendKeys(name);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setSecondaryName");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setSecondaryTitle(String title) {
		try {
			if (secondaryTitleElement.isEnabled()) {
				secondaryTitleElement.click();
				Utility.clearField(driver, secondaryTitleElement);
				secondaryTitleElement.sendKeys(title);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setSecondaryTitle");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setSecondaryPhoneNumber(String number) {
		try {
			if (secondaryPhoneNumberElement.isEnabled()) {
				secondaryPhoneNumberElement.click();
				Utility.clearField(driver, secondaryPhoneNumberElement);
				secondaryPhoneNumberElement.sendKeys(number);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setSecondaryPhoneNumber");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setSecondaryAltPhoneNumber(String number) {
		try {
			if (secondaryAlternativePhoneNumberElement.isEnabled()) {
				secondaryAlternativePhoneNumberElement.click();
				Utility.clearField(driver, secondaryAlternativePhoneNumberElement);
				secondaryAlternativePhoneNumberElement.sendKeys(number);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setSecondaryAltPhoneNumber");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setSecondaryEmail(String email) {
		try {
			if (secondaryEmailElement.isEnabled()) {
				secondaryEmailElement.click();
				Utility.clearField(driver, secondaryEmailElement);
				secondaryEmailElement.sendKeys(email);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setSecondaryEmail");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setAuthorizedName(String name) {
		try {
			if (authorizedNameElement.isEnabled()) {
				authorizedNameElement.click();
				Utility.clearField(driver, authorizedNameElement);
				authorizedNameElement.sendKeys(name);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setAuthorizedName");
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean setAuthorizedTitle(String title) {
		try {
			if (authorizedTitleElement.isEnabled()) {
				authorizedTitleElement.click();
				Utility.clearField(driver, authorizedTitleElement);
				authorizedTitleElement.sendKeys(title);
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - ContactInformation_partner and Method - setAuthorizedTitle");
			e.printStackTrace();
			return false;
		}
	}
	
	
}
