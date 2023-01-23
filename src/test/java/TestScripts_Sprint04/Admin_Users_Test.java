package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Admin_Users_Page;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Admin_Users_Test {
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String username;
	String userpassword;
	Admin_Users_Page adminUsers;

	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		username = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		userpassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		adminUsers = new Admin_Users_Page(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	/* Admin Users - Search */
	
	@Test(priority = 1, description = " Verify if Admin is able to sign in through the correct credentials and , Verify if admin is able to go to the Admin users tab   ", enabled = true)
	public void TSSHYB191() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminUsers.AdminUserTab();
		CustomAssert.assertTrue(flag, "Verify if admin is able to go to the Admin users tab.",
				"Unable to Verify if admin is able to go to the Admin users tab.");
	}

	@Test(priority = 2, description = "Verify if user can Search the data according to Full name, username and  email ", enabled = true)
	public void TSSHYB192() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminUsers.AdminUserTab();
		CustomAssert.assertTrue(flag, "Verify if admin is able to go to the Admin users tab.",
				"Unable to Verify if admin is able to go to the Admin users tab.");
		flag = adminUsers.VerifyFullNameSearch();
		CustomAssert.assertTrue(flag, "Verify if Searching Bar is working fine for Full Name. ",
				"Unable to Verify if Searching Bar is working fine for Full Name. ");
		flag = adminUsers.VerifyUserNameSearch();
		CustomAssert.assertTrue(flag, "Verify if Searching Bar is working fine for UserName. ",
				"Unable to Verify if Searching Bar is working fine for UserName. ");
		flag = adminUsers.VerifyEmailSearch();
		CustomAssert.assertTrue(flag, "Verify if Searching Bar is working fine for Email. ",
				"Unable to Verify if Searching Bar is working fine for Email. ");
	}

	/* Admin Users - Enable/disable */
	
	@Test(priority = 3, description = " Verify that ADMIN/USER Are Enable and disable Successful  ", enabled = true)
	public void TSSHYB193() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminUsers.AdminUserTab();
		CustomAssert.assertTrue(flag, "Verify if admin is able to go to the Admin users tab.",
				"Unable to Verify if admin is able to go to the Admin users tab.");
		flag = adminUsers.EnableDisable();
		CustomAssert.assertTrue(flag,
				"Verify if admin is able to go to the Admin users tab and Verify Enable , Disable toggle button.",
				"Unable to Verify if admin is able to go to the Admin users tab and Verify Enable , Disable toggle button.");

	}

	/* Admin Users - sorting */
	@Test(priority = 5, description = " Verify and validate that ADMIN/USER Sorting Are Working Properly  ", enabled = true)
	public void TSSHYB195() {
		WaitClass.waitForTime(17000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminUsers.AdminUserTab();
		CustomAssert.assertTrue(flag, "Verify if admin is able to go to the Admin users tab.",
				"Unable to Verify if admin is able to go to the Admin users tab.");
		flag = adminUsers.SortingAdminUserFullname(1);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by Full Name  in ASC order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by Full Name  in ASC order.");
		flag = adminUsers.SortingAdminUserFullname(2);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by Full Name  in Desc order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by Full Name  in Desc order.");
		flag = adminUsers.SortingAdminUserUserName(1);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by UserName  in ASc order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by UserName  in Asc order.");
		flag = adminUsers.SortingAdminUserUserName(2);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by UserName  in Desc order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by UserName  in Desc order.");
		flag = adminUsers.SortingAdminUserEmail(1);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by Email  in Asc order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by Email  in Asc order.");
		flag = adminUsers.SortingAdminUserEmail(2);
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER is able to Sort  the value by Email  in Desc order. ",
				"Unable to Verify ADMIN USER is able to Sort the value by Email  in Desc order.");
	}
	/* Admin Users - list */
	@Test(priority = 6, description = " Verify that ADMIN/USER  Listing are correct as per the ADMIN Added", enabled = true)
	public void TSSHYB196() {
		WaitClass.waitForTime(20000);
		boolean flag = signInAdmin.signinActionAdmin(username, userpassword);
		CustomAssert.assertTrue(flag, "Verify that Sign In is Successful on  ADMIN.",
				"Unable to Verify Sign In is Successful on  ADMIN.");
		flag = adminUsers.AdminUserTab();
		CustomAssert.assertTrue(flag, "Verify if admin is able to go to the Admin users tab.",
				"Unable to Verify if admin is able to go to the Admin users tab.");
		flag = adminUsers.AdminUserList();
		CustomAssert.assertTrue(flag, "Verify if ADMIN USER Listing are Correct.",
				"Unable to Verify ADMIN USER Listing are Correct ");

	}

}
