package TestScripts_Sprint03;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Premium_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class Premium_Gamer_Tests {
	
	WebDriver driver;
	
	Premium_Gamer premiumPage;
	SignInPage_Gamer signInPage;

	String UserNameGamer;
	String PasswordGamer;
	String monthlyPrice;
	String AnnuallyPrice;
	
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
		monthlyPrice = Utility.getPropertiesFile("primaryLogin", "monthlyPrice3");
		AnnuallyPrice = Utility.getPropertiesFile("primaryLogin", "annuallyPrice3");
	}
	
	
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer");
		premiumPage = new Premium_Gamer(driver);
		signInPage = new SignInPage_Gamer(driver);

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify all elements are visible on Premium page.")
	public void TSSHYB166() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.checkElementsVisibilityPremiumPage();
		CustomAssert.assertTrue(flag, "All elements visibility validated on premium page", "Fail to validate all elements on premium page");
		
	}
	
	@Test(description = "Verify that plan price and toggle button working correctly.")
	public void TSSHYB167() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.validatingMonthlyAndAnnuallyPrices(monthlyPrice, AnnuallyPrice);
		CustomAssert.assertTrue(flag, "Monthly and Annually prices validated successfully on premium page", "Fail to validate Monthly and Annually on premium page");
		flag = premiumPage.packageToggleValidation();
		CustomAssert.assertTrue(flag, "Toggle button validated successfully on premium page", "Fail to validate Toggle button on premium page");
		
	}
	
	@Test(description = "Verify that subscribe button working or not")
	public void TSSHYB168() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.subscribeButtonValdation();
		CustomAssert.assertTrue(flag, "Subscribe button validated successfully on premium page", "Fail to validate subscribe button on premium page");
		flag = premiumPage.paymentPageBackButtonValdation();
		CustomAssert.assertTrue(flag, "Payment Page back link validated successfully", "Fail to validate Payment Page back link");
		
	}
	
	@Test(description = "Verify that wrong payment info  flow  working correctly")
	public void TSSHYB169() {
		String CardNumber2 = Utility.getPropertiesFile("primaryLogin", "cardNumber2");
		String ExpiryDate2 = Utility.getPropertiesFile("primaryLogin", "expiryDate2");
		String CvvNumber2 = Utility.getPropertiesFile("primaryLogin", "cvv2");
		String CardHolderName2 = Utility.getPropertiesFile("primaryLogin", "CardHolderName2");
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.subscribeButtonValdation();
		CustomAssert.assertTrue(flag, "Subscribe button validated successfully on premium page", "Fail to validate subscribe button on premium page");
		flag = premiumPage.paymentPagePriceAndEmailValdation("Monthly", monthlyPrice, AnnuallyPrice);
		CustomAssert.assertTrue(flag, "Payment page plan price and user email validated successfully", "Fail to validate Payment Page plan price and user email");
		flag = premiumPage.paymentFlowValdation(false, CardNumber2, ExpiryDate2, CvvNumber2, CardHolderName2);
		CustomAssert.assertTrue(flag, "Payment processing failed validated successfully", "Fail to validate Payment processing failed");
		
	}
	
	@Test(description = "Verify that payment flow working correctly")
	public void TSSHYB170() {
		String CardNumber1 = Utility.getPropertiesFile("primaryLogin", "cardNumber1");
		String ExpiryDate1 = Utility.getPropertiesFile("primaryLogin", "expiryDate1");
		String CvvNumber1 = Utility.getPropertiesFile("primaryLogin", "cvv1");
		String CardHolderName1 = Utility.getPropertiesFile("primaryLogin", "CardHolderName1");
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.subscribeButtonValdation();
		CustomAssert.assertTrue(flag, "Subscribe button validated successfully on premium page", "Fail to validate subscribe button on premium page");
		flag = premiumPage.paymentFlowValdation(true, CardNumber1, ExpiryDate1, CvvNumber1, CardHolderName1);
		CustomAssert.assertTrue(flag, "Payment validated successfully", "Fail to validate Payment");
		
	}
   
	@Test(description = "Verify that after subscription of one plan payment flow should not come up again")
	public void TSSHYB171() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = premiumPage.navigateToPremium();
		CustomAssert.assertTrue(flag, "successfully landed on premium page", "Fail to land on premium page");
		flag = premiumPage.subscribeButtonValdationAfterSubscription();
		CustomAssert.assertTrue(flag, "successfully stayed on premium page", "Fail to stayed on premium page");
		flag = premiumPage.annuallypackageToggleValidation();
		CustomAssert.assertTrue(flag, "Subscribe button for annually validated successfully on premium page", "Fail to validate subscribe button annually on premium page");
		flag = premiumPage.subscribeButtonValdationAfterSubscription();
		CustomAssert.assertTrue(flag, "successfully stayed on premium page", "Fail to stayed on premium page");
		
	}

}
