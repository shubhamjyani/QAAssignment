package recruitCRM;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	Base base = new Base();
	
	public void onTestFailure(ITestResult result) {
		
		try {
			base.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
