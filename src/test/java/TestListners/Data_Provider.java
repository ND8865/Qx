package TestListners;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import Labelling.DataRepository;

public class Data_Provider {

	private static XSSFSheet sheet;
	private static XSSFWorkbook ExcelWBook;
	public static boolean flag = false;
	public static String suiteName = "";
	public void setExcelFile(String FileName,String SheetName) throws Exception {

	try 
		{
			FileInputStream ExcelFile = new FileInputStream("src/test/resources/TestData/"+FileName+".xlsx");
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			sheet = ExcelWBook.getSheet(SheetName);
		} 
	catch(Exception e)
	{
			throw (e);
	}

	}
	
	@DataProvider(name = "data")
	public String[][] dataProvider(Method m){
		String methodName = m.getName();
		String className = m.getDeclaringClass().getName();
		className = className.substring(className.indexOf(".")+1);
		String repoDetails[] = DataRepository.getDataRepository(methodName,className);
		try {
			setExcelFile(repoDetails[0], repoDetails[1]);
		} catch (Exception e1) {
			System.err.println(e1);
			System.out.print("");
		}
		
		int rows = 0 , a = 0 , b = 0 , cols = 0;
		try{
			while(!sheet.getRow(a).getCell(0).toString().equals("")){
				rows++;
				a++;
			}
		}
		catch(Exception e){}
		try{
			while(!sheet.getRow(1).getCell(b).toString().equals("")){
				cols++;
				b++;
			}
			
		}
		catch(Exception e){}
		if(repoDetails[2].equals("0")) {
			rows = 3;
		}
		String ar[][] = new String[rows-2][cols-1];
		int k = 0 , l = 0;
		for(int i = 2 ; i < rows ; i++ , k++){
			l = 0;
			for(int j = 1 ; j < cols ; j++ , l++){
				try{
					try{
						String s = "";
						try {
							s = sheet.getRow(i).getCell(j).getCellFormula();
						}
						catch(Exception e) {}
						if(s.length()>0) {
							ar[k][l] = sheet.getRow(i).getCell(j).getRawValue().toString();
						}
						else {
							ar[k][l] = sheet.getRow(i).getCell(j).toString();
						}
					}
					catch(Exception e){
						ar[k][l] = "";
					}
				}
				catch(Exception e){}
			}
		}
		return ar;
	}
}
