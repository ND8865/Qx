package TestScripts_Sprint01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Accounts_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import PageObjectClasses.TopBar_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class ChangePasswordOfAccount_Tests {

	private WebDriver driver;
	
	private SignInPage_Gamer signIn;
	private Accounts_Gamer changePwdPage;
	private TopBar_Gamer menu;
	
	String count;	
	String username;
	String email;
	String currentPassword = "";
	String newPassword = "";

	
	@BeforeClass
	public void accountSetup() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		username = "automation_gamer"+counter;
		email = "automation_gamer"+counter+"@1secmail.com";
		currentPassword = "Qwerty@12345678";
		newPassword = "Qwerty@123456789";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(username, email, currentPassword, firstname, lastname);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		System.out.println(flag);
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void beforeMethod(String browsername){
		driver = DriverClass.setDriver(browsername, "gamer");
		signIn = new SignInPage_Gamer(driver);
		menu = new TopBar_Gamer(driver);
		changePwdPage=new Accounts_Gamer(driver);
	}
	

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Validating that All WebElements are Visible on Change Password Page")
	public void TSSHYB45() {
		boolean flag = signIn.signinAction(username, currentPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.checkElementVisibilty();
		CustomAssert.assertTrue(flag, "All Elements are displayed on ChangePassword Page"," Elements are not displayed on ChangePassword Page");
	}

	@Test(description = "To Test And Verify All the Password Fields are filled by Valid PassWord Details")
	public void TSSHYB46() {
		boolean flag = signIn.signinAction(username, currentPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.inputCredintials(currentPassword, newPassword, newPassword);
		CustomAssert.assertTrue(flag, "Form filled successully.", "Unable to fill the field.");
		flag = changePwdPage.validationOfPassworFields(true, false, false, false, false,false,false);
		CustomAssert.assertTrue(flag, "Validation verified.", "Unable to verify the validation");

	}

	@Test(description = "To Test And Verify  With Wrong Current Password and With Valid New password and  Confirm Password ")
	public void TSSHYB47() { 
		boolean flag = signIn.signinAction(username, newPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.inputCredintials("XYZAKCL@12334", newPassword,newPassword);
		CustomAssert.assertTrue(flag, "Form submitted", "Unable to submit the form");
		flag = changePwdPage.validationOfPassworFields(false, false, false, false, false,true,false);
		CustomAssert.assertTrue(flag, "Validation verified.", "Unable to verify the validation");

	}

	@Test(description = "To Test And Verify That newPassword field or Confirm PassWord Field have less then 12 Character")
	public void TSSHYB48() {
		boolean flag = signIn.signinAction(username, newPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.inputCredintials(newPassword, "Adm@123", newPassword);
		CustomAssert.assertTrue(flag, "Form submitted", "Unable to submit the form");
		flag = changePwdPage.validationOfPassworFields(false, false, true, false, false,false,false);
		CustomAssert.assertTrue(flag, "Validation verified.", "Unable to verify the validation");
	}

	@Test(description = "To Test And Verify That new Password field and Confirm PassWord Field is Missmatch")
	public void TSSHYB49() {
		boolean flag = signIn.signinAction(username, newPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.inputCredintials(newPassword, "XYZPLSMA@1223", "ACHSPWK@12234");
		CustomAssert.assertTrue(flag, "Form submitted", "Unable to submit the form");
		flag = changePwdPage.validationOfPassworFields(false, true, false, false, false,false,false);
		CustomAssert.assertTrue(flag, "Validation verified.", "Unable to verify the validation");
		
	}
	
	@Test(description = "To Test And Verify That in  newPassword field  not include Uppercase character and not include Special character and Number ")
	public void TSSHYB50() {
		boolean flag = signIn.signinAction(username, newPassword);
		CustomAssert.assertTrue(flag, "Signed in successfully.","Unable to Sign in.");
		flag = menu.clickDropdownItems(2);
		CustomAssert.assertTrue(flag, "Accounts dropdown clicked.","Unable to click accounts.");
		flag = changePwdPage.navigateToChangePassword();
		CustomAssert.assertTrue(flag, "Navigated to change password.","Unable to navigate to change password.");
		flag = changePwdPage.inputCredintials(newPassword, "adminadminadmin", "adminadminadmin");
		CustomAssert.assertTrue(flag, "Input Right Credintail", "");
		flag = changePwdPage.validationOfPassworFields(false, false, false, false, false,false,true);
		CustomAssert.assertTrue(flag, "Exclude Upper Case or Exclude Character ", "Pop up not Showing");
	}


}
