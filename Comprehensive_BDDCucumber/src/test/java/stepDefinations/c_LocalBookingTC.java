package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.c_LocalDetails;
import Resources.Base;



@RunWith(Cucumber.class)
public class c_LocalBookingTC extends Base{

	@Given("^Initialize the browser and navigate to site$")
	public void Initialize_the_browser() throws Throwable {
	    
		Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		

		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		 Log.info("Driver Initialized Sucessfully and Url opened Succesfully");

	    
	}
	 
	 @When("^Select the Local box$")
	    public void Select_Local_Box() throws Throwable {
		 
		Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		
		 
		 c_LocalDetails lc = new c_LocalDetails(driver);
		 
			System.out.println("This is the title of the Page =  "+driver.getTitle());   //Title of Current the page
			lc.LocalTabSelection().click();		
			Log.info("Local Cab selected Successfully");
		  
		
	}
	 

	 @Then("^User enters City (.+) and User selects the date$")
	public void User_enters_City_and_select_Date(String arg1) throws Throwable {
		 
			Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");		
	      
		    c_LocalDetails lc = new c_LocalDetails(driver);
		    WebElement FromCity = lc.FromCitySelection();
		    lc.FromCitySelection().sendKeys(arg1);	    
		    Log.info("From City Name is read from excel Sheet");
		    
			Thread.sleep(3000);
			FromCity.sendKeys(Keys.ARROW_DOWN);
			FromCity.sendKeys(Keys.ENTER);
						
			lc.PickUpDate().click();
			lc.DateSelect().click();		
			Log.info("PickUp Date is selected Successfully");
					
	}
	 
	 
	 @Then("^user select the time of travel and summit the details$")
		public void User_TimeOfTravel_Summit() throws Throwable {
		 
			Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");		
	      
		    c_LocalDetails lc = new c_LocalDetails(driver);
			lc.PickUpAt().click();
			lc.PickUpTime().click();		
			Log.info("Pickup Time is Selected Successfully");
			
			lc.SubmitDetails().click();		
			Log.info("Details Summited Sucessfully");
				
		}


    @Then("^Change the hr and km details and Check the car Name$")
    public void CarName_Validate() throws Throwable {
    	
		Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		
 	
    	c_LocalDetails lc = new c_LocalDetails(driver);
		System.out.println("This is the title of Second Page =  "+driver.getTitle());
		lc.HrSelection().click();
		Log.info("Hour per KM Changed");
		
		System.out.println("The Selected Car is  =  "+lc.CarTypeSelection().getText());
		Assert.assertEquals(lc.CarTypeSelection().getText() ,"Toyota Etios");		
		lc.SelectCar().click();
		Log.info("Car is selected Successfully");
          
               
    }
    
    @Then("^Navigate to next page and checks the title$")
    public void Check_Title() throws Throwable {
    	
		Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		
   	
    	c_LocalDetails lc = new c_LocalDetails(driver);
		System.out.println("This is the title of the Third Page  =  "+driver.getTitle());
		
		System.out.println(lc.TitleRead().getText());		 
		Assert.assertEquals(lc.TitleRead().getText() ,"1. Contact & Pickup Details");	
		Log.info("Title is Validated Successfully");
	
              
    }
    
   
    @And("^Close all browsers$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(c_LocalBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		

		driver.quit();
    	Log.info("Driver is Closed For c_LocalBookingTC TestCase");
    	
    }
	 
}