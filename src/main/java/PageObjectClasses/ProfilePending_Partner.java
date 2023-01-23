package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePending_Partner {
	
	private WebDriver driver;
	
	public ProfilePending_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h2")
	private WebElement pageHeading;
	
	@FindBy(xpath = "//h3")
	private WebElement userGreeting;
	
	@FindBy(xpath = "//button[text() = 'Update']")
	private WebElement updateButtonElement;
	
	
	public boolean validatePageHeading(String heading) {
		try {
			return pageHeading.getText().contains(heading);
		} catch (Exception e) {
			System.err.println("Class - ProfilePending_Partner and Method - validatePageHeading");
			return false;
		}
	}
	
	/**
	 * Description - checking logged in user name on dashboard.
	 * @return-True- If logged in user name showing correctly.
	 */
	public boolean checkLoggedInUserName(String gamerName ) {

		try {
			String dashboardUserName = userGreeting.getText();
			String loggedInUserName ="Hi, "+ gamerName;
			return (dashboardUserName.equals(loggedInUserName));

		} catch (Exception e) {
			System.err.println("Exception in method - checkLoggedInUserName, class - ProfilePending_Partner" + e);
			return false;
		}
	}
	
	public boolean validateSuggestedChanges() {
		try {
			List<WebElement> suggestedChanges= driver.findElements(By.xpath("//strong[@class = 'bold-heading']//following-sibling::p"));
			Thread.sleep(3000);
			if (suggestedChanges.size() > 0) {
				return true;				
			} else return false;
		} catch (Exception e) {
			System.err.println("Exception in method - checkLoggedInUserName, class - ProfilePending_Partner" + e);
			return false;
		}
	}
	
	public boolean clickUpdate() {
		try {
			updateButtonElement.click();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in method - clickUpdate, class - ProfilePending_Partner" + e);
			return false;
		}
	}
}
