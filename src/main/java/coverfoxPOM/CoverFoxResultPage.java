package coverfoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {
		@FindBy(xpath = "//div[contains(text(),'matching Health ')]")private WebElement results;
        @FindBy(className = "plan-card-container") private List<WebElement> allResults;
        
        public CoverFoxResultPage(WebDriver driver)
        {
        PageFactory.initElements(driver, this);
        }
        
        public int textCount()
        {
        	Reporter.log("Getting count from text", true);
        	String resultInString = results.getText().substring(0, 2);
 	        int textCount = Integer.parseInt(resultInString);
 	        return textCount;
 	        
        }
        public int bannerCount()
        {
        	Reporter.log("Getting count from banner", true);
        	int bannerCount = allResults.size();
        	return bannerCount;
        }
        
        
        
//	    public void validateResults()
//	    {
//	       String resultInString = results.getText().substring(0, 2);
//	       int resultinNum = Integer.parseInt(resultInString);
//	       int planlists = allResults.size();
	   
//	    if(resultinNum==planlists)
//	    {
//	    	System.out.println("results are matching tc passed");
//	    }
//	    else
//	    {
//	    	System.out.println("results are not matching tc failed");
//	    } 
	    

}
