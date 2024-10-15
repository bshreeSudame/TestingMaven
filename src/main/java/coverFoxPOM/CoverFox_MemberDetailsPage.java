package coverFoxPOM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFox_MemberDetailsPage {
	
	@FindBy(id="Age-You") private WebElement me;
	@FindBy(css="div.next-btn") private WebElement nextButton;

	
	public CoverFox_MemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void handelingAge_Dropdown(String age)
	{
		Reporter.log("Selecting age...",true);
		Select s=new Select(me);
		s.selectByValue(age+"y");  	
	}
	
	public void ClickOnNextButton()
	{
		Reporter.log("Clicking on next button",true);
		nextButton.click();
	}	
}
