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
import org.testng.Assert;

import PageObjects.e_FeaturedIN;
import Resources.Base;



@RunWith(Cucumber.class)
public class e_FeaturedInTC extends Base{
	 e_FeaturedIN fea = new e_FeaturedIN(driver);
	 
	@Given("^Initialize the browser and navigate to savaari site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(e_FeaturedInTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
	   
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		 Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
	    
	}
	 
	 @When("^Select the One option from featured Section$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
		Logger Log = Logger.getLogger(e_FeaturedInTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		 e_FeaturedIN fea = new e_FeaturedIN(driver);
		 fea.IndianExpressionIcon().click();
		 Log.info("Indian Express Icon is selcted");
		 
		    Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
		
	}
	 
	 
	 
	 @Then("^Navigate to next page and print the title and Validate the heading$")
		public void User_enters() throws Throwable {
	
		 Logger Log = Logger.getLogger(e_FeaturedInTC.class);                      //Configuration for log4j
		 PropertyConfigurator.configure("log4j.properties");

		  e_FeaturedIN fea = new e_FeaturedIN(driver);
			
		  System.out.println("This is the title of the next Window =  "+driver.getTitle());   
	
		  System.out.println("Page Heading is  = "+ fea.PageHeading().getText());
		  Assert.assertEquals(fea.PageHeading().getText(),"Rent a car to avoid risk of COVID-19 is what office goers seem to prefer");
		  Log.info("Page Heading varified");
		     
				
		}


  
    @And("^Close all browsers2$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(e_FeaturedInTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For e_FeaturedInTC TestCase");
    	
    }
	 
}