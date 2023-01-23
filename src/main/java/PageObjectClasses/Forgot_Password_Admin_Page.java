package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class Forgot_Password_Admin_Page {
	public Forgot_Password_Admin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Elements Locators
	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Code']")
	private WebElement CodeField;
	@FindBy(xpath = "//h3[contains(text(),'Reset your password')]")
	private WebElement resetPasswordText;
	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement NewPasswordFiled;
	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement logo;
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement ConfirmPasswordFiled;
	@FindBy(xpath = "//button[contains(text(),'Send code')]")
	private WebElement SEndCodeButton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement SubMitButton;
	@FindBy(xpath = "//button[contains(text(),'Back to Sign In')]")
	private WebElement BackToSignInPage;
	@FindBy(xpath = "//button[contains(text(),'Forgot your password?')]")
	private WebElement forgotyourPasswordButton;
	@FindBy(xpath = "//button[contains(text(),'Resend Code')]")
	private WebElement ResendCode;
	@FindBy(xpath = "//div[@data-variation='default']//div[2]//div[1]//div[2]//button[1]")
	private WebElement NewPassEyeButton;
	@FindBy(xpath = "//div[3]//div[1]//div[2]//button[1]")
	private WebElement ConfirmPassEyeButton;

	public boolean logInPage() {
		try {
			WaitClass.waitForTime(2000);
			forgotyourPasswordButton.click();
			return resetPasswordText.isDisplayed();
		} catch (Exception e) {
			System.err.println("Exception in method - logInPage, class - Forgot_Password_Admin_Page" + e);
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
			flag = flag && resetPasswordText.isDisplayed();
			flag = flag && logo.isDisplayed();
			flag = flag && SEndCodeButton.isDisplayed();
			flag = flag && BackToSignInPage.isDisplayed();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - checkelements, class - Forgot_Password_Admin_Page" + e);
			return false;
		}

	}

	/**
	 * Description - Checking reset password button
	 * 
	 * @return - true- if visible
	 */
	public boolean checkResetPasswordButton() {

		try {

			boolean flag = resetPasswordText.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err
					.println("Exception in method - checkResetPasswordButton, class - Forgot_Password_Admin_Page" + e);
			return false;
		}

	}

	/**
	 * Description - Checking Forgot Password form action
	 * 
	 * @return - True, if action works correctly
	 */
	public boolean forgotPassword(String userName1) {

		try {
			userNameField.clear();
			userNameField.sendKeys(userName1);
			SEndCodeButton.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - forgotPassword, class - Forgot_Password_Admin_Page" + e);
			return false;
		}
	}

	/**
	 * Description - Checking Forgot Password form action without filling username
	 * field
	 * 
	 * @return - true, if validation msg shown correctly.
	 */
	public boolean forgotPasswordBlankField(String userName2) {

		try {
			userNameField.clear();
			userNameField.sendKeys(userName2);
			SEndCodeButton.click();
			String validation = "Please fill";
			String extractedValidation = userNameField.getAttribute("validationMessage");
			return extractedValidation.contains(validation);
		} catch (Exception e) {
			System.err
					.println("Exception in method - forgotPasswordBlankField, class - Forgot_Password_Admin_Page" + e);
			return false;
		}
	}

	/**
	 * Description - Checking Elements on Forgot password page
	 * 
	 * @return - True if all Elements are visible
	 */
	public boolean checkElementsOnResetPassword() {

		try {

			boolean flag = resetPasswordText.isDisplayed();
			flag = flag && CodeField.isDisplayed();
			flag = flag && NewPasswordFiled.isDisplayed();
			flag = flag && ConfirmPasswordFiled.isDisplayed();
			flag = flag && SubMitButton.isDisplayed();
			flag = flag && ResendCode.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - checkelementsOnResetPassword, class - Forgot_Password_Admin_Page" + e);
			return false;
		}

	}

	/**
	 * Description - Verify that Forgot Password or Password has been Created
	 * Successfully.
	 * 
	 * 
	 * @return -true-If Forgot Password or Password has been Created Successfully.
	 * 
	 */
	public boolean FillResetPassDetails(String NewPassword, String ConfirmPassword) {
		try {
			boolean flag = false;
			NewPasswordFiled.clear();
			NewPasswordFiled.sendKeys(NewPassword);
			if (NewPassEyeButton.isEnabled()) {
				NewPassEyeButton.click();
				flag = true;
			}

			ConfirmPasswordFiled.clear();
			ConfirmPasswordFiled.sendKeys(ConfirmPassword);
			if (ConfirmPassEyeButton.isEnabled()) {
				ConfirmPassEyeButton.click();
				
				flag = true;
			}
			SubMitButton.click();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - FillResetPassDetails, Class - Forgot_Password_Admin_Page : " + e);
			return false;
		}

	}

	/**
	 * Description - Checking user landing on dashboard after successful forgot
	 * password the code.
	 * 
	 * @param code - Code sent to email for confirmation.
	 * @return True - if user land on dashboard.
	 */
	public boolean ConfirmAccountResend(String code) {

		try {
			CodeField.click();
			CodeField.clear();
			CodeField.sendKeys(code);
		

			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - ConfirmAccount, class - Forgot_Password_Admin_Page :" + e);
			return false;
		}
	}

}
