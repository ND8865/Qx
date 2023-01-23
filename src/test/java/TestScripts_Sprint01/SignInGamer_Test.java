package TestScripts_Sprint01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.SignInPage_Gamer;
import PageObjectClasses.TopBar_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignInGamer_Test {

	private WebDriver driver;
	SignInPage_Gamer signinpage_gamer;
	TopBar_Gamer gamerdashboardheadersidemenu;
	
	String gamerUsername;
	String gamerPassword;
	String gamerEmail;
	
		@BeforeClass
		public void accountSetup() {
			String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
			int counter = Integer.parseInt(count)+1;
			gamerUsername = "automation_gamer"+counter;
			gamerEmail = "automation_gamer"+counter+"@1secmail.com";
			gamerPassword = "Qwerty@12345678";
			String firstname = "Automation";
			String lastname = "Gamer"+counter;
			boolean flag = APICalls.prepareGamerAccount(gamerUsername, gamerEmail, gamerPassword, firstname, lastname);
			Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
			System.out.println(flag);
		}
	
		@BeforeMethod
		@Parameters(value = {"browser"})
		public void beforeMethod(String browser) throws InterruptedException {
			driver = DriverClass.setDriver(browser, "gamer");
			signinpage_gamer = new SignInPage_Gamer(driver);
			gamerdashboardheadersidemenu = new TopBar_Gamer(driver);
		}
		@AfterMethod
		public void afterMethod() {
			driver.quit();
		}
		
		@Test(description="Verify if the user is able to see the login screen in AWS Cognito")
		public void TSSHYB14()
		{
			boolean flag = signinpage_gamer.displayCheckSignInElement();
			CustomAssert.assertTrue(flag, "Sign In screen verified.", "Unable to verify the Sign In screen.");
		}
		
		@Test(description="Verify that the user get the option to sign in using other platforms such as Facebook, Google Account")
		public void TSSHYB15(){
			boolean flag = signinpage_gamer.checkSignInForGoogleAndFacebook();
			CustomAssert.assertTrue(flag, "Sign In with Facebook and Google option is available.", "Sign In with Facebook/Google option is not found!");
		}
		
		@Test(description="Verify the Sign in without entering the username and password")
		public void TSSHYB16(){
			boolean flag = signinpage_gamer.signinAction("", "");
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.checkValidationMessages(true, false, false, false);
			CustomAssert.assertTrue(flag, "Validation messages verified.", "Unable to verify validation messages.");
		}
		
		@Test(description="Verify the sign in with Invalid credentials")
		public void TSSHYB17(){
			boolean flag = signinpage_gamer.signinAction("abc", "xyz");
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.checkValidationMessages(false, false, true, false);
			CustomAssert.assertTrue(flag, "Validation messages verified.", "Unable to verify validation messages.");
		}
		
		@Test(description="Verify the sign in by entering the username only.")
		public void TSSHYB18(){
			boolean flag = signinpage_gamer.signinAction("xyz", "");
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.checkValidationMessages(false, true, false, false);
			CustomAssert.assertTrue(flag, "Validation messages verified.", "Unable to verify validation messages.");
		}
		
		@Test(description="Verify if user enters username exceeding the char limit, an error message should be displayed.")
		public void TSSHYB19(){
			boolean flag = signinpage_gamer.signinAction("shkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhk","shkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhkshkdjhajkdhjkahkashdkhsakdhakjshdkahdkahkdhakjshdkajhdkjashkjdhkdhk");
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.checkValidationMessages(false, false, false, true);
		    CustomAssert.assertTrue(flag, "Validation messages verified.", "Unable to verify validation messages.");
		}
		
		@Test(description="Verify that an error message is shown if user tries to login without any internet.")
		public void TSSHYB20(){
			WaitClass.waitForTime(5000);
			Utility.InternetAccess(true);
			boolean flag = signinpage_gamer.signinAction("abc", "xyz");
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
		}
		
		@Test(description="Verify that on signing in with same user, user is redirected to the dashboard.")
		public void TSSHYB24(){
			boolean flag = signinpage_gamer.signinAction(gamerUsername, gamerPassword);
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
			driver.navigate().back();
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertFalse(flag, "Redirecting on page where user ask to login back to same account or with different user.", "Not redirecting on page where user ask to login back to same account or with different user.");
			flag = signinpage_gamer.checkSignInAsUser();
			CustomAssert.assertTrue(flag, "Sign In as user actions performed.", "Unable to perform Sign In as user actions.");
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
		}
		
	@Test(description="Verify that on selecting sign in with different user, user is redirected to the login page.")
		public void TSSHYB25(){
			boolean flag = signinpage_gamer.signinAction(gamerUsername, gamerPassword);
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
			driver.navigate().back();
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertFalse(flag, "Redirecting on page where user ask to login back to same account or with different user.", "Not redirecting on page where user ask to login back to same account or with different user.");
			flag = signinpage_gamer.checkSignInAsDifferentUser();
			CustomAssert.assertTrue(flag, "Sign In as different user actions performed.", "Unable to perform actions Sign In as different user.");
			flag = signinpage_gamer.displayCheckSignInElement();
			CustomAssert.assertTrue(flag, "Sign In screen verified.", "Unable to verify the Sign In screen.");
		}
		
		@Test(description="Verify that the on reaching the login page, user cannot go back to selection page or dashboard by clicking back button.")
		public void TSSHYB26() {
			boolean flag = signinpage_gamer.displayCheckSignInElement();
			CustomAssert.assertTrue(flag, "Sign In screen verified.", "Unable to verify the Sign In screen.");
		}
		
		@Test(description="Verify if Gamer can click on Forgot your password link")
		public void TSSHYB27(){
			boolean flag = signinpage_gamer.checkForgotPasswordLink();
			CustomAssert.assertTrue(flag, "Forgot Password click actions performed.", "Unable to perform Forgot Password click actions.");
		}
		
		@Test(description="Verify if Gamer can click on Sign Up link")
		public void TSSHYB28(){
			boolean flag = signinpage_gamer.checkSignUpLink();
			CustomAssert.assertTrue(flag, "Sign Up link click actions performed.", "Unable to perform Sign Up link click actions.");
		}
		
		@Test(description="Verify if user is able to click on the Sign out from the side menu and click never ask")
		public void TSSHYB29() {
			boolean flag = signinpage_gamer.signinAction(gamerUsername, gamerPassword);
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
			flag = gamerdashboardheadersidemenu.clickDropdownItems(1);
			CustomAssert.assertTrue(flag, "Dropdown list item action performed.", "Dropdown list item action not performed.");
			flag = gamerdashboardheadersidemenu.checkSignOutPopUpHost();
			CustomAssert.assertTrue(flag, "Popup diplay action performed.", "Popup diplay action not performed.");
			flag = gamerdashboardheadersidemenu.validateSignOutPopupNeverAskButton();
			CustomAssert.assertTrue(flag, "Never Ask Again action performed.", "Never Ask Again action not performed.");
			flag = gamerdashboardheadersidemenu.clickDropdownItems(1);
			CustomAssert.assertTrue(flag, "Dropdown list item action performed.", "Dropdown list item action not performed.");
			flag = signinpage_gamer.displayCheckSignInElement();
			CustomAssert.assertTrue(flag, "Sign In screen verified.", "Unable to verify the Sign In screen.");
		}
		
		@Test(description="Verify if user is able to click on the Sign out from the side menu and cancel")
		public void TSSHYB30() {
			boolean flag = signinpage_gamer.signinAction(gamerUsername, gamerPassword);
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			WaitClass.waitForTime(2000);
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
			WaitClass.waitForTime(2000);
			flag = gamerdashboardheadersidemenu.clickDropdownItems(1);
			WaitClass.waitForTime(2000);
			CustomAssert.assertTrue(flag, "Dropdown list item action performed.", "Dropdown list item action not performed.");
			flag = gamerdashboardheadersidemenu.checkSignOutPopUpHost();
			CustomAssert.assertTrue(flag, "Popup diplay action performed.", "Popup diplay action not performed.");
			WaitClass.waitForTime(2000);
			flag = gamerdashboardheadersidemenu.validateSignOutPopupCancelButton();
			CustomAssert.assertTrue(flag, "Cancel button action performed.", "Cancel button action not performed.");
			WaitClass.waitForTime(2000);
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
		}
		
		@Test(description="Verify if user is able to click on the Sign out from the side menu and confirm")
		public void TSSHYB31() {
			WaitClass.waitForTime(2000);
			boolean flag = signinpage_gamer.signinAction(gamerUsername, gamerPassword);
			CustomAssert.assertTrue(flag, "Sign In actions performed.", "Unable to perform Sign In actions.");
			WaitClass.waitForTime(2000);
			flag = signinpage_gamer.validateSignIn();
			CustomAssert.assertTrue(flag, "Sign In verified.", "Unable to verify valid Sign In.");
			flag = gamerdashboardheadersidemenu.clickDropdownItems(1);
			CustomAssert.assertTrue(flag, "Dropdown list item action performed.", "Dropdown list item action not performed.");
			flag = gamerdashboardheadersidemenu.checkSignOutPopUpHost();
			CustomAssert.assertTrue(flag, "Popup diplay action performed.", "Popup diplay action not performed.");
			flag = gamerdashboardheadersidemenu.validateSignOutPopupConfirmButton();
			CustomAssert.assertTrue(flag, "Cancel button action performed.", "Cancel button action not performed.");
			flag = signinpage_gamer.displayCheckSignInElement();
			CustomAssert.assertTrue(flag, "Sign In screen verified.", "Unable to verify the Sign In screen.");
		}
}		