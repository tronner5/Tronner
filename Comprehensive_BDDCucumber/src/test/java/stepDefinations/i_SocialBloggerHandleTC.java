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

import PageObjects.i_SocialBlooger;
import Resources.Base;



@RunWith(Cucumber.class)
public class i_SocialBloggerHandleTC extends Base{

	@Given("^initialize the browser and Open the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
		PropertyConfigurator.configure("log4j.properties");

	    
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
			Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
	    
	}

	 @Then("^Click on the Blogger icon$")
	    public void Navigate_to_Site() throws Throwable {
		 
			Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
			PropertyConfigurator.configure("log4j.properties");


		 i_SocialBlooger sb = new i_SocialBlooger(driver);
		 sb.BloggerIconClick().click();
			Log.info("Blogger Icon is clicked Successfully");
			
	 }
	 
	 
	 @When("^Navigate to next window and click on travel guide$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
			Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
			PropertyConfigurator.configure("log4j.properties");

		 i_SocialBlooger sb = new i_SocialBlooger(driver);
		 
		 Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			sb.TravelGuideClick().click();
			Log.info("Travel guide is Selected");
		
	}
	 

	 @Then("^Print the article heading in console$")
	public void User_enters_and_and_logs_in() throws Throwable {
		 
			Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
			PropertyConfigurator.configure("log4j.properties");

	      
		 i_SocialBlooger sb = new i_SocialBlooger(driver);
			System.out.println("The title of the blog is :-  "+sb.pondicherryText().getText());
			
			sb.pondicherryText().click();
			Log.info("Pondicherry Blog is Selected");
			
			System.out.println("Title of the Blog is :-  "+sb.BlogTitleValidate().getText());
}
	 
	
   
    @And("^Close all browsers6$")
    public void Close_browsers() throws Throwable {
    	
		Logger Log = Logger.getLogger(i_SocialBloggerHandleTC.class);
		PropertyConfigurator.configure("log4j.properties");

		driver.quit();
    	Log.info("Driver is Closed For i_SocialBloggerHandleTC TestCase");
    	
    	
    }
	 
}