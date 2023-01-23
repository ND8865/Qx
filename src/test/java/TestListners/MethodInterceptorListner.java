package TestListners;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptorListner implements IMethodInterceptor{

	List<String> testCaseName = new ArrayList<String>();
	public static HashMap<String, String> testDetails = new HashMap<String, String>();
	
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		try {
			FileInputStream ExcelFile = new FileInputStream("src/test/resources/TESTCASES.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook excelWBook = new XSSFWorkbook(ExcelFile);
			XSSFSheet sheet = excelWBook.getSheet("TESTCASES");
			int i = 1;
	    	try{
	    		while(sheet.getRow(i).getCell(1).toString()!= "") {
	    			if(sheet.getRow(i).getCell(2).toString().equalsIgnoreCase("Y")){
						testCaseName.add(sheet.getRow(i).getCell(1).toString().replace("-", ""));
						testDetails.put(sheet.getRow(i).getCell(1).toString().replace("-", ""), sheet.getRow(i).getCell(3).toString());
	    			}
	    			i++;
		  		}
	    	}
	    	catch(Exception e){}
	    	
	    	int size = testCaseName.size();
	    	IMethodInstance array[] = new IMethodInstance[size];
	    	
	    	@SuppressWarnings("unused")
			int j = 0;
	    	
	    	for(IMethodInstance m : methods) {
	    		String name = m.getMethod().getMethodName();
	    		if(testCaseName.contains(name)){
	    			int a = testCaseName.indexOf(name);
	    			array[a] = m;
	    		    j++;
	    		}
	    	}
	    	List<IMethodInstance> result = new ArrayList<IMethodInstance>();
	    	for(int k = 0 ; k < array.length; k++){
	    		try{
	    			if(array[k] != null){
	    				result.add(array[k]);
	    			}
	    		}
	    		catch(Exception e){	}
	    	}
	    	
	    	methods = result;
	    	ExtentReportListner.totalMethodsCount = result.size();
	    	return methods;
	    	
		} catch (Exception e) {
			System.err.println("Exception in class MethodInterceptorListner" +e);
			return null;
		} 
		
	}

}
