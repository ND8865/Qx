package TestListners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.google.common.io.Files;

import BaseClass.DriverClass;
import Labelling.Categories;
import UtilityClass.EventListeners;

public class ExtentReportListner implements ITestListener{
	
	ExtentSparkReporter reporter;
	ExtentReports extent;
	public static String methodUnderExecution = "";
	public static int totalMethodsCount = 0;
	
	
	
	public void onTestStart(ITestResult result) {
		methodUnderExecution = result.getMethod().getMethodName();
		EventListeners.test = extent.createTest(result.getMethod().getMethodName(),MethodInterceptorListner.testDetails.get(result.getMethod().getMethodName())).assignCategory(Categories.getCategoryName(result.getTestClass().getName()));
		EventListeners.test.log(Status.PASS,EventListeners.firstLog);
	}

	public void onTestSuccess(ITestResult result) {
	
	}
	
	public void onTestFailure(ITestResult result) {
		EventListeners.test.log(Status.FAIL, EventListeners.failLog,result.getThrowable(),null);
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		String file = "./ExtentReport/Screenshot/"+ExtentReportListner.methodUnderExecution+"-"+sdf.format(cal.getTime())+".png";
		try {
			File scr = ((TakesScreenshot)DriverClass.driver).getScreenshotAs(OutputType.FILE);
			File a = new File(file);
			Files.move(scr, a);
			Media screenshot = MediaEntityBuilder.createScreenCaptureFromPath(file.substring(file.indexOf("S"))).build();
			EventListeners.test.info("Screenshot - ", screenshot);
		 } catch (Exception f) {System.out.println(f);}
		EventListeners.test.createNode(CustomAssert.failMessage+" : "+EventListeners.failLog).fail(MarkupHelper.createLabel(methodUnderExecution, ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(ITestContext context) {
			reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/"+context.getCurrentXmlTest().getName()+".html").viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.EXCEPTION, ViewName.CATEGORY}).apply();
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("OS : ", System.getProperty("os.name"));
			extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
			extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
			extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
			reporter.config().enableOfflineMode(false);
			reporter.config().setDocumentTitle("QX AUTOMATION REPORT");
			reporter.config().setReportName("acQyr eXchange");
			reporter.config().setTheme(Theme.DARK);
			reporter.config().setCss(".row { float: left; width: 120%;}");
			reporter.config().setCss(".m-t-10.m-l-5 { padding-top: 7px; font-size: 20px; font-weight: bold; }");
			reporter.config().setTimelineEnabled(true);
			reporter.config().setTheme(Theme.STANDARD);
	}
	
	@SuppressWarnings("deprecation")
	public void onFinish(ITestContext context) {
		if(totalMethodsCount > 0) {
			Capabilities caps = ((RemoteWebDriver) DriverClass.eDriver).getCapabilities();
			String browserName = caps.getBrowserName();
			String browserVersion = caps.getVersion();
			extent.setSystemInfo("Browser Name : ", browserName);
			extent.setSystemInfo("Browser Version", browserVersion);
			extent.flush();
		}
		
		
	}
	
	

}
