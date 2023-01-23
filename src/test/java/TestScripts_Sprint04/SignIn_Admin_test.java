package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class SignIn_Admin_test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, description = " Verify that All Web Element Are Visible on ADMIN Sign In Page", enabled = true)
	public void TSSHYB207() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.AllWebElementDisplayedPartnerSignIn();
		CustomAssert.assertTrue(flag, "Verify that All Web Element Are Visible on ADMIN Sign In Page.",
				"Unable to Verify that All Web Element Are Visible on ADMIN Sign In Page..");
	}

	@Test(priority = 2, description = " Verify that Validation is Success on Sign In ADMIN ", enabled = true)
	public void TSSHYB208() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.ValidateSignIn(true, false, false);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In ADMIN with BlankUser.",
				"Unable to Validation is Successfull on Sign In Partner with BlankUser.");
		flag = signInAdmin.ValidateSignIn(false, true, false);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In ADMIN with BlankPassword.",
				"Unable to Validation is Successfull on Sign In Partner with BlankPassword.");
		flag = signInAdmin.ValidateSignIn(false, false, true);
		CustomAssert.assertTrue(flag, "Verify that Validation is Successfull on Sign In ADMIN with WrongCredentials.",
				"Unable to Validation is Successfull on Sign In Partner with WrongCredentials.");
	}

	@Test(priority = 3, description = " Verify that Sign In is Successfully on ADMIN  ", enabled = true)
	public void TSSHYB209() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
	}

	@Test(priority = 4, description = " Verify that Sign Out is SuccessFul on ADMIN  ", enabled = true)
	public void TSSHYB210() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		WaitClass.waitForTime(1000);
		flag = signInAdmin.SignOutADMIN();
		CustomAssert.assertTrue(flag, "Verify that Sign Out is Successful on  ADMIN.",
				"Unable to Verify Sign Out is Successful on  ADMIN.");
	}

}
