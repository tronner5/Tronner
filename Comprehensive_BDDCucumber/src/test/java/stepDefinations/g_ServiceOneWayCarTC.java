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

import PageObjects.g_ServiceOneWay;
import Resources.Base;



@RunWith(Cucumber.class)
public class g_ServiceOneWayCarTC extends Base{

	@Given("^Initialize the browser , Open site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(g_ServiceOneWayCarTC.class);
		PropertyConfigurator.configure("log4j.properties");
	    
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
			Log.info("Driver Initialized Sucessfully and Url opened Succesfully");

	    
	}

	 @Then("^Click on One way Cab option under service$")
	    public void Navigate_to_Site() throws Throwable {
		 
			Logger Log = Logger.getLogger(g_ServiceOneWayCarTC.class);
			PropertyConfigurator.configure("log4j.properties");

		   
		 g_ServiceOneWay srv = new g_ServiceOneWay(driver);
			srv.ServiceOneWayClick().click();
			Log.info("Airport Box is selcted");
			
	 }
	 
	 
	 @When("^Navigate to next window and select a journey$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
			Logger Log = Logger.getLogger(g_ServiceOneWayCarTC.class);
			PropertyConfigurator.configure("log4j.properties");

		 g_ServiceOneWay srv = new g_ServiceOneWay(driver);
		 
		  Set <String> ids = driver.getWindowHandles(); //Handling multi windows
		  Iterator<String> it = ids.iterator();
		  it.next();
		  String ChildId = it.next();
		  driver.switchTo().window(ChildId);
		 
		  System.out.println("This is the title of the next Window :-  "+ driver.getTitle());
			
		  srv.AhmedabadCitySelect().click();
		  srv.AhmedabadToVadodara().click();
		  Log.info("The Trip route is Selected");
		  
		
	}
	 

	 @Then("^Navigate to next window and validate the journey selected right$")
	public void User_enters_and_and_logs_in() throws Throwable {
		 
			Logger Log = Logger.getLogger(g_ServiceOneWayCarTC.class);
			PropertyConfigurator.configure("log4j.properties");

	      
		 g_ServiceOneWay srv = new g_ServiceOneWay(driver);

		  Set <String> idss = driver.getWindowHandles(); //Handling multi windows
		  Iterator<String> its = idss.iterator();
		  its.next();
		  its.next();
		  String ChildIds = its.next();
		  driver.switchTo().window(ChildIds);
		  
		  Thread.sleep(3000);
		  
		  System.out.println("This si the title of the #rd Window :-  "+driver.getTitle());
		  Log.info("Window is switched");
		  
		  System.out.println(srv.TitleOfThePage().getText());
		  Assert.assertEquals(srv.TitleOfThePage().getText(), "/\n"+"Ahmedabad To Vadodara Cabs");
		  Log.info("Trip Route Varified Successfully");
	}
	 
	
   
    @And("^Close all browsers4$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(g_ServiceOneWayCarTC.class);
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For g_ServiceOneWayCarTC TestCase");
    	
    }
	 
}