package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.asserts.SoftAssert;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignIn_Partner_Pages {
	WebDriver driver;
	SoftAssert softassert;

	public SignIn_Partner_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	// # Sign In Page All WebElement
	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement AcQyrLogo;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement SignInHeaderButton;
	@FindBy(xpath = "//button[contains(text(),'Create Account')]")
	private WebElement CreateAccountHeaderButton;
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
	@FindBy(xpath = "//span[text()='Sign Out']")
	private WebElement SignOutButton;
	@FindBy(xpath = "//p[contains(text(),'Are you sure you want to Sign Out?')]")
	private WebElement PopUpSignOutMsg;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement ConfirmButton;

	/**
	 * Description - Verify that All WebElement Are Visible on Partner Sign In Page
	 * .
	 * 
	 * @return - True - If all Web Elements are visible.
	 */
	public boolean AllWebElementDisplayedPartnerSignIn() {

		try {
			boolean flag = AcQyrLogo.isDisplayed();
			flag = flag && SignInHeaderButton.isDisplayed();
			flag = CreateAccountHeaderButton.isDisplayed();
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
	public boolean signinActionPartner(String username, String password) {
		UserNameField.clear();
		try {
			if (username.length() > 0) {
				UserNameField.sendKeys(username);
			}
			PasswordField.clear();
			if (password.length() > 0) {
				PasswordField.sendKeys(password);
			}

			/*EyeButton.click();
			String passwordAfterClickOnEye = driver
					.findElement(By.xpath("(//input[@class='amplify-input amplify-field-group__control'])[2]"))
					.getAttribute("value");
			String expected = "Test@1234567";
			softassert.assertEquals(passwordAfterClickOnEye, expected);
			softassert.assertAll();
			*/

			EyeButton.click();
//			String passwordAfterClickOnEye = driver
//					.findElement(By.xpath("(//input[@class='amplify-input amplify-field-group__control'])[2]"))
//					.getAttribute("value");
//			String expected = "Test@1234567";
//			softassert.assertEquals(passwordAfterClickOnEye, expected);
//			softassert.assertAll();

			SignInGreenButton.click();
//			boolean Landonpage = driver.findElement(By.xpath("//div[@class='logo-box']//img[@alt='logo']"))
//					.isDisplayed();
			WaitClass.waitForTime(10000);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Method - signinActionPartner, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}

	/**
	 * Method to perform Validation for Sign In on Partner.
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
	 * Description - Verify that Sign Out is Successful on Partner. .
	 * 
	 * @return - True - If Sign Out is Successful on Partner
	 */
	public boolean SignOutPartner() {
		try {
			driver.findElement(By.xpath("//h4[text()='Settings']")).click();
			Utility.javaScriptClick(SignOutButton, driver);
			boolean signOutMsgPopup = PopUpSignOutMsg.isDisplayed();
			Utility.javaScriptClick(ConfirmButton, driver);
			signOutMsgPopup = AcQyrLogo.isDisplayed();
			return true && signOutMsgPopup;
		} catch (Exception e) {

			System.err.println("Exception in Method - SignOutPartner, Class - SignIn_Partner_Pages : " + e);
			return false;
		}
	}
}
