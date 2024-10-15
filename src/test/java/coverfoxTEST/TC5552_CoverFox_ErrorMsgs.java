package coverfoxTEST;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverfoxBASE.BaseClass;
import coverfoxPOM.CoverFoxAddressDetailsPage;
import coverfoxPOM.CoverFoxHealthPlanPage;
import coverfoxPOM.CoverFoxHomePage;
import coverfoxPOM.CoverFoxMemberDetailPage;
import coverfoxPOM.CoverFoxResultPage;
import coverfoxUTILITY.UtilityClass;

public class TC5552_CoverFox_ErrorMsgs extends BaseClass {

	CoverFoxHomePage home;
	CoverFoxHealthPlanPage hplan;
	CoverFoxMemberDetailPage mdetails;
	CoverFoxAddressDetailsPage adddetails;
	CoverFoxResultPage cresult;
	String excelpath = System.getProperty("user.dir") + "\\DataSheet\\file1.xlsx";
	String SheetName = "Sheet1";
	public static Logger logger;
	

//	@BeforeClass
//	public void openapplication() throws IOException
//	{
//		launchingBrowser();	
//	}

	@BeforeMethod
	public void details() throws EncryptedDocumentException, IOException, InterruptedException {
		launchingBrowser();	
		logger=Logger.getLogger("Maven Automation");
		PropertyConfigurator.configure("log4j.properties");
		home = new CoverFoxHomePage(driver);
		hplan = new CoverFoxHealthPlanPage(driver);
		mdetails = new CoverFoxMemberDetailPage(driver);
		adddetails = new CoverFoxAddressDetailsPage(driver);
		cresult = new CoverFoxResultPage(driver);
		
		
		home.cliclongenderButton();
		Thread.sleep(1000);
		hplan.clickonNextButton();
		Thread.sleep(1000);
		logger.warn("please enter age above18");
		mdetails.handleDropDown(UtilityClass.readDataFromExcel(excelpath, SheetName, 0, 0));
		mdetails.clickonNextButton();
		Thread.sleep(1000);
		
		
	}

	@Test(priority = -1)
	public void validatePincodeErrMsg() throws EncryptedDocumentException, IOException {
		
		logger.info("entering mobnumber");
		adddetails.entermobNum(UtilityClass.readDataFromExcel(excelpath, SheetName, 0, 2));
		adddetails.clickoncontinueButton();
		logger.info("Code Execution is Succesful ");
		String actualpincode = adddetails.getWrongPinMsg();
		String expectedpincode = "Please enter a valid pincode";
		Assert.assertEquals(actualpincode, expectedpincode,"Error messeges are not matching,TC Fail");

//		int totaltextcount = cresult.textCount();
//		int totalbannercount = cresult.bannerCount();
//		Assert.assertEquals(totaltextcount, totalbannercount, "text are not matching ,tc failed");
//	   // Assert.fail();
	}
	@Test
	public void validateMobileNumErrorMsg() throws EncryptedDocumentException, IOException
	{
	   logger.info("entering pincode");
	   adddetails.enterpincode(UtilityClass.readDataFromExcel(excelpath, SheetName, 0, 1));
	   adddetails.clickoncontinueButton();
	   String actualMobNum =  adddetails.getWrongMobMsg();
	   String expectedMobNum = "Please enter a valid mobile no.";
	   Assert.assertEquals(actualMobNum, expectedMobNum,"Text are not matching TC failed");
	
	}

	@AfterMethod
	public void closeapplication()
	{
		closingBrowser();
	}
}
