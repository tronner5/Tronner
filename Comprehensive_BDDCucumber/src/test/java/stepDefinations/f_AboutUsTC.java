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

import PageObjects.f_AboutUsObjects;
import Resources.Base;



@RunWith(Cucumber.class)
public class f_AboutUsTC extends Base{
	 
	@Given("^Initialize the browser , navigate to the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(f_AboutUsTC.class);                         //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
	   
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
		 Log.info("Driver Initialized Sucessfully and Url opened Succesfully");

	    
	}
	 
	 @When("^Select the About Us Option$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
			Logger Log = Logger.getLogger(f_AboutUsTC.class);                         //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

		    f_AboutUsObjects Abu = new f_AboutUsObjects(driver);
			Abu.aboutUsClick().click();
			Log.info("About us is selcted");

	}
	 
	  
	 @Then("^Navigate to next page and print all the details$")
		public void User_enters() throws Throwable {

			Logger Log = Logger.getLogger(f_AboutUsTC.class);                         //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");

		 f_AboutUsObjects Abu = new f_AboutUsObjects(driver);
			
		    Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			System.out.println("Printing the Whole text of the page  "+Abu.InnerText().getText());
				
		}
	 
	 @Then("^validate the CEO name$")
		public void User_enterss() throws Throwable {
		 
			Logger Log = Logger.getLogger(f_AboutUsTC.class);                         //Configuration for log4j
			PropertyConfigurator.configure("log4j.properties");
	
		    f_AboutUsObjects Abu = new f_AboutUsObjects(driver);
			
			System.out.println("The CEO of the company is = " +Abu.CEONameDisplay().getText());
			
			Assert.assertEquals(Abu.CEONameDisplay().getText(), "Gaurav Aggarwal");
			Log.info("CEO Name is Varified Successfully");

		}


  
    @And("^Close all browsers3$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(f_AboutUsTC.class);                         //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For f_AboutUsTC TestCase");
    	
    }
	 
}