package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts_Gamer {


	public Accounts_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement changeNewPassword_Bt;

	@FindBy(css = "[data-testid='currentPassword']")
	private WebElement currentPassword_Tb;

	@FindBy(css = "[data-testid='newPassword']")
	private WebElement newPassword_Tb;

	@FindBy(css = "[data-testid='confirmPassword']")
	private WebElement confirmNewPassword_Tb;

	@FindBy(xpath = "//button[text()='Update']")
	private WebElement update_Bt;

	@FindBy(xpath = "//div[contains(text(),'Password must')]")
	private WebElement errorMassage;

	@FindBy(xpath = "//div[contains(text(),'password do not match.')]")
	private WebElement passwordDonotMatch;

	@FindBy(xpath = "//div[contains(text(),'changed successfully')]")
	private WebElement succesMassage;

	@FindBy(xpath = "//div[contains(text(),'Incorrect username or password.')]")
	private WebElement incorrectMassage;

	@FindBy(xpath="//div[contains(text(),'Password must contain a lower case letter, an upper case letter, a special character, a number and at least 12 characters.')]")
	private WebElement policyErrorMassage;
	
	
	
	public boolean navigateToChangePassword() {
		try {
			changeNewPassword_Bt.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - navigateToChangePassword, class - ChangePasswordPage_Accounts" + e);
			return false;
		}
	}

	/**
	 * Description - Checking All WebElements on Change password page of Account
	 * 
	 * @return - True if all Elements visible
	 */

	public boolean checkElementVisibilty() {

		try {

			boolean flag = changeNewPassword_Bt.isDisplayed();
			flag = flag && currentPassword_Tb.isDisplayed();
			flag = flag && newPassword_Tb.isDisplayed();
			flag = flag && confirmNewPassword_Tb.isDisplayed();
			flag = flag && update_Bt.isDisplayed();

			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - checkElementsChangePassword, class - ChangePasswordPage_Accounts" + e);
			return false;
		}
	}

	/**
	 * Description - To Input Data in Current Password and new Password ,Confirm
	 * PAssword and click on update BT
	 * 
	 * @return - True if change password action successfully completed.
	 */

	public boolean inputCredintials(String currentPass, String newPassword,String confirmPass) {

		try {
			currentPassword_Tb.sendKeys(currentPass);
			newPassword_Tb.sendKeys(newPassword);
			confirmNewPassword_Tb.sendKeys(confirmPass);
			return true;
		}catch(Exception e) {
			System.err.println("Exception in method - inputCredintials, class - ChangePasswordPage_Accounts" + e);
			return false;
		}

	}

	/**
	 * Description - To Check Password must contains 12 character and confirm
	 * password and new password is matching or not
	 * 
	 * @return - True if validation msg shown correctly.
	 */

	public boolean validationOfPassworFields(boolean newPasswordAndConfirmPassSame,boolean newPasswordAndConfirmPassDiff, boolean lengthValidation, boolean dataSameInAllField,boolean protectedPass,boolean wrongCurrentPass,boolean excludeSpecialChar_Number_UpperCase) {
		try {
			update_Bt.click();
			if (newPasswordAndConfirmPassSame == true) {
				return succesMassage.isDisplayed();
			}
			if (newPasswordAndConfirmPassDiff == true) {
				return passwordDonotMatch.isDisplayed();
			}
			if (lengthValidation == true) {
				return errorMassage.isDisplayed();
			}
			if (dataSameInAllField == true) {
				return incorrectMassage.isDisplayed();
			}
			if(wrongCurrentPass==true) {
				return incorrectMassage.isDisplayed();
			}
			if(excludeSpecialChar_Number_UpperCase==true) {
				return policyErrorMassage.isDisplayed();
			}
			return false;
		} catch (Exception e) {
			System.err.println("Exception in method - validationOfPassworFields, class - ChangePasswordPage_Accounts" + e);
			return false;
		}

	}

}