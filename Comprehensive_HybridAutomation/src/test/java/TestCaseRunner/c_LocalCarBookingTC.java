package TestCaseRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.c_LocalDetails;
import Resources.Base;


public class c_LocalCarBookingTC extends Base{      
	
	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Local_Car_Booking_TC() throws IOException, InterruptedException
	{
    
		Logger Log = Logger.getLogger(c_LocalCarBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		c_LocalDetails lc = new c_LocalDetails(driver);
		
		System.out.println("This is the title of the Page =  "+driver.getTitle());   //Title of Current the page
		lc.LocalTabSelection().click();		
		Log.info("Local Cab selected Successfully");
		
		
		FileInputStream fileInput = null;                                      //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Fromcity = sheet.getRow(7).getCell(0).getStringCellValue();      //Data Read From Excel Read
		String CarName = sheet.getRow(7).getCell(1).getStringCellValue();
		String Title = sheet.getRow(7).getCell(2).getStringCellValue();
		
		
	    WebElement FromCity = lc.FromCitySelection();
	    lc.FromCitySelection().sendKeys(Fromcity);	    
	    Log.info("From City Name is read from excel Sheet");
	    
		Thread.sleep(3000);
		FromCity.sendKeys(Keys.ARROW_DOWN);
		FromCity.sendKeys(Keys.ENTER);
		
		
		lc.PickUpDate().click();
		lc.DateSelect().click();		
		Log.info("PickUp Date is selected Successfully");
		
		lc.PickUpAt().click();
		lc.PickUpTime().click();		
		Log.info("Pickup Time is Selected Successfully");
		
		lc.SubmitDetails().click();		
		Log.info("Details Summited Sucessfully");

		System.out.println("This is the title of Second Page =  "+driver.getTitle());
		lc.HrSelection().click();
		Log.info("Hour per KM Changed");
		
		System.out.println("The Selected Car is  =  "+lc.CarTypeSelection().getText());
		Assert.assertEquals(lc.CarTypeSelection().getText() ,CarName);		
		lc.SelectCar().click();
		Log.info("Car is selected Successfully");
		
		System.out.println("This is the title of the Third Page  =  "+driver.getTitle());
		
		System.out.println(lc.TitleRead().getText());		 
		Assert.assertEquals(lc.TitleRead().getText() ,Title);	
		Log.info("Title is Validated Successfully");
		
	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		
	
}

