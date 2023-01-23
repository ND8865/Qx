package TestScripts_Sprint04;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.AdminUsers_Admin;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignIn_Admin_Pages;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class AdminUsers_Admin_Tests {
	
	private WebDriver driver;
	SignIn_Admin_Pages signInAdmin;
	String userNameAdmin;
	String PasswordAdmin;
	AdminUsers_Admin adminUsersPage;
	MailBox code;
	
	String newUsername;
	String newEmail;
	String newPass;
	String tempUser;
	String tempEmail;
	String tempPass;
	
	@BeforeClass
	public void beforeClass() {
		driver = DriverClass.setDriver("chrome", "admin");
		WaitClass.waitForTime(10000);
		code = new MailBox();
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count) + 1;
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		newUsername = "admin_user_2022"+c;
		newEmail = newUsername+"@1secmail.com";
		newPass = "Qwerty@12345678";
		boolean flag = APICalls.prepareAdminAccount(Utility.getPropertiesFile("primaryLogin", "superAdminUsername"), Utility.getPropertiesFile("primaryLogin", "superAdminPassword"), "Automation Admin", newUsername, newEmail, newPass, driver);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(3000);
		driver.quit();
	}
	
	@BeforeMethod
	public void browserlaunch() {
		driver = DriverClass.setDriver("chrome", "admin");
		signInAdmin = new SignIn_Admin_Pages(driver);
		adminUsersPage = new AdminUsers_Admin(driver);
		userNameAdmin = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		PasswordAdmin = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
		code = new MailBox();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(description = " Verify that all contents are visible on the admin users page.")
	public void TSSHYB220() 
	{   
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page","Fail to navigate on the Admin users page");
		flag = adminUsersPage.validateAllElementsAdminUsersPage();
		CustomAssert.assertTrue(flag, "All elements are validated successfully on the Admin users Page.","Fail to  validated all elements on the Admin users Page.");
		
	}
	
	@Test(description = " Verify that Add New Button working correctly")
	public void TSSHYB221() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully.","Fail to validate admin login.");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page.","Fail to navigate on the Admin users page.");
		flag = adminUsersPage.validateAddNewButton();
		CustomAssert.assertTrue(flag, "Add new Button validated successfully.","Fail to  validated Add new Button.");
		flag = adminUsersPage.validateBackButton();
		CustomAssert.assertTrue(flag, "Back Button validated successfully.","Fail to validated back Button.");
		flag = adminUsersPage.validateAddNewButton();
		CustomAssert.assertTrue(flag, "Add new Button again validated successfully.","Fail to  validated Add new Button again.");
		flag = adminUsersPage.validateCancelButton();
		CustomAssert.assertTrue(flag, "Cancel Button validated successfully.","Fail to validated cancel Button.");
		
	}
	
	@Test(description = " Verify that all validation on Add Admin form.")
	public void TSSHYB222() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully.","Fail to validate admin login.");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page.","Fail to navigate on the Admin users page.");
		flag = adminUsersPage.validateAddNewButton();
		CustomAssert.assertTrue(flag, "Add new Button validated successfully.","Fail to  validated Add new Button.");
		flag = adminUsersPage.ValidateAddAdminUserForm(true, false, false);
		CustomAssert.assertTrue(flag, "Blank fields validations validated successfully.","Fail to validated Blank fields validation");
		flag = adminUsersPage.ValidateAddAdminUserForm(false, true, false);
		CustomAssert.assertTrue(flag, "Invalid email validated successfully.","Fail to validated invalid email.");
		
	}
	
	@Test(description = " Verify the admin invite flow.")
	public void TSSHYB223() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully.","Fail to validate admin login.");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page.","Fail to navigate on the Admin users page.");
		flag = adminUsersPage.validateAddNewButton();
		CustomAssert.assertTrue(flag, "Add new Button validated successfully.","Fail to  validated Add new Button.");
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count) + 1;
		tempUser = "admin_user_2022"+c;
		tempEmail = tempUser+"@1secmail.com";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		flag = adminUsersPage.ValidateInviteAdminFlow("Automation Admin", tempUser, tempEmail);
		CustomAssert.assertTrue(flag, "Admin Invite Button validated successfully.","Fail to validated admin Invite button");
		flag = adminUsersPage.ValidatelatestAddedAdmin(tempUser);
		CustomAssert.assertTrue(flag, "Latest added admin validated successfully.","Fail to validated Latest added admin");
	}
	
		@Test(description = " Verify that newly added admin able to login with temp password.")
	    public void TSSHYB224() 
		{
		WaitClass.waitForTime(4000);
		String adminPortalURL = Utility.getPropertiesFile("link","admin");
		adminPortalURL = adminPortalURL.substring(0,(adminPortalURL.length())-1);
		String verificationURL = code.getEmailData(tempEmail, "a", 1);
		boolean flag = adminPortalURL.equals(verificationURL);
		CustomAssert.assertTrue(flag, "Email admin URL validated successfully.","Fail to validate Email admin URL");
		String verificationText = code.getEmailData(tempEmail, "body", 2, 1);
		String arr[] = verificationText.split(" ");
		String passwordEmail = arr[8];
		tempPass = passwordEmail.substring(0,(passwordEmail.length())-1);
		flag = signInAdmin.signinActionNewAdmin(tempUser, tempPass);
		CustomAssert.assertTrue(flag, "Admin login validated successfully.","Fail to validate admin login.");
			
	}
    
	@Test(description = "Verify that all correct contents are visibile on edit admin page")
	public void TSSHYB225() 
	{
		WaitClass.waitForTime(8000);
		String adminfullName = Utility.getPropertiesFile("primaryLogin", "superAdminName");
		String adminUserName  = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
		String adminEmail  = Utility.getPropertiesFile("primaryLogin", "superAdminEmail");
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page","Fail to navigate on the Admin users page");
		flag = adminUsersPage.ValidateEditAdminButton(adminUserName);
		CustomAssert.assertTrue(flag, "Admin edit button validated successfully","Fail to navigate Admin edit button");
		flag = adminUsersPage.ValidateprefilledDataAddAdmin(adminfullName, adminUserName, adminEmail);
		CustomAssert.assertTrue(flag, "Admin prefilled data validated successfully","Fail to validate admin prefilled data");
		flag = adminUsersPage.validateAllPermissionsContentVisibility();
		CustomAssert.assertTrue(flag, "Permissions visibility validated successfully","Fail to validate permission visibility");
    }
	
	@Test(description = "Verify that admin should be able be to assign all permission to sub-admin.")
	public void TSSHYB226()
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page","Fail to navigate on the Admin users page");
		flag = adminUsersPage.ValidateEditAdminButton(tempUser);
		CustomAssert.assertTrue(flag, "Admin edit button validated successfully","Fail to navigate Admin edit button");
		flag = adminUsersPage.validatePermissionUpdateFlow();
		CustomAssert.assertTrue(flag, "Permissions update validated successfully","Fail to validate permissions update");
    }
	
	@Test(description = "Verify that given permissions should be accessible by sub-admin")
	public void TSSHYB227() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(newUsername, newPass);
		CustomAssert.assertTrue(flag, "updated Admin login validated successfully","Fail to validate updated admin login");
		flag = adminUsersPage.validateAssignedPermissionsTabs();
		CustomAssert.assertTrue(flag, "Permission tabs validated on admin dashboard","Fail to validate Permission tabs on admin dashboard");
		flag = adminUsersPage.validateIsGameApproveButtonEnable();
		CustomAssert.assertTrue(flag, "Approve and Reject Games buttons are enabled","Fail to validate approve and Reject Games buttons");
		flag = adminUsersPage.validateIsOfferApproveButtonEnable();
		CustomAssert.assertTrue(flag, "Approve and Reject offers buttons are enabled","Fail to validate approve and Reject offers buttons");
		
    }
	

	@Test(description = "Verify that admin should be able to remove all permission from sub-admin.")
	public void TSSHYB228()
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page","Fail to navigate on the Admin users page");
		flag = adminUsersPage.ValidateEditAdminButton(newUsername);
		CustomAssert.assertTrue(flag, "Admin edit button validated successfully","Fail to navigate Admin edit button");
		flag = adminUsersPage.validatePermissionUpdateFlow();
		CustomAssert.assertTrue(flag, "Permissions update validated successfully","Fail to validate permissions update");
    }
	
	@Test(description = "Verify that removed permissions should not be accessible by sub-admin")
	public void TSSHYB229() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(newUsername, newPass);
		CustomAssert.assertTrue(flag, "updated Admin login validated successfully","Fail to validate updated admin login");
		flag = adminUsersPage.validateAssignedPermissionsTabs();
		CustomAssert.assertFalse(flag, "Permission tabs disability validated on admin dashboard","Fail to validate Permission tabs on admin dashboard");
		flag = adminUsersPage.validateIsGameApproveButtonEnable();
		CustomAssert.assertFalse(flag, "Approve and Reject Games buttons are Disabled","Fail to validate approve and Reject Games buttons");
		flag = adminUsersPage.validateIsOfferApproveButtonEnable();
		CustomAssert.assertFalse(flag, "Approve and Reject offers buttons are disabled","Fail to validate approve and Reject offers buttons");
		
    }
	
	@Test(description = "Verify that super admin should be able to Edit and update sub-admin.")
	public void TSSHYB230() 
	{
		WaitClass.waitForTime(8000);
		boolean flag = signInAdmin.signinActionAdmin(userNameAdmin, PasswordAdmin);
		CustomAssert.assertTrue(flag, "Admin login validated successfully","Fail to validate admin login");
		flag = adminUsersPage.navigateToAdminUsers();
		CustomAssert.assertTrue(flag, "Admin Navigated to Admin users page","Fail to navigate on the Admin users page");
		flag = adminUsersPage.ValidateEditAdminButton(newUsername);
		CustomAssert.assertTrue(flag, "Admin edit button validated successfully","Fail to navigate Admin edit button");
		flag = adminUsersPage.validateDisabilityOfTextFields();
		CustomAssert.assertTrue(flag, "All text fields are disabled","Fail to validate field disability.");
		flag = adminUsersPage.validateAdminEditUpdateFlow();
		CustomAssert.assertTrue(flag, "Permissions update and updated button validated successfully","Fail to validate permissions update and updated button");
    }
    
}