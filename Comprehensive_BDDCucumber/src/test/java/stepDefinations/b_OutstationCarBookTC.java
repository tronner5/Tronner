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
import org.openqa.selenium.WebElement;

import PageObjects.b_OutstationDetails;
import Resources.Base;




@RunWith(Cucumber.class)
public class b_OutstationCarBookTC extends Base{

	@Given("^Initialize the browser$")
	public void Initialize_the_browser() throws Throwable {
	
		 driver = initializeDriver();
	    
	}

	 @Then("^Read the Site From excel and navigate$")
	    public void Navigate_to_Site() throws Throwable {
		  
			Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
			PropertyConfigurator.configure("log4j.properties");
					
		    FileInputStream fileInput = null;
			File search = new File("ExcelSheet\\TronnerDataReadBDD.xlsx");

			FileInputStream fis = new FileInputStream(search);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String url = sheet.getRow(1).getCell(0).getStringCellValue();
					
		     driver.get(url);
		     log.info("Url Opened Successfully");
			
	 }
	 
	 
	 @When("^Select the Round Trip checkBox$")
	    public void Click_on_RoundTrip_CheckBox() throws Throwable {
		 
			Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
			PropertyConfigurator.configure("log4j.properties");

		    b_OutstationDetails os = new b_OutstationDetails(driver);
		 
		    os.RoundTripCheckBox().click();
		    log.info("RoundTrip Check Box checked");
		  
		
	}
	 

	 @Then("^User enters From City (.+)$")
	public void User_enters_From_City(String arg1) throws Throwable {
		 
		Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
		PropertyConfigurator.configure("log4j.properties");
      
		 b_OutstationDetails os = new b_OutstationDetails(driver);
			WebElement FromLocation = os.InputFromLocation();
			FromLocation.sendKeys(arg1);
			
			log.info("From City Data is read from Excel File");
			
			Thread.sleep(2000);
			FromLocation.sendKeys(Keys.ARROW_DOWN);
			FromLocation.sendKeys(Keys.ARROW_DOWN);
			FromLocation.sendKeys(Keys.ENTER);
			
	}
	 
	 
	 @Then("^User enters To City Details (.+)$")
		public void User_enters_To_City(String arg2) throws Throwable {
		      
			Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
			PropertyConfigurator.configure("log4j.properties");
		
		    b_OutstationDetails os = new b_OutstationDetails(driver);
			WebElement ToLocation = os.InputToLocation();
			ToLocation.sendKeys(arg2);
			
			log.info("To City Data is read from Excel File");
			
			Thread.sleep(3000);
			ToLocation.sendKeys(Keys.ARROW_DOWN);
			ToLocation.sendKeys(Keys.ARROW_DOWN);
			ToLocation.sendKeys(Keys.ENTER);
									
		}


    @Then("^User select the time for travel and click to summit button$")
    public void Selects_Time_For_Travel() throws Throwable {
    	
		Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
		PropertyConfigurator.configure("log4j.properties");
	
    	b_OutstationDetails os = new b_OutstationDetails(driver);
    	os.PickupTimeBox().click();
    	os.PickUpTimingSelection().click();
		 
		log.info("PickUp Time is selected");
		 
		os.SelectCarButton().click();

		log.info("Car details Summited Successfully");
	            
               
    }
    
    @Then("^Display the title of the selected car and select the summit button$")
    public void Display_Title() throws Throwable {
    	
		Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
		PropertyConfigurator.configure("log4j.properties");
	
    	b_OutstationDetails os = new b_OutstationDetails(driver);
		System.out.println("The Selected car is = "+os.SelectCar().getText()); 
		os.SummitCarButton().click();
		  
		log.info("Car selected sucessfully");
              
    }
    
   
    @And("^Close browserss$")
    public void Close_browsers() throws Throwable {
    	
		Logger log = Logger.getLogger(b_OutstationCarBookTC.class);
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	log.info("Driver is Closed For b_OutstationCarBookTC TestCase");
    
    }
	 
}