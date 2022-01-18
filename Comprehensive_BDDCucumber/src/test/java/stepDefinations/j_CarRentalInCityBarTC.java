package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;

import PageObjects.j_CarRentalInCities;
import Resources.Base;



@RunWith(Cucumber.class)
public class j_CarRentalInCityBarTC extends Base{

	@Given("^initialize the chrome Open the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {

		Logger Log = Logger.getLogger(j_CarRentalInCityBarTC.class);                                  //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		 Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
	    
	}

	 @Then("^Click on the city in the bottom car rental bar$")
	    public void Navigate_to_Site() throws Throwable {
		 
			Logger Log = Logger.getLogger(j_CarRentalInCityBarTC.class);                                  //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

		 j_CarRentalInCities cr = new j_CarRentalInCities(driver);
		 cr.CitySelecation().click();
		 Log.info("City Location Option is Selected");
			
	 }
	 
	 
	 @When("^Navigate to next window and check the correct city is selected$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
			Logger Log = Logger.getLogger(j_CarRentalInCityBarTC.class);                                  //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

		 j_CarRentalInCities cr = new j_CarRentalInCities(driver);
		 
			
			Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			System.out.println("The Selected City is :-  "+cr.FromCityText().getText());
			Log.info("City is Selected");
    }
	 

	 @Then("^Click on travel guide and print the pune details in console$")
	public void User_enters_and_and_logs_in() throws Throwable {
		 
			Logger Log = Logger.getLogger(j_CarRentalInCityBarTC.class);                                  //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

	      
		 j_CarRentalInCities cr = new j_CarRentalInCities(driver);

			cr.TravelGuideTab().click();
			Log.info("Travel Guide Option is Selected");
			
			System.out.println("Heading is :- "+cr.AboutPuneHeading().getText());
			System.out.println("The Inside Text about the Pune is :-  "+"/n"+cr.PuneTextBox().getText());
	}
	 
	
   
    @And("^Close all browsers7$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
		PropertyConfigurator.configure("log4j.properties");

    	driver.quit();
    	Log.info("Driver is Closed For j_CarRentalInCityBarTC TestCase");
    	
    	
    }
	 
}