package coverFoxUtility;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.coverFoxBase;

public class listener extends coverFoxBase implements ITestListener
{
   
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+"Passed",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+"Failed",true);
		try
		{
			Reporter.log("Take Screenshot of failure",true);
			coverFoxUtility.takescreenshot(driver, "Test123");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
