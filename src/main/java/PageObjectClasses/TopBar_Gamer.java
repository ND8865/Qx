package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class TopBar_Gamer {
	
	private WebDriver driver;
	
	public TopBar_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class = 'topBar']//a[text() = 'Link Games']")
	private WebElement linkGames;
	
	@FindBy(xpath = "//div[@class = 'topBar']//a[text() = 'Offers']")
	private WebElement offers;
	
	@FindBy(xpath = "//div[text() = 'Games']")
	private WebElement gamesHeading;
	
	@FindBy(xpath = "//div[text() = 'Offers']")
	private WebElement offersHeading;
	
//	Dashboard dropdown menu locator
	
	@FindBy(xpath="//div[@class='dropdown']//button")
	WebElement headerMenu;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']")
	WebElement dropdownHostElement;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[1]")
	WebElement dropdownItem1Accunt;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	WebElement dropdownItem2FAQs;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[3]")
	WebElement dropdownItem3Support;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[4]")
	WebElement dropdownItem4SignOut;
	
//	PopUp locator
	
	@FindBy(xpath="//div[@class='modal-content']")
	WebElement signOutPopUpHostElement;
	
	@FindBy(xpath="//p[text()='Are you sure you want to Sign Out?']")
	WebElement areYouSuretext;
	
	@FindBy(xpath="//button[text()='Never ask again']")
	WebElement neverAskButton;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement confirmButton;
	
	/**
	 * Method to click the menu item in top bar.
	 * @param menu - Integer type parameter. 1 = Link Games, 2 = Offers
	 * @return - True if link is clicked.
	 */
	public boolean clickMenuItem(int menu) {
		try {
			WaitClass.waitForTime(4000);
			if(menu == 1) {
				linkGames.click();
				WaitClass.waitForTime(2000);
				return gamesHeading.isDisplayed();
			}
			if(menu == 2) {
				Utility.javaScriptClick(offers, driver);
				WaitClass.waitForTime(4000);
				return offersHeading.isDisplayed();
			}
			return true;
		}
		catch(Exception e) {
			System.err.println("Exception in Method - clickMenuItem, Class - TopBar_Gamer : "+e);
			return false;
		}
	}
	
	/**
	 * Method to check Header menu displayed
	 * @return - true if action performed
	 */
	public boolean checkDisplayHeaderMenu() {
		try {
				headerMenu.isDisplayed();
				return true;
			}catch(Exception e) {
				System.err.println("Class - gamerDashboardHeaderSidemenu and Method - checkDisplayHeaderMenu"+e);
				 return false;
			}
	   }	

	/**
	 * Method to validate click dropDown item sign out option
	 * @param option - Integer type parameter. 1 = Log out, 2 = Accounts
	 * @return - true if actions performed
	 */
	public boolean clickDropdownItems(int option) {
		try {
			WaitClass.waitForTime(5000);
			Utility.javaScriptClick(headerMenu, driver);
			WaitClass.waitForTime(2000);
			if(option == 1) {
				dropdownItem4SignOut.click();
			}
			else if(option == 2) {
				dropdownItem1Accunt.click();
			}
			WaitClass.waitForTime(2000);
			return true;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - clickDropdownItems"+e);
			 return false;
		}
	}
	
	/**
	 * Method to check dropDown element displayed.
	 * @return - true if all element is displayed
	 */
	public boolean displayCheckDropdownHostElement() {
		try {
			headerMenu.click();
			WaitClass.waitForTime(2000);
			boolean flag = dropdownHostElement.isDisplayed();
			flag = flag && dropdownItem1Accunt.isDisplayed();
			flag = flag && dropdownItem2FAQs.isDisplayed();
			flag = flag && dropdownItem4SignOut.isDisplayed();
			return flag;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - displayCheckDropdownHostElement"+e);
			 return false;
		}
	}
	
	/**
	 *  Method to check signOut popUp element displayed.
	 * @return - true if all element is displayed
	 */
	public boolean checkSignOutPopUpHost() {
		try {
			boolean flag = signOutPopUpHostElement.isDisplayed();
			flag = flag && areYouSuretext.isDisplayed();
			flag = flag && neverAskButton.isDisplayed();
			flag = flag && cancelButton.isDisplayed();
			flag = flag && confirmButton.isDisplayed();
			return true;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - checkSignOutPopUpHost"+e);
			 return false;
	    }
	}
	
	/**
	 *  Method to validate signOut popUp option Never Ask Again button click action
	 * @return - true if action is performed
	 */
	public boolean validateSignOutPopupNeverAskButton() {
		try {
			neverAskButton.click();
			return true;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - validateSignOutPopupNeverAskButton"+e);
			return false;
		}
	}
	
	/**
	 * Method to validate signOut popUp option cancel button click action
	 * @return - true if action is performed
	 */
	public boolean validateSignOutPopupCancelButton() {
		try {
			cancelButton.click();
			return true;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - validateSignOutPopupCancelButton"+e);
			return false;
		}
	}
	
	/**
	 * Method to validate signOut popUp option confirm button click action
	 * @return - true if action is performed
	 */
	public boolean validateSignOutPopupConfirmButton() {
		try {
			confirmButton.click();
			return true;
		}catch(Exception e) {
			System.err.println("Class - gamerDashboardHeaderSidemenu and Method - validateSignOutPopupConfirmButton"+e);
			return false;
		}
	}

}
