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
import PageObjectClasses.LinkGames_Gamer;
import PageObjectClasses.MailBox;
import PageObjectClasses.SignInPage_Gamer;
import PageObjectClasses.SignUp_CreateAccount_Partner_Page;
import PageObjectClasses.TopBar_Gamer;
import TestListners.CustomAssert;
import UtilityClass.APICalls;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class LinkGames_Gamer_Tests {
	
	private WebDriver driver;
	
	String adminUsername = Utility.getPropertiesFile("primaryLogin", "superAdminUsername");
	String adminPassword = Utility.getPropertiesFile("primaryLogin", "superAdminPassword");
	String partnerUsername = "";
	String partnerPassword = "";
	String gamerUsername = "";
	String gamerPassword = "";
	
	
	String auth = "";
	ArrayList<String[]> data = new ArrayList<String[]>();
	
	SignInPage_Gamer signIn;
	TopBar_Gamer menu;
	LinkGames_Gamer game;
	SignUp_CreateAccount_Partner_Page partner;
	MailBox mail;
	
	@BeforeClass
	public void beforeClass() {
		auth = APICalls.apiLogin(adminUsername, adminPassword);
		data = APICalls.getTotalPublishedGamesInfoFromAdmin(auth);
		
		String count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		int c = Integer.parseInt(count)+1;
		gamerUsername = "qa_gamer131"+c;
		String EmailGamer = "qa_gamer131"+c+"@1secmail.com";
		gamerPassword = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		boolean flag = APICalls.prepareGamerAccount(gamerUsername, EmailGamer, gamerPassword, "Gamer", "Automation");
		Assert.assertTrue(flag);
		
		count = Utility.getPropertiesFile("testDataVariables", "signUpUserCount");
		c = Integer.parseInt(count)+1;
		partnerUsername = "qa_partner11"+c;
		String emailPartner = "qa_partner11"+c+"@1secmail.com";
		partnerPassword = "Qwerty@12345678";
		Utility.setTempProperties("testDataVariables", "signUpUserCount",c+"");
		
		driver = DriverClass.setDriver("chrome", "partner");
		partner = new SignUp_CreateAccount_Partner_Page(driver);
		WaitClass.waitForTime(10000);
		flag = partner.CreateAccountButtonClick();
		Assert.assertTrue(flag);
		flag = partner.SignUpCreateAccount("Automation Partner", partnerUsername, emailPartner, partnerPassword, partnerPassword);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(5000);
        mail = new MailBox();
        String verificationCode = mail.getEmailData(emailPartner, "body > em", 2);
		flag = partner.ConfirmAccount(verificationCode);
		Assert.assertTrue(flag);
		WaitClass.waitForTime(10000);
		driver.quit();
		flag = APICalls.preparePartnerAccountAfterSignup(emailPartner, partnerUsername, partnerPassword, adminUsername, adminPassword);
		Assert.assertTrue(flag);
	}
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void beforeMethod(String browser) {
		driver = DriverClass.setDriver(browser, "gamer"); 
		signIn = new SignInPage_Gamer(driver);
		menu = new TopBar_Gamer(driver);
		game = new LinkGames_Gamer(driver);
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(description = "Verify that the user is able to redirect to the game's page on clicking the Link Games menu item.")
	public void TSSHYB78() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
	}
	
	@Test(description = "Verify that the user is able to see the total number of published games on the Link Game page.")
	public void TSSHYB79() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		flag = game.verifyNumberOfGames(data.size()+"");
		CustomAssert.assertTrue(flag, "Number of games shown validated.", "Unable to validate the number of games shown.");
	}
	
	@Test(description = "Verify that the search bar is working properly.")
	public void TSSHYB80() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = game.searchGames(data.get(random)[0], true);
		CustomAssert.assertTrue(flag, "Search according to Game name verified.", "Unable to verify search according to game name.");
		flag = game.searchGames(data.get(random)[2], true);
		CustomAssert.assertTrue(flag, "Search according to Description text verified.", "Unable to verify search according to description text.");
		flag = game.searchGames("zzzzyzzzzyzsksl", false);
		CustomAssert.assertTrue(flag, "Search for no results found verified.", "Unable to verify search for no results found.");
	}
	
	@Test(description = "Verify that the filters are working on grid view.")
	public void TSSHYB81() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		WaitClass.waitForTime(2000);
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		ArrayList<String> games = new ArrayList<String>();
		int random = Utility.getRandomInt(0, data.size()-1);
		games.add(data.get(random)[0]);
		flag = game.applyFilters(true, games, 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to game names.", "Unable to add filters according to game names.");
		flag = game.validateFilterInGrid(games, 0);
		CustomAssert.assertTrue(flag, "Game name filter verified.", "Unable to verify game name filter.");
		flag = game.applyFilters(true, new ArrayList<String>(), 0, 1);
		CustomAssert.assertTrue(flag, "Game name filter removed.", "Unable to remove game name filter.");
		flag = game.applyFilters(true, new ArrayList<String>(), 1, 0);
		CustomAssert.assertTrue(flag, "Linked Status filter applied.", "Unable to apply Linked status filter.");
		flag = game.validateFilterInGrid(new ArrayList<String>(), 1);
		CustomAssert.assertTrue(flag, "Linked Status filter verified.", "Unable to verify Linked status filter.");
		flag = game.applyFilters(true, new ArrayList<String>(), 0, 2);
		CustomAssert.assertTrue(flag, "Linked status filter removed.", "Unable to remove Linked status filter.");
		flag = game.applyFilters(true, new ArrayList<String>(), 2, 0);
		CustomAssert.assertTrue(flag, "Not linked status filter applied.", "Unable to apply Not linked status filter.");
		flag = game.validateFilterInGrid(new ArrayList<String>(), 2);
		CustomAssert.assertTrue(flag, "Not linked status filter verified.", "Unable to verify Not linked status filter.");
		flag = game.applyFilters(true, new ArrayList<String>(), 0, 2);
		CustomAssert.assertTrue(flag, "Not linked status filter removed.", "Unable to remove Not linked status filter.");
	}
	
	@Test(description = "Verify that the sort button on the linked games page.")
	public void TSSHYB82() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		flag = game.checkSortBtn();
		CustomAssert.assertTrue(flag, "Sort verified.", "Unable to verify sort.");
	}
	
	@Test(description = "Verify that the view buttons on the linked games page.")
	public void TSSHYB83() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		flag = game.checkViewBtns();
		CustomAssert.assertTrue(flag, "View button's working verified.", "Unable to verify view button's working.");
	}
	
	@Test(description = "Verify that the filters are working on list view.")
	public void TSSHYB84() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		ArrayList<String> games = new ArrayList<String>();
		int random = Utility.getRandomInt(0, data.size()-1);
		games.add(data.get(random)[0]);
		flag = game.applyFilters(false, games, 0, 0);
		CustomAssert.assertTrue(flag, "Filters applied according to game names.", "Unable to add filters according to game names.");
		flag = game.validateFilterInList(games, 0);
		CustomAssert.assertTrue(flag, "Game name filter verified.", "Unable to verify game name filter.");
		flag = game.applyFilters(false, new ArrayList<String>(), 0, 1);
		CustomAssert.assertTrue(flag, "Game name filter removed.", "Unable to remove game name filter.");
		flag = game.applyFilters(false, new ArrayList<String>(), 1, 0);
		CustomAssert.assertTrue(flag, "Linked Status filter applied.", "Unable to apply Linked status filter.");
		flag = game.validateFilterInList(new ArrayList<String>(), 1);
		CustomAssert.assertTrue(flag, "Linked Status filter verified.", "Unable to verify Linked status filter.");
		flag = game.applyFilters(false, new ArrayList<String>(), 0, 2);
		CustomAssert.assertTrue(flag, "Linked status filter removed.", "Unable to remove Linked status filter.");
		flag = game.applyFilters(false, new ArrayList<String>(), 2, 0);
		CustomAssert.assertTrue(flag, "Not linked status filter applied.", "Unable to apply Not linked status filter.");
		flag = game.validateFilterInList(new ArrayList<String>(), 2);
		CustomAssert.assertTrue(flag, "Not linked status filter verified.", "Unable to verify Not linked status filter.");
		flag = game.applyFilters(false, new ArrayList<String>(), 0, 2);
		CustomAssert.assertTrue(flag, "Not linked status filter removed.", "Unable to remove Not linked status filter.");
	}
	
	@Test(description = "Verify that the user is able to see Game name, description text and description in grid view.")
	public void TSSHYB85() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = game.checkGameData(true, data.get(random)[0], data.get(random)[2], data.get(random)[1], "");
		CustomAssert.assertTrue(flag, "Game data verified.", "Unable to verify game data.");
	}
	
	@Test(description = "Verify that the user is able to see Game name, description text and description in list view.")
	public void TSSHYB86() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = game.checkGameData(true, data.get(random)[0], data.get(random)[2], data.get(random)[1], "");
		CustomAssert.assertTrue(flag, "Game data verified.", "Unable to verify game data.");
	}
	
	@Test(description = "Verify that the user is able to see the steps to link a game in Unlinked game's details section.")
	public void TSSHYB87() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		flag = game.applyFilters(true, new ArrayList<String>(), 2, 0);
		CustomAssert.assertTrue(flag, "Not linked filter applied", "Unable to apply the filter.");
		flag = game.checkHowToLink();
		CustomAssert.assertTrue(flag, "How to link steps verified.", "Unable to verify how to link.");
	}
	
	@Test(description = "Verify that the user is not able to see the steps to link a game in Linked game's details section.")
	public void TSSHYB88() {
		boolean flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		flag = game.applyFilters(true, new ArrayList<String>(), 1, 0);
		CustomAssert.assertTrue(flag, "Not linked filter applied", "Unable to apply the filter.");
		flag = game.checkHowToLink();
		CustomAssert.assertFalse(flag, "How to link steps not found as expected.", "How to links steps found!");
	}
	
	@Test(description = "Verify that if a partner adds a new game and admin publishes it, it will be visible to the gamer portal.")
	public void TSSHYB89() {
		String authToken = APICalls.apiLogin(partnerUsername, partnerPassword);
		CustomAssert.assertTrue(authToken.length()>6, "Partner auth found.", "Unable to get partner auth.");
		String gameCount = Utility.getPropertiesFile("testDataVariables", "gameNo");
		int gameCounter = Integer.parseInt(gameCount)+1;
		Utility.setTempProperties("testDataVariables", "gameNo", gameCounter+"");
		String gameId = APICalls.createGame(authToken, "Automation Game "+gameCounter, "This is the description for game "+gameCounter, data.get(0)[3], "https://www.google.com");
		CustomAssert.assertTrue(gameId.length()>6, "Game created by partner successfully.", "Unable to create the game by partner.");
		authToken = APICalls.apiLogin(adminUsername, adminPassword);
		CustomAssert.assertTrue(authToken.length()>6, "Admin auth found.", "Unable to get admin auth.");
		boolean flag = APICalls.approveGame(authToken, gameId);
		CustomAssert.assertTrue(flag, "Game approved by admin", "Unable to approve game by admin");
		flag = signIn.signinAction(gamerUsername, gamerPassword);
		CustomAssert.assertTrue(flag, "Login action performed", "Unable to perform login actions");
		flag = menu.clickMenuItem(1);
		CustomAssert.assertTrue(flag, "Redirected to the gamer page.", "Unable to redirect to the gamer page.");
		int random = Utility.getRandomInt(0, data.size()-1);
		flag = game.checkGameData(true, data.get(random)[0], data.get(random)[2], data.get(random)[1], "");
		CustomAssert.assertTrue(flag, "Game data verified.", "Unable to verify game data.");
	}

}
