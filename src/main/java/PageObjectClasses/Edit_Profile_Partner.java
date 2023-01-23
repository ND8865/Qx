package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;


public class Edit_Profile_Partner {
	
	WebDriver driver;
	
	public Edit_Profile_Partner(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//GENERAL INFORMATION
	@FindBy(xpath = "//h4[text()='Settings']")
	private WebElement settingsTab;

	@FindBy(xpath = "//span[text()='Change Password']")
	private WebElement changePasswordTab;
	
	@FindBy(xpath = "//label[text()='Legal Entity Name']")
	private WebElement legalEntityLabel;
	
	@FindBy(xpath = "//input[@name='legalEntityName']")
	private WebElement legalEntityField;
	
	@FindBy(xpath = "//select[@name='categoryId']")
	private WebElement categoryField;
	
	@FindBy(xpath = "//select[@name='joinReasonId']")
	private WebElement resonToJoinQxField;
	
	@FindBy(xpath = "//label[@for='logoUpload']")
	private WebElement uploadLogo;
	
	@FindBy(xpath = "//button[@data-testid='update-partner-profile']")
	private WebElement updateButton;
	
	@FindBy(xpath = "//div[text()='Partner details updated successfully.']")
	private WebElement updateSuccessMessage;
	
	//CONTACT INFORMATION
	@FindBy(xpath = "//input[@data-testid='address1']")
	private WebElement addressLine1;
	
	@FindBy(xpath = "//input[@name='primaryName']")
	private WebElement namePrimary;
	
	@FindBy(xpath = "//input[@name='primaryTitle']")
	private WebElement titlePrimary;
	
	@FindBy(xpath = "//input[@name='authorizedName']")
	private WebElement authorisedName;
	
	@FindBy(xpath = "//input[@name='authorizedTitle']")
	private WebElement authorisedTitle;
	
	//OTHER INFORMATION
	@FindBy(xpath = "//input[@name='estimatedOfGames']")
	private WebElement estimatedGames;
	
	@FindBy(xpath = "//input[@name='estimatedOfGamers']")
	private WebElement estimatedGamers;
	
	@FindBy(xpath = "//input[@name='gameGrowth']")
	private WebElement gameGrowth;
	
	@FindBy(xpath = "//input[@name='gamersGrowth']")
	private WebElement gamerGrowth;
	
	@FindBy(xpath = "gamersGrowth")
	private List<WebElement> radioButtons;
	

	
	
	/**
	 * Description - Navigating to change password page.
	 * @return - true - if admin lands successfully on setting page.
	 */
	public boolean navigateToEditProfilePage() {
		try {
			boolean flag = settingsTab.isDisplayed();
			settingsTab.click();
			WaitClass.waitForTime(1000);
			flag = flag && legalEntityLabel.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - navigateToEditProfilePage : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating text fields are disabled or not.
	 * @return - true - if all text fields are disabled.
	 */
	public boolean validateAllTextFieldsDisabled() {
		try {
			boolean flag = legalEntityField.isEnabled();
			flag = flag && categoryField.isEnabled();
			flag = flag && resonToJoinQxField.isEnabled();
			return (!(flag));
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - validateAllTextFieldsDisabled : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating upload log.
	 * @return - true - if Logo updated successfully.
	 */
	public boolean uploadLogoAction() {
		try {
			new Actions(driver).click(uploadLogo).build().perform();
			WaitClass.waitForTime(2000);
			Utility.uploadFileWithRobot(Utility.getPropertiesFile("primaryLogin", "partnerLogo"));
			updateButton.click();
			boolean flag = updateSuccessMessage.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - uploadLogoAction : " + e);
			return false;
		}
	}
	
	/**
	 * Description - validating contact information edit and update action.
	 * @return - true - if details updated successfully.
	 */
	public boolean contactInformationUpdateAction() {
		try {
			driver.findElement(By.xpath("//a[text()='Contact Information']")).click();
			WaitClass.waitForTime(2000);
			String address = addressLine1.getAttribute("value");
			addressLine1.clear();
			addressLine1.sendKeys(address);
			String primaryname = namePrimary.getAttribute("value");
			namePrimary.clear();
			namePrimary.sendKeys(primaryname);
			String primarytitle = titlePrimary.getAttribute("value");
			titlePrimary.clear();
			titlePrimary.sendKeys(primarytitle);
			boolean flag = authorisedName.isEnabled();
			flag = flag && authorisedTitle.isEnabled();
			updateButton.click();
			boolean flag1 = updateSuccessMessage.isDisplayed();
			return (!(flag)) && flag1;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - contactInformationUpdateAction : " + e);
			return false;
		}
	}
	
	/**
	 * Description - other information details editable validation.
	 * @return - true - if all fields disabled.
	 */
	public boolean otherInformationEditablefieldsValidation() {
		try {
			driver.findElement(By.xpath("//a[text()='Other Information']")).click();
			boolean flag = estimatedGames.isEnabled();
			flag = flag && estimatedGamers.isEnabled();
			flag = flag && gameGrowth.isEnabled();
			flag = flag && gamerGrowth.isEnabled();
			for(int i = 0; i < (radioButtons.size()); i++) {
				flag = flag && radioButtons.get(i).isEnabled();
			}
			updateButton.click();
			return (!(flag));
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - otherInformationEditablefieldsValidation : " + e);
			return false;
		}
	}

	
	/**
	 * Description - other information details update validation.
	 * @return - true - if details updated successfully.
	 */
	public boolean otherInformationUpdateValidation() {
		try {
			driver.findElement(By.xpath("//a[text()='Other Information']")).click();
			boolean flag = estimatedGames.isEnabled();
			flag = flag && estimatedGamers.isEnabled();
			flag = flag && gameGrowth.isEnabled();
			flag = flag && gamerGrowth.isEnabled();
			for(int i = 0; i < (radioButtons.size()); i++) {
				flag = flag && radioButtons.get(i).isEnabled();
			}
			updateButton.click();
			boolean flag1 = updateSuccessMessage.isDisplayed();
			return (!(flag)) && flag1;
		} catch (Exception e) {
			System.err.println("Exception in Class - Edit_Profile_Partner, Method - otherInformationUpdateValidation : " + e);
			return false;
		}
	}


}
