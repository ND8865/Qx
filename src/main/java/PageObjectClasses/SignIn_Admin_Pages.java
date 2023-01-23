package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignIn_Admin_Pages {
	WebDriver driver;
	SoftAssert softassert;

	public SignIn_Admin_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	// # Sign In Page All WebElement ADMIN
	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement AcQyrLogo;
	@FindBy(xpath = "//label[contains(text(),'Username *')]")
	private WebElement UserNameHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement UserNameField;
	@FindBy(xpath = "//label[contains(text(),'Password *')]")
	private WebElement PasswordHeader;
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement PasswordField;
	@FindBy(xpath = "//button[@class='amplify-button amplify-field-group__control amplify-field__show-password']")
	private WebElement EyeButton;
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement SignInGreenButton;
	@FindBy(xpath = "//button[text()='Forgot your password?']")
	private WebElement ForgotPasswordButton;
	@FindBy(xpath = "//a[@class='signout-btn']")
	private WebElement SignOutButton;
	@FindBy(xpath = "//p[text()='Are you sure you want to Sign Out?']")
	private WebElement PopUpSignOutMsg;
	@FindBy(xpath = "//button[text()='Confirm']")
	private WebElement ConfirmButton;
	@FindBy(xpath = "//span[contains(text(), 'Email')]")
	private WebElement verifyEmailText;
	@FindBy(xpath = "//button[text() = 'Verify']")
	private WebElement verifyBtn;
	
	@FindBy(xpath = "//input[@name = 'confirmation_code']")
	private WebElement codeField;
	@FindBy(xpath = "//button[text() = 'Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//input[@name = 'password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@name = 'confirm_password']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//button[text() = 'Change Password']")
	private WebElement changePasswordBtn;

	/**
	 * Description - Verify that All WebElement Are Visible on ADMIN Sign In Page .
	 * 
	 * @return - True - If all Web Elements are visible.
	 */
	public boolean AllWebElementDisplayedPartnerSignIn() {

		try {
			boolean flag = AcQyrLogo.isDisplayed();
			flag = flag && UserNameHeader.isDisplayed();
			flag = flag && UserNameField.isDisplayed();
			flag = flag && PasswordHeader.isDisplayed();
			flag = flag && PasswordField.isDisplayed();
			flag = flag && EyeButton.isDisplayed();
			flag = flag && SignInGreenButton.isDisplayed();
			flag = flag && ForgotPasswordButton.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - AllWebElementDisplayedPartnerSignIn, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}

	/**
	 * Method to perform sign in actions.
	 * 
	 * @param username
	 * @param password
	 * @return - true if all the actions are performed.
	 */
	public boolean signinActionAdmin(String username, String password) {

		UserNameField.clear();

		try {

			if (username.length() > 0) {

				UserNameField.sendKeys(username);
			}

			PasswordField.clear();
			if (password.length() > 0) {

				PasswordField.sendKeys(password);
			}

			EyeButton.click();
			
			WaitClass.waitForTime(1000);
			SignInGreenButton.click();
			boolean Landonpage = driver.findElement(By.xpath("//div[@class='logo-box']//img[@alt='logo']"))
					.isDisplayed();
			return Landonpage;
		} catch (Exception e) {
			System.err.println("Exception in Method - signinActionPartner, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}

	/**
	 * Method to perform sign in actions.
	 * 
	 * @param username
	 * @param password
	 * @return - true if all the actions are performed.
	 */
	public boolean signinActionNewAdmin(String username, String password) {

		try {
			UserNameField.clear();
			if (username.length() > 0) {
				UserNameField.sendKeys(username);
			}
			PasswordField.clear();
			if (password.length() > 0) {
				PasswordField.sendKeys(password);
			}
			SignInGreenButton.click();
			WaitClass.waitForTime(1000);
			boolean flag = driver.findElement(By.xpath("//button[text()='Change Password']")).isDisplayed();

			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - signinActionPartner, Class - signinActionNewAdmin : " + e);
			return false;
		}
	}

	/**
	 * Method to perform Validation for Sign In on ADMIN.
	 * 
	 * @param boolean BlankUser Name , BlankPassword, Wrong Credentials
	 * @param
	 * @return - True if Validation is Successful
	 */
	public boolean ValidateSignIn(boolean BlankUser, boolean BlankPassword, boolean WrongCredentials) {

		try {
			if (BlankUser == true) {
				UserNameField.clear();
				SignInGreenButton.click();
				String extractedValidation = UserNameField.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}

			if (BlankPassword == true) {
				PasswordField.clear();
				SignInGreenButton.click();
				String extractedValidation = PasswordField.getAttribute("validationMessage");
				String validation = "Please fill in this field.";
				softassert.assertEquals(extractedValidation, validation);
				softassert.assertAll();
			}
			if (WrongCredentials == true) {
				WaitClass.waitForTime(1000);
				UserNameField.clear();
				WaitClass.waitForTime(1000);
				UserNameField.sendKeys("Anubha_partner");
				WaitClass.waitForTime(1000);
				PasswordField.clear();
				WaitClass.waitForTime(1000);
				PasswordField.sendKeys("Partner12345");
				WaitClass.waitForTime(1000);
				SignInGreenButton.click();
				WaitClass.waitForTime(1000);
				String Expected = driver.findElement(By.xpath("//div[@class='amplify-alert__body']")).getText();
				String Actual = "Incorrect username or password.";
				softassert.assertEquals(Actual, Expected);
				softassert.assertAll();
			}
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - ValidateSignIn, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}

	/**
	 * Description - Verify that Sign Out is Successful on ADMIN. .
	 * 
	 * @return - True - If Sign Out is Successful on ADMIN
	 */
	public boolean SignOutADMIN() {
		try {
			Utility.javaScriptClick(SignOutButton, driver);
			boolean signOutMsgPopup = PopUpSignOutMsg.isDisplayed();
			Utility.javaScriptClick(ConfirmButton, driver);
			boolean acQyrlogo = AcQyrLogo.isDisplayed();
			return acQyrlogo && signOutMsgPopup;
		} catch (Exception e) {

			System.err.println("Exception in Method - SignOutADMIN, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}
	
	public boolean signInChangePassword(String username, String oldPassword, String newPassword) {
		try {
			if (username.length() > 0) {

				UserNameField.sendKeys(username);
			}

			PasswordField.clear();
			if (oldPassword.length() > 0) {

				PasswordField.sendKeys(oldPassword);
			}

			EyeButton.click();
			
			WaitClass.waitForTime(1000);
			SignInGreenButton.click();
			changePasswordBtn.isDisplayed();
			passwordField.sendKeys(newPassword);
			confirmPasswordField.sendKeys(newPassword);
			changePasswordBtn.click();
			return driver.findElement(By.xpath("//span[text()='Admin Users']")).isDisplayed();
		}
		catch (Exception e) {
			System.err.println("Exception in Class - SignIn_Partner_Pages, Method - signInChangePassword : " + e);
			return false;
		}
	}
	
	public boolean signInWithCodeVerification(String username, String password) {

		UserNameField.clear();

		try {

			if (username.length() > 0) {

				UserNameField.sendKeys(username);
			}

			PasswordField.clear();
			if (password.length() > 0) {

				PasswordField.sendKeys(password);
			}

			EyeButton.click();
			
			WaitClass.waitForTime(1000);
			SignInGreenButton.click();
			
			verifyEmailText.isDisplayed();
			verifyEmailText.click();
			verifyBtn.click();
			
			return submitBtn.isDisplayed();
		} catch (Exception e) {
			System.err.println("Exception in Method - signInWithCodeVerification, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}
	
	public boolean verifyCode(String code) {
		try {
			codeField.sendKeys(code);
			submitBtn.click();
			boolean Landonpage = driver.findElement(By.xpath("//div[@class='logo-box']//img[@alt='logo']"))
					.isDisplayed();
			return Landonpage;
		}
		catch (Exception e) {
			System.err.println("Exception in Method - signInWithCodeVerification, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}
}
