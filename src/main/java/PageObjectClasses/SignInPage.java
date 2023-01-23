package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignInPage {
	
	private WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//*[contains(text() = 'Facebook')]")
	private WebElement signInWithFacebookBtn;
	
	@FindBy(xpath = "//*[contains(text() = 'Google')]")
	private WebElement signInWithGoogleBtn;
	
	/**
	 * Method to check the elements on Sign In page.
	 * @param user - Integer type parameter. 1 = Admin and 2 = Partner
	 * @return - true if all elements are found.
	 */
	public boolean checkSignInPage(int user) {
		try {
			WebElement signInHostElement = driver.findElement(By.xpath("//amplify-sign-in"));
			SearchContext shadowRoot = signInHostElement.getShadowRoot();
			
			boolean flag = shadowRoot.findElement(By.cssSelector("h3.header")).getText().equals("Sign In");
			flag = flag && shadowRoot.findElement(By.cssSelector("label[for = 'username']")).getText().equals("Username *");
			flag = flag && shadowRoot.findElement(By.cssSelector("label[for = 'password']")).getText().equals("Password *");
			flag = flag && shadowRoot.findElement(By.cssSelector("#username.input")).isDisplayed();
			flag = flag && shadowRoot.findElement(By.cssSelector("#password.input")).isDisplayed();
			flag = flag && shadowRoot.findElement(By.cssSelector("div.sign-in-form-footer")).isDisplayed();
			flag = flag && shadowRoot.findElement(By.cssSelector("amplify-button[data-test='sign-in-forgot-password-link']")).isDisplayed();
			if(user == 2) {
				flag = flag && shadowRoot.findElement(By.cssSelector("amplify-button[data-test='sign-in-create-account-link']")).isDisplayed();
			}
			
			return flag;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkSignInPage, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the login with Facebook and google is not available.
	 * @return - true if if not available.
	 */
	public boolean checkSignInPageForFacebookOrGoogle() {
		try {
			try {
				signInWithFacebookBtn.isDisplayed();
				return false;
			}
			catch(Exception e) {}
			try {
				signInWithGoogleBtn.isDisplayed();
				return false;
			}
			catch(Exception e) {}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkSignInPageForFacebookOrGoogle, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to perform sign in actions.
	 * @param username - String type parameter. The user name.
	 * @param password - String type parameter. The password.
	 * @return - true if all the actions are performed.
	 */
	public boolean signIn(String username, String password) {
		try {
			WebElement signInHostElement = driver.findElement(By.xpath("//amplify-sign-in"));
			SearchContext shadowRoot = signInHostElement.getShadowRoot();
			
			if(username.length()>0) {
				WebElement usernameField = shadowRoot.findElement(By.cssSelector("#username.input"));
				usernameField.sendKeys(username);
			}
			if(password.length()>0) {
				WebElement passwordField = shadowRoot.findElement(By.cssSelector("#password.input"));
				passwordField.sendKeys(password);
			}
			WebElement signInBtn = shadowRoot.findElement(By.cssSelector("button[type='submit']"));
			Utility.javaScriptClick(signInBtn, driver);
			
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - signIn, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to validate the sign in action.
	 * @param username - String type parameter. The user name.
	 * @param user - Integer type parameter. 1 = Admin , 2 = Partner
	 * @return - true or false according to the action.
	 */
	public boolean validateSignIn(String name, int user) {
		try {
			if(user == 1) {
				return driver.findElement(By.xpath("//h3[text() = '"+name+"']")).isDisplayed();
			}
			else {
				return driver.findElement(By.xpath("//h4[text() = '"+name+"']")).isDisplayed();
			}
				
		}
		catch(Exception e) {
			System.err.println("Exception in Method - validateSignIn, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check the validation messages.
	 * @param blankUsername - Boolean type parameter. true when login button is clicked with user name field blank.
	 * @param blankPassword - Boolean type parameter. true when login button is clicked with password field blank.
	 * @param wrongCreds - Boolean type parameter. true when login button is clicked with wrong credentials filled.
	 * @param charLimit - Boolean type parameter. true when user name field has more than 128 characters.
	 * @param noInternet - Boolean type parameter. true when login is tried without connectivity.
	 * @return - true if validation messages matches.
	 */
	public boolean checkValidationMessages(boolean blankUsername, boolean blankPassword, boolean wrongCreds, boolean charLimit, boolean noInternet) {
		try {
			WebElement signInHostElement = driver.findElement(By.xpath("//amplify-sign-in"));
			SearchContext shadowRoot = signInHostElement.getShadowRoot();
			if(blankUsername == true) {
				String validation = Utility.getValidation(1);	
				WebElement usernameField = shadowRoot.findElement(By.cssSelector("#username.input"));
				String extractedValidation = usernameField.getAttribute("validationMessage").trim();
				return validation.equals(extractedValidation);
			}
			else if(blankPassword == true) {
				String validation = Utility.getValidation(1);
				WebElement passwordField = shadowRoot.findElement(By.cssSelector("#password.input"));
				String extractedValidation = passwordField.getAttribute("validationMessage").trim();
				return validation.equals(extractedValidation);
			}
			else if(wrongCreds == true) {
				signInHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
				shadowRoot = signInHostElement.getShadowRoot();
				WaitClass.waitForTime(5000);
				WebElement signInHostElement2 = shadowRoot.findElement(By.cssSelector("amplify-toast"));
				SearchContext shadowRoot2 = signInHostElement2.getShadowRoot();
				String toastMessage = Utility.getValidation(2);
				WebElement toast = shadowRoot2.findElement(By.cssSelector("div.toast span"));
				String extractedToastMessage = toast.getText().trim();
				return toastMessage.equals(extractedToastMessage);
			}
			else if(charLimit == true) {
				signInHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
				shadowRoot = signInHostElement.getShadowRoot();
				WaitClass.waitForTime(5000);
				WebElement signInHostElement2 = shadowRoot.findElement(By.cssSelector("amplify-toast"));
				SearchContext shadowRoot2 = signInHostElement2.getShadowRoot();
				String toastMessage = Utility.getValidation(3);
				WebElement toast = shadowRoot2.findElement(By.cssSelector("div.toast span"));
				String extractedToastMessage = toast.getText().trim();
				return toastMessage.equals(extractedToastMessage);
			}
			else if(noInternet == true) {
				signInHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
				shadowRoot = signInHostElement.getShadowRoot();
				WaitClass.waitForTime(5000);
				WebElement signInHostElement2 = shadowRoot.findElement(By.cssSelector("amplify-toast"));
				SearchContext shadowRoot2 = signInHostElement2.getShadowRoot();
				String toastMessage = Utility.getValidation(4);
				WebElement toast = shadowRoot2.findElement(By.cssSelector("div.toast span"));
				String extractedToastMessage = toast.getText().trim();
				return toastMessage.equals(extractedToastMessage);
			}
			return false;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - checkValidationMessages, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to click the reset password link on the sign in screen.
	 * @return - True if clicked.
	 */
	public boolean clickResetPasswordLink() {
		try {
			WebElement signInHostElement = driver.findElement(By.xpath("//amplify-sign-in"));
			SearchContext shadowRoot = signInHostElement.getShadowRoot();
			
			WebElement forgotPasswordLink = shadowRoot.findElement(By.cssSelector("amplify-button[data-test='sign-in-forgot-password-link']"));
			forgotPasswordLink.click();
			
			WaitClass.waitForTime(3000);
			
			WebElement forgotPasswordHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
			SearchContext searchRoot = forgotPasswordHostElement.getShadowRoot();
			
			WebElement root = searchRoot.findElement(By.cssSelector("amplify-forgot-password"));
			SearchContext shadowRootForgotPassword = root.getShadowRoot();
			
			WebElement forgotPasswordHeading = shadowRootForgotPassword.findElement(By.cssSelector("h3.header"));
			return forgotPasswordHeading.getText().equals("Reset your password");
		}
		catch(Exception e) {
			System.err.println("Exception in Method - clickResetPasswordLink, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to perform action on the enter user name screen of reset password.
	 * @param username - String type parameter. The user name of the user.
	 * @param validationCheck - Boolean type parameter. true if want to check validation, false if want to send code email.
	 * @return - true if action follows.
	 */
	public boolean usernameFieldInResetPassword(String username, boolean validationCheck) {
		try {
			WebElement forgotPasswordHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
			SearchContext searchRoot = forgotPasswordHostElement.getShadowRoot();
			
			WebElement root = searchRoot.findElement(By.cssSelector("amplify-forgot-password"));
			SearchContext shadowRootForgotPassword = root.getShadowRoot();
			
			WebElement usernameField = shadowRootForgotPassword.findElement(By.cssSelector("#username.input"));
			usernameField.sendKeys(username);
			
			WebElement sendCodeBtn = shadowRootForgotPassword.findElement(By.cssSelector("amplify-button[data-test = 'forgot-password-forgot-password-button']"));
			sendCodeBtn.click();
			
			if(validationCheck == true) {
				String validation = Utility.getValidation(1);
				String extractedValidation = usernameField.getAttribute("validationMessage").trim();
				return validation.equals(extractedValidation);
			}
			else {
				WaitClass.waitForTime(5000);
				WebElement forgotPasswordHostElement2 = driver.findElement(By.xpath("//amplify-authenticator"));
				SearchContext searchRoot2 = forgotPasswordHostElement2.getShadowRoot();
				
				WebElement root2 = searchRoot2.findElement(By.cssSelector("amplify-forgot-password"));
				SearchContext shadowRootForgotPassword2 = root2.getShadowRoot();
				return shadowRootForgotPassword2.findElement(By.cssSelector("input#code.input")).isDisplayed();
				
			}
		}
		catch(Exception e) {
			System.err.println("Exception in Method - usernameFieldInResetPassword, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to click the back to sign in link on enter user name screen of reset password
	 * @return - true if redirects to sign in screen
	 */
	public boolean backToSignInResetPasswordEmailScreen() {
		try {
			WebElement forgotPasswordHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
			SearchContext searchRoot = forgotPasswordHostElement.getShadowRoot();
			
			WebElement root = searchRoot.findElement(By.cssSelector("amplify-forgot-password"));
			SearchContext shadowRootForgotPassword = root.getShadowRoot();
			
			WebElement backToSignInLink = shadowRootForgotPassword.findElement(By.cssSelector("amplify-button[data-test = 'forgot-password-back-to-sign-in-link']"));
			backToSignInLink.click();
			
			return driver.findElement(By.xpath("//amplify-sign-in")).isDisplayed();
		}
		catch(Exception e) {
			System.err.println("Exception in Method - backToSignInResetPasswordEmailScreen, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to click the back to sign in link on enter code screen.
	 * @return - true if redirects to sign in screen
	 */
	public boolean backToSignInResetPasswordCodeScreen() {
		try {
			WebElement forgotPasswordHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
			SearchContext searchRoot = forgotPasswordHostElement.getShadowRoot();
			
			WebElement root = searchRoot.findElement(By.cssSelector("amplify-forgot-password"));
			SearchContext shadowRootForgotPassword = root.getShadowRoot();
			
			shadowRootForgotPassword.findElement(By.cssSelector("input#code.input")).isDisplayed();
			
			WebElement backToSignInLink = shadowRootForgotPassword.findElement(By.cssSelector("amplify-button[data-test = 'forgot-password-back-to-sign-in-link']"));
			backToSignInLink.click();
			
			return driver.findElement(By.xpath("//amplify-sign-in")).isDisplayed();
		}
		catch(Exception e) {
			System.err.println("Exception in Method - backToSignInResetPasswordCodeScreen, Class - SignInPage : "+e);
			return false;
		}
	}
	
	/**
	 * Method to create password.
	 * @param code - String type parameter. The code extracted from email.
	 * @param password - String type parameter. The password.
	 * @param isValidCode - Boolean type parameter. true if valid code is entered.
	 * @return - true if successfully changes password.
	 */
	public boolean fillCodePasswordResetPassword(String code, String password, boolean isValidCode) {
		try {
			WebElement forgotPasswordHostElement = driver.findElement(By.xpath("//amplify-authenticator"));
			SearchContext searchRoot = forgotPasswordHostElement.getShadowRoot();
			
			WebElement root = searchRoot.findElement(By.cssSelector("amplify-forgot-password"));
			SearchContext shadowRootResetPassword = root.getShadowRoot();
			
			WebElement codeField = shadowRootResetPassword.findElement(By.cssSelector("input#code.input"));
			codeField.sendKeys(code);
			
			WebElement passwordField = shadowRootResetPassword.findElement(By.cssSelector("input#code.input"));
			passwordField.sendKeys(password);
			
			WebElement submitBtn = driver.findElement(By.cssSelector("amplify-button[data-test = forgot-password-forgot-password-button]"));
			submitBtn.click();
			
			if(isValidCode == true) {
				return driver.findElement(By.xpath("//amplify-sign-in")).isDisplayed();
			}
			else {
				WebElement signInHostElement2 = shadowRootResetPassword.findElement(By.cssSelector("amplify-toast"));
				SearchContext shadowRoot2 = signInHostElement2.getShadowRoot();
				String toastMessage = Utility.getValidation(5);
				WebElement toast = shadowRoot2.findElement(By.cssSelector("div.toast span"));
				String extractedToastMessage = toast.getText().trim();
				return toastMessage.equals(extractedToastMessage);
			}
		}
		catch(Exception e) {
			System.err.println("Exception in Method - fillCodePasswordResetPassword, Class - SignInPage : "+e);
			return false;
		}
	}

}
