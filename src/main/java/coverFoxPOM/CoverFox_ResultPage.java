package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_ResultPage {
	@FindBy(xpath = "//div[contains(text(),'matching Health')]") private WebElement resultText; ;
	@FindBy(css = "div.plan-card-container") private List<WebElement> planList;
    
	
	public CoverFox_ResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int getCountFromText()
	{
		Reporter.log("Getting policy count from text displayed..",true);
		String resultInString=resultText.getText().substring(0,2);
	    int CountFromText = Integer.parseInt(resultInString);
		return CountFromText;
		
	}
	
	public int getCountfromBanner()
	{
		Reporter.log("Getting policy count from banner displayed");
		int countFromBannerPage=planList.size();
		return countFromBannerPage;
	}

}
	

