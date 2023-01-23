package UtilityClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;

import com.google.common.collect.ImmutableMap;

import BaseClass.DriverClass;

public class Utility {

	public static boolean javaScriptClick(WebElement element, WebDriver driver) {
		try {

			scrollToView(driver, element);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : javaScriptClick " + e);
			return false;
		}
	}

	public static boolean fillReadOnlyDate(WebDriver driver, WebElement element, String date) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", element);
			element.sendKeys(date);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : fillReadOnlyDate " + e);
			return false;
		}
	}

	public static boolean scrollToViewElement(WebDriver driver, WebElement element) {
		try {
			WaitClass.waitForTime(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : scrollToViewElement " + e);
			return false;
		}
	}

	public static boolean scrollToView(WebDriver driver, WebElement element) {
		try {
			WaitClass.waitForTime(1000);
			String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
					+ "var elementTop = arguments[0].getBoundingClientRect().top;"
					+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";

			((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : scrollToView " + e);
			return false;
		}
	}

	public static String getValidation(int row) {
		try {
			FileInputStream ExcelFile = new FileInputStream("src/test/resources/Validations.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
			XSSFSheet sheet = excelWBook.getSheet("lists");
			String s = sheet.getRow(row).getCell(2).toString();
			return s;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : getValidation " + e);
			return null;
		}
	}

	public static boolean handleTextEditor(WebDriver driver, WebElement iFrame, String data) {
		try {
			WaitClass.waitForElement(iFrame, driver, 10000);
			Utility.scrollToView(DriverClass.eDriver, iFrame);
			DriverClass.eDriver.switchTo().frame(iFrame);
			WebElement ele = DriverClass.eDriver.findElement(By.xpath(
					"/html/body[@class = 'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"));
			Actions performAct = new Actions(DriverClass.eDriver);
			performAct.keyDown(ele, Keys.SHIFT).sendKeys(Keys.PAGE_DOWN).keyUp(Keys.SHIFT).sendKeys(Keys.DELETE)
					.keyDown(Keys.SHIFT).sendKeys(Keys.PAGE_UP).keyUp(Keys.SHIFT).sendKeys(data).build().perform();
			DriverClass.eDriver.switchTo().defaultContent();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : handleTextEditor " + e);
			return false;
		}
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static int getRandomInt(int min, int max) {
		int x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;
	}

	public static String getPropertiesFile(String fileName, String key) {
		try {
			Properties properties = new Properties();
			String dir = new File("src/main/resources/" + fileName + ".properties").getAbsolutePath();
			FileInputStream file = new FileInputStream(dir);
			properties.load(file);
			String value = properties.getProperty(key);
			file.close();
			return value;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : getPropertiesFile " + e);
			return null;
		}
	}

	/**
	 * Method to turn off or on internet access for chrome browser only.
	 * 
	 * @param offline - True if want to close internet access, false otherwise.
	 * @return - driver with the offline functioning.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static WebDriver InternetAccess(boolean offline) {
		try {
			CommandExecutor executor = ((RemoteWebDriver) DriverClass.eDriver).getCommandExecutor();

			HashMap map = new HashMap();
			map.put("offline", offline);
			map.put("latency", 5);
			map.put("download_throughput", 5000);
			map.put("upload_throughput", 5000);
			Response response = executor.execute(new Command(((RemoteWebDriver) DriverClass.eDriver).getSessionId(),
					"setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
			return DriverClass.eDriver;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : InternetAccess " + e);
			return null;
		}

	}

	public static void clearField(WebDriver driver, WebElement element) {
		try {
			int size = element.getAttribute("value").length();
			String s = "";
			for (int i = 0; i < size; i++) {
				s = s + Keys.BACK_SPACE.toString();
			}
			element.sendKeys(s);
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : clearField " + e);
		}
	}

	public static void javascriptSendKeys(WebDriver driver, WebElement element, String data) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" + data + "';", element);
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : javascriptSendKeys " + e);
		}
	}

	public static boolean setTempProperties(String fileName, String key, String value) {
		try {
			String path = new File("src/main/resources/" + fileName + ".properties").getAbsolutePath();
			FileInputStream in = new FileInputStream(path);
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(path);
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
			return true;
		} catch (Exception e) {
			System.err.println("Exception in Class : Utility - Method : setTempProperties " + e);
			return false;
		}
	}

	/**
	 * 
	 * @param driver
	 * @param Strhoverobj
	 * @param Strobjclick
	 * @return true MouseHover and click on WebElement
	 * @author Nishant Dhiman
	 */
	public static boolean MouseHovernclick(WebDriver driver, String Strhoverobj, String Strobjclick) {
		try {
			WebElement element = driver.findElement(By.linkText(Strhoverobj));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(4000);
			driver.findElement(By.linkText(Strobjclick)).click();
			return true;
		} catch (Exception ex) {
			System.out.println("Exception in MouseHovern click");
			return false;
		}

	}

	/**
	 * 
	 * @param imagePath (String)  Path;
	 * 
	 * @return True if upload file is success full.
	 * 
	 * @author Nishant Dhiman
	 */

	public static boolean uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(150);
			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.delay(250);

			return true;
		} catch (AWTException e) {
			System.out.println("Issue in RobotUpload file");
			return false;
		}
	}

	/**
	 * 
	 * @param WebDriver driver , WebElement ;
	 * 
	 * @return Alert text if is available .
	 * @author Nishant Dhiman
	 */
	public static String getalerttext(WebDriver driver, WebElement WebElmentMessage) {
		String altext = "";
		try {
			altext = WebElmentMessage.getText();
			Thread.sleep(1000);
			return altext;
		} catch (Exception ex) {
			System.out.println("Issue in get value from alert text.");
		}
		return altext;
	}
	
	public static void printCredentials(String username, String password, String email, String name) {
		System.out.println("Created New Credentials : ");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("email: " + email);
		System.out.println("name: " + name);
	}
}
