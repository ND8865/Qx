package PageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Premium_Gamer {
	
	WebDriver driver;
	String UserEmail;
	
	
	public Premium_Gamer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		UserEmail = Utility.getPropertiesFile("primaryLogin", "gamerEmail3");
	}
	
	@FindBy(xpath = "//a[text() = 'Subscription']")
	private WebElement premiumTab;
	
	@FindBy(xpath = "//div[text()='Bill Annually']")
	private WebElement annuallyToggleText;
	
	@FindBy(xpath = "//div[text()='Gold']")
	private WebElement goldPageHeader;
	
	@FindBy(xpath = "//div[text()='Choose the package that suits you.']")
	private WebElement packageSelectText;
	
	@FindBy(xpath = "//div[text()='Bill Monthly']")
	private WebElement monthlyToggleText;
	
	@FindBy(xpath = "//input[@id='custom-switch']")
	private WebElement packageToggle;
	
	@FindBy(xpath = "//h3[text()='Gold']")
	private WebElement packageName;
	
	@FindBy(xpath = "//h5[text()='(Level 2)']")
	private WebElement levelText;
	
	@FindBy(xpath = "//div[text()=' / Month']")
	private WebElement monthlyPackagePrice;
	
	@FindBy(xpath = "//div[text()=' / Year']")
	private WebElement annuallyPackagePrice;
	
	@FindBy(xpath = "//button[contains(text(),'Subscribe')]")
	private WebElement subscribeButton;
	
	@FindBy(xpath = "//button[contains(@class,'btn-primary')]//following-sibling::div")
	private List<WebElement> packageDescriptionList;
	
	//PAYMENT PAGE LOCATORS
	
	@FindBy(xpath = "//div[text()='Pay with card']")
	private WebElement payWithCardText;
	
	@FindBy(xpath = "//a[@class='Link Header-businessLink Link--primary']")
	private WebElement paymentPageBackLink;
	
	@FindBy(xpath = "//div[@class='mr2 flex-item width-fixed']/span")
	private WebElement selectedPlanPrice;
	
	@FindBy(xpath = "//div[@class='ReadOnlyFormField-titleContainer']/div[1]")
	private WebElement paymentPageEmail;
	
	@FindBy(xpath = "//input[@id='cardNumber']")
	private WebElement cardNumberTextField;
	
	@FindBy(xpath = "//input[@id='cardExpiry']")
	private WebElement expiryDateTextField;
	
	@FindBy(xpath = "//input[@id='cardCvc']")
	private WebElement cvvTextField;
	
	@FindBy(xpath = "//input[@id='billingName']")
	private WebElement billingNameTextField;
	
	@FindBy(xpath = "//form/div[2]/div[2]/button")
	private WebElement paymentPageSubscribeButton;
	
	
	
	
	/**
	 * Description - Navigating to Premium page.
	 * @return - True, if landed successfully on  premium page.
	 */
	public boolean navigateToPremium() {
		try {
			premiumTab.click();
			WaitClass.waitForTime(3000);
			return annuallyToggleText.isDisplayed();
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - navigateToPremium : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - checking all elements on premium page.
	 * @return - True - if all elements are visible.
	 */
	public boolean checkElementsVisibilityPremiumPage() {
		try {
			boolean flag = annuallyToggleText.isDisplayed();
			flag = flag && goldPageHeader.isDisplayed();
			flag = flag && packageSelectText.isDisplayed();
			flag = flag && monthlyToggleText.isDisplayed();
			flag = flag && packageToggle.isDisplayed();
			flag = flag && packageName.isDisplayed();
			flag = flag && levelText.isDisplayed();
			flag = flag && monthlyPackagePrice.isDisplayed();
			flag = flag && annuallyPackagePrice.isDisplayed();
			flag = flag && subscribeButton.isDisplayed();
			
			for(int i = 0; i < packageDescriptionList.size(); i++) {
				flag = flag && packageDescriptionList.get(i).isDisplayed();	
			}
			
			return flag;
		} catch (Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - checkElementsVisibilityPremiumPage : " + e);
			return false;
		}
		
	}
		
		/**
		 * Description - Validating monthly and annually prices.
		 * @param monthly - Taking monthly price.
		 * @param annually - Taking annually price.
		* @return - True - if prices are showing correctly.
		 */
		 
		public boolean validatingMonthlyAndAnnuallyPrices(String monthly, String annually) {
			try {
				WaitClass.waitForTime(3000);
				String monthlyPrice = (monthlyPackagePrice.getText().replace(" / Month", "").replace("$", ""));
				boolean flag = monthlyPrice.equals(monthly);
				String annuallyPrice = (annuallyPackagePrice.getText().replace(" / Year", "").replace("$", ""));
				flag = flag && annuallyPrice.equals(annually);
				return flag;
			} catch (Exception e) {
				System.err.println("Exception in Class - Premium_Gamer, Method - validatingMonthlyAndAnnuallyPrices : " + e);
				return false;
			}

		
	}
	
	/**
	 * Description - Validating package change toggle , monthly to yearly and vice versa.
	 * @return - True, if package changing correctly.
	 */
	public boolean packageToggleValidation() {
		try {
			WaitClass.waitForTime(3000);
			String classNameMonthly = monthlyPackagePrice.getAttribute("class");
			boolean flag = classNameMonthly.contains("package-price false");
			String classNameYearly = annuallyPackagePrice.getAttribute("class");
			flag = flag && classNameYearly.contains("package-price light-color");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", packageToggle);
			String classNameMonthly1 = monthlyPackagePrice.getAttribute("class");
			flag = flag && classNameMonthly1.contains("package-price light-color");
			String classNameYearly1 = annuallyPackagePrice.getAttribute("class");
			flag = flag && classNameYearly1.contains("package-price false");
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click()", packageToggle);
			String classNameMonthly2 = monthlyPackagePrice.getAttribute("class");
			flag = flag && classNameMonthly2.contains("package-price false");
			String classNameYearly2 = annuallyPackagePrice.getAttribute("class");
			flag = flag && classNameYearly2.contains("package-price light-color");
			
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - packageToggleValidation : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating package change toggle to annually.
	 * @return - True, if package changing correctly.
	 */
	public boolean annuallypackageToggleValidation() {
		try {
			WaitClass.waitForTime(3000);
			String classNameMonthly = monthlyPackagePrice.getAttribute("class");
			boolean flag = classNameMonthly.contains("package-price false");
			String classNameYearly = annuallyPackagePrice.getAttribute("class");
			flag = flag && classNameYearly.contains("package-price light-color");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", packageToggle);
			String classNameMonthly1 = monthlyPackagePrice.getAttribute("class");
			flag = flag && classNameMonthly1.contains("package-price light-color");
			String classNameYearly1 = annuallyPackagePrice.getAttribute("class");
			flag = flag && classNameYearly1.contains("package-price false");
			
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - annuallypackageToggleValidation : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating subscribe button.
	 * @return - True, if subscribe button working correctly.
	 */
	public boolean subscribeButtonValdation() {
		try {
			subscribeButton.click();
			WaitClass.waitForTime(2000);
			boolean flag = payWithCardText.isDisplayed();			
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - subscribeButtonValdation : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating subscribe button after subscription completed.
	 * @return - True, if subscribe button should not re direct to payment flow.
	 */
	public boolean subscribeButtonValdationAfterSubscription() {
		try {
			subscribeButton.click();
			WaitClass.waitForTime(2000);
			boolean flag = monthlyToggleText.isDisplayed();			
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - subscribeButtonValdationAfterSubscription : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating back button on payment page.
	 * @return - True, if back button working correctly.
	 */
	public boolean paymentPageBackButtonValdation() {
		try {
			paymentPageBackLink.click();
			WaitClass.waitForTime(2000);
			boolean flag = driver.findElement(By.xpath("//div[@class='Toastify']/div/div/div")).isDisplayed();
			WaitClass.waitForTime(4000);
			flag = flag && monthlyToggleText.isDisplayed();
			return flag;
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - paymentPageBackButtonValdation : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating plan price and user email on payment page.
	 * @param plan - Selected plan for subscription.
	 * @param monthlyPrice - Taking monthly price.
	 * @param annuallyPrice - Taking annually price.
	 * @return - True, if data showing  correctly.
	 */
	public boolean paymentPagePriceAndEmailValdation(String plan, String monthlyPrice, String annuallyPrice) {
		try {
			String planPrice = selectedPlanPrice.getText().replace("$","");
			String userEmail = paymentPageEmail.getText();
			
			if(plan.equalsIgnoreCase("Monthly")) {
				boolean flag = monthlyPrice.equals(planPrice);
				flag = flag && UserEmail.equals(userEmail);
				return flag;
			}
			else if(plan.equalsIgnoreCase("Annually")) {
				boolean flag = annuallyPrice.equals(planPrice);
				flag = flag && UserEmail.equals(userEmail);
				return flag;
			}
		
		    return false;
	
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - paymentPagePriceAndEmailValdation : " + e);
			return false;
		}	
		
	}
	
	/**
	 * Description - Validating payment flow.
	 * @param validPaymentInfo - Accepting true or false, true = correct payment info , false = incorrect payment info.
	 * @param cardNumber - taking card number.
	 * @param expiryDate - taking expire date.
	 * @param cvv - taking cvv number.
	 * @param cardHolderName - taking card holder name.
	 * @return - true, if working correctly.
	 */
	public boolean paymentFlowValdation(boolean validPaymentInfo, String cardNumber, String expiryDate, String cvv, String cardHolderName) {
		try {
			if(validPaymentInfo == false) {
				cardNumberTextField.sendKeys(cardNumber);
				expiryDateTextField.sendKeys(expiryDate);
				cvvTextField.sendKeys(cvv);
				billingNameTextField.sendKeys(cardHolderName);
				WaitClass.waitForTime(3000);
				paymentPageSubscribeButton.click();
				WaitClass.waitForTime(2000);
				return (driver.findElement(By.xpath("//div[@class='PaymentForm-confirmPaymentContainer flex-item width-grow']/div/p"))).isDisplayed();
				
			}
			else if(validPaymentInfo == true) {
				WaitClass.waitForTime(5000);
				cardNumberTextField.clear();
				cardNumberTextField.sendKeys(cardNumber);
				expiryDateTextField.clear();
				expiryDateTextField.sendKeys(expiryDate);
				cvvTextField.clear();
				cvvTextField.sendKeys(cvv);
				billingNameTextField.clear();
				billingNameTextField.sendKeys(cardHolderName);
				paymentPageSubscribeButton.click();
				WaitClass.waitForTime(12000);
				return (driver.findElement(By.xpath("//button[text()='Subscribed']"))).isDisplayed();
			}
		    return false;
	
		}catch(Exception e) {
			System.err.println("Exception in Class - Premium_Gamer, Method - paymentFlowValdation : " + e);
			return false;
		}	
		
	}
	
}

