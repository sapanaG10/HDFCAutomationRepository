package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	
public static void captureScreenshot(WebDriver driver, String testId) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		
		String fileName=date.toString().replace(" ", "_").replace(":", " ");
		File dest=new File("test-output\\FailedScreenshots\\Test"+testId+" "+fileName+".jpg");
		FileHandler.copy(src, dest);
		
	}
	
   public static String getExcelData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
	   
	   String path="src/main/resources/Data/ExcelFetch.xlsx";
	   FileInputStream file=new FileInputStream (path);
	   Workbook book= WorkbookFactory.create(file);
	   Sheet sheet= book.getSheet(sheetName);
	   Row row=sheet.getRow(rowNo);
	   Cell cell=row.getCell(cellNo);
	   
	   String excelData;
	   try
	   {
		 excelData=cell.getStringCellValue();  
	   }
	   catch(IllegalStateException e)
	   {
		   double value=cell.getNumericCellValue();
		   excelData = String.valueOf(value);
	   }
	   
	   return excelData;   
   }
}
