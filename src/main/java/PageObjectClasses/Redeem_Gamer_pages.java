package PageObjectClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import UtilityClass.Utility;
import UtilityClass.WaitClass;

public class Redeem_Gamer_pages {
	WebDriver driver;
	SoftAssert softassert;

	public Redeem_Gamer_pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		softassert = new SoftAssert();
	}

	@FindBy(xpath = "(//a[contains(text(),'Redeem')])[2]")
	private WebElement clickredeemnutton;
	@FindBy(xpath = "//div[text()='Redeem']")
	private WebElement redeemlogo;
	@FindBy(xpath = "//div[contains(text(),'QX Points (1 QX Point = $0.01)')]")
	private WebElement Qxpointswithdoller;
	@FindBy(xpath = "//div[contains(text(),'U.S. Dollars')]")
	private WebElement Usdoller;
	@FindBy(xpath = "//div[@class='exchange-amount']")
	private WebElement exchangeamount;
	@FindBy(xpath = "//div[@class='exchange-amount text-green mb-0']")
	private WebElement usdollarexchangeamt;
	@FindBy(xpath = "//h4[contains(text(),'Redeem Transactions')]")
	private WebElement RedeemTransactionslogo;
	@FindBy(xpath = "//div[contains(text(),'Cashback Vendor')]")
	private WebElement CashbackVendorHeader;
	@FindBy(xpath = "//div[contains(text(),'Status')]")
	private WebElement statusHeader;
	@FindBy(xpath = "//div[contains(text(),'QX Points Redeemed')]")
	private WebElement QxpointsRedeemedHeader;
	@FindBy(xpath = "//div[contains(text(),'Fees')]")
	private WebElement FeesHeader;
	@FindBy(xpath = "//div[contains(text(),'Amount')]")
	private WebElement AmountHeader;
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	private WebElement continuebutton;
	// These WebElement are for Sorting in Redeem Transactions
	@FindBys({ @FindBy(xpath = "//span[@class='bigText']") })
	private List<WebElement> SortingCashbackVendor;
	@FindBys({ @FindBy(xpath = "//div[@class='tbody-data']//label[text()='QX Points']/parent::div") })
	private List<WebElement> SortingQxPointsRedeemed;
	@FindBys({ @FindBy(xpath = "//div[@class='tbody-data']//label[text()='Fees']/parent::div") })
	private List<WebElement> SortingFees;
	@FindBys({ @FindBy(xpath = "//div[@class='tbody-data']//label[text()='Status']/parent::div") })
	private List<WebElement> SortingStatus;
	@FindBy(xpath = "//div[text() = 'Cashback Vendor']/span/span[contains(@class, 'asc')]")
	private WebElement CashbackVendorAsc;
	@FindBy(xpath = "//div[text() = 'Cashback Vendor']/span/span[contains(@class, 'desc')]")
	private WebElement CashbackVendorDesc;
	@FindBy(xpath = "//div[text() = 'QX Points Redeemed']/span/span[contains(@class, 'asc')]")
	private WebElement QxPointsRedeemedAsc;
	@FindBy(xpath = "//div[text() = 'QX Points Redeemed']/span/span[contains(@class, 'desc')]")
	private WebElement QxPointsRedeemedDesc;
	@FindBy(xpath = "//div[text() = 'Fees']/span/span[contains(@class, 'asc')]")
	private WebElement FeesAsc;
	@FindBy(xpath = "//div[text() = 'Fees']/span/span[contains(@class, 'desc')]")
	private WebElement FeesDesc;
	@FindBy(xpath = "//div[text() = 'Status']/span/span[contains(@class, 'asc')]")
	private WebElement statusAsc;
	@FindBy(xpath = "//div[text() = 'Status']/span/span[contains(@class, 'desc')]")
	private WebElement statusDesc;
	@FindBy(xpath = "(//a[text()='Dashboard'])[2]")
	private WebElement HomeButton;
	@FindBy(xpath = "//input[@data-testid='searchKey']")
	private WebElement SearchBarField;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement SearchButtonClick;
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	private WebElement ContinueButtonClick;
	// All WebElement after click on continue Button
	@FindBy(xpath = "//div[contains(text(),'Add Cashback Method')]")
	private WebElement AddCashbackMethodafterContinue;
	@FindBy(xpath = "//button[contains(text(),'Add Now')]")
	private WebElement AddNowButton;
	// All WebElement of Redeem Page after Click on Continue Button
	@FindBy(xpath = "//div[contains(text(),'Redeem')]")
	private WebElement RedeemLogo;
	@FindBy(xpath = "//label[contains(text(),'QX Points')]")
	private WebElement QxPoints;
	@FindBy(xpath = "//input[@id='formAssets']")
	private WebElement QxPointsFields;
	@FindBy(xpath = "//*[text()='Please enter more QX points. Net redemption amount given below should be greater than 0.']")
	private WebElement QxPointsFieldsclear;
//	@FindBy(xpath = "//div[@class='jss22']")
//	private WebElement QxPointWithDoller;
	@FindBy(xpath = "//div[contains(text(),'Total')]/parent::div/div[@class='exchange-label']")
	private WebElement TotalHeader;
	@FindBy(xpath = "//div[contains(text(),'Total')]/parent::div/div[@class='exchange-amount']")
	private WebElement TotalAmounts;
	@FindBy(xpath = "//div[text()='Net redemption']")
	private WebElement NetRedemption;
	@FindBy(xpath = "//div[text()='Net redemption']/parent::div/div[@class='exchange-amount']")
	private WebElement NetRedemptionAmount;
	@FindBy(xpath = "(//div[@class='exchange-amount'])[2]")
	private WebElement FeesLessRedemption;
	@FindBy(xpath = "//button[contains(text(),'Redeem')]")
	private WebElement RedeemButton;

