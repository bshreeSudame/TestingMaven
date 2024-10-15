package coverFoxTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import coverFoxBase.coverFoxBase;
import coverFoxPOM.CoverFox_AddressDetailsPage;
import coverFoxPOM.CoverFox_HealthPlanPage;
import coverFoxPOM.CoverFox_HomePage;
import coverFoxPOM.CoverFox_MemberDetailsPage;
import coverFoxPOM.CoverFox_ResultPage;
import coverFoxUtility.coverFoxUtility;

public class TC1234_CoverFox_ValidationBannerCount extends coverFoxBase {
  
	CoverFox_HomePage homePage;
	CoverFox_HealthPlanPage healthPage;
	CoverFox_MemberDetailsPage memberDetailsPage;
	CoverFox_AddressDetailsPage addressDetailsPage;
	CoverFox_ResultPage resultPage;
	//String excelPath="C:\\Users\\ABC\\eclipse-workspace\\Sample_Project\\DataExcel\\ExcelData.xlsx";
	String excelPath= "C:\\Users\\ABC\\eclipse-workspace\\testig.group1\\DataExcel\\ExcelData.xlsx";
    String sheetName="sheet1";

	  //open browser-->open application
	@BeforeClass
	public void openingbroswser() throws IOException
	{
		launchBrowser();
	}
	
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		homePage=new CoverFox_HomePage(driver);
		healthPage=new CoverFox_HealthPlanPage(driver);
		memberDetailsPage=new CoverFox_MemberDetailsPage(driver);
		addressDetailsPage=new CoverFox_AddressDetailsPage(driver);
		resultPage=new CoverFox_ResultPage(driver);
		
		homePage.clickOnGenderButton();
		Thread.sleep(2000);
		
		healthPage.ClickOnNextButton(driver);
		Thread.sleep(2000);
		
		memberDetailsPage.handelingAge_Dropdown(coverFoxUtility.readDataFromExcel(excelPath, sheetName, 0, 0));
		Thread.sleep(2000);

		memberDetailsPage.ClickOnNextButton();
		Thread.sleep(2000);

		addressDetailsPage.enterpincode(coverFoxUtility.readDataFromExcel(excelPath, sheetName, 0, 1));
		Thread.sleep(2000);

		addressDetailsPage.enterMobNum(coverFoxUtility.readDataFromExcel(excelPath, sheetName, 0, 2));
		Thread.sleep(2000);

		addressDetailsPage.clickOnContinueButton();
	    Thread.sleep(2000);	
	}
	
	@Test
  public void validatePolicyCount() {
	  
	  //gender-->.next click-->Age selection-->next-->pin code-->mobile no-->click on next
	  int countText=resultPage.getCountFromText();
	  int bannerCount=resultPage.getCountfromBanner();
	  Assert.assertEquals(countText, bannerCount,"text count is not matching with banner count TC Failed");	  
  }
  
  //close broswer
  @AfterClass
  public void closingBroswer()
  {
	  closeBrowser();
  }
  
  
  
  
  
}
