package coverFoxPOM;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox_AddressDetailsPage {
		
		@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement Pin;
		@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement phone;
	    @FindBy(css = "div.next-btn") private WebElement continueButton;
			
		public CoverFox_AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		public void enterpincode(String Pincode)
		{
			Reporter.log("Entering pincode...",true);
			Pin.sendKeys(Pincode);
		}
		public void enterMobNum(String mobNum) 
		{
			Reporter.log("Entering mobile number...",true);
			phone.sendKeys(mobNum);
		}
		public void clickOnContinueButton() 
		{
			Reporter.log("Clicking on continue button...",true);
			continueButton.click();
		}
		
}
