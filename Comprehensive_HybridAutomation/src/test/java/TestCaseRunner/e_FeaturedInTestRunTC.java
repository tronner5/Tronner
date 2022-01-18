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

import PageObjects.e_FeaturedIN;
import Resources.Base;


public class e_FeaturedInTestRunTC extends Base{                  // inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Featured_In_TC() throws IOException, InterruptedException
	{
    
		Logger Log = Logger.getLogger(e_FeaturedInTestRunTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		e_FeaturedIN fea = new e_FeaturedIN(driver);
		fea.IndianExpressionIcon().click();
		Log.info("Indian Express Icon is selcted");
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		 
		FileInputStream fileInput = null;                                     //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);                                          //Data Read From Excel Read
		String PageHeading = sheet.getRow(12).getCell(0).getStringCellValue();
	
		
		
	     System.out.println("This is the title of the next Window =  "+driver.getTitle());	
	     
	     System.out.println("Page Heading is  = "+ fea.PageHeading().getText());
	     Assert.assertEquals(fea.PageHeading().getText(),PageHeading);
	     Log.info("Page Heading varified");
	     
	     fea.PopupClose().click();
		
		
	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		


	
	
	}

