package TestCaseRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.d_AirportPickUp;
import Resources.Base;


public class d_AirportCarBookingTC extends Base {             //Inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();	
	}


	@Test(dataProvider = "newdata")
	public void Airport_Car_Booking_TC(String Name , String email ,  int number ) throws IOException, InterruptedException {
		
		Logger Log = Logger.getLogger(d_AirportCarBookingTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(prop.getProperty("url"));
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		d_AirportPickUp air = new d_AirportPickUp(driver);                            
		air.AirportClickForDetails().click();
		Log.info("Airport Box is selcted");
		

		FileInputStream fileInput = null;                                               //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Fromcity = sheet.getRow(7).getCell(4).getStringCellValue();              //Data Read From Excel Read
		String pickUpLocation = sheet.getRow(7).getCell(5).getStringCellValue();
		String CarName = sheet.getRow(7).getCell(6).getStringCellValue();
		//String UserName = sheet.getRow(7).getCell(7).getStringCellValue();
		//String Email = sheet.getRow(7).getCell(8).getStringCellValue();
		
		
		air.FromCityDetail().sendKeys(Fromcity);
		Log.info("From City Name is read from excel Sheet");
		
		Thread.sleep(2000);                                              //Wait time for Getting City Suggestion DropDown
		air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
		air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
		air.FromCityDetail().sendKeys(Keys.ENTER);
		
		air.TripTypeSelection().click();
		Thread.sleep(2000);                                              //Wait time for Getting TripType Suggestion DropDown
		air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
		air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
		air.TripTypeSelection().sendKeys(Keys.ENTER);
		
		air.PickUpLocation().sendKeys(pickUpLocation);
		Log.info("PickUp Location is Selected");
		
		Thread.sleep(7000);                                             //Wait time for Getting PickupLocation Suggestion DropDown
		air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
		air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
		air.PickUpLocation().sendKeys(Keys.ENTER);
		
		air.PickupTime().click();
		Log.info("Pickup Time is Selected Successfully");
		
		Thread.sleep(2000);                                           //Wait time for Getting Time DropDown
		air.PickupTime().sendKeys(Keys.ARROW_DOWN);
		air.PickupTime().sendKeys(Keys.ARROW_DOWN);
		air.PickupTime().sendKeys(Keys.ENTER);
		
		air.SummitButton().click();
		Log.info("Details Summited Sucessfully");
		
	    System.out.println("The Selected Car is  =  "+air.SelectedCarName().getText());
	    Assert.assertEquals(air.SelectedCarName().getText(), CarName);
	    air.SelectButton().click();
	    Log.info("Car is selected Successfully");
	    
	  
	    String Number = String.valueOf(number);
	    
	    air.NameDetailsFill().sendKeys(Name);	    
	    air.EmailFillDetails().sendKeys(email);	   
	    air.MobileNumber().sendKeys(Number);
	    Log.info("Login Details Filled");
	    
	    air.WhatsappNotiCheckBox().click();
	    Log.info("Whatsapp CheckBox UnChecked");
	    
	    air.ProceedButton().click();
	    Log.info("Details Summited Successfully");
	    Log.error(Number+"  Wrong Phone number is summited successfully");
	    
	    System.out.println("Did payment tab visible ?  "+air.PaymentTabCheck().isDisplayed());
	    System.out.println("Details of Journey is  "+air.BookingDetailsDisplay().getText());
	    
	}
	
	@DataProvider(name = "newdata")
	public static Object[][] getData() {
	    return new Object[][]{
	    	
	            {"Tronner"   ,   "tronner@gmail.com"  ,   1224355047 },
	            {"Derick"    ,   "DerickOP@gmail.com" ,   1233444730 } 
	    };
	}
	
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		

}
