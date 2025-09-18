package ScreenShot;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			captureScreenShot(result.getMethod().getMethodName()+".png");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