// All WebElement of Confirmation Pop Up Message 

	@FindBy(xpath = "//div[@class='modal-title h4']")
	private WebElement confirmationlogo;
	@FindBy(xpath = "//div[@class='modal-body']/p")
	private WebElement SureMsg;
	@FindBy(xpath = "//div[@class='modal-body']/ul/li[1]")
	private WebElement Amount;
	@FindBy(xpath = "//div[@class='modal-body']/ul/li[2]")
	private WebElement Fees;
	@FindBy(xpath = "//div[@class='modal-body']/ul/li[3]")
	private WebElement NetRedemptions;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement ConfirmButton;
	@FindBy(xpath = "//div[contains(text(),'Success')]")
	private WebElement SuccessMessage;
	@FindBy(xpath = "//div[@class=\"modal-body\"]/p")
	private WebElement CongratulationMessage;
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement closeButton;

	// Cash Back Method WebElement
	@FindBy(xpath = "//div[contains(text(),'Add Cashback')]")
	private WebElement AddCashBackMethodHeader;
	@FindBy(xpath = "//button[text()='Add New']")
	private WebElement addnewbutton;
	@FindBy(xpath = "//button[@id='dropdown-basic']")
	private WebElement SelectCashBackMethodDropdown;
	@FindBy(xpath = "//*[contains(text(),'Cashback Method Nickname')]")
	private WebElement accountnicknameheader;
	@FindBy(xpath = "//*[contains(text(),'Routing Number')]")
	private WebElement accountroutingheader;
	@FindBy(xpath = "//*[contains(text(),'Account Number')]")
	private WebElement accountnumberheader;
	@FindBy(xpath = "//*[contains(text(),'Bank Account Name')]")
	private WebElement bankaccountname;

	@FindBy(xpath = "//button[@id='userDropdown']")
	private WebElement arrowbutton;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
	private WebElement accountbutton;
	@FindBy(xpath = "(//button[contains(text(),'Edit')])[2]")
	private WebElement EditButtonforremove;
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement RemoveButtonCashback;
	@FindBy(xpath = "//div[contains(text(),'Remove Cashback')]")
	private WebElement AlertRemoveCashbackmethod;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement Confirmcashbackmethod;

	// Add Account Details
	@FindBy(xpath = "(//input[@id='formFirstName'])[1]")
	private WebElement accountnicknameheaderfield;
	@FindBy(xpath = "//input[@placeholder='Routing Number']")
	private WebElement accountroutingheaderfield;
	@FindBy(xpath = "//input[@placeholder='Account Number']")
	private WebElement accountnumberheaderfield;
	@FindBy(xpath = "//input[@placeholder='Bank Account Name']")
	private WebElement bankaccountnamefields;
	@FindBy(xpath = "//input[@placeholder='Bank Account Name']")
	private WebElement bankaccountnamefield;
	@FindBy(xpath = "//button[contains(text(),'Add New')]")
	private WebElement clickonAddNewButton;
	@FindBy(xpath = "//a[contains(text(),'+ add')]")
	private WebElement clickonadd;
	@FindBy(xpath = "(//input[@id='formBasicRadio'])[1]")
	private WebElement chekingradiobutton;
	@FindBy(xpath = "(//input[@id='formBasicRadio'])[2]")
	private WebElement chekingsavingbutton;
	@FindBy(xpath = "//input[@id='formBasicCheckbox']")
	private WebElement clickoncheckbox;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement clickonAddButton;
	@FindBy(xpath = "//input[@placeholder='Confirm Account Number']")
	private WebElement confirmAccount;
	// Sprint 3 Starting from there
	@FindBy(xpath = "//label[contains(text(),'Cashback Method Nickname')]")
	private WebElement PaypalCashNickNameHeader;
	@FindBy(xpath = "//label[contains(text(),'Enter email or phone number associated with your PayPal account')]")
	private WebElement EmailPhoneHeader;
	@FindBy(xpath = "//span[contains(text(),'Make this the default cashback method.')]")
	private WebElement CheckButtonText;
	@FindBy(xpath = "//button[contains(text(),'Add Now')]")
	private WebElement AddAmount;
	@FindBy(xpath = "//input[@placeholder='Cashback Method Nickname']")
	private WebElement PayPalAccountNickNamefield;
	@FindBy(xpath = "//input[@placeholder='PayPal Email or Phone Number']")
	private WebElement EmailorPhoneFieldPaypal;
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement PayPalAddButton;
	@FindBy(xpath = "//div[@class='Toastify__toast-body' or contains(text(),'Payment method added successfully.')]")
	private WebElement AlertAfterAddAccount;
	@FindBy(xpath = "//a[text()='Terms and Conditions']")
	private WebElement TermAndCondition;
	@FindBy(xpath = "//h1[text()='Terms & Conditions']")
	private WebElement TermsAndConditionPage;
	@FindBy(xpath = "//button[@id='dropdown-basic']")
	private WebElement DropdownValueRedeem;
	@FindBy(xpath = "//p[contains(text(),'PayPal')]//parent::div")
	private WebElement DropdownValueRedeemPayPal;
	// # CashBack Page After Redeem the Value of PayPal
	@FindBy(xpath = "//label[contains(text(),'Cashback Method')]")
	private WebElement CashbackMethodHeader;
	@FindBy(xpath = "//div[contains(text(),'Cashback')]")
	private WebElement CashbackPageHeader;
	@FindBy(xpath = "//label[contains(text(),'Redeem Amount')]")
	private WebElement RedeemAmountHeader;
	@FindBy(xpath = "//label[contains(text(),'Email or Phone Number')]")
	private WebElement EmailorPhoneNumberHeader;
	@FindBy(xpath = "//label[contains(text(),'Transaction Code')]")
	private WebElement TransactionCodeHeader;
	@FindBy(xpath = "//input[@id='formFirstName']")
	private List<WebElement> ListofWebElementofCashBack;
	@FindBy(xpath = "//div[contains(text(),'Cashback')]")
	private WebElement CashBackHeaderonPage;
	@FindBy(xpath = "//h3[contains(text(),'Congratulations!')]")
	private WebElement CongratulationmsgonCashbackpage;
	@FindBy(xpath = "//label[contains(text(),'PayPal URL')]")
	private WebElement PayPalURLHeader;
	@FindBy(xpath = "//span[contains(text(),'www.PayPal.me/QxRewards')]")
	private WebElement PayPalURLLink;
	@FindBy(xpath = "//h5[contains(text(),'Please follow the steps below to redeem your QX Points to your PayPal account.')]")
	private WebElement HeaderFollowStepsForPaypal;
	@FindBy(xpath = "//h5[text()='Please follow the steps below to redeem your QX Points to your PayPal account.']/following-sibling::ol/li")
	private List<WebElement> ListofFollowStepsOnCashBack;
	@FindBy(xpath = "//div[@class='input-with-image form-group']//*[name()='svg']")
	private WebElement TransactionCopiedButton;
	@FindBy(xpath = "//div[@class='Toastify__toast-body' or contains(text(),'Copied!')]")
	private WebElement AlertMessageAfterCopy;
	@FindBy(xpath = "//div[contains(text(),'TSS, Inc. (dba acQyr eXchange)')]")
	private WebElement PayPalMePage;
	@FindBy(xpath = "//*[contains(text(),'View Transactions')]")
	private WebElement TransactionButton;
