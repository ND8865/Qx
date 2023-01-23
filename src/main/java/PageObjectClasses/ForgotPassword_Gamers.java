package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class ForgotPassword_Gamers {

	public ForgotPassword_Gamers(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Elements Locators
	@FindBy(xpath = "//input[@id=\"username\"]")
	private WebElement userNameField;

	@FindBy(xpath = "//button[@name='reset_my_password']")
	private WebElement resetPasswordButton;

	@FindBy(xpath = "//img[@class=\"logo-customizable\"]")
	private WebElement logo;

	@FindBy(xpath = "//h1")
	private WebElement forgotYourPasswordTxt;

	@FindBy(xpath = "//span")
	private WebElement resetPasswordGuideTxt;
	
	@FindBy(xpath = "(//a[@class=\"redirect-customizable\"])[2]")
	private WebElement forgetPasswordLink;
	
	
	public boolean logInPage(){
		try {
			WaitClass.waitForTime(2000);
			forgetPasswordLink.click();
			return resetPasswordButton.isDisplayed();
		} catch (Exception e) {
			System.err.println("Exception in method - checkElements, class - ForgotPassword_Gamers" + e);
			return false;
		}
		
	}
	

	/**
	 * Description - Checking Elements on Forgot password page
	 * 
	 * @return - True if all Elements visible
	 */
	public boolean checkelements() {

		try {

			boolean flag = userNameField.isDisplayed();
			flag = flag && resetPasswordButton.isDisplayed();
			flag = flag && logo.isDisplayed();
			flag = flag && forgotYourPasswordTxt.isDisplayed();
			flag = flag && resetPasswordGuideTxt.isDisplayed();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - checkElements, class - ForgotPassword_Gamers" + e);
			return false;
		}

	}
	/**
	 * Description - Checking reset password button
	 * @return - true- if visible
	 */
	public boolean checkResetPasswordButton() {

		try {

			boolean flag = resetPasswordButton.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in method - checkElements, class - ForgotPassword_Gamers" + e);
			return false;
		}

	}
/**
 * Description - Checking Forgot Password form action
 * @return - True, if action works correctly
 */
	public boolean forgotPassword(String userName1) {

		try {
			userNameField.clear();
			userNameField.sendKeys(userName1);
			resetPasswordButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - forgotPassword, class - ForgotPassword_Gamers" + e);
			return false;
		}
	}
/**
 * Description - Checking Forgot Password form action without filling username field
 * @return - true, if validation msg shown correctly.
 */
	public boolean forgotPasswordBlankField(String userName2) {

		try {
			userNameField.clear();
			userNameField.sendKeys(userName2);
			resetPasswordButton.click();
			String validation = "Please fill";
			String extractedValidation = userNameField.getAttribute("validationMessage");
			return extractedValidation.contains(validation);
		} catch (Exception e) {
			System.err.println("Exception in method - forgotPasswordBlankField, class - ForgotPassword_Gamers" + e);
			return false;
		}
	}
}
