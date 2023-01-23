package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class ChangePasswordPage_Gamers {

	public ChangePasswordPage_Gamers(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Elements Locators
	@FindBy(xpath = "//img[@class='logo-customizable']")
	private WebElement logo;

	@FindBy(xpath = "//span[@id='text-code']")
	private WebElement changePasswordMsg;

	@FindBy(xpath = "//label[@for='forgot_password_code']")
	private WebElement codeFieldHeading;

	@FindBy(xpath = "//input[@id='forgot_password_code']")
	private WebElement codeField;

	@FindBy(xpath = "//label[@for='new_password']")
	private WebElement newPasswordFieldHeading;

	@FindBy(xpath = "//input[@id='new_password']")
	private WebElement newPasswordFied;

	@FindBy(xpath = "//label[@for='confirm_password']")
	private WebElement confirmPassowdFieldHeading;

	@FindBy(xpath = "//input[@id='confirm_password']")
	private WebElement confirmPassowdField;

	@FindBy(xpath = "//button[@name='reset_password']")
	private WebElement changePasswordButton;

	@FindBy(xpath = "//p[@id='errorMessage']")
	private WebElement wrongCodeMessage;

	/**
	 * Description - Checking Elements on Change password page
	 * 
	 * @return - True if all Elements visible
	 */
	public boolean checkElementsChangePassword() {

		try {

			boolean flag = logo.isDisplayed();
			flag = flag && changePasswordMsg.isDisplayed();
			flag = flag && codeFieldHeading.isDisplayed();
			flag = flag && codeField.isDisplayed();
			flag = flag && newPasswordFieldHeading.isDisplayed();
			flag = flag && newPasswordFied.isDisplayed();
			flag = flag && confirmPassowdFieldHeading.isDisplayed();
			flag = flag && confirmPassowdField.isDisplayed();
			flag = flag && changePasswordButton.isDisplayed();
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - checkElementsChangePassword, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - checking if change password button is visible or not.
	 * @return -true - if change password button is visible.
	 */
	public boolean checkChangePasswordButton() {

		try {
			boolean flag = changePasswordButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - checkElementsChangePassword, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - Change Password Button Action
	 * 
	 * @param code           - Forgot Password Email code
	 * @param newPassword    - New Password
	 * @param confirmPasword - New Password Confirm
	 * @return - true, if change password action validated successfully.
	 */
	public boolean changePasswordFeature(String code, String newPassword, String confirmPasword) {

		try {
			codeField.clear();
			if(code.length()>0) {
				codeField.sendKeys(code);
			}
			newPasswordFied.clear();
			if(newPassword.length()>0) {
				newPasswordFied.sendKeys(newPassword);
			}
			confirmPassowdField.clear();
			if(confirmPasword.length()>0) {
				confirmPassowdField.sendKeys(confirmPasword);
			}
			changePasswordButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - changePasswordAnyFieldBlank, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - checking if change password button is enabled or not
	 * 
	 * @return -true - if button is disabled
	 */
	public boolean isChangePasswordButtonEnabled() {

		try {
			return changePasswordButton.isEnabled();
		} catch (Exception e) {
			System.err.println("Exception in method - isChangePasswordButtonEnabled, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - checking blank field validation message showing or not
	 * 
	 * @return -true - if blank field validation message showing matching
	 */
	public boolean blankFieldMessageValidation() {

		try {
			String validation = "Please fill";
			String extractedValidation = codeField.getAttribute("validationMessage");
			return extractedValidation.contains(validation);
		} catch (Exception e) {
			System.err.println("Exception in method - blankFieldMessageValidation, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - checking wrong code validation message.
	 * 
	 * @return -true - if wrong code validation message shown.
	 */
	public boolean wrongCodeErrorMessage() {

		try {
			WaitClass.waitForTime(5000);
			boolean flag = wrongCodeMessage.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - wrongCodeErrorMessage, class - ChangePasswordPage_Gamers" + e);
			return false;
		}
	}
}
