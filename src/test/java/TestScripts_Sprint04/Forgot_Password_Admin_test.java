package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Forgot_Password_Admin_Page;
import PageObjectClasses.MailBox;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Forgot_Password_Admin_test {

	WebDriver driver;

	MailBox code = new MailBox();

	Forgot_Password_Admin_Page forgetPassword_page;

	String count;
	String confirmpassword;
	String UserNameGamer;
	String EmailAdmin;
	int c;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverClass.setDriver("chrome", "admin");
		WaitClass.waitForTime(10000);
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		UserNameGamer = "admin_user_2022"+c;
		EmailAdmin = UserNameGamer+"@1secmail.com";
		confirmpassword = "Qwerty@12345678";
		boolean flag = APICalls.prepareAdminAccount(Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), "Automation Admin", UserNameGamer, EmailAdmin, confirmpassword, driver);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(3000);
		driver.quit();
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "admin");
		forgetPassword_page = new Forgot_Password_Admin_Page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test( description = "Verify all elements are visible", enabled = true)
	public void TSSHYB197() {
		WaitClass.waitForTime(17000);
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened", "Unable to open forgot password page.");
		boolean flag = forgetPassword_page.checkelements();
		CustomAssert.assertTrue(flag, "All elements are present on forgot password page",
				"Missing Elements on forgot password page");
	}

	@Test( description = "Verify if Admin can click on 'Forgot your password?' button with blank email/username field", enabled = true)
	public void TSSHYB198() {
		WaitClass.waitForTime(17000);
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened", "Unable to open forgot password page.");
		boolean flag = forgetPassword_page.forgotPasswordBlankField("");
		CustomAssert.assertTrue(flag, "User name field blank message shown", "User name field blank message not shown");

	}


	@Test( description = " Verify that admin is able to click on Forgot Password and verify all element and complete the process", enabled = true)
	public void TSSHYB201() {
		WaitClass.waitForTime(17000);
		boolean flag = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(flag, "Verify that Forgot Password Button   Button is Working on Partner Sign In .",
				"Unable to Verify that Forgot Password Button is Working on Partner Sign In .");
		boolean flag0 = forgetPassword_page.forgotPassword(EmailAdmin);
		CustomAssert.assertTrue(flag0, "Reset password page shown", "Fail to shaw Reset password page");
		Utility.setTempProperties("testDataVariables", "signUpUserCount", c + "");
		String verificationCode = code.getEmailData(EmailAdmin, "body > em", 2);
		flag = forgetPassword_page.ConfirmAccountResend(verificationCode);
		CustomAssert.assertTrue(flag, "Forgot Password confirmed successfully",
				"having isssue with Forgot Password confirmation");
		flag = forgetPassword_page.FillResetPassDetails(confirmpassword, confirmpassword);
		CustomAssert.assertTrue(flag, "Verify that Details are filled in Reset password ADMIN.",
				"Unable to Verify that Details are filled in Reset password ADMIN.");

	}
}
