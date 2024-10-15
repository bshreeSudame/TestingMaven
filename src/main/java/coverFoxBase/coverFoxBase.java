package coverFoxBase;

import java.io.IOException;


import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import coverFoxUtility.coverFoxUtility;

public class coverFoxBase {
	
	//driver
	//url
	//launch browser
	//close browser
	
	protected static WebDriver driver;
	public void launchBrowser() throws IOException
	{
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("...disable-notifications");
		driver=new ChromeDriver(Options);
		driver.manage().window().maximize();
		driver.get(coverFoxUtility.readDataFromPropertyFile("url"));
		Reporter.log("Launching Application...",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("Waiting for appplicatin launch...",true);
	}
	
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("Closing Application\",true");
	}
	

}
