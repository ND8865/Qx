package TestScripts_Sprint02;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Exchange_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class Exchange_Gamer_Tests {

	WebDriver driver;
	Exchange_Gamer ExchangePage;
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
		ExchangePage = new Exchange_Gamer(driver);
		signInPage = new SignInPage_Gamer(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Verify that all elements are visible ")
	public void TSSHYB124() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.checkAllExchangePageElements();
		CustomAssert.assertTrue(flag, "All elements are validated successfully", "Fail to validate all elements");
	}

	@Test(description = "Verify that linked games are showing correctly")
	public void TSSHYB125() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.linkedGamesCountValidation();
		CustomAssert.assertTrue(flag, "Linked Games count validated successfully",
				"Fail to validate Linked Games count");
	}

	@Test(description = "Verify search validation for correct and incorrect values")
	public void TSSHYB126() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.searchValidation();
		CustomAssert.assertTrue(flag, "Search feature validated successfully", "Fail to validate search feature");
		flag = ExchangePage.searchValidationWrongKeys("qwerty");
		CustomAssert.assertTrue(flag, "Search feature validated successfully with wrong text",
				"fail to validate search feature");
	}

	@Test(description = "Verify that sorting working correctly")
	public void TSSHYB127() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.checkSort(1, 0);
		CustomAssert.assertTrue(flag, "game name ascending sorting  validated successfully",
				"fail to validate game name ascending sorting");
		flag = ExchangePage.checkSort(2, 0);
		CustomAssert.assertTrue(flag, "game name descending sorting  validated successfully",
				"fail to validate game name descending sorting");
		flag = ExchangePage.checkSort(0, 1);
		CustomAssert.assertTrue(flag, "Points ascending sorting  validated successfully",
				"fail to validate Points ascending sorting");
		flag = ExchangePage.checkSort(0, 2);
		CustomAssert.assertTrue(flag, "Points descending sorting  validated successfully",
				"fail to validate Points descending sorting");
	}

	@Test(description = "Verify that each Exchange button visible and working ")
	public void TSSHYB128() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.exchangeButtonsValidation(1, 0);
		CustomAssert.assertTrue(flag, "Exchange buttons visibility validated successfully",
				"fail to validate Exchange buttons visibility");
		flag = ExchangePage.exchangeButtonsValidation(0, 1);
		CustomAssert.assertTrue(flag, "Exchange buttons working validated successfully",
				"fail to validate Exchange buttons working");

	}

	@Test(description = "Verify that selected game each asset showing correct Qx points in Each row.")
	public void TSSHYB129() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.exchangeButtonsValidation(1, 0);
		CustomAssert.assertTrue(flag, "Exchange buttons visibility validated successfully",
				"fail to validate Exchange buttons visibility");
		flag = ExchangePage.exchangeButtonsValidation(0, 1);
		CustomAssert.assertTrue(flag, "Exchange buttons working validated successfully",
				"fail to validate Exchange buttons working");
		flag = ExchangePage.eachAssetToQxPointValidation();
		CustomAssert.assertTrue(flag, "Selected game's each row asset validated successfully",
				"fail to validate Selected game's each row asset");

	}

	@Test(description = "Verify that selected game total points and asset showing correctly and redirecting ")
	public void TSSHYB130() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.exchangeButtonsValidation(1, 0);
		CustomAssert.assertTrue(flag, "Exchange buttons visibility validated successfully",
				"fail to validate Exchange buttons visibility");
		flag = ExchangePage.exchangeButtonsValidation(0, 1);
		CustomAssert.assertTrue(flag, "Exchange buttons working validated successfully",
				"fail to validate Exchange buttons working");
		flag = ExchangePage.selectedGameTotalPointsValidation();
		CustomAssert.assertTrue(flag, "Selected game's total points validated successfully",
				"fail to validate Selected game's total points");
		flag = ExchangePage.selectedGameAssetVisibilityAndRedirectValidation();
		CustomAssert.assertTrue(flag, "Asset visibility and Redirection validated successfully",
				"fail to validate Asset visibility and Redirection");

	}

	@Test(description = "Verify that all elements are visible on asset field page ")
	public void TSSHYB131() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.exchangeButtonsValidation(1, 0);
		CustomAssert.assertTrue(flag, "Exchange buttons visibility validated successfully",
				"fail to validate Exchange buttons visibility");
		flag = ExchangePage.exchangeButtonsValidation(0, 1);
		CustomAssert.assertTrue(flag, "Exchange buttons working validated successfully",
				"fail to validate Exchange buttons working");
		flag = ExchangePage.selectedGameAssetVisibilityAndRedirectValidation();
		CustomAssert.assertTrue(flag, "Asset visibility and Redirection validated successfully",
				"fail to validate Asset visibility and Redirection");
		flag = ExchangePage.checkAllAssetFieldPageElements();
		CustomAssert.assertTrue(flag, "All elements on asset field page are validated successfully",
				"Fail to validate all elements on asset field page");

	}

	@Test(description = "Verify all the validation on asset fileds and conversion cash ")
	public void TSSHYB132() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangeTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange page", "Fail to land on Exchange page");
		flag = ExchangePage.exchangeButtonsValidation(1, 0);
		CustomAssert.assertTrue(flag, "Exchange buttons visibility validated successfully",
				"fail to validate Exchange buttons visibility");
		flag = ExchangePage.exchangeButtonsValidation(0, 1);
		CustomAssert.assertTrue(flag, "Exchange buttons working validated successfully",
				"fail to validate Exchange buttons working");
		flag = ExchangePage.selectedGameAssetVisibilityAndRedirectValidation();
		CustomAssert.assertTrue(flag, "Asset visibility and Redirection validated successfully",
				"fail to validate Asset visibility and Redirection");
		flag = ExchangePage.assetQuantityFieldValidation(true, false, false, false);
		CustomAssert.assertTrue(flag, "Larger value than available asset validated successfully",
				"Fail to validate Larger value than available asset");
		flag = ExchangePage.assetQuantityFieldValidation(false, true, false, false);
		CustomAssert.assertTrue(flag, "Zero asset validated successfully", "Fail to validate zero asset");
		flag = ExchangePage.assetQuantityFieldValidation(false, false, true, false);
		CustomAssert.assertTrue(flag, "Blank asset validated successfully", "Fail to validate blank asset");
		flag = ExchangePage.assetQuantityFieldValidation(false, false, false, true);
		CustomAssert.assertTrue(flag, "Valid asset input validated successfully", "Fail to validate Valid asset input");
		flag = ExchangePage.assetfieldPageExchangeButtonvalidation();
		CustomAssert.assertTrue(flag, "Exchange Button and Confirm pop-up validated successfully",
				"Fail to validate Exchange Button and Confirm pop-up");

	}

	@Test(description = "Verify that all elements are visible on Exchange Transaction page ")
	public void TSSHYB133() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangetransactionTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange Transaction",
				"Fail to land on Exchange Transaction");
		flag = ExchangePage.checkAllExchangeTransactionPageElements();
		CustomAssert.assertTrue(flag, "All elements on Exchange Transaction page are validated successfully",
				"Fail to validate elements on Exchange Transaction page");
	}

	@Test(description = "Verify that search feature working corectly on exchange transaction page ")
	public void TSSHYB134() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangetransactionTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange Transaction",
				"Fail to land on Exchange Transaction");
		flag = ExchangePage.searchValidationTransactionPage(true, false, "");
		CustomAssert.assertTrue(flag, "Exchange Transaction page search validated successfully",
				"Fail to validate elements on Exchange Transaction page search");
		flag = ExchangePage.searchValidationTransactionPage(false, true, "qwerty");
		CustomAssert.assertTrue(flag, "Exchange Transaction page search validated successfully with wrong game name",
				"Fail to validate elements on Exchange Transaction page search with wrong game name");
	}

	@Test(description = "Verify that total QX points and Dollar value showing correctly on Exchange Transaction page ")
	public void TSSHYB136() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangetransactionTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange Transaction",
				"Fail to land on Exchange Transaction");
		flag = ExchangePage.totalExchangedQxPointsValidation();
		CustomAssert.assertTrue(flag, "Exchange Transaction page total Qx points and dollar validated successfully",
				"Fail to validate Exchange Transaction page total Qx points and dollar");
		flag = ExchangePage.eachGameQxPointValidation();
		CustomAssert.assertTrue(flag, "Exchange Transaction page each game QX points validated successfully",
				"Fail to validate Exchange Transaction page each game QX points");
	}

	@Test(description = "Verify that sorting working correctly ")
	public void TSSHYB135() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = ExchangePage.navigateToExchangetransactionTab();
		CustomAssert.assertTrue(flag, "successfully landed on Exchange Transaction",
				"Fail to land on Exchange Transaction");
		flag = ExchangePage.checkSortExchangetransaction(1, 0, 0);
		CustomAssert.assertTrue(flag, "game name ascending sorting  validated successfully",
				"fail to validate game name ascending sorting");
		flag = ExchangePage.checkSortExchangetransaction(2, 0, 0);
		CustomAssert.assertTrue(flag, "game name descending sorting  validated successfully",
				"fail to validate game name descending sorting");
		flag = ExchangePage.checkSortExchangetransaction(0, 1, 0);
		CustomAssert.assertTrue(flag, "qxPoints ascending sorting  validated successfully",
				"fail to validate qxPoints ascending sorting");
		flag = ExchangePage.checkSortExchangetransaction(0, 2, 0);
		CustomAssert.assertTrue(flag, "qxPoints descending sorting  validated successfully",
				"fail to validate qxPoints descending sorting");
		flag = ExchangePage.checkSortExchangetransaction(0, 0, 1);
		CustomAssert.assertTrue(flag, "Transaction date ascending sorting  validated successfully",
				"fail to validate Transaction date ascending sorting");
		flag = ExchangePage.checkSortExchangetransaction(0, 0, 2);
		CustomAssert.assertTrue(flag, "Transaction date descending sorting  validated successfully",
				"fail to validate Transaction date descending sorting");
	}

}
