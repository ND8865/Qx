package TestScripts_Sprint01;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.DriverClass;
import PageObjectClasses.Offers_Gamers;
import PageObjectClasses.SignInPage_Gamer;
import PageObjectClasses.TopBar_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;

public class Offers_Gamer_Tests {
	
	
private WebDriver driver;
	
	String adminUsername = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
	String adminPassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
	String gamerUsername = "";
	String gamerPassword = "";
	String gamerEmail;
	
	
	String auth = "";
	ArrayList<String[]> data = new ArrayList<String[]>();
	
	
	SignInPage_Gamer signIn;
	TopBar_Gamer menu;
	Offers_Gamers offer;
	
	@BeforeClass
	public void beforeClass() {
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int counter = Integer.parseInt(count)+1;
		gamerUsername = "automation_gamer"+counter;
		gamerEmail = "automation_gamer"+counter+"@1secmail.com";
		gamerPassword = "Qwerty@12345678";
		String firstname = "Automation";
		String lastname = "Gamer"+counter;
		boolean flag = APICalls.prepareGamerAccount(gamerUsername, gamerEmail, gamerPassword, firstname, lastname);
		Utility.setTempProperties("testDataVariables", "signUpUserCount", counter+"");
		Assert.assertTrue(flag);
		auth = APICalls.apiLogin(gamerUsername, gamerPassword);
		data = APICalls.getTotalOffersListFromGamer(auth);
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer"); 
		signIn = new SignInPage_Gamer(driver);
		menu = new TopBar_Gamer(driver);
		offer = new Offers_Gamers(driver);
		
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify that the user is able to redirect to the Offer's page on clicking the Offers menu item.")
	public void TSSHYB71() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
	}
	
