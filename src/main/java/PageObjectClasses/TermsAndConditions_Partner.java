package PageObjectClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class TermsAndConditions_Partner {

	private WebDriver driver;

	public TermsAndConditions_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//h4[contains(@class, 'page-heading')]")
	private WebElement pageHeadingElement;

	@FindBy(xpath = "//div[@class=\"tc-content scrollbar\"]")
	private WebElement reviewTermsAndConditions;

	@FindBy(xpath = "//input[@type = 'checkbox']//following-sibling::span")
	private WebElement acceptTermsAndConditionsCheckBox;

	@FindBy(xpath = "//textarea")
	private WebElement addSuggestedChangesTextBox;

	@FindBy(xpath = "//button[text() = 'Submit']")
	private WebElement submitButtonElement;

	@FindBy(xpath = "//button[text() = 'Back']")
	private WebElement backButtonElement;
	
	@FindBy(xpath = "//button[text() = 'Close']")
	private WebElement closeButtonElement;

	@FindBy(xpath = "//div[contains(@class, 'modal-content')]")
	private WebElement dialogBoxElement;

	@FindBy(xpath = "//h2[contains(@class, 'modal-heading')]")
	private WebElement dialogBoxHeadingElement;
	
	@FindBy(xpath = "//ul[contains(@class, 'show-all')]//span")
	private WebElement errorMessageElement;
	
	@FindBy(xpath = "//a[contains(@class, 'signout')]")
	private WebElement signoutElement;
	
	@FindBy(xpath = "//div[contains(@class, 'modal-footer')]/button[3]")
	private WebElement confirmButtonElement;

	private final String errorSubHeadingsPattern = "//div[@class = 'heading-with-button'][4]//a";

	public boolean validatePageHeading(String pageHeading) {
		try {
			return pageHeadingElement.getText().contains(pageHeading);
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - validatePageHeading");
			return false;
		}
	}

	public boolean clickButton(boolean back, boolean submit, boolean close) {
		try {
			WebElement element = null;
			if (submit) {
				element = submitButtonElement;
			} else if (back) {
				element = backButtonElement;
			} else if (close) {
				element = closeButtonElement;
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - clickButton");
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateTermsConditionsScrolling() {
		try {
			reviewTermsAndConditions.click();
			Actions act = new Actions(driver);
			for (int i = 0; i < 50; i++) {
				act.sendKeys(Keys.ARROW_DOWN).build().perform();
				WaitClass.waitForTime(500);
			}
			for (int i = 0; i < 50; i++) {
				act.sendKeys(Keys.ARROW_UP).build().perform();
				WaitClass.waitForTime(500);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - validateTermsConditionsScrolling");
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyIfTermsConditionsIsEditable() {
		try {
			boolean isEditable = (Boolean) ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].isContentEditable", reviewTermsAndConditions);
			return !isEditable;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - verifyIfTermsConditionsIsEditable");
			e.printStackTrace();
			return false;
		}
	}

	public boolean enableTermsAndConditions(boolean value) {
		try {
			if (acceptTermsAndConditionsCheckBox.isEnabled()) {
				if (!value && acceptTermsAndConditionsCheckBox.isSelected()) {
					acceptTermsAndConditionsCheckBox.click();
				} else if (value && !acceptTermsAndConditionsCheckBox.isSelected()) {
					acceptTermsAndConditionsCheckBox.click();
				}
				return true;
			} else
				return false;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - enableTermsAndConditions");
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSuggestedChanges(String text) {
		try {
			addSuggestedChangesTextBox.click();
			clearSuggestedChanges();
			addSuggestedChangesTextBox.sendKeys(text);
			return true;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - addSuggestedChanges");
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateErrorMessages(boolean generalInfo, boolean termsAndConditions) {
		try {
			boolean flag = false;
			clickButton(false, true, false);
			List<WebElement> all = driver.findElements(By.xpath("//div[@class = 'heading-with-button']//a"));
			int numOfErrorHeadings = all.size();
			if (numOfErrorHeadings <= 0) return false;
			if (generalInfo) {
				if (dialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().equals("Errors")) {
					all.get(0).click();
					flag = errorMessageElement.getText().contains("Legal entity name is missing.");
				}
			}
			else if (termsAndConditions) {
				if (dialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().equals("Errors")) {
					all.get(numOfErrorHeadings -1).click();
					flag = errorMessageElement.getText().contains("Either accept terms and conditions or add some suggestions.");
				}	
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - validateErrorMessages");
			e.printStackTrace();
			return false;
		}
	}

	public boolean clearSuggestedChanges() {
		try {
			Utility.clearField(driver, addSuggestedChangesTextBox);
			return true;
		} catch (Exception e) {
			System.err.println("Class - TermsAndConditions_Partner and Method - clearSuggestedChanges");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean signoutAction() {
		try {
			signoutElement.click();
			if (dialogBoxElement.isDisplayed() && dialogBoxHeadingElement.getText().contains("Sign Out")) {
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
