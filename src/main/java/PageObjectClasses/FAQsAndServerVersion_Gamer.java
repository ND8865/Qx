package PageObjectClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.WaitClass;

public class FAQsAndServerVersion_Gamer {
	
WebDriver driver;
	
	public FAQsAndServerVersion_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[@id='userDropdown']")
	private WebElement userArrowDropdown;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']/a[2]")
	private WebElement FAQsDropdownOption;
	
	@FindBy(xpath = "//div[@class='qa-container']/p")
	private List<WebElement> FAQsQuestionsList;
	
	
	
	/**
	 * Description - Navigating to FAQs page.
	 * @return - True, if landed successfully on FAQs page.
	 */
	public boolean navigateToFAQs() {
		try {
			userArrowDropdown.click();
			WaitClass.waitForTime(3000);
			
			String oldTab = driver.getWindowHandle();
			FAQsDropdownOption.click();
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		    newTab.remove(oldTab);
		    driver.switchTo().window(newTab.get(0));
		    
		    WaitClass.waitForTime(3000);
			boolean flag = (driver.findElement(By.xpath("(//a[text()='Download App'])[1]"))).isDisplayed();
		    
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - FAQsAndServerVersion_Gamer, Method - navigateToFAQs : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - checking all elements on FAQs page.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkElementsVisibilityFAQsPage() {
		try {
			WaitClass.waitForTime(3000);
			boolean flag = true;
			for(int i = 0; i < FAQsQuestionsList.size(); i++) {
				flag = flag && FAQsQuestionsList.get(i).isDisplayed();	
			}
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - FAQsAndServerVersion_Gamer, Method - checkElementsVisibilityFAQsPage : " + e);
			return false;
		}
		
	}
	

	/**
	 * Description - Validating server version number.
	 * @return - True, if showing correct server version.
	 */
	public boolean serverVersionValidation(String serverVersion) {
		try {
			userArrowDropdown.click();
			WaitClass.waitForTime(2000);
			String serverVersionFetched = (driver.findElement(By.xpath("//div[@class='dropdown-menu show']/div/p"))).getText();
			return serverVersionFetched.equals(serverVersion);
		}catch(Exception e) {
			System.err.println("Exception in Class - FAQsAndServerVersion_Gamer, Method - serverVersionValidation : " + e);
			return false;
		}	
		
	}

}