//#TransAction Page Visibility of Element
	@FindBy(xpath = "//button[contains(text(),'Back')]")
	private WebElement BackButtonTransAction;
	@FindBy(xpath = "//div[contains(text(),'Transactions')]")
	private WebElement TransActionLogo;
	@FindBy(xpath = "//div[text()='QX Points (1 QX Point = $0)']")
	private WebElement QxPointsHeaderTransAction;
	@FindBy(xpath = "//div[contains(text(),'U.S. Dollars')]")
	private WebElement UsDollersHeaderTransAction;
	@FindBy(xpath = "//div[@class='exchange-amount']")
	private WebElement QxPointsValueTransaction;
	@FindBy(xpath = "//div[@class='exchange-amount text-green mb-0']")
	private WebElement UsDollerValueTransAction;
	@FindBy(xpath = "(//label[@class='form-label'])[1]")
	private WebElement QxPointsSliderHeaderTransaction;
	@FindBy(xpath = "(//label[@class='form-label'])[2]")
	private WebElement CashBackVedorDropdownHeaderTransaction;
	@FindBy(xpath = "(//label[@class='form-label'])[3]")
	private WebElement FeesSliderHeaderTransaction;
	@FindBy(xpath = "(//label[@class='form-label'])[4]")
	private WebElement StatusDropdownHeaderTransaction;
	@FindBy(xpath = "(//label[@class='form-label'])[5]")
	private WebElement AmountSliderHeaderTransaction;
	@FindBy(xpath = "//div[text()='QX Points']")
	private WebElement QxPointsTransAction;
	@FindBy(xpath = "//div[text()='Cashback Vendor']")
	private WebElement CashBackVendorTransAction;
	@FindBy(xpath = "//div[text()='Fees']")
	private WebElement FeesTransAction;
	@FindBy(xpath = "//div[text()='Status']")
	private WebElement StatusTransAction;
	@FindBy(xpath = "//div[text()='Amount']")
	private WebElement AmountTransAction;
	@FindBy(xpath = "//button[contains(text(),'Redeem')]")
	private WebElement RedeemButtonUpdated;
	@FindBy(xpath = "//p[contains(text(),'After that, PayPal will send us (acQyr eXchange) y')]")
	private WebElement CautionText;
	@FindBy(xpath = "//p[contains(text(),'Caution: if the Request Id you enter into the Note')]")
	private WebElement CautionTextafterRedeem;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[1]")
	private WebElement CashBackdropdownTransAction;
	@FindBy(xpath = "(//span[contains(text(),'Select')])[2]")
	private WebElement StatusdropdownTransAction;
	@FindBy(xpath = "//*[text()='Dwolla']//preceding-sibling::input")
	private WebElement SearchDropDownValueDwolla;
	@FindBy(xpath = "//*[text()='Pending']//preceding-sibling::input")
	private WebElement SearchDropDownValuePending;
	@FindBy(xpath = "//*[text()='PayPal']//preceding-sibling::input")
	private WebElement SearchDropDownValuePayPal;
	@FindBy(xpath = "//*[text()='Processed']//preceding-sibling::input")
	private WebElement SearchDropDownValueProcessed;
	@FindBy(xpath = "//div[@class='jss19']")
	private WebElement TempClick;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19 6.41L1')]")
	private WebElement DropDownCross;
	@FindBy(xpath = "//span[contains(text(),'Done')]")
	private WebElement DoneButton;

	/**
	 * Description - checking all Web Elements are visible on Redeem Module .
	 * 
	 * @return - True - if all Elements are visible.
	 */
	public boolean IsAllElementVisiableRedeem() {

		try {
			boolean flag = RedeemLogo.isDisplayed();
			flag = flag && QxPoints.isDisplayed();
			flag = QxPointsFields.isDisplayed();
			flag = flag && TotalHeader.isDisplayed();
			flag = flag && TotalAmounts.isDisplayed();
			flag = flag && NetRedemption.isDisplayed();
			flag = flag && NetRedemptionAmount.isDisplayed();
			Utility.clearField(driver, QxPointsFields);
			flag = flag && QxPointsFieldsclear.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println("Exception in Method - IsAllElementVisiableRedeem, Class - Redeem_Gamer_pages : " + e);
			return false;
		}
	}

	/**
	 * Description - checking redeem button is Click able .
	 * 
	 * @return - True - if is redeem button work.
	 */

	public boolean clickonredeembutton() {
		try {

			clickredeemnutton.click();

			return true;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - clickonredeembutton, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - checking redeem button is Click able .
	 * 
	 * @return - True - if is redeem button work.
	 */

	public boolean ClickOnRedeemGreenButton() {
		try {

			RedeemButtonUpdated.click();

			return true;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - ClickOnRedeemGreenButton, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - checking Transaction button is Click able .
	 * 
	 * @return - True - if is Transaction button work.
	 */

	public boolean TransactionButton() {
		try {

			TransactionButton.click();

			return true;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - TransactionButton, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify Sorting Cashback Vendor, QxPointsRedeemed, Fees , Status
	 * on Redeem Page .
	 * 
	 * @return - True - if Sorting is working it retruns 1 for Asc order and 2 for
	 *         Desc order.
	 */

	public boolean SortingRedeemPage(int cashBackVendor, int QxPointsRedeemed, int Fees, int status) {
		try {
			if (cashBackVendor == 1) {
				ArrayList<String> data1 = new ArrayList<String>();
				ArrayList<String> data2 = new ArrayList<String>();
				for (int j = 0; j <= SortingCashbackVendor.size() - 1; j++) {
					String cashbacksort1 = SortingCashbackVendor.get(j).getText();

					data1.add(cashbacksort1);
				}
				Collections.sort(data1);
				CashbackVendorAsc.click();
				CashbackVendorDesc.click();
				CashbackVendorAsc.click();

				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingCashbackVendor.size() - 1; j++) {
					String cashbacksort2 = SortingCashbackVendor.get(j).getText();

					data2.add(cashbacksort2);
				}
				return data1.equals(data2);
			}
			if (cashBackVendor == 2) {
				ArrayList<String> data3 = new ArrayList<String>();
				ArrayList<String> data4 = new ArrayList<String>();
				for (int j = 0; j <= SortingCashbackVendor.size() - 1; j++) {
					String cashbacksort3 = SortingCashbackVendor.get(j).getText();

					data3.add(cashbacksort3);
				}
				Collections.reverse(data3);
				CashbackVendorDesc.click();
				CashbackVendorAsc.click();
				CashbackVendorDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingCashbackVendor.size() - 1; j++) {
					String cashbacksort4 = SortingCashbackVendor.get(j).getText();

					data4.add(cashbacksort4);
				}
				return data3.equals(data4);
			}
			// Sorting for QX Points Redeemed
			if (QxPointsRedeemed == 1) {
				ArrayList<String> data5 = new ArrayList<String>();
				ArrayList<String> data6 = new ArrayList<String>();
				for (int j = 0; j <= SortingQxPointsRedeemed.size() - 1; j++) {
					String QxpointsSort5 = SortingQxPointsRedeemed.get(j).getText();
					// int Qxpoints = Integer.parseInt(QxpointsSort5);
					data5.add(QxpointsSort5);
				}
				Collections.sort(data5);
				QxPointsRedeemedAsc.click();
				QxPointsRedeemedDesc.click();
				QxPointsRedeemedAsc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingQxPointsRedeemed.size() - 1; j++) {
					String QxpointsSort6 = SortingQxPointsRedeemed.get(j).getText();
					// int Qxpoints = Integer.parseInt(QxpointsSort6);
					data6.add(QxpointsSort6);
				}
				return data5.equals(data6);
			}
			if (QxPointsRedeemed == 2) {
				ArrayList<String> data7 = new ArrayList<String>();
				ArrayList<String> data8 = new ArrayList<String>();
				for (int j = 0; j <= SortingQxPointsRedeemed.size() - 1; j++) {
					String QxpointsSort7 = SortingQxPointsRedeemed.get(j).getText();
					// int Qxpoints = Integer.parseInt(QxpointsSort7);
					data7.add(QxpointsSort7);
				}
				Collections.reverse(data7);
				QxPointsRedeemedDesc.click();
				QxPointsRedeemedAsc.click();
				QxPointsRedeemedDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingQxPointsRedeemed.size() - 1; j++) {
					String QxpointsSort8 = SortingQxPointsRedeemed.get(j).getText();
					// int Qxpoints = Integer.parseInt(QxpointsSort8);
					data8.add(QxpointsSort8);

				}
				return data7.equals(data8);
			}
			// Sorting for Fees on Redeem Page.
			if (Fees == 1) {
				ArrayList<Float> li1 = new ArrayList<Float>();
				ArrayList<Float> li2 = new ArrayList<Float>();
				for (int j = 0; j <= SortingFees.size() - 1; j++) {
					String fees = SortingFees.get(j).getText();
					String data = fees.replace("$", "");
					float value = Float.valueOf(data);
					li1.add(value);
				}
				Collections.sort(li1);
				FeesAsc.click();
				FeesDesc.click();
				FeesAsc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingFees.size() - 1; j++) {
					String fees = SortingFees.get(j).getText();
					String data = fees.replace("$", "");
					float value = Float.valueOf(data);
					li2.add(value);
				}
				return li1.equals(li2);
			}
			if (Fees == 2) {
				ArrayList<Float> li1 = new ArrayList<Float>();
				ArrayList<Float> li2 = new ArrayList<Float>();
				for (int j = 0; j <= SortingFees.size() - 1; j++) {
					String fees = SortingFees.get(j).getText();
					String data = fees.replace("$", "");
					float value = Float.valueOf(data);
					li1.add(value);
				}
				Collections.reverse(li1);
				FeesDesc.click();
				FeesAsc.click();
				FeesDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingFees.size() - 1; j++) {
					String fees = SortingFees.get(j).getText();
					String data = fees.replace("$", "");
					float value = Float.valueOf(data);
					li2.add(value);
				}
				return li1.equals(li2);
			}
			// Sorting for Status in Redeem Page
			if (status == 1) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				for (int j = 0; j <= SortingStatus.size() - 1; j++) {
					String sta = SortingStatus.get(j).getText();

					list1.add(sta);
				}
				Collections.sort(list1);
				statusAsc.click();
				statusDesc.click();
				statusAsc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingStatus.size() - 1; j++) {
					String sta = SortingStatus.get(j).getText();

					list2.add(sta);
				}
				return list1.equals(list2);
			}
			if (status == 2) {
				ArrayList<String> list1 = new ArrayList<String>();
				ArrayList<String> list2 = new ArrayList<String>();
				for (int j = 0; j <= SortingStatus.size() - 1; j++) {
					String sta = SortingStatus.get(j).getText();

					list1.add(sta);
				}
				Collections.reverse(list1);
				statusDesc.click();
				statusAsc.click();
				statusDesc.click();
				WaitClass.waitForTime(2000);
				for (int j = 0; j <= SortingStatus.size() - 1; j++) {
					String sta = SortingStatus.get(j).getText();

					list2.add(sta);
				}
				return list2.size() > 0 ? list1.equals(list2) : false;
			}

		} catch (Exception e) {

			System.err.println("Exception in Method - SortingRedeemPage, Class - Redeem_Gamer_pages : " + e);

		}
		return false;
	}

	/**
	 * Description - Verify Search Bar for Cashback Vendor, Qx Points Redeemed,
	 * Fees, Status .
	 * 
	 * @return - True - if is search Bar is working .
	 */

	public boolean verifySearchBarCashbackVendor() {
		try {

			// Verify Search Bar for Cashback Vendor
			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingCashbackVendor.size() - 1);
			WebElement list = SortingCashbackVendor.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			SearchButtonClick.click();

			for (WebElement data : SortingCashbackVendor) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return flag;
		}

		catch (Exception e) {

			System.err
					.println("Exception in Method - verifySearchBarCashbackVendor, Class - Redeem_Gamer_pages : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify Search Bar for Cashback Vendor, Qx Points Redeemed,
	 * Fees, Status .
	 * 
	 * @return - True - if is search Bar is working .
	 */

	public boolean verifySearchBarQxPointsRedeemed() {
		try {

			// Verify Search Bar for Qx Points Redeemed
			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingQxPointsRedeemed.size() - 1);
			WebElement list = SortingQxPointsRedeemed.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			SearchButtonClick.click();

			for (WebElement data : SortingQxPointsRedeemed) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return flag;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - verifySearchBarQxPointsRedeemed, Class - Redeem_Gamer_pages : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify Search Bar for Cashback Vendor, Qx Points Redeemed,
	 * Fees, Status .
	 * 
	 * @return - True - if is search Bar is working .
	 */

	public boolean verifySearchBarFees() {
		try {

			// Verify Search Bar for Fees
			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingFees.size() - 1);
			WebElement list = SortingFees.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			SearchButtonClick.click();

			for (WebElement data : SortingFees) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return flag;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - verifySearchBarFees, Class - Redeem_Gamer_pages : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify Search Bar for Cashback Vendor, Qx Points Redeemed,
	 * Fees, Status .
	 * 
	 * @return - True - if is search Bar is working .
	 */

	public boolean verifySearchBarStatus() {
		try {

			// Verify Search Bar for Fees
			WaitClass.waitForTime(2000);
			boolean flag = true;
			SearchBarField.clear();
			WaitClass.waitForTime(2000);
			int random = Utility.getRandomInt(0, SortingStatus.size() - 1);
			WebElement list = SortingStatus.get(random);
			String searchdetails = list.getText();
			SearchBarField.sendKeys(searchdetails);
			WaitClass.waitForTime(3000);
			SearchButtonClick.click();

			for (WebElement data : SortingStatus) {
				String dataverify = data.getText();
				flag = flag && dataverify.equals(searchdetails);
			}
			return flag;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - verifySearchBarStatus, Class - Redeem_Gamer_pages : " + e);

		}
		return false;

	}

	/**
	 * Description - Verify Amount value is present on Redeem page .
	 * 
	 * @return - True - if Amount is Prersent on Redeem page .
	 */

	public boolean VerifyAmount() {
		try {
			boolean flag = true;
			WaitClass.waitForTime(2000);
			List<WebElement> Amount = driver.findElements(By.xpath("//div[@class='tbody-data text-md-right']"));
			flag = driver.findElement(By.xpath("//div[contains(text(),'Amount')]")).isDisplayed();
			for (WebElement dd : Amount) {
				flag = dd.isDisplayed();
			}
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(arrowbutton, driver);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(accountbutton, driver);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(EditButtonforremove, driver);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(RemoveButtonCashback, driver);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(Confirmcashbackmethod, driver);
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(HomeButton, driver);
			WaitClass.waitForTime(2000);
			driver.navigate().refresh();
			WaitClass.waitForTime(2000);
			return flag;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - VerifyAmount, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - checking Continue Button Working and Land on Redeem Pages .
	 * 
	 * @return - True - if is work Continue Button and Landing on Redeem Pages.
	 */

	public boolean clickOnContinueButton() {
		try {

			continuebutton.click();
			// boolean flag = AddCashbackMethodafterContinue.isDisplayed();
			Utility.javaScriptClick(AddNowButton, driver);
			WaitClass.waitForTime(2000);

			return true;
		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - Click on Continue Button and Land on Redeem page, Class - Redeem_Gamer_pages : "
							+ e);
			return false;
		}

	}
// Starting  Add Cash Back Account from Here..................................................

	/**
	 * Description - Verify cash back method element is display .
	 * 
	 * @return-True- if cash back method is work.
	 * 
	 */
	public boolean cashbackmethod() {
		try {

			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,50)");
			Utility.javaScriptClick(RedeemButtonUpdated, driver);
			WaitClass.waitForTime(2000);
			boolean flag1 = AddCashBackMethodHeader.isDisplayed();
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(AddNowButton, driver);
			Utility.javaScriptClick(SelectCashBackMethodDropdown, driver);
			WaitClass.waitForTime(2000);
			paymentsMethod("Dwolla");
			boolean flag = accountnicknameheader.isDisplayed();
			flag = flag && accountroutingheader.isDisplayed();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,50)");
			flag = flag && accountnumberheader.isDisplayed();
			flag = flag && bankaccountname.isDisplayed();

			return flag1 && flag;
		} catch (Exception e) {
			System.err.println("Exception in method - cashbackmethod, class - EditAccount__Gamers" + e);
			return false;

		}
	}

	/**
	 * Description - Verify details for add account .
	 * 
	 * @return-True- if all details are filled .
	 * 
	 */
	public boolean addDepositaccount() {
		try {

			accountnicknameheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnickname"));
			WaitClass.waitForTime(2000);
			accountroutingheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "routingnumber"));
			WaitClass.waitForTime(2000);
			accountnumberheaderfield.sendKeys(Utility.getPropertiesFile("primaryLogin", "accountnumber"));
			WaitClass.waitForTime(2000);
			confirmAccount.sendKeys(Utility.getPropertiesFile("primaryLogin", "ConfirmACNumber"));
			WaitClass.waitForTime(2000);
			bankaccountnamefield.sendKeys(Utility.getPropertiesFile("primaryLogin", "bankname"));
			WaitClass.waitForTime(2000);
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("window.scrollBy(0,100)");
			chekingradiobutton.click();
			WaitClass.waitForTime(2000);
			chekingsavingbutton.click();
			WaitClass.waitForTime(2000);
			clickoncheckbox.click();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,-600)");
			clickonAddButton.click();
			WaitClass.waitForTime(5000);
			HomeButton.click();
			WaitClass.waitForTime(5000);
			driver.navigate().refresh();

			return true;

		} catch (Exception e) {
			System.err.println("Exception in method - addDepositAccount, class - EditAccount__Gamers" + e);
			return false;
		}
	}

	/**
	 * Description - Method for Payment Add Cash back Method .
	 * 
	 */
	private void paymentsMethod(String PaymentMethod) {
		List<WebElement> paymethods = driver.findElements(By.xpath("//li[@class='active_item']"));
		for (WebElement cashbackmethod : paymethods) {
			if (cashbackmethod.getText().contains(PaymentMethod)) {
				cashbackmethod.click();
				break;
			}
		}
	}

	/**
	 * Description - checking all elements are visible on Redeem From Page After
	 * click on Continue .
	 * 
	 * @return - True - if all elements are visible on Redeem from Page .
	 */
	public boolean IsAllElementVisiableFromRedeemPage() {

		try {

			boolean flag = RedeemLogo.isDisplayed();
			flag = flag && QxPoints.isDisplayed();
			flag = QxPointsFields.isDisplayed();
			flag = flag && TotalHeader.isDisplayed();
			flag = flag && TotalAmounts.isDisplayed();
			flag = flag && NetRedemption.isDisplayed();
			flag = flag && NetRedemptionAmount.isDisplayed();
			Utility.clearField(driver, QxPointsFields);
			flag = flag && QxPointsFieldsclear.isDisplayed();

			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - IsAllElementVisiableFromRedeemPage, Class - Redeem_Gamer_pages : " + e);
			return false;
		}
	}

	/**
	 * Description - Add Qx Points and Verify the Amount is Adding and Redeem .
	 * 
	 * @return - True - if is Adding Qx Points and Verify the amount is Adding and
	 *         Redeem .
	 */

	public boolean AddQxpoints() {
		try {

			QxPointsFields.click();
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, QxPointsFields);
			QxPointsFields.sendKeys("200");
			WaitClass.waitForTime(2000);
			WebElement value = driver.findElement(By.xpath("//input[@id='formAssets']"));
			String value1 = value.getAttribute("value");
			int a = Integer.valueOf(value1);
			float b = Float.valueOf(a);
			float c = (float) (b * 0.01);
			ArrayList<Float> li1 = new ArrayList<Float>();
			li1.add(c);

			List<WebElement> totalvalue = driver.findElements(By.xpath("//div[@class='exchange-amount']"));
			WebElement total1 = totalvalue.get(0);
			String a1 = total1.getText();
			String[] sp = a1.split("");
			ArrayList<String> li = new ArrayList<String>();
			li.add(sp[1] + sp[2] + sp[3] + sp[4]);

			float[] floatValues = new float[li.size()]; // change String list to float value

			for (int i = 0; i < li.size(); i++) {
				floatValues[i] = Float.parseFloat(li.get(i));
			}
			for (float A : li1) {
				for (float B : floatValues) {
					Assert.assertEquals(A, B);
					break;
				}

			}

			return true;

		} catch (Exception e) {

			System.err.println("Exception in Method - AddQxpoints, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Validating Redeem Page and Confirmation Message Pages Amount ,
	 * Fees , And Net redemption.
	 * 
	 * @return - True - if is Validating Redeem Page and Confirmation Message Pages
	 *         Amount , Fees , And Net redemption are same. Redeem .
	 */

	public boolean ValidateRedeemAndConfirmationMessage() {
		try {
			ArrayList<String> expecteddata = new ArrayList<String>();
			ArrayList<String> actualdata = new ArrayList<String>();
			List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='exchange-amount']"));
			String amount = list1.get(0).getText();
			expecteddata.add(amount);
			String fees = list1.get(1).getText();
			expecteddata.add(fees);
			String netRedemption = list1.get(2).getText();
			expecteddata.add(netRedemption);
			RedeemButton.click();
			List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='modal-body']/ul/li"));
			String amount2 = list2.get(0).getText();
			String[] a = amount2.split("");
			actualdata.add(a[8] + a[9] + a[10] + a[11] + a[12]);
			String fees2 = list2.get(1).getText();
			String[] b = fees2.split("");
			actualdata.add(b[5] + b[6] + b[7] + b[8] + b[9] + b[10]);
			String netredemption2 = list2.get(2).getText();
			String[] c = netredemption2.split("");
			actualdata.add(c[15] + c[16] + c[17] + c[18] + c[19]);

			for (String A : actualdata) {
				for (String B : expecteddata) {
					Assert.assertEquals(A, B);
					expecteddata.remove(B);
					break;
				}
			}
			return true;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - ValidateRedeemAndConfirmationMessage, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify Amount Confirmation Message in Pop Up and Success
	 * Message . Message .
	 * 
	 * @return - True - if is Verify Amount Confirmation Message in Pop Up and
	 *         Success Message .
	 */
	public boolean VerifyElementVisibilityAmountConfirmationMsg() {
		try {

			boolean flag = confirmationlogo.isDisplayed();
			flag = flag && SureMsg.isDisplayed();
			flag = Amount.isDisplayed();
			flag = flag && Fees.isDisplayed();
			flag = flag && NetRedemptions.isDisplayed();
			WaitClass.waitForTime(2000);
			ConfirmButton.click();

			// Success Message after click on Confirm Button
			boolean flag1 = SuccessMessage.isDisplayed();
			flag1 = flag1 && CongratulationMessage.isDisplayed();
			closeButton.click();
			return true;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - VerifyAmountConfirmationMsg, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Validate Total Amount , Less Fees Redemption , and Net
	 * Redemption is correct.
	 * 
	 * 
	 * @return - True - if is Total Amount , Less Fees Redemption , and Net
	 *         Redemption is correct.
	 * 
	 */
	public boolean ValidatetotalAmountLessFeesNetRedemption() {
		try {

			QxPointsFields.click();
			WaitClass.waitForTime(2000);
			Utility.clearField(driver, QxPointsFields);
			QxPointsFields.sendKeys("100");
			WaitClass.waitForTime(2000);
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='exchange-amount']"));
			String li = list.get(0).getText();
			li = li.replace("$", "");
			float less = Float.valueOf(li);
			float multi = less;
			String li1 = list.get(1).getText();
			li1 = li1.replace("-$", "");
			float less1 = Float.valueOf(li1);

			float netRedemption = multi - less1;
			String li2 = list.get(2).getText();
			li2 = li2.replace("$", "");
			float netredemption = Float.valueOf(li2);
			Assert.assertEquals(netRedemption, netredemption);

			return true;

		}

		catch (Exception e) {

			System.err.println(
					"Exception in Method - ValidatetotalAmountLessFeesNetRedemption, Class - Redeem_Gamer_pages : "
							+ e);
			return false;
		}

	}

	// # Sprint 3 are starting from there (PayPal)
	/**
	 * Description - Verify that PayPal CashBack Method are Adding on Redeem Module.
	 * 
	 * 
	 * @return - True - if PayPal CashBack Method are Adding on Redeem Module.
	 * 
	 */
	public boolean AddPayPalCashback() {
		try {
			Utility.javaScriptClick(RedeemButtonUpdated, driver);
			Utility.javaScriptClick(continuebutton, driver);
			WaitClass.waitForTime(2000);
			boolean text = driver.findElement(By.xpath("//div[@class='modal-body']")).isDisplayed();
			WaitClass.waitForTime(2000);
			AddAmount.click();
			boolean flag1 = AddCashBackMethodHeader.isDisplayed();
			WaitClass.waitForTime(2000);
			Utility.javaScriptClick(SelectCashBackMethodDropdown, driver);
			WaitClass.waitForTime(2000);
			paymentsMethod("PayPal");
			WaitClass.waitForTime(2000);
			boolean flag = PaypalCashNickNameHeader.isDisplayed();
			flag = flag && EmailPhoneHeader.isDisplayed();
			JavascriptExecutor je1 = (JavascriptExecutor) driver;
			je1.executeScript("window.scrollBy(0,50)");
			flag = flag && CheckButtonText.isDisplayed();

			return flag && flag1 && text;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - AddPayPalCashback, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that in PayPal Cash Back method Value is Inserting or
	 * not .
	 * 
	 * @return-True- if Cash PayPal Back Method Value is inserting .
	 * 
	 */
	public boolean InsertValuePaypalCashbackRedeemPaypal() {
		try {
			// # Verify from first with email id
			Utility.clearField(driver, PayPalAccountNickNamefield);
			WaitClass.waitForTime(2000);
			PayPalAccountNickNamefield.sendKeys("Gamerpaypal");
			Utility.clearField(driver, EmailorPhoneFieldPaypal);
			WaitClass.waitForTime(2000);
			EmailorPhoneFieldPaypal.sendKeys("gamer12345@gmail.com");
			Utility.javaScriptClick(PayPalAddButton, driver);
			String alerttext = Utility.getalerttext(driver, AlertAfterAddAccount);
			String alerttextex = "User cashback method added successfully.";
			Assert.assertEquals(alerttext, alerttextex);
			softassert.assertAll();
			System.out.println(alerttext);
			WaitClass.waitForTime(4000);
			HomeButton.click();
			WaitClass.waitForTime(4000);
			driver.navigate().refresh();
			return true;
		} catch (Exception e) {
			System.err.println(
					"Exception in method - InsertValuePaypalCashbackRedeemPaypal, class - EditAccount_Gamer_pages.java"
							+ e);
			return false;

		}
	}

	/**
	 * Description - Verify that Terms And Condition page is Enable after click on
	 * continue button .
	 * 
	 * @return - True - if Term and condition page is Enable.
	 */

	public boolean TermsAndConditions() {
		try {
			String oldTab = driver.getWindowHandle();
			WaitClass.waitForTime(2000);
			TermAndCondition.click();
			WaitClass.waitForTime(2000);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			WaitClass.waitForTime(2000);
			newTab.remove(oldTab);
			WaitClass.waitForTime(2000);
			driver.switchTo().window(newTab.get(0));
			WaitClass.waitForTime(4000);
			boolean termandConditionpage = TermsAndConditionPage.isDisplayed();
			WaitClass.waitForTime(2000);
			driver.switchTo().window(oldTab);
			return true && termandConditionpage;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - TermsAndConditions, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that Get the value from Transfer to from the drop down .
	 * 
	 * @return - True - if pick the value successfully from the dropdown.
	 */

	public boolean GetValueFromdropdownRedeem() {
		try {
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(continuebutton, driver);
			WaitClass.waitForTime(1000);
			boolean transferto = driver.findElement(By.xpath("//label[contains(text(),'Transfer to:')]")).isDisplayed();
			WaitClass.waitForTime(2000);
			DropdownValueRedeem.click();
			WaitClass.waitForTime(1000);
			DropdownValueRedeemPayPal.click();
			WaitClass.waitForTime(1000);
			Utility.javaScriptClick(QxPointsFields, driver);
			Utility.clearField(driver, QxPointsFields);
			QxPointsFields.sendKeys("53");
			Utility.javaScriptClick(RedeemButton, driver);
			Utility.javaScriptClick(ConfirmButton, driver);

			WaitClass.waitForTime(2000);

			return true && transferto;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - GetValueFromdropdownRedeem, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify that CashBack Page is Enable after the Redeem the value
	 * and check Visibility of Elements(PayPal) .
	 * 
	 * @return - True - if CashBack Page is Enable and Visibility of Elements.
	 */

	public boolean CashBackAfterRedeemPaypal() {
		try {

			boolean flag = CashbackMethodHeader.isDisplayed();
			flag = flag && CashbackPageHeader.isDisplayed();
			flag = RedeemAmountHeader.isDisplayed();
			flag = flag && EmailorPhoneNumberHeader.isDisplayed();
			flag = flag && TransactionCodeHeader.isDisplayed();
			flag = flag && PayPalURLLink.isDisplayed();
			flag = flag && CashBackHeaderonPage.isDisplayed();
			flag = flag && CongratulationmsgonCashbackpage.isDisplayed();
			flag = flag && HeaderFollowStepsForPaypal.isDisplayed();

			return flag ;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - CashBackAfterRedeemPaypal, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Validate the CashBack Method After Redeem the value on for
	 * (PayPal)
	 * 
	 * 
	 * @return - True - if CashBack Method value is present after redeem the value
	 *         for (PayPal).
	 */

	public boolean ValidateCashBackMethodPaypal() {
		try {
			boolean flag = false;
			String CashBackMethod = ListofWebElementofCashBack.get(0).getAttribute("value");
			String RedeemAmount = ListofWebElementofCashBack.get(1).getAttribute("value");
			String EmailorPhoneNumber = ListofWebElementofCashBack.get(2).getAttribute("value");
			String TransactionCode = ListofWebElementofCashBack.get(3).getAttribute("value");
			if (driver.getPageSource().contains(CashBackMethod)) {
				flag = true;
			}
			if (driver.getPageSource().contains(RedeemAmount)) {
				flag = true;
			}
			if (driver.getPageSource().contains(EmailorPhoneNumber)) {
				flag = true;
			}
			if (driver.getPageSource().contains(TransactionCode)) {
				flag = true;
			}
			Assert.assertTrue(flag, " Value is Present ");
			WaitClass.waitForTime(1000);
			Actions action = new Actions(driver);
			action.moveToElement(TransactionCopiedButton).click().perform();
			String alerttext = Utility.getalerttext(driver, AlertMessageAfterCopy);
			String alerttextex = "Copied!";
			Assert.assertEquals(alerttext, alerttextex);
			softassert.assertAll();
			System.out.println(alerttext);
			WaitClass.waitForTime(2000);
			String oldTab = driver.getWindowHandle();
			WaitClass.waitForTime(2000);
			PayPalURLLink.click();
			WaitClass.waitForTime(2000);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			newTab.remove(oldTab);
			driver.switchTo().window(newTab.get(0));
			WaitClass.waitForTime(4000);
			boolean payPalmepage = PayPalMePage.isDisplayed();
			driver.close();
			driver.switchTo().window(oldTab);
			Utility.javaScriptClick(DoneButton, driver);
			boolean revertRedeem = driver.findElement(By.linkText("Redeem")).isDisplayed();

			return payPalmepage && revertRedeem && flag;
		}

		catch (Exception e) {

			System.err.println("Exception in Method - ValidateCashBackMethodPaypal, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify and Validate the QxPoints Slider .
	 * 
	 * @return - True - if Slider Are Working properly.
	 */

	public boolean QxPointsSlider() {
		try {
			ArrayList<String> lista = new ArrayList<String>();
			Utility.javaScriptClick(TransactionButton, driver);
			boolean flag = false;
			WaitClass.waitForTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//label[text()='QX Points']/following-sibling::div/span/span)[3]")));
			WaitClass.waitForTime(3000);
			WebElement low = driver
					.findElement(By.xpath("(//label[text()='QX Points']/following-sibling::div/span/span)[3]"));
			WaitClass.waitForTime(3000);
			int xwidth = low.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act = new Actions(driver);
			WaitClass.waitForTime(3000);
			act.clickAndHold(low).moveByOffset(xwidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(3000);
			List<WebElement> list = driver
					.findElements(By.xpath("//div[@class='tbody-data']//label[text()='QX Points']/parent::div"));

			String lowvalue = low.getText();
			int correctlowvalue = Integer.valueOf(lowvalue);

			for (int i = 0; i <= list.size() - 1; i++) {
				String listvalue = list.get(i).getText();
				lista.add(listvalue);
			}
			String data = lista.get(0);
			String[] expected = data.split("");
			int correctexpectvalue = Integer
					.valueOf(expected[0] + expected[1] + expected[3] + expected[4] + expected[5]);

			if (correctexpectvalue > correctlowvalue) {
				flag = true;
			}
			Assert.assertTrue(flag, "Value is not Matching");
			WaitClass.waitForTime(3000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//label[text()='QX Points']/following-sibling::div/span/span)[4]")));
			WaitClass.waitForTime(3000);
			WebElement high = driver
					.findElement(By.xpath("(//label[text()='QX Points']/following-sibling::div/span/span)[4]"));
			WaitClass.waitForTime(3000);
			int Ywidth = high.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act1 = new Actions(driver);
			WaitClass.waitForTime(3000);
			act1.clickAndHold(high).moveByOffset(-Ywidth * 2, 0).release().build().perform();
			WaitClass.waitForTime(5000);
			act1.clickAndHold(high).moveByOffset(Ywidth * 5, 0).release().build().perform();
			return flag;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - QxPointsSlider, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify and Validate the Amount Slider .
	 * 
	 * @return - True - if Amount Slider Are Working properly.
	 */

	public boolean AmountSlider() {
		try {
			ArrayList<String> lista = new ArrayList<String>();

			float datavalue = 0;
			boolean flag = false;
			WaitClass.waitForTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Amount']/following-sibling::div/span/span)[3]")));
			WaitClass.waitForTime(3000);
			WebElement low = driver
					.findElement(By.xpath("(//label[text()='Amount']/following-sibling::div/span/span)[3]"));
			WaitClass.waitForTime(3000);
			int xwidth = low.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act = new Actions(driver);
			WaitClass.waitForTime(3000);
			act.clickAndHold(low).moveByOffset(xwidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(3000);
			List<WebElement> li = driver.findElements(By.xpath("//div[@class='tbody-data text-md-right']"));
			float lowvalue = Float.parseFloat(low.getText());
			for (int i = 0; i <= li.size() - 1; i++) {
				String listvalue = li.get(i).getText();
				String amvalue = listvalue.replace('$', ' ');
				lista.add(amvalue);
			}

			String data = lista.get(0);
			datavalue = Float.parseFloat(data);
			if (datavalue > lowvalue) {
				flag = true;
			}
			Assert.assertTrue(flag, "Value is not Matching");
			WaitClass.waitForTime(3000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Amount']/following-sibling::div/span/span)[4]")));
			WaitClass.waitForTime(3000);
			WebElement high = driver
					.findElement(By.xpath("(//label[text()='Amount']/following-sibling::div/span/span)[4]"));
			WaitClass.waitForTime(3000);
			int Ywidth = high.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act1 = new Actions(driver);
			WaitClass.waitForTime(3000);
			act1.clickAndHold(high).moveByOffset(-Ywidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(5000);
			act1.clickAndHold(high).moveByOffset(Ywidth * 5, 0).release().build().perform();
			return true;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - AmountSlider, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - Verify and Validate the Fees Slider .
	 * 
	 * @return - True - if Fees Slider Are Working properly.
	 */

	public boolean FeesSlider() {
		try {
			ArrayList<String> lista = new ArrayList<String>();

			float datavalue = 0;
			boolean flag = false;
			WaitClass.waitForTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Fees']/following-sibling::div/span/span)[3]")));
			WaitClass.waitForTime(3000);
			WebElement low = driver
					.findElement(By.xpath("(//label[text()='Fees']/following-sibling::div/span/span)[3]"));
			WaitClass.waitForTime(3000);
			int xwidth = low.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act = new Actions(driver);
			WaitClass.waitForTime(3000);
			act.clickAndHold(low).moveByOffset(xwidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(3000);
			List<WebElement> li = driver
					.findElements(By.xpath("//div[@class='tbody-data']//label[text()='Fees']/parent::div"));
			float lowvalue = Float.parseFloat(low.getText());
			for (int i = 0; i <= li.size() - 1; i++) {
				String listvalue = li.get(i).getText();
				String amvalue = listvalue.replace('$', ' ');
				lista.add(amvalue);
			}
			String max = Collections.max(lista);

			datavalue = Float.parseFloat(max);
			if (datavalue > lowvalue) {
				flag = true;
			}
			Assert.assertTrue(flag, "Value is not Matching");
			WaitClass.waitForTime(3000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//label[text()='Fees']/following-sibling::div/span/span)[4]")));
			WaitClass.waitForTime(3000);
			WebElement high = driver
					.findElement(By.xpath("(//label[text()='Fees']/following-sibling::div/span/span)[4]"));
			WaitClass.waitForTime(3000);
			int Ywidth = high.getSize().width;
			WaitClass.waitForTime(3000);
			Actions act1 = new Actions(driver);
			WaitClass.waitForTime(3000);
			act1.clickAndHold(high).moveByOffset(-Ywidth * 3, 0).release().build().perform();
			WaitClass.waitForTime(5000);
			act1.clickAndHold(high).moveByOffset(Ywidth * 5, 0).release().build().perform();
			return true;

		}

		catch (Exception e) {

			System.err.println("Exception in Method - FeesSlider, Class - Redeem_Gamer_pages : " + e);
			return false;
		}

	}

	/**
	 * Description - checking all WebElement Are Present on Transactions Page .
	 * 
	 * @return - True - if all Elements are visible Transactions Page.
	 */
	public boolean AllWebElementPresentonTransActionsPage() {

		try {
			WaitClass.waitForTime(1000);
			TransactionButton.click();
			WaitClass.waitForTime(1000);
			boolean flag = clickredeemnutton.isDisplayed();
			flag = flag && UsDollersHeaderTransAction.isDisplayed();
			flag = flag && QxPointsValueTransaction.isDisplayed();
			flag = flag && UsDollerValueTransAction.isDisplayed();
			flag = flag && QxPointsSliderHeaderTransaction.isDisplayed();
			flag = flag && CashBackVedorDropdownHeaderTransaction.isDisplayed();
			flag = flag && FeesSliderHeaderTransaction.isDisplayed();
			flag = flag && StatusDropdownHeaderTransaction.isDisplayed();
			flag = flag && AmountSliderHeaderTransaction.isDisplayed();
			flag = flag && QxPointsTransAction.isDisplayed();
			flag = flag && CashBackVendorTransAction.isDisplayed();
			flag = flag && FeesTransAction.isDisplayed();
			flag = flag && StatusTransAction.isDisplayed();
			flag = flag && AmountTransAction.isDisplayed();
			return flag;
		} catch (Exception e) {

			System.err.println(
					"Exception in Method - AllWebElementPresentonTransActionsPage, Class - Redeem_Gamer_pages : " + e);
			return false;
		}
	}

	/**
	 * Description : Verify and validate the Drop down value for CashBack Vendor,
	 * Status on Transaction page
	 * 
	 * @return true: if the drop down value are working fine for the CashBack Vendor
	 *         and Status
	 */

	public boolean GetdropdownfromTransactionPageCashbackVendor() {
		try {

			// it is Verify and validate for "Dwolla"
			WaitClass.waitForTime(1000);
			TransactionButton.click();
			WaitClass.waitForTime(1000);
			CashBackdropdownTransAction.click();
			WaitClass.waitForTime(1000);
			SearchDropDownValueDwolla.click();
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(CashBackdropdownTransAction).click().perform();
			WaitClass.waitForTime(2000);
			String CashBackVendorA = driver.findElement(By.xpath("//span[contains(text(),'Dwolla')]/ancestor::button"))
					.getText();
			String CashBackVendortextB = SortingCashbackVendor.get(0).getText();
			Assert.assertEquals(CashBackVendorA, CashBackVendortextB);
			softassert.assertAll();
			// it is use for the PayPal
			action.moveToElement(DropDownCross).click().perform();
			WaitClass.waitForTime(1000);
			CashBackdropdownTransAction.click();
			WaitClass.waitForTime(1000);
			SearchDropDownValuePayPal.click();
			WaitClass.waitForTime(2000);

			action.moveToElement(CashBackdropdownTransAction).click().perform();
			WaitClass.waitForTime(2000);
			String CashBackVendorPayPal = driver
					.findElement(By.xpath("//span[contains(text(),'PayPal')]/ancestor::button")).getText();
			String CashBackVendortextBPayPal = SortingCashbackVendor.get(1).getText();
			Assert.assertEquals(CashBackVendorPayPal, CashBackVendortextBPayPal);
			softassert.assertAll();
			action.moveToElement(DropDownCross).click().perform();
			return true;

		} catch (Exception e) {
			System.err
					.println("Exception in Method - GetdropdownfromTransactionPage, Class - Redeem_Gamer_pages : " + e);
			return false;
		}
	}

	/**
	 * Description : Verify and validate the Drop down value for Status Status on
	 * Transaction page
	 * 
	 * @return true: if the drop down value are working fine for the CashBack Vendor
	 *         and Status
	 */

	public boolean GetdropdownfromTransactionPageStatus() {
		try {

			// it is Verify and validate for "Status Pending"

			StatusdropdownTransAction.click();
			WaitClass.waitForTime(1000);
			SearchDropDownValuePending.click();
			WaitClass.waitForTime(2000);
			Actions action = new Actions(driver);
			action.moveToElement(StatusDropdownHeaderTransaction).click().perform();
			WaitClass.waitForTime(2000);
			String StatustextA = driver.findElement(By.xpath("//span[contains(text(),'Pending')]/ancestor::button"))
					.getText();
			String StatustextB = SortingStatus.get(0).getText();
			if (StatustextA.equalsIgnoreCase(StatustextB)) {
				System.out.println("Sucessfully Matched");
			}
			// it is use for the "Processed"
			action.moveToElement(DropDownCross).click().perform();
			WaitClass.waitForTime(1000);
			StatusdropdownTransAction.click();
			WaitClass.waitForTime(1000);
			SearchDropDownValueProcessed.click();
			WaitClass.waitForTime(2000);
			action.moveToElement(StatusDropdownHeaderTransaction).click().perform();
			WaitClass.waitForTime(2000);
			String CashBackVendorprocessed = driver
					.findElement(By.xpath("//span[contains(text(),'Processed')]/ancestor::button")).getText();
			String CashBackVendortextBprocessed = SortingStatus.get(0).getText();
			if (CashBackVendorprocessed.equalsIgnoreCase(CashBackVendortextBprocessed)) {
				System.out.println("Sucessfully Matched");
			}
			action.moveToElement(DropDownCross).click().perform();
			return true;

		} catch (Exception e) {
			System.err
					.println("Exception in Method - GetdropdownfromTransactionPage, Class - Redeem_Gamer_pages : " + e);
			return false;
		}
	}

}
