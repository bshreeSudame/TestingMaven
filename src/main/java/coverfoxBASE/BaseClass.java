package coverfoxBASE;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverfoxUTILITY.UtilityClass;

public class BaseClass
{
	//Actions like setup of driver,launching and closing browser and gettting url.
	
	protected static WebDriver driver ;
	
	public void launchingBrowser() throws IOException
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("-disable-notifications");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get(UtilityClass.readDatafromPropertiesFile("url"));
		Reporter.log("Launching Browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		Reporter.log("Waiting", true);
	}
	public void closingBrowser()
	{
		Reporter.log("Closing Browser", true);
		driver.quit();
	}
	
	
	
}
