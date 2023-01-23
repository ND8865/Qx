package TestScripts_Sprint05;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Change_Password_Admin;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Change_Password_Admin_Tests {
	
	private WebDriver driver;
	Change_Password_Admin changePasswordPage;
	SignIn_Admin_Pages signInAdmin;
	String userNameAdmin;
	String PasswordAdmin;
	String NewPassword;
	String oldPassword;
	MailBox code;
	int d = 0;
	int c = 0;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverClass.setDriver("chrome", "admin");
		WaitClass.waitForTime(10000);
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count) + 1;
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		userNameAdmin = "admin_user_2022"+c;
		String EmailAdmin = userNameAdmin+"@1secmail.com";
		PasswordAdmin = "Qwerty@12345678";
		boolean flag = APICalls.prepareAdminAccount(Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), "Automation Admin", userNameAdmin, EmailAdmin, PasswordAdmin, driver);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(3000);
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		changePasswordPage = new Change_Password_Admin(driver);
		String count = Utility.getPropertiesFile("testDataVariables", "adminPasswordCount");
		d = Integer.parseInt(count);
		c = Integer.parseInt(count)+1;
		oldPassword = "Qwerty@12345678"+d;
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify if  Admin is able to sign in through the correct credentials lands on settings page by clicking on the Settings tab")
	public void TSSHYB292() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		
	}
    
	@Test(description = "Verify if Admin is able to  see all contents on change password page.")
	public void TSSHYB293() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.validateAllElementsChangePasswordPage();
		CustomAssert.assertTrue(flag, "All elements are validated successfully on the change password Page.","Fail to  validated all elements on the change password Page.");
		
	}
	
	@Test(description = "Verify If Admin enters invalid current password.")
	public void TSSHYB294() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.validateFieldsValidation(true, false, false);
		CustomAssert.assertTrue(flag, "Blank fields validation validated successfully.","Fail to  validated Blank fields validation");
		flag = changePasswordPage.validateFieldsValidation(false, true, false);
		CustomAssert.assertTrue(flag, "Invalid current password validated successfully.","Fail to  validated Invalid current password");
		
	}
	
	@Test(description = "Verify If Admin can see an error message, if the new password and the confirm new password don't match.")
	public void TSSHYB295() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.validateFieldsValidation(false, false, true);
		CustomAssert.assertTrue(flag, "Confirm password mismatch validated successfully.","Fail to  validated Confirm password mismatch");
		
	}
	
	@Test(description = "Verify If Admin  can add the current password.")
	public void TSSHYB296() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.changePasswordAction(true, false , false);
		CustomAssert.assertTrue(flag, "Current password field filling validated successfully.","Fail to  validated Current password field filling");
		
	}
	
	@Test(description = "Verify if Admin can add new password & Confirm new password.")
	public void TSSHYB297() 
	{   
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.changePasswordAction(false, true , false);
		CustomAssert.assertTrue(flag, "new password & Confirm password fields filling validated successfully.","Fail to  validated new password & Confirm password fields filling.");
		
	}
	
	@Test(description = "Verify If Admin can click on Update to change the password.")
	public void TSSHYB298() 
	{   
		String EditableUserNameAdmin = Utility.getPropertiesFile("primaryLogin", "adminUsername4");
		boolean flag = signInAdmin.signinActionAdmin(EditableUserNameAdmin, oldPassword);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		WaitClass.waitForTime(4000);
		flag = changePasswordPage.navigateToSetting();
		CustomAssert.assertTrue(flag, "Admin Navigated to settings page","Fail to navigate on the settings page page");
		flag = changePasswordPage.changePasswordAction(false, false , true);
		CustomAssert.assertTrue(flag, "Change password update button validated successfully.","Fail to  validated Change password update button");
		Utility.setTempProperties("testDataVariables", "adminPasswordCount",c+"");
		
	}
    
}
