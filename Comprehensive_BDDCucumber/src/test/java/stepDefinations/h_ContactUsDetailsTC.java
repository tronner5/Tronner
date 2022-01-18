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

import PageObjects.h_ContactUs;
import Resources.Base;



@RunWith(Cucumber.class)
public class h_ContactUsDetailsTC extends Base{

	@Given("^Initialize the browser , Open the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(h_ContactUsDetailsTC.class);                   //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
	    
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
	    
	}

	 @Then("^Click Contact us under GET IN TOUCH$")
	    public void Navigate_to_Site() throws Throwable {
	  
		 h_ContactUs cs = new h_ContactUs(driver);
		 cs.ContactUsClick().click();
			
	 }
	 
	 
	 @When("^Navigate to next window and get the mail id$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
		 Logger Log = Logger.getLogger(h_ContactUsDetailsTC.class);                   //Configuration for log4j
		 PropertyConfigurator.configure("log4j.properties");

		 h_ContactUs cs = new h_ContactUs(driver);
		 
			Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			Log.info("Window is Switched");
			
		    System.out.println(cs.SendUsMailText().getText());
		    System.out.println("This is the mailId for contacting :-  "+cs.mailIDText().getText());
		    Log.info("Mail ID is printed Successfully");
		
	}
	 

	 @Then("^Print the Phone number and full address$")
	public void User_enters_and_and_logs_in() throws Throwable {
		 
		Logger Log = Logger.getLogger(h_ContactUsDetailsTC.class);                   //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
	      
		  h_ContactUs cs = new h_ContactUs(driver);

		   System.out.println(cs.CallUsText().getText());
		   System.out.println("This is the Phone Number for contacting  :-  "+cs.NumberText().getText());
		   Log.info("Phone Number is printed Successfully");
		    
		   System.out.println(cs.AdressBar().getText());
		   System.out.println("This is the Address for contacting :-  "+cs.AdressDetailsText().getText());
		   Log.info("Address is printed Successfully");
	}
	 
	
   
    @And("^Close all browsers5$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(h_ContactUsDetailsTC.class);                   //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For h_ContactUsDetailsTC TestCase");
    	
    	
    }
	 
}