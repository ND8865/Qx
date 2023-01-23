package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Partner {
	
	private WebDriver driver;
	
	public Dashboard_Partner(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//h4[contains(@class, 'page-heading')]")
	private WebElement partnerGreetingElement;
	
	@FindBy(xpath = "//h4[contains(@class, 'card-title')][text() = 'Settings']")
	private WebElement settingElement;
	
	
	
	
	
	/**
	 * Description - checking logged in user name on dashboard.
	 * @return-True- If logged in user name showing correctly.
	 */
	public boolean checkLoggedInUserName(String gamerName ) {

		try {
			String dashboardUserName = partnerGreetingElement.getText();
			String loggedInUserName ="Hi, "+ gamerName;
			return (dashboardUserName.equals(loggedInUserName));

		} catch (Exception e) {
			System.err.println("Exception in method - checkLoggedInUserName, class - Dashboard_Partner" + e);
			return false;
		}
	}
}
