package TestListners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int count = 0;
    private static int maxTry = 0;
	
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      
            if (count < maxTry) {                            
                count++;                                     
                iTestResult.setStatus(ITestResult.SKIP);  
                return true;                                 
            } else {
            	count = 0;
                iTestResult.setStatus(ITestResult.FAILURE);  
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);     
        }
        return false;
    }

	
}
