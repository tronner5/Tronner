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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.b_OutstationDetails;
import Resources.Base;

public class b_OutstationCarBookingTC extends Base { // inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}

	@Test()
	public void Out_Station_CarBooking_TC() throws IOException, InterruptedException {

		Logger log = Logger.getLogger(b_OutstationCarBookingTC.class);
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Url Opened Successfully");
		
		b_OutstationDetails l = new b_OutstationDetails(driver);
		l.RoundTripCheckBox().click();
		
		log.info("RoundTrip Check Box checked");

		
		 //Taking data from excel file 
		FileInputStream fileInput = null;
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String FromCity = sheet.getRow(2).getCell(3).getStringCellValue();
		String ToCity = sheet.getRow(2).getCell(4).getStringCellValue();
		   		
		
		WebElement FromLocation = l.InputFromLocation();
		FromLocation.sendKeys(FromCity);
		
		log.info("From City Data is read from Excel File");
		
		Thread.sleep(2000);
		FromLocation.sendKeys(Keys.ARROW_DOWN);
		FromLocation.sendKeys(Keys.ARROW_DOWN);
		FromLocation.sendKeys(Keys.ENTER);

		WebElement ToLocation = l.InputToLocation();
		ToLocation.sendKeys(ToCity);
		
		log.info("To City Data is read from Excel File");
		
		Thread.sleep(3000);
		ToLocation.sendKeys(Keys.ARROW_DOWN);
		ToLocation.sendKeys(Keys.ARROW_DOWN);
		ToLocation.sendKeys(Keys.ENTER);
		
		
		// l.ReturnDateCalender().click(); 
		// Thread.sleep(3000);
		// l.ReturnDateSelection().click();

		
		 l.PickupTimeBox().click();
		 l.PickUpTimingSelection().click();
		 
		 log.info("PickUp Time is selected");
		 
		 l.SelectCarButton().click();

		 log.info("Car details Summited Successfully");
		 
		  System.out.println("The Selected car is = "+l.SelectCar().getText()); 
		  l.SummitCarButton().click();
		  
		  log.info("Car selected sucessfully");
		  
	}
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		

}
