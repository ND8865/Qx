package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Forgot_Password_Partner_page;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Forgot_Password_Partner_test {
	WebDriver driver;

	MailBox code = new MailBox();

	Forgot_Password_Partner_page forgetPassword_page;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;

	String count;
	String confirmpassword;
	String UserNameGamer;
	String EmailParner;
	int c;

	@BeforeClass
	public void beforeClass() {
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count)+1;
		UserNameGamer = "qa_partner11"+c;
		EmailParner = "qa_partner11"+c+"@1secmail.com";
		confirmpassword = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		boolean flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", UserNameGamer, EmailParner, confirmpassword, confirmpassword);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(EmailParner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(EmailParner, UserNameGamer, confirmpassword, Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"));
		Assert.assertTrue(flag);
	}
	
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "partner");
		forgetPassword_page = new Forgot_Password_Partner_page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1, description = "Verify all elements are visible", enabled = true)
	public void TSSHYB202() {
		WaitClass.waitForTime(17000);
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened", "Unable to open forgot password page.");
		boolean flag = forgetPassword_page.checkelements();
		CustomAssert.assertTrue(flag, "All elements are present on forgot password page",
				"Missing Elements on forgot password page");
	}

	@Test(priority = 2, description = "Verify if Partner can click on 'Forgot your password?' button with blank email/username field", enabled = true)
	public void TSSHYB203() {
		WaitClass.waitForTime(17000);
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened", "Unable to open forgot password page.");
		boolean flag = forgetPassword_page.forgotPasswordBlankField("");
		CustomAssert.assertTrue(flag, "User name field blank message shown", "User name field blank message not shown");

	}


	@Test(priority = 5, description = " Verify that Forgot Password has been Successfully Completed   ", enabled = true)
	public void TSSHYB206() {
		WaitClass.waitForTime(17000);
		boolean flag = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(flag, "Verify that Forgot Password Button   Button is Working on Partner Sign In .",
				"Unable to Verify that Forgot Password Button is Working on Partner Sign In .");
		boolean flag0 = forgetPassword_page.forgotPassword(EmailParner);
		CustomAssert.assertTrue(flag0, "Reset password page shown", "Fail to shaw Reset password page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount", c + "");
		String verificationCode = code.getEmailData(EmailParner, "body > em", 2);
		flag = forgetPassword_page.ConfirmAccountResend(verificationCode);
		CustomAssert.assertTrue(flag, "Forgot Password confirmed successfully",
				"having isssue with Forgot Password confirmation");
		flag = forgetPassword_page.FillResetPassDetails(confirmpassword, confirmpassword);
		CustomAssert.assertTrue(flag, "Verify that Details are filled in Reset password Partner.",
				"Unable to Verify that Details are filled in Reset password Partner.");

	}
}
