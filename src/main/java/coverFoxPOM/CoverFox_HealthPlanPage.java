package coverFoxPOM;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_HealthPlanPage {
	
	@FindBy(className ="next-btn") private WebElement nextButton;
	
	public CoverFox_HealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void ClickOnNextButton(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,4000)");
		Reporter.log("Clicking on next button",true);
		nextButton.click();
	}

}
