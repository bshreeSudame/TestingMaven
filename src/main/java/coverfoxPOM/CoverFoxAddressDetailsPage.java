package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {

	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement pincode;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobNum;
	@FindBy(className = "next-btn") private WebElement continueButton;
	@FindBy(xpath = "//div[text()=' Please enter a valid pincode ']")private WebElement WrongPincodeMsg;
	@FindBy(xpath = "//div[text()=' Please enter a valid mobile no. ']")private WebElement WrongMobileMsg;
	public CoverFoxAddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void enterpincode(String Pincode)
	{
		Reporter.log("Entering pincode", true);
		pincode.sendKeys(Pincode);
	}
	public void entermobNum(String MobNum)
	{
		Reporter.log("Entering mobileNumber", true);
		mobNum.sendKeys(MobNum);
	}
	public void clickoncontinueButton()
	{
		Reporter.log("Clicking on continue button", true);
		continueButton.click();
	}
	
	public String getWrongPinMsg()
	{
		String actualPinText = WrongPincodeMsg.getText();
		return actualPinText;
	}
	public String  getWrongMobMsg()
	{
		String actualMobText=WrongMobileMsg.getText();
		return actualMobText;
	}
}
