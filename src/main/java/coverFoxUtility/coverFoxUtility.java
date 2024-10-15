package coverFoxUtility;

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

public class coverFoxUtility {

	public static void takescreenshot(WebDriver driver,String filename) throws IOException
	{
		//screenshot
		String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desti=new File(System.getProperty("user.dir") + "\\ScreenShots\\" + filename + timestamp + ".png");
		FileHandler.copy(source, desti);
	}
	
	public static String readDataFromExcel(String excelPath, String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException 
	{
		//excelReading
		FileInputStream myFile=new FileInputStream(excelPath);
		String value = WorkbookFactory.create(myFile).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//read data from property file
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\ABC\\eclipse-workspace\\Sample_Project\\src\\propertyfile.properties");
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
	
}
