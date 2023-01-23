package TestScripts_Sprint01;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Dashboard_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class Dashboard_Gamer_Tests {
	
	WebDriver driver;
	Dashboard_Gamer dashboardPage;
	SignInPage_Gamer signInFeature;
	
	String UserNameGamer;
	String PasswordGamer;
	String NameGamer;
	String gamerEmail;
	
	@BeforeClass
	public void accountSetup() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		UserNameGamer = "automation_gamer"+counter;
		gamerEmail = "automation_gamer"+counter+"@1secmail.com";
		PasswordGamer = "Qwerty@12345678";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		NameGamer = firstname+" "+lastname;
		boolean flag = APICalls.prepareGamerAccount(UserNameGamer, gamerEmail, PasswordGamer, firstname, lastname);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		System.out.println(flag);
	}
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		signInFeature = new SignInPage_Gamer(driver);
		dashboardPage = new Dashboard_Gamer(driver);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Verify all elements are visible on dashboard" )
	public void TSSHYB64() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag1 = dashboardPage.isGamerDetailsElementsVisible();
		CustomAssert.assertTrue(flag1, "Gamer's all element are visible on Dashboard", "Some elements are not visible on gamer on dashboard");
	}
	
	@Test(description = "Verify that explore button working" )
	public void TSSHYB65() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag = dashboardPage.exploreAction();
		CustomAssert.assertTrue(flag, "Successfully land on explore page", "Fail to land on explore page");
	}
	
	
	@Test(description = "Verify that redeem link button working or not" )
	public void TSSHYB66() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag = dashboardPage.redeemAction();
		CustomAssert.assertTrue(flag, "Successfully land on redeem page", "Fail to land on redeem page");
	}
	
	@Test(description = "Verify that correct user name showing on dashboard" )
	public void TSSHYB67() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag = dashboardPage.checkLoggedInUserName(NameGamer);
		CustomAssert.assertTrue(flag, "Showing Correct user name on dashboard", "Showing wrong user name on dashboard");
	}
    
	@Test(description = "Verify that total game count showing correctly" )
	public void TSSHYB68() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag = dashboardPage.checkTotalPlatformGamesCount();
		CustomAssert.assertTrue(flag, "Showing Correct games count on dashboard", "Showing wrong games count on dashboard");
	}
	
	@Test(description = "Verify that total linked game count showing correctly" )
	public void TSSHYB69() {
		boolean flag0 = dashboardPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag0, "Signin action successfully completed", "Fail to sign in");
		boolean flag = dashboardPage.checkTotalLinkedmGamesCount();
		CustomAssert.assertTrue(flag, "Showing Correct Linked games count on dashboard", "Fail to validate linked games");
	}
	
	
}
