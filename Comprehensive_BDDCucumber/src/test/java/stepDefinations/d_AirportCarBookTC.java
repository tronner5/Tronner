package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import PageObjects.d_AirportPickUp;
import Resources.Base;


@RunWith(Cucumber.class)
public class d_AirportCarBookTC extends Base{

	@Given("^Initialize the browser and opens site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

	   
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		 Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
			
	    
	}
	 
	 @When("^Select the Airport box$")
	    public void Click_Airport_Box() throws Throwable {
		 
			Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

		 d_AirportPickUp air = new d_AirportPickUp(driver);                           
			air.AirportClickForDetails().click();
			Log.info("Airport Box is selcted");

		  
		
	}
	 

	 @Then("^User enters CityName from ExcelSheet and User selects trip type$")
	public void User_enters_CityName() throws Throwable {
		 
			Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");
	      
		    d_AirportPickUp air = new d_AirportPickUp(driver);
		 
		    FileInputStream fileInput = null;
			File search = new File("ExcelSheet\\TronnerDataReadBDD.xlsx");

			FileInputStream fis = new FileInputStream(search);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String CityName = sheet.getRow(5).getCell(0).getStringCellValue();
					
			air.FromCityDetail().sendKeys(CityName);
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
			
	}
	 
	 
	 @Then("^User enters pickup location from ExcelSheet and User selects pickup time and summit$")
		public void User_enters_Pickup_Location() throws Throwable {
		 
			Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");
		      
		    d_AirportPickUp air = new d_AirportPickUp(driver);
		 
		    FileInputStream fileInput = null;
		    File search = new File("ExcelSheet\\TronnerDataReadBDD.xlsx");

			FileInputStream fis = new FileInputStream(search);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String pickup = sheet.getRow(5).getCell(1).getStringCellValue();
			
			air.PickUpLocation().sendKeys(pickup);
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

			
	}


    @Then("^Navigate to next page gets car name and validate and summit$")
    public void Validate_Car_Details() throws Throwable {
    	
		Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

    	
    	d_AirportPickUp air = new d_AirportPickUp(driver);
    	System.out.println(driver.getTitle());
	    System.out.println("The Selected Car is  =  "+air.SelectedCarName().getText());
   	    Assert.assertEquals(air.SelectedCarName().getText(), "Toyota Innova Crysta");
   	    air.SelectButton().click();
	    Log.info("Car is selected Successfully");
              
    }
    
    @Then("^Navigate to next page and fill the name (.+) email (.+) number (.+)$")
    public void Navigate_and_Fill_Details(String name  , String email   , String number) throws Throwable {
    	
		Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
  	
    	d_AirportPickUp air = new d_AirportPickUp(driver);
    	air.NameDetailsFill().sendKeys(name);
 	    air.EmailFillDetails().sendKeys(email);
 	    air.MobileNumber().sendKeys(number);
 	    Log.info("Login Details Filled");
 	    Log.error(number+"  Wrong Phone number is summited successfully");
              
    }
    
    @Then("^Unchecked the whatsapp notification check box and summit$")
    public void Uncheck_Whatsapp_Noti() throws Throwable {
    	
		Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
	
    	d_AirportPickUp air = new d_AirportPickUp(driver);
    	air.WhatsappNotiCheckBox().click();
    	Log.info("Whatsapp CheckBox UnChecked");
  	    air.ProceedButton().click();
	    Log.info("Details Summited Successfully");
	    
            
    }
    
    @Then("^Prints the details of the ride in console$")
    public void Print_The_Details() throws Throwable {
    	
    	d_AirportPickUp air = new d_AirportPickUp(driver);
	    System.out.println("Did payment tab visible ?  "+air.PaymentTabCheck().isDisplayed());
	    System.out.println("Details of Journey is  "+air.BookingDetailsDisplay().getText());
              
    }
    
   
    @And("^Close all browsers1$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(d_AirportCarBookTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For d_AirportCarBookTC TestCase");
    	
    }
	 
}