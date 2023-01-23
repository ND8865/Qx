package TestScripts_Sprint01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignUp_Gamers;
import TestListners.CustomAssert;
import UtilityClass.Utility;

public class SignUp_Gamer_Tests {

	WebDriver driver;
	SignUp_Gamers SignUp_GamersPage;
	MailBox code;
	
	String UserNameGamer;
	String EmailGamer;
	int c;
	
	String PasswordGamer;
	
	String signedUserName = "";
	String signedEmail = "";
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		SignUp_GamersPage = new SignUp_Gamers(driver);
		code = new MailBox();
		
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count)+1;
		UserNameGamer = "qa_gamer131"+c;
		EmailGamer = "qa_gamer131"+c+"@1secmail.com";
		PasswordGamer = "Qwerty@12345678";
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Verify all elements are visible on sign up page")
	public void TSSHYB32() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag = SignUp_GamersPage.checkAllElementsSignUp();
		CustomAssert.assertTrue(flag,"All elements are present on Signup page","Missing Elements on signup  page");
	}
	
	@Test(description = "Verify if the user cannot proceed without filling all the mandatory fields." )
	public void TSSHYB33() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp("", "", "");
		CustomAssert.assertTrue(flag0, "Signup button working correctly", "Fail to click on signup button");
		boolean flag1 = SignUp_GamersPage.checkValidationSignUpGamer(true, false, false , false);
		CustomAssert.assertTrue(flag1, "User name validation msg shown fail to signup", "Validation msg not shown");
		
	}
	
	@Test(description = "Verify if the user cannot proceed without filling newPassword fields." )
	public void TSSHYB34() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp(UserNameGamer, "", PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signup page shown", "Fail to open signup page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		boolean flag1 = SignUp_GamersPage.checkValidationSignUpGamer(false, true, false , false);
		CustomAssert.assertTrue(flag1, "Email validation msg shown fail to signup", "Vlidation msg not shown");	
	}
	
	@Test(description = "Verify if the user cannot proceed without filling confirm password field." )
	public void TSSHYB35() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp(UserNameGamer, EmailGamer, "");
		CustomAssert.assertTrue(flag0, "Signup page shown", "Fail to open signup page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		boolean flag = SignUp_GamersPage.checkAllCrossPasswordValidation();
		CustomAssert.assertTrue(flag, "Password incorrect format validation working", "Password incorrect format validation not working");
		boolean flag1 = SignUp_GamersPage.checkAllPasswordValidationMsg();
		CustomAssert.assertTrue(flag1, "Password validatiom msg showing", "Password validatiom msg not showing");
		
	}
	
	@Test(description = "Verify if the user filled only text in email field and missed '@' in the email field" )
	public void TSSHYB36() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp(UserNameGamer, "anuj", PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signup page shown", "Fail to open signup page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		boolean flag1 = SignUp_GamersPage.checkValidationSignUpGamer(false, false, true , false);
		CustomAssert.assertTrue(flag1, "Email validation msg shown fail to signup", "Validation msg not shown");
		flag0 = SignUp_GamersPage.signUp(UserNameGamer, "anuj@", PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signup page shown", "Fail to open signup page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		flag1 = SignUp_GamersPage.checkValidationSignUpGamer(false, false, false , true);
		CustomAssert.assertTrue(flag1, "Email validation msg shown fail to signup", "Vlidation msg not shown");
	}
	

	@Test(description = "Verify if a user can sign-up successfully with all the mandatory details i.e. username, email address and password and check the elements of confirmation page and approve the OTP." )
	public void TSSHYB38() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		signedUserName = UserNameGamer;
		signedEmail = EmailGamer;
		boolean flag = SignUp_GamersPage.signUp(UserNameGamer, EmailGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "SignUp button clicked successfully", "Issue with Signup button");
		boolean flag1 = SignUp_GamersPage.signUpCompletionCheck();
		CustomAssert.assertTrue(flag1, "Landed on Confirm Account", "Issue with Signup button");
		flag = SignUp_GamersPage.checkAllElementsConfirmAccountPage();
		CustomAssert.assertTrue(flag, "Landed on Confirm Account", "Issue with Signup button");
		String verificationCode = code.getEmailData(EmailGamer, "body > em", 2);
		flag = SignUp_GamersPage.ConfirmAccount(verificationCode);
		CustomAssert.assertTrue(flag, "Account confirmed successfully", "having isssue with Account confirmation");
		
	}
	
	@Test(description = "Verify if a user is already existing on platform" )
	public void TSSHYB39() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp(signedUserName, signedEmail, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signup button clicked", "Fail to click signup button");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		boolean flag = SignUp_GamersPage.signUpExistingUserNameMsg();
		CustomAssert.assertTrue(flag, "Atready existing User", "Issue with Signup");
	}
	
	@Test(description = "Verify signin link working or not" )
	public void TSSHYB40() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag = SignUp_GamersPage.signUpPageSignInLink();
		CustomAssert.assertTrue(flag, "Signin link working correctly", "Issue with Signin link button");
	}

	
	@Test(description = "Verify if code resend link working and user is able to see validation on wrong OTP" )
	public void TSSHYB42() {
		boolean fla = SignUp_GamersPage.sighUpLinkClick();
		CustomAssert.assertTrue(fla,"Redirected to the sign up page","Unable to redirect to the sign up page.");
		boolean flag0 = SignUp_GamersPage.signUp(UserNameGamer, EmailGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signup button clicked successfully", "Fail to click signup button");
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		boolean flag = SignUp_GamersPage.resendLinkConfirmAccount();
		CustomAssert.assertTrue(flag, "code sent successfully", "having issue with resend link");
		flag = SignUp_GamersPage.WrongCodeErrorMsg("123456");
		CustomAssert.assertTrue(flag, "Wrong code error msg shown", "Wrong code error msg did not show");
   }
	
	
}
