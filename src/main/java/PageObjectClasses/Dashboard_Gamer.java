package PageObjectClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Dashboard_Gamer {

	private WebDriver driver;
	
	LinkGames_Gamer linkGames;
	

	public Dashboard_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		linkGames = new LinkGames_Gamer(driver);
	}
	// Gamer's Name Tile Element Locators

	@FindBy(xpath = "//img[@data-testid='profileImage']")
	private WebElement profileImage;

	@FindBy(xpath = "//h2[@data-testid='gamerName']")
	private WebElement gamerNameGreeting;

	@FindBy(xpath = "//h4")
	private WebElement welcomeText;

	@FindBy(xpath = "//div[@data-testid='linkedGamesCount']")
	private WebElement linkedGamesCount;

	@FindBy(xpath = "(//*[text() = 'Linked Games'])[1]")
	private WebElement linkedGamesTxt;

	@FindBy(xpath = "//*[text() = 'QX Points']/preceding-sibling::div")
	private WebElement qxPoints;

	@FindBy(xpath = "//*[text() = 'QX Points']")
	private WebElement qxPointsTxt;

	@FindBy(xpath = "//div[text() = 'Rewards In Progress']/preceding-sibling::div")
	private WebElement rewardCount;

	@FindBy(xpath = "//div[text() = 'Rewards In Progress']")
	private WebElement rewardCountTxt;

	// Explore Games Tile Element Locators

	@FindBy(xpath = "//div[text() = 'on our platform']/parent::div/div[contains(text() , 'Games')]")
	private WebElement totalPlatformGames;

	@FindBy(xpath = "//div[text() = 'on our platform']")
	private WebElement onOurPlatformTxt;

	@FindBy(xpath = "//a[text() = 'Explore']")
	private WebElement exploreLink;

	// Green Tile Element Locators
	@FindBy(xpath = "//a[text() = 'Redeem']/parent::div//div[contains(text() , 'QX Points')]")
	private WebElement qxPointstext;

	@FindBy(xpath = "//a[text() = 'Redeem']/parent::div//div[contains(text() , 'exchanged and redeemed')]")
	private WebElement exchangeRedeemtext;

	@FindBy(xpath = "(//a[text() = 'Redeem'])[3]")
	private WebElement redeemLink;
	

	// Green Tile Element Locators

	@FindBy(xpath = "(//input[@id='signInFormUsername'])[2]")
	private WebElement usernameField;

	@FindBy(xpath = "(//input[@id='signInFormPassword'])[2]")
	private WebElement passwordField;

	@FindBy(xpath = "(//input[@name='signInSubmitButton'])[2]")
	private WebElement signInButton;
	
	@FindBy(xpath = "//div[text() = 'Games']")
	private WebElement gamesPageHeading;

	
	/**
	 * Description - checking all elements on dashboaed.
	 * @return - True - if all elements are visible.
	 */
	public boolean isGamerDetailsElementsVisible() {

		try {
			boolean flag = profileImage.isDisplayed();
			flag = flag && gamerNameGreeting.isDisplayed();
			flag = flag && welcomeText.isDisplayed();
			flag = flag && linkedGamesCount.isDisplayed();
			flag = flag && linkedGamesTxt.isDisplayed();
			flag = flag && qxPoints.isDisplayed();
			flag = flag && qxPointsTxt.isDisplayed();
			flag = flag && totalPlatformGames.isDisplayed();
			flag = flag && onOurPlatformTxt.isDisplayed();
			flag = flag && exploreLink.isDisplayed();
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Method - isGamerDetailsElementsVisible, Class - Dashboard_Gamer : " + e);
			return false;
		}
	}

	/**
	 * Description - checking explore linking action.
	 * @return-True- If lands on explore page
	 */
	public boolean exploreAction() {

		try {
			exploreLink.click();
			return gamesPageHeading.isDisplayed();
		} 
		catch (Exception e) {
			System.err.println("Exception in method - exploreAction, class - Dashboard_Gamer" + e);
			return false;
		}
	}
	
	
	/**
	 * Description - checking redeem button action.
	 * @return-True- If lands on explore page.
	 */
	public boolean redeemAction() {

		try {
			WaitClass.waitForTime(2000);
			redeemLink.click();
			WebElement redeemButton = driver.findElement(By.xpath("//button[text()='Redeem']"));
			redeemButton.isDisplayed();
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - redeemAction, class - Dashboard_Gamer" + e);
			return false;
		}
	}
	
	
	/**
	 * Description - checking logged in user name on dashboard.
	 * @return-True- If logged in user name showing correctly.
	 */
	public boolean checkLoggedInUserName(String gamerName ) {

		try {
			String dashboardUserName = gamerNameGreeting.getText();
			String loggedInUserName ="Hi "+gamerName+",";
			return (dashboardUserName.equals(loggedInUserName));

		} catch (Exception e) {
			System.err.println("Exception in method - checkLoggedInUserName, class - Dashboard_Gamer" + e);
			return false;
		}
	}
	
	/**
	 * Description - checking platform total games count.
	 * @return-True- If total games count showing correctly.
	 */
	public boolean checkTotalPlatformGamesCount() {

		try {
			String dashboardGamesCount = totalPlatformGames.getText();
			WaitClass.waitForTime(2000);
			driver.findElement(By.xpath("(//a[text() = 'Link Games'])[2]")).click();
		    WebElement gamesCount = driver.findElement(By.xpath("//h4"));
			String actualGamescount = gamesCount.getText();
			return (dashboardGamesCount).equalsIgnoreCase(actualGamescount);

		} catch (Exception e) {
			System.err.println("Exception in method - checkTotalPlatformGamesCount, class - Dashboard_Gamer" + e);
			return false;
		}
	}
	
	/**
	 * Description - checking total linked games count.
	 * @return-True- If total linked games count showing correctly.
	 */
	public boolean checkTotalLinkedmGamesCount() {

		try {
			String dashboardLinkedGamesCount = linkedGamesCount.getText();
			WaitClass.waitForTime(2000);
			driver.findElement(By.xpath("(//a[text() = 'Link Games'])[2]")).click();
			linkGames.applyFilters(true, new ArrayList<String>(), 1, 0);
		    WebElement gamesLinkedCount = driver.findElement(By.xpath("//h4"));
			String actualGamescount = gamesLinkedCount.getText();
			actualGamescount = actualGamescount.replace(" Games", "");
			return (Integer.parseInt(dashboardLinkedGamesCount) == Integer.parseInt(actualGamescount));

		} catch (Exception e) {
			System.err.println("Exception in method - checkTotalPlatformGamesCount, class - Dashboard_Gamer" + e);
			return false;
		}
	}
	
	/**
	 * Method to perform sign in actions.
	 * 
	 * @param username
	 * @param password
	 * @return - true if all the actions are performed.
	 */
	public boolean signinAction(String username, String password) {
		try {
			usernameField.clear();
			if (username.length() > 0) {
				usernameField.sendKeys(username);
			}
			passwordField.clear();
			if (password.length() > 0) {
				passwordField.sendKeys(password);
			}
			signInButton.click();
			WaitClass.waitForTime(8000);
			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - signinAction, class - Dashboard_Gamer" + e);
			return false;
		}
	}
}
