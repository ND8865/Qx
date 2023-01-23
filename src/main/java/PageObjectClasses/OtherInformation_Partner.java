package PageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.Utility;


public class OtherInformation_Partner {
	
	private WebDriver driver;
	
	public OtherInformation_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h4[contains(@class, 'page-heading')]")
	private WebElement pageHeadingElement;
	
	@FindBy(xpath = "//input[@name = 'estimatedOfGames']")
	private WebElement estNumberOfGames;
	
	@FindBy(xpath = "//input[@name = 'estimatedOfGamers']")
	private WebElement estNumberOfGamers;
	
	@FindBy(xpath = "//input[@name = 'gameGrowth']")
	private WebElement gameGrowthPercentage;
	
	@FindBy(xpath = "//input[@name = 'gamersGrowth']")
	private WebElement gamersGrowthPercentage;
	
	@FindBy(xpath = "//button[text() = 'Next']")
	private WebElement nextButtonElement;
	
	@FindBy(xpath = "//button[text() = 'Back']")
	private WebElement backButtonElement;
	
	@FindBy(xpath = "//a[contains(@class, 'signout')]")
	private WebElement signoutElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-content')]")
	private WebElement DialogBoxElement;
	
	@FindBy(xpath = "//h2[contains(@class, 'modal-heading')]")
	private WebElement dialogBoxHeadingElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-footer')]/button[3]")
	private WebElement confirmButtonElement;
	
	
	public boolean validatePageHeading(String pageHeading) {
		try {
			return pageHeadingElement.getText().contains(pageHeading);
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - validatePageHeading");
			return false;
		}
	}
	
	public boolean clickButton(boolean Back, boolean Next) {
		try {
			WebElement element = null;
			if (Next) {
				element = nextButtonElement;
			} else if (Back) {
				element = backButtonElement;
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - clickButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean fillAllFields(String numOfGames, String numOfGamers, String gameGrowth, String gamersGrowth) {
		try {
			if (numOfGamers != null) setEstNumberOfGames(numOfGames);
			if (numOfGamers != null) setEstNumberOfGamers(numOfGamers);
			if (gameGrowth != null) setGameGrowthPercentage(gameGrowth);
			if (gamersGrowth != null) setGamersGrowthPercentage(gamersGrowth);
			return true;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - fillAllFields");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setEstNumberOfGames(String value) {
		try {
			if (estNumberOfGames.isEnabled()) {
				estNumberOfGames.click();
				Utility.clearField(driver, estNumberOfGames);
				estNumberOfGames.sendKeys(value);
				return true;
			} else return false;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - setEstNumberOfGames");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setEstNumberOfGamers(String value) {
		try {
			if (estNumberOfGamers.isEnabled()) {
				estNumberOfGamers.click();
				Utility.clearField(driver, estNumberOfGamers);
				estNumberOfGamers.sendKeys(value);
				return true;
			} else return false;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - setEstNumberOfGamers");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setGameGrowthPercentage(String value) {
		try {
			if (gameGrowthPercentage.isEnabled()) {
				gameGrowthPercentage.click();
				Utility.clearField(driver, gameGrowthPercentage);
				gameGrowthPercentage.sendKeys(value);
				return true;
			} else return false;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - setGameGrowthPercentage");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setGamersGrowthPercentage(String value) {
		try {
			if (gamersGrowthPercentage.isEnabled()) {
				gamersGrowthPercentage.click();
				Utility.clearField(driver, gamersGrowthPercentage);
				gamersGrowthPercentage.sendKeys(value);
				return true;
			} else return false;
		} catch (Exception e) {
			System.err.println("Class - OtherInformation_Partner and Method - setGamersGrowthPercentage");
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param value (String) "0" to "4"
	 * @return
	 */
	public boolean selectRadioButton(String value) {
		try {
			driver.findElement(By.xpath("//input[@value = '"+ value +"']//following-sibling::span")).click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_Partner and Method - selectRadioButton");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean signoutAction() {
		try {
			signoutElement.click();
			if (DialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().contains("Sign Out")) {
				confirmButtonElement.click();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Class - GeneralInformation_partner and Method - signoutAction");
			System.err.println(e);
			return false;
		}
	}
}
