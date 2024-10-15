package coverfoxUTILITY;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverfoxBASE.BaseClass;

public class Listener extends BaseClass implements ITestListener 
{
@Override
public void onTestSuccess(ITestResult result) {
	Reporter.log("tc "+result.getName()+"passed", true);
}
@Override
	public void onTestFailure(ITestResult result) {
	Reporter.log("Taking Screenshot", true);
	try {
		UtilityClass.takeScreenShot(driver, result.getName());
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
}
