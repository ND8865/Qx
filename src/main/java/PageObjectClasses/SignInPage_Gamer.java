package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class SignInPage_Gamer {
private WebDriver driver;
	
	public SignInPage_Gamer(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	SignIn locator
	
	@FindBy(xpath="//div[@class='container']")
	WebElement signInHostElement;
	
	@FindBy(xpath="(//img[@class='logo-customizable'])[2]")
	private WebElement logo;
	
	@FindBy(xpath="(//span[text()='Sign in with your username and password'])[2]")
	private WebElement signinText;
	
	@FindBy(xpath="(//label[text()='Username'])[2]")
	private WebElement usernameLabel;
	
	@FindBy(xpath="(//input[@id='signInFormUsername'])[2]")
	private WebElement usernameField;
	
	@FindBy(xpath="(//label[text()='Password'])[2]")
	private WebElement passwordLabel;
	
	@FindBy(xpath="(//input[@id='signInFormPassword'])[2]")
	private WebElement passwordField;
	
	@FindBy(xpath="(//a[text()='Forgot your password?'])[2]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="(//input[@name='signInSubmitButton'])[2]")
	private WebElement signInButton;
	
	@FindBy(xpath="(//span[text()='Need an account?'])[2]")
	private WebElement needAnAccount;
	
	@FindBy(xpath="(//a[text()='Sign up'])[2]")
	private WebElement signupLink;
	
	@FindBy(xpath="(//span[text()='Sign In with your social account'])[2]")
	private WebElement socialSignin;
	
	@FindBy(xpath="(//button[@name='googleSignUpButton'])[2]")
	private WebElement signInWithGoogle;
	
	
	@FindBy(xpath="(//span[@class='legalText-customizable'])[2]")
	private WebElement text;
	
	
	@FindBy(xpath="//div[@class='modal-content background-customizable modal-content-mobile visible-md visible-lg']")
	WebElement userSignInHostElement;
	
	@FindBy(xpath="(//div[@class='banner-customizable'])[2]")
	WebElement logo1;
	
	@FindBy(xpath="(//button[@class='btn btn-primary submitButton-customizable'])[2]")
	WebElement signInAsUser;
	
	@FindBy(xpath="(//p[@class='redirect-customizable'])[2]")
	WebElement differentUser;
	
//	Dashboard locator
	
	@FindBy(xpath="//h4[text()='Welcome to your dashboard.']")
	WebElement dashboard;
	
/**
 * Method to check the elements on Sign In page.
 * @return - true if all elements are found.
 */
	public boolean displayCheckSignInElement() {
		try {
			boolean flag = signInHostElement.isDisplayed();
			flag = flag && logo.isDisplayed();
			flag = flag && signinText.isDisplayed();
			flag = flag && usernameLabel.isDisplayed();
			flag = flag && usernameField.isDisplayed();
			flag = flag && passwordLabel.isDisplayed();
			flag = flag && passwordField.isDisplayed();
			flag = flag && forgotPasswordLink.isDisplayed();
			flag = flag && signInButton.isDisplayed();
			flag = flag && needAnAccount.isDisplayed();
			flag = flag && signupLink.isDisplayed();
			flag = flag && socialSignin.isDisplayed();
			flag = flag && signInWithGoogle.isDisplayed();
			flag = flag && text.isDisplayed();
			return flag;
		}catch(Exception e) {
			 System.err.println("Class - SignInPage_Gamer and Method - displayCheckSignInElement"+e);
			 return false;
		}
	}
	/**
	 * Method to perform sign in actions.
	 * @param username
	 * @param password
	 * @return - true if all the actions are performed.
	 */
	public boolean signinAction(String username, String password){
		usernameField.clear();
		try {
			if(username.length()>0) {
				usernameField.sendKeys(username);
			}
			passwordField.clear();
			if(password.length()>0) {
			    passwordField.sendKeys(password);
			}
			signInButton.click();
			WaitClass.waitForTime(10000);
			return true;
		}catch(Exception e){
			 System.err.println("Class - SignInPage_Gamer and Method - signinAction"+e);
            return false;
		}
	}
	/**
	 * Method to check the validation messages.
	 * @param blankUsername - Boolean type parameter. true when login button is clicked with user name field blank.
	 * @param blankPassword - Boolean type parameter. true when login button is clicked with password field blank.
	 * @param wrongCredentials - Boolean type parameter. true when login button is clicked with wrong credentials filled.
	 * @param charLimit - Boolean type parameter. true when user name field has more than 128 characters.
	 * @return - true if validation messages matches.
	 */
	public boolean checkValidationMessages(boolean blankUsername, boolean blankPassword,boolean wrongCredentials, boolean charLimit){
		try {
			signInHostElement.isDisplayed();
			if(blankUsername == true) {
				signInButton.click();
				String extractedValidation = usernameField.getAttribute("validationMessage");
				String validation ="Please fill";
				return extractedValidation.contains(validation);
			}
			else if(blankPassword==true) {
				signInButton.click();
				String extractedValidation = passwordField.getAttribute("validationMessage");
				String validation ="Please fill";
				return extractedValidation.contains(validation);
			}
			else if(wrongCredentials==true) {
				signInHostElement.isDisplayed();
				WaitClass.waitForTime(5000);
				return driver.findElement(By.xpath("(//p[text()='Incorrect username or password.'])[2]")).isDisplayed();
			}
			else if(charLimit == true) {
				signInHostElement.isDisplayed();
				WaitClass.waitForTime(5000);
				return driver.findElement(By.xpath("(//p[contains(text(),'1 validation error detected:')])[2]")).isDisplayed();
			}
			return false;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkValidationMessages, Class - SignInPage_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to validate the sign in actions.
	 * @return - true if the actions are performed.
	 */
	public boolean validateSignIn() {
		try {
			WaitClass.waitForTime(4000);
			return dashboard.isDisplayed(); 
			
		}
		catch(Exception e) 
		{
			System.err.println("Exception in Method - validateSignIn, Class - SignInPage_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check display all the elements on the page
	 * @return - True if all element is displayed
	 */
	public boolean checkDisplaySignInAsUserOrDifferentUser() {
		try {
			boolean flag = userSignInHostElement.isDisplayed();
			flag = flag && logo1.isDisplayed();
			flag = flag && signInAsUser.isDisplayed();
			flag = flag && differentUser.isDisplayed();
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Method - checkDisplaySignInAsUserOrDifferentUser, Class - SignInPage_Gamer : "+e);
			return false;
		}
	}
	/**
	 * Method to signIn as user
	 * @return -True if signIn action performed
	 */
	public boolean checkSignInAsUser() {
		try {
			 signInAsUser.click();
			 return true;
		   } catch (Exception e) {
			System.err.println("Exception in Method - checkSignInAsUser, Class - SignInPage_Gamer : "+e);
			return false;
		}
	}
	/**
	 * Method to signIn as different user
	 * @return -True if signIn action performed
	 */
	public boolean checkSignInAsDifferentUser() {
		try {
			differentUser.click();
			return true;
		}catch(Exception e){
			System.err.println("Exception in Method - checkSignInAsDifferentUser, Class - SignInPage_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to perform actions click on Forgot Password Link.
	 * @return - true if the actions are performed.
	 */
	public boolean checkForgotPasswordLink(){
		try {
			forgotPasswordLink.click();
			return true;
		}catch(Exception e) {
			System.err.println("Class - SignInPage_Gamer and Method - checkForgotPasswordLink"+e);
			return false;
		}
	 }	
		/**
		 * Method to perform actions click on Sign Up Link.
		 * @return - true if the actions are performed.
		 */
		public boolean checkSignUpLink(){
			try {
				signupLink.click();
				return true;
			}catch(Exception e) {
				System.err.println("Class - SignInPage_Gamer and Method - checkSignUpLink"+e);
				return false;
			}
		}
		/**
		 * Method to check the login with google and FaceBook is available on signIn page.
		 * @return - true if both option is available on screen
		 */
	public boolean checkSignInForGoogleAndFacebook(){
		try {
			boolean flag = signInHostElement.isDisplayed();
			flag = flag && signInWithGoogle.isDisplayed();
			return flag;
		 }catch(Exception e) {
				System.err.println("Exception in Method - checkSignInForGoogleAndFacebook, Class - SignInPage_Gamer : "+e);
				return false;
	   }
   }
}
