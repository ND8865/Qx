package TestListners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.IExecutionListener;

public class DirectoryManagement implements IExecutionListener{

	
	public void onExecutionStart() {
		try {
			File file = new File("ExtentReport/Screenshot");
			file.mkdir();
			FileUtils.cleanDirectory(file);
		} catch (IOException e) {
			System.err.println("Unable to clear directory");
		}
		
	}

	
	public void onExecutionFinish() {
		try {
			FileUtils.cleanDirectory(new File("test-output"));
			new File("test-output").delete();
		} catch (IOException e) {
			System.err.println("Unable to clear directory");
		}
		
	}

}
