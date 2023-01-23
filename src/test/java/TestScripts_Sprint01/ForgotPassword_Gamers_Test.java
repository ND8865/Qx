package TestScripts_Sprint01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.ChangePasswordPage_Gamers;
import PageObjectClasses.ForgotPassword_Gamers;
import PageObjectClasses.MailBox;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class ForgotPassword_Gamers_Test {

	WebDriver driver;

	MailBox code = new MailBox();
	
	ForgotPassword_Gamers forgetPassword_page;
	ChangePasswordPage_Gamers changePassword_Page;
	
	String count;
	
	String EmailGamer;
	String forgotUsernameGamer;
	String currentPassword;
	String newPassword;
	
	
	@BeforeClass
	public void accountSetup() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		forgotUsernameGamer = "automation_gamer"+counter;
		EmailGamer = "automation_gamer"+counter+"@1secmail.com";
		currentPassword = "Qwerty@12345678";
		newPassword = "Qwerty@123456789";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(forgotUsernameGamer, EmailGamer, currentPassword, firstname, lastname);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		System.out.println(flag);
	}
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		forgetPassword_page = new ForgotPassword_Gamers(driver);
		changePassword_Page = new ChangePasswordPage_Gamers(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Verify all elements are visible")
	public void TSSHYB51() {
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened","Unable to open forgot password page.");
		boolean flag = forgetPassword_page.checkelements();
		CustomAssert.assertTrue(flag, "All elements are present on forgot password page",
				"Missing Elements on forgot password page");
	}

	@Test(description = "Verify if Gamer can click on 'Forgot your password?' button with blank email/username field")
	public void TSSHYB52() {
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened","Unable to open forgot password page.");
		boolean flag = forgetPassword_page.forgotPasswordBlankField("");
		CustomAssert.assertTrue(flag, "User name field blank message shown", "User name field blank message not shown");

	}

	@Test(description = "Verify if Gamer can click on 'Forgot your password?' button with wrong email/username field")
	public void TSSHYB53() {
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened","Unable to open forgot password page.");
		boolean flag0 = forgetPassword_page.forgotPassword("xypskmasoo@lmapso.com");
		CustomAssert.assertTrue(flag0, "Reset password page shown", "Fail to shaw Reset password page");
		boolean flag1 = forgetPassword_page.checkResetPasswordButton();
		CustomAssert.assertTrue(flag1, "Land on Change Password page successfully ","Unable to Land on Change Password page successfully");

	}
	
	@Test(description = "Verify the validations for forgot password screen.")
	public void TSSHYB56() {
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened","Unable to open forgot password page.");
		boolean flag0 = forgetPassword_page.forgotPassword(EmailGamer);
		CustomAssert.assertTrue(flag0, "Reset password button clicked successfully", "Fail to click Reset password button ");
		boolean flag1 = changePassword_Page.changePasswordFeature("", "Qwerty@12432", "Qwerty@12432");
		CustomAssert.assertTrue(flag1, "Land on change password page successfully", "Fail to land on  Reset password page ");
		boolean flag = changePassword_Page.isChangePasswordButtonEnabled();
		CustomAssert.assertTrue(flag, "Change password button disabled", "Change password button Enabled");
		flag1 = changePassword_Page.changePasswordFeature("", "", "");
		CustomAssert.assertTrue(flag1, "Land on change password page successfully", "Fail to land on  Reset password page ");
		flag = changePassword_Page.blankFieldMessageValidation();
		CustomAssert.assertTrue(flag, "Code field blank message shown", "Code field blank message not shown");
	}
	
	@Test(description = "Verify gamer successfully change password after filling all fields correctly.")
	public void TSSHYB63() {
		boolean fla = forgetPassword_page.logInPage();
		CustomAssert.assertTrue(fla, "Forgot password page opened","Unable to open forgot password page.");
		boolean flag0 = forgetPassword_page.forgotPassword(EmailGamer);
		CustomAssert.assertTrue(flag0, "Reset password button clicked successfully", "Fail to click Reset password button ");
		WaitClass.waitForTime(5000);
		String verificationCode = code.getEmailData(EmailGamer, "body > em", 2);
		boolean flag1 = changePassword_Page.changePasswordFeature(verificationCode, newPassword, newPassword);
		CustomAssert.assertTrue(flag1, "change password page successfully", "Fail to land on  Reset password page ");
		WebElement signButton = driver.findElement(By.xpath("(//input[@name='signInSubmitButton'])[2]"));
		boolean flag = signButton.isDisplayed();
		CustomAssert.assertTrue(flag, "Password changed successfully", "Fail to change password");
	}

}
