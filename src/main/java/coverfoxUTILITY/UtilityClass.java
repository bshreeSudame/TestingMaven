package coverfoxUTILITY;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	// Commonlu used methods 
	
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
		File temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yymmddhhmmss").format(new Date());
	   // File dest = new File("C:\\Users\\anilj\\OneDrive\\Desktop\\Selenium\\Screenshots"+fileName+timestamp+".png");
		File dest = new File(System.getProperty("user.dir")+"\\ScreenShot"+fileName+timestamp+".png");
	    FileHandler.copy(temp, dest);
	}
	
	
	public static String readDataFromExcel( String fileName ,String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ABC\\git\\AutomationP\\DataSheet\\file1.xlsx");
		String value = WorkbookFactory.create(file).getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	    return value;
	}
	public static String readDatafromPropertiesFile(String key) throws IOException
	{
		FileInputStream myfile = new FileInputStream("C:\\Users\\ABC\\eclipse-workspace\\Testing_MavenGroup\\propertyfile.properties");
	    Properties prop = new Properties();
	    prop.load(myfile);
	    String value = prop.getProperty(key);
	    return value; 
	
	}
	
	
	

}
