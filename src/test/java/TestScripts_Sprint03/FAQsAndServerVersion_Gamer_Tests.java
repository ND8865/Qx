package TestScripts_Sprint03;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.FAQsAndServerVersion_Gamer;
import PageObjectClasses.SignInPage_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class FAQsAndServerVersion_Gamer_Tests {
	
	WebDriver driver;
	
	SignInPage_Gamer signInPage;
	
	FAQsAndServerVersion_Gamer FAQsAndServerVersionPage;
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
		FAQsAndServerVersionPage = new FAQsAndServerVersion_Gamer(driver);
		signInPage = new SignInPage_Gamer(driver);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@Test(description = "Verify all elements are visible on FAQs page.")
	public void TSSHYB164() {
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = FAQsAndServerVersionPage.navigateToFAQs();
		CustomAssert.assertTrue(flag, "successfully landed on FAQa page", "Fail to land on FAQs page");
		flag = FAQsAndServerVersionPage.checkElementsVisibilityFAQsPage();
		CustomAssert.assertTrue(flag, "All elements visibility validated on FAQs page", "Fail to validate all elements on FAQs page");
		
	}
	
	@Test(description = "Verify that server version showing correctly.")
	public void TSSHYB165() {
		String ServerVersion = Utility.getPropertiesFile("primaryLogin", "gamerServerVersion");
		boolean flag = signInPage.signinAction(UserNameGamer, PasswordGamer);
		CustomAssert.assertTrue(flag, "Signin action successfully completed", "Fail to sign in");
		flag = FAQsAndServerVersionPage.serverVersionValidation(ServerVersion);
		CustomAssert.assertTrue(flag, "successfully validated server version", "Fail to validate server version");
		
	}
	
	

}
