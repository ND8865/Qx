package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.WaitClass;

public class Games_Admin_Page {
	
	private WebDriver driver;
	
	public Games_Admin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text() = 'Games']")
	private WebElement gamesTab;
	
	@FindBy(xpath = "//input[@name = 'searchKey']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//span[contains(@class, 'cursor-pointer')]")
	private WebElement eyeIcon;
	
	@FindBy(xpath = "//h4[@data-testId = 'gameNameTitle']")
	private WebElement gameNameHeading;
	
	@FindBy(xpath = "//button[text() = 'Approve']")
	private WebElement approveButton;

	@FindBy(xpath = "//button[text() = 'Confirm']")
	private WebElement confirmButton;
	
	public boolean clickGames() {
		try {
			gamesTab.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - Games_Admin_Page and Method - clickGames");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean approveGame(String gameName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(searchBar));
			searchBar.clear();
			searchBar.sendKeys(gameName);
			WaitClass.waitForTime(2000);
			
			eyeIcon.click();
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait2.until(ExpectedConditions.visibilityOf(gameNameHeading));
			approveButton.click();
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait3.until(ExpectedConditions.elementToBeClickable(confirmButton));
			confirmButton.click();
			return true;
			
		} catch (Exception e) {
			System.err.println("Class - Games_Admin_Page and Method - approveGame");
			e.printStackTrace();
			return false;
		}
	}
	
}
