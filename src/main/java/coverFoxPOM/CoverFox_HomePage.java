package coverFoxPOM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_HomePage {


	//variable declaration
	@FindBy(xpath="//div[text()='Female']") private WebElement gender;
	
	//constructor
	public CoverFox_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//method
	public void clickOnGenderButton()
	{
		Reporter.log("Clicking on gender betton...",true);
		gender.click();
	}
	

}
