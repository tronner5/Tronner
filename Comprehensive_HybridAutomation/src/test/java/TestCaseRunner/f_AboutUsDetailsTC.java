package TestCaseRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.f_AboutUsObjects;
import Resources.Base;


public class f_AboutUsDetailsTC extends Base {                   // Inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void About_US_TC() throws IOException, InterruptedException {
		
		Logger Log = Logger.getLogger(f_AboutUsDetailsTC.class);                                 //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		f_AboutUsObjects Abu = new f_AboutUsObjects(driver);
		Abu.aboutUsClick().click();
		Log.info("About us is selcted");
		
		Set <String> ids = driver.getWindowHandles();                             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		System.out.println("Printing the Whole text of the page \n"+Abu.InnerText().getText());
		
		FileInputStream fileInput = null;                                          //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);                                    //Data Read From Excel Read
		String CEOName = sheet.getRow(17).getCell(0).getStringCellValue();
		
		System.out.println("The CEO of the company is = " +Abu.CEONameDisplay().getText());
		
		Assert.assertEquals(Abu.CEONameDisplay().getText(), CEOName);
		Log.info("CEO Name is Varified Successfully");

		


	}
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		

}
