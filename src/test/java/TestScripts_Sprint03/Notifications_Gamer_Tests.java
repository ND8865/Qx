package TestScripts_Sprint03;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MyRewards_Gamer;
import PageObjectClasses.Notifications_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class Notifications_Gamer_Tests {
	
	WebDriver driver;
	Notifications_Gamer notificationsPage;
	MyRewards_Gamer MyRewardPage;
	
	SignInPage_Gamer signInPage;
	APICalls apiCall;
	String UserNameGamer;
	String PasswordGamer;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		UserNameGamer = "automation_gamer"+counter;
		String email = "automation_gamer"+counter+"@1secmail.com";
		PasswordGamer = "Qwerty@12345678";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(UserNameGamer, email, PasswordGamer, firstname, lastname);
		Assert.assertTrue(flag);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		notificationsPage = new Notifications_Gamer(driver);
		signInPage = new SignInPage_Gamer(driver);
		MyRewardPage = new MyRewards_Gamer(driver);
		apiCall = new APICalls();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify all elements are visible on Notifications page.")
	public void TSSHYB172() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = notificationsPage.navigateToNotifications();
		CustomAssert.assertTrue(flag, "successfully landed on notifications page", "Fail to land on notifications page");
		flag = notificationsPage.checkAllNotificationPageElements();
		CustomAssert.assertTrue(flag, "successfully validated all elements on notifications page", "Fail to validate all elements on notifications page");
	}
	
	
	@Test(description = "Verify that points and Exchange value slider filter working correctly on My Reward page.")
	public void TSSHYB174() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.pointsSliderFilter();
	    CustomAssert.assertTrue(flag, "Points slider filter validated successfully", "fail to validate points slider filter");
		flag = MyRewardPage.exchangeValueSliderFilter();
		CustomAssert.assertTrue(flag, "Exchange value slider filter validated successfully", "fail to validate exchange value slider filter");
		
	}
	
}
