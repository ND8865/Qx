package TestListners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import UtilityClass.EventListeners;

public class CustomAssert {
	
	public static String failMessage = "";
	
	/**
	 * Method to assert the conditions. Must use to reflect results in reports. Basically asserts true.
	 * @param condition - The actual true or false condition met.
	 * @param step - The success message or the step name.
	 * @param message - The error message or the failure message to display.
	 */
	public static void assertTrue(boolean condition, String step, String message) {
		if(condition == true) {
			EventListeners.test.createNode(step).pass(MarkupHelper.createLabel(ExtentReportListner.methodUnderExecution, ExtentColor.GREEN));
		}
		else {
			failMessage = message;
			throw new AssertionError(message);
		}
	}
	
	/**
	 * Method to assert the conditions. Must use to reflect results in reports. Basically asserts false.
	 * @param condition - The actual true or false condition met.
	 * @param step - The success message or the step name.
	 * @param message - The error message or the failure message to display.
	 */
	public static void assertFalse(boolean condition, String step, String message) {
		if(condition == false) {
			EventListeners.test.createNode(step).pass(MarkupHelper.createLabel(ExtentReportListner.methodUnderExecution, ExtentColor.GREEN));
		}
		else {
			failMessage = message;
			throw new AssertionError(message);
		}
	}
}