	@Test(description = "Verify that the user is able to see the total number of Offers on the Offer's page.")
	public void TSSHYB72() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		flag = offer.verifyNumberOfOffers(data.size()+"");
		CustomAssert.assertTrue(flag, "Number of offers shown validated.", "Unable to validate the number of offers shown.");
	}
	
	@Test(description = "Verify that the search bar is working properly.")
	public void TSSHYB73() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = offer.searchOffer(data.get(random)[1], true);
		CustomAssert.assertTrue(flag, "Search according to offer name verified.", "Unable to verify search according to offer name.");
		flag = offer.searchOffer("zzzzyzzzzyzsksl", false);
		CustomAssert.assertTrue(flag, "Search for no results found verified.", "Unable to verify search for no results found.");
	}
	
	@Test(description = "Verify that the filters are working.")
	public void TSSHYB74() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		ArrayList<String> offerName = new ArrayList<String>();
		ArrayList<String> gameName = new ArrayList<String>();
		int random = Utility.getRandomInt(0, data.size()-1);
		offerName.add(data.get(random)[1]);
		gameName.add(data.get(random)[5]);
		String startDate = data.get(random)[3];
		String endDate = data.get(random)[4];
		
		flag = offer.applyFilters(offerName, new ArrayList<String>(), "", "", 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Offer names.", "Unable to add filters according to Offer names.");
		flag = offer.validateFilter(offerName, new ArrayList<String>(), "", "", 0);
		CustomAssert.assertTrue(flag, "Offer name filter verified.", "Unable to verify Offer name filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 1);
		CustomAssert.assertTrue(flag, "Offer name filter removed.", "Unable to remove offer name filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), gameName, "", "", 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Game names.", "Unable to add filters according to Game names.");
		flag = offer.validateFilter(new ArrayList<String>(), gameName, "", "", 0);
		CustomAssert.assertTrue(flag, "Game name filter verified.", "Unable to verify game name filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 2);
		CustomAssert.assertTrue(flag, "Game name filter removed.", "Unable to remove game name filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), startDate, "", 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Start Date.", "Unable to add filters according to Start date.");
		flag = offer.validateFilter(new ArrayList<String>(), new ArrayList<String>(), startDate, "", 0);
		CustomAssert.assertTrue(flag, "Start Date filter verified.", "Unable to verify Start Date filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 3);
		CustomAssert.assertTrue(flag, "Start Date filter removed.", "Unable to remove start date filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", endDate, 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to End Date.", "Unable to add filters according to End date.");
		flag = offer.validateFilter(new ArrayList<String>(), new ArrayList<String>(), "", endDate, 0);
		CustomAssert.assertTrue(flag, "End Date filter verified.", "Unable to verify End Date filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 4);
		CustomAssert.assertTrue(flag, "End Date filter removed.", "Unable to remove End date filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 1, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Current status.", "Unable to add filters according to Current status.");
		flag = offer.validateFilter(new ArrayList<String>(), new ArrayList<String>(), "", "", 1);
		CustomAssert.assertTrue(flag, "Current status filter verified.", "Unable to verify Current status filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 5);
		CustomAssert.assertTrue(flag, "Status filter removed.", "Unable to remove Status filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 2, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Expired status.", "Unable to add filters according to Expired status.");
		flag = offer.validateFilter(new ArrayList<String>(), new ArrayList<String>(), "", "", 2);
		CustomAssert.assertTrue(flag, "Expired status filter verified.", "Unable to verify Expired status filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 5);
		CustomAssert.assertTrue(flag, "Status filter removed.", "Unable to remove Status filter.");
		
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 3, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to Approved status.", "Unable to add filters according to Approved status.");
		flag = offer.validateFilter(new ArrayList<String>(), new ArrayList<String>(), "", "", 3);
		CustomAssert.assertTrue(flag, "Approved status filter verified.", "Unable to verify Approved status filter.");
		flag = offer.applyFilters(new ArrayList<String>(), new ArrayList<String>(), "", "", 0, 5);
		CustomAssert.assertTrue(flag, "Status filter removed.", "Unable to remove Status filter.");
	}
	
	@Test(description = "Verify that the sort functionality is working.")
	public void TSSHYB75() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		flag = offer.checkSort(1, 0, 0, 0, 0, 0);
		CustomAssert.assertTrue(flag, "offer sort with ascending order verified.", "Unable to verify offer sort with ascending order.");
		flag = offer.checkSort(2, 0, 0, 0, 0, 0);
		CustomAssert.assertTrue(flag, "offer sort with descending order verified.", "Unable to verify offer sort with descending order.");
		flag = offer.checkSort(0, 1, 0, 0, 0, 0);
		CustomAssert.assertTrue(flag, "game sort with ascending order verified.", "Unable to verify game sort with ascending order.");
		flag = offer.checkSort(0, 2, 0, 0, 0, 0);
		CustomAssert.assertTrue(flag, "game sort with descending order verified.", "Unable to verify game sort with descending order.");
		flag = offer.checkSort(0, 0, 1, 0, 0, 0);
		CustomAssert.assertTrue(flag, "start date sort with ascending order verified.", "Unable to verify start date sort with ascending order.");
		flag = offer.checkSort(0, 0, 2, 0, 0, 0);
		CustomAssert.assertTrue(flag, "start date sort with descending order verified.", "Unable to verify start date sort with descending order.");
		flag = offer.checkSort(0, 0, 0, 1, 0, 0);
		CustomAssert.assertTrue(flag, "end date sort with ascending order verified.", "Unable to verify end date sort with ascending order.");
		flag = offer.checkSort(0, 0, 0, 2, 0, 0);
		CustomAssert.assertTrue(flag, "end date sort with descending order verified.", "Unable to verify end date sort with descending order.");
		flag = offer.checkSort(0, 0, 0, 0, 1, 0);
		CustomAssert.assertTrue(flag, "progress sort with ascending order verified.", "Unable to verify progress sort with ascending order.");
		flag = offer.checkSort(0, 0, 0, 0, 2, 0);
		CustomAssert.assertTrue(flag, "progress sort with descending order verified.", "Unable to verify progress sort with descending order.");
		flag = offer.checkSort(0, 0, 0, 0, 0, 1);
		CustomAssert.assertTrue(flag, "status sort with ascending order verified.", "Unable to verify status sort with ascending order.");
		flag = offer.checkSort(0, 0, 0, 0, 0, 2);
		CustomAssert.assertTrue(flag, "status sort with descending order verified.", "Unable to verify status sort with descending order.");
	}
	
	@Test(description = "Verify that the user is able to see Offer name, Game name, description text, start Date and End Date in list view.")
	public void TSSHYB76() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = offer.checkOfferListView(data.get(random)[1], data.get(random)[5], data.get(random)[2], data.get(random)[3], data.get(random)[4]);
		CustomAssert.assertTrue(flag, "offer list view data verified.", "Unable to verify offer list view data.");
	}
	
	@Test(description = "Verify that the user is able to see offer name, offer description, achievement name, achievement description, reward, Game name, start date and end date in detailed view of an offer.")
	public void TSSHYB77() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(2);
		CustomAssert.assertTrue(flag, "Redirected to the offer page.", "Unable to redirect to the offer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		String id = data.get(random)[0];
		auth = APICalls.apiLogin(adminUsername, adminPassword);
		String[] details = APICalls.getOfferDetails(auth, id);
		flag = offer.checkDetailedViewData(details[0], details[1], details[2], details[3], details[4], details[5], details[6], details[7]);
		CustomAssert.assertTrue(flag, "offer detailed view data verified.", "Unable to verify offer detailed view data.");
	}

}
