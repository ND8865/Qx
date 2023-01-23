package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class Notifications_Gamer {
	
	WebDriver driver;
	
	public Notifications_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[contains(@href,'notifications')]")
	private WebElement notificationTab;
	
	@FindBy(xpath = "//button[text()='Mark All Read']")
	private WebElement markAllReadButton;
	
	@FindBy(xpath = "//div[text()='Notifications']")
	private WebElement notificationPageHeader;
	
	@FindBy(xpath = "(//li/div)[1]")
	private WebElement topOneNotification;
	
	@FindBy(xpath = "//li/div")
	private List<WebElement> notificationList;
	
	
	
	/**
	 * Description - Navigating to notification page.
	 * @return - True, if landed successfully on notification page.
	 */
	public boolean navigateToNotifications() {
		try {
			notificationTab.click();
			WaitClass.waitForTime(3000);
			return markAllReadButton.isDisplayed();
		}catch(Exception e) {
			System.err.println("Exception in Class - Notifications_Gamer, Method - navigateToNotifications : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - checking all elements and notifications on notification page.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkAllNotificationPageElements() {

		try {
			boolean flag = markAllReadButton.isDisplayed();
			flag = flag && notificationPageHeader.isDisplayed();
			for (int i = 0; i < notificationList.size(); i++) {
				flag = flag && (notificationList.get(i)).isDisplayed();
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Notifications_Gamer, Method - checkAllNotificationPageElements : " + e);
			return false;
		}
	}
	
	/**
	 * Description - checking all elements and notifications on notification page.
	 * @return - True - if all elements are visible.
	 */
	public boolean latestNotificationTextValidation(String rejectReason) {
		
		try {
			String comment[] = topOneNotification.getText().split("- ");
			
			String str = (comment[1]).replace(rejectReason, "");
			String reason = (comment[1]).replace(str, "");
			return (reason).equals(rejectReason);
			 
		} catch (Exception e) {
			System.err.println("Exception in Class - Notifications_Gamer, Method - latestNotificationTextValidation : " + e);
			return false;
		}
	}
}
