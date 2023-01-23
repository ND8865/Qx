package UtilityClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.DriverClass;

public class EventListeners implements WebDriverListener{
		
	public static String failLog = "";
	public static String firstLog = "";
	public static ExtentTest test;
	private By ele = null;
	int universalTime = 10;
	
	  // WebDriver

	  public void beforeGet(WebDriver driver, String url) {
		  failLog = "Unable to open the URL.";
		  
	  }
	  public void afterGet(WebDriver driver, String url) {
		  try {
			  test.log(Status.PASS,"Navigated successfully to - "+url+".");
			  failLog = "";
		  }
		  catch(Exception e) {
			  firstLog = "Navigated successfully to - "+url+".";
			  failLog = "";
		  }
	  }

	  public void beforeGetCurrentUrl(WebDriver driver) {
		  failLog = "Unable to get current URL.";
	  }
	  public void afterGetCurrentUrl(String result, WebDriver driver) {
		  try {
			  test.log(Status.PASS,"Current URL Extracted.");
		  }
		  catch(Exception e) {}
		  failLog = "";
	  }

	  public void beforeGetTitle(WebDriver driver) {
		  failLog = "Unable to get current page Title.";
	  }
	  public void afterGetTitle(WebDriver driver, String result) {
		  try {
			  test.log(Status.PASS,"Current Page Title Extracted.");
		  }
		  catch(Exception e) {}
		  failLog = "";
	  }

	  public void beforeFindElement(WebDriver driver, By locator) {
		  try {
				WebDriverWait ob = new WebDriverWait(driver, Duration.ofSeconds(universalTime));
				ob.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}catch(Exception e) {}
			failLog = "Unable to Find Element with location : "+locator.toString();
	  }
	  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		  try {
			  test.log(Status.PASS,"Element found with location : "+locator.toString());
		  }
		  catch(Exception e) {}
		  ele = locator;
		  failLog = "";
	  }

	  public void beforeFindElements(WebDriver driver, By locator) {
		  try {
				WebDriverWait ob = new WebDriverWait(driver, Duration.ofSeconds(universalTime));
				ob.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}catch(Exception e) {}
			failLog = "Unable to Find Elements with location : "+locator.toString();
	  }
	  public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		  try {
			  test.log(Status.PASS,"Element found with location : "+locator.toString());
		  }
		  catch(Exception e) {}
		  ele = locator;
		  failLog = "";
	  }

	  public void beforeClose(WebDriver driver) {
		  failLog = "Unable to close the browser tab.";
	  }
	  public void afterClose(WebDriver driver) {
		  try {
			  test.log(Status.PASS,"Browser Tab Closed Successfully.");
		  }
		  catch(Exception e) {}
		  failLog = "";
	  }

	  public void beforeQuit(WebDriver driver) {
		  failLog = "Unable to close the browser window.";
	  }
	  public void afterQuit(WebDriver driver) {
		  try {
			  test.log(Status.PASS,"Browser Window Closed Successfully.");
		  }
		  catch(Exception e) {}
		  failLog = "";
	  }

	  // WebElement

	  public void beforeClick(WebElement element) {
		  failLog = "Unable to click the button with location : "+ele;
			try {
				WebDriverWait ob = new WebDriverWait(DriverClass.driver, Duration.ofSeconds(universalTime));
				ob.until(ExpectedConditions.elementToBeClickable(element));
			}catch(Exception e) {}
			Utility.scrollToViewElement(DriverClass.driver, element);
			Utility.scrollToView(DriverClass.driver, element);
			WaitClass.waitForTime(1000);
	  }
	  public void afterClick(WebElement element) {
		  try {
			  test.log(Status.PASS,"Element Clicked with location : "+ele);
		  }
		  catch(Exception e) {}
		  failLog = "";
		  
	  }

	  public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
			String str = "";
			try {
				for(int i=0; i<keysToSend.length; i++) {
					str = str+keysToSend[i];
				}
			}
			catch(Exception e) {}
			failLog = "Unable to enter text - "+str;
	  }
	  public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		  String str = "";
			try {
				for(int i=0; i<keysToSend.length; i++) {
					str = str+keysToSend[i];
				}
			}
			catch(Exception e) {}
			if(str.length()>0) {
				try {
					test.log(Status.PASS,"Text Entered successfully - "+str);
				}
				catch(Exception e) {}
				failLog = "";
			}
	  }

	  // Navigation

	  public void afterRefresh(WebDriver.Navigation navigation) {
		  try {
			  test.log(Status.PASS,"Page Refreshed successfully.");
		  }
		  catch(Exception e) {}
		  failLog = "";
	  }


	
}
