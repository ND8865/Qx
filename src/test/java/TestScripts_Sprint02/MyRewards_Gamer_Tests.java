package TestScripts_Sprint02;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.MyRewards_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class MyRewards_Gamer_Tests {

	WebDriver driver;

	MyRewards_Gamer MyRewardPage;
	SignInPage_Gamer signInPage;

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
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		MyRewardPage = new MyRewards_Gamer(driver);
		signInPage = new SignInPage_Gamer(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify all elements are visible")
	public void TSSHYB114() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.checkAllMyRewardsPageElements();
		CustomAssert.assertTrue(flag, "All elements are visible", "fail to read some elements");

	}

	@Test(description = "Verify that total QxPoints Showing correct")
	public void TSSHYB115() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.totalQxPointsValidation();
		CustomAssert.assertTrue(flag, "Total QX points validated successfully", "fail to validate Total QX points");

	}

	@Test(description = "Verify that total Exchange value Showing correct")
	public void TSSHYB116() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.totalExchangeValueValidation();
		CustomAssert.assertTrue(flag, "Total Exchange value validated successfully",
				"fail to validate Total Exchange value");

	}

	@Test(description = "Verify that total Total Games count Showing correct")
	public void TSSHYB117() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.totalGamesCountValidation();
		CustomAssert.assertTrue(flag, "Total Games count validated successfully", "fail to validate Total Games count");

	}

	@Test(description = "Verify that search feature working correctly")
	public void TSSHYB118() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.searchValidation();
		CustomAssert.assertTrue(flag, "Search feature validated successfully", "fail to validate search feature");
		flag = MyRewardPage.searchValidationWrongKeys("qwerty");
		CustomAssert.assertTrue(flag, "Search feature validated successfully with wrong text",
				"fail to validate search feature");

	}
	
	@Test(description = "Verify that game name dropdown filter working correctly")
	public void TSSHYB119() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.gameNameDropdownFilter();
		CustomAssert.assertTrue(flag, "Game name Filter Dropdown validated successfully",
				"fail to validate Game name Filter Dropdown");

	}

	@Test(description = "Verify that sorting working correctly")
	public void TSSHYB120() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.checkSort(1, 0, 0);
		CustomAssert.assertTrue(flag, "game name ascending sorting  validated successfully",
				"fail to validate game name ascending sorting");
		flag = MyRewardPage.checkSort(2, 0, 0);
		CustomAssert.assertTrue(flag, "game name descending sorting  validated successfully",
				"fail to validate game name descending sorting");
		flag = MyRewardPage.checkSort(0, 1, 0);
		CustomAssert.assertTrue(flag, "QX points ascending sorting  validated successfully",
				"fail to validate QX points ascending sorting");
		flag = MyRewardPage.checkSort(0, 2, 0);
		CustomAssert.assertTrue(flag, "QX points descending sorting  validated successfully",
				"fail to validate QX points descending sorting");
		flag = MyRewardPage.checkSort(0, 0, 1);
		CustomAssert.assertTrue(flag, "Exchange Value ascending sorting  validated successfully",
				"fail to validate Exchange Value ascending sorting");
		flag = MyRewardPage.checkSort(0, 0, 2);
		CustomAssert.assertTrue(flag, "Exchange Value descending sorting  validated successfully",
				"fail to validate Exchange Value descending sorting");

	}

	@Test(description = "Verify that sorting working correctly")
	public void TSSHYB121() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = MyRewardPage.navigateToMyRewardTab();
		CustomAssert.assertTrue(flag, "successfully landed on my reward page", "Fail to land on my reward page");
		flag = MyRewardPage.exchangeAndRedeemButtonsValidation(1, 0, 0);
		CustomAssert.assertTrue(flag, "Redeem button  validated successfully", "fail to validate Redeem button");
		flag = MyRewardPage.exchangeAndRedeemButtonsValidation(0, 1, 0);
		CustomAssert.assertTrue(flag, "Exchange button's Visibility  validated successfully",
				"fail to validate Exchange button's Visibility");
		flag = MyRewardPage.exchangeAndRedeemButtonsValidation(0, 0, 1);
		CustomAssert.assertTrue(flag, "Exchange button's working validated successfully",
				"fail to validate Exchange button's working");

	}
    
}
