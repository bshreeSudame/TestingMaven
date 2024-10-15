package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
		// variable declaration
      @FindBy(xpath = "//div[text()='Male']")private WebElement gender;
      // variable initializeusing constructor
      public CoverFoxHomePage(WebDriver driver) 
      {
    	  PageFactory.initElements(driver, this);
      }
      // method
      public void cliclongenderButton()
      {
    	  Reporter.log("Clicking on genderButton", true);
    	  gender.click();
      }
      

}
