package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailPage {

  @FindBy(id = "Age-You")private WebElement agedropdownButton;
  @FindBy(className = "next-btn") private WebElement nextbutton;

  public CoverFoxMemberDetailPage(WebDriver driver)
  {
	  
	  PageFactory.initElements(driver, this);
  }
  public void handleDropDown(String age)
  {
	  Reporter.log("Handling age dropdown", true);
	  Select slt = new Select(agedropdownButton);
	  slt.selectByValue(age+"y");
  }
  public void clickonNextButton()
  {
	  Reporter.log("Clicking on nextButton", true);
	  nextbutton.click();
  }
}
