package TestCaseRunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.h_ContactUs;
import Resources.Base;


public class h_ContactUsTC extends Base{                   //Inheritating all the methods from base class
	
	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();	
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Contact_US_TC() throws IOException, InterruptedException
	{
		
		Logger Log = Logger.getLogger(h_ContactUsTC.class);                   //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
 
		h_ContactUs cs = new h_ContactUs(driver);
		cs.ContactUsClick().click();
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		Log.info("Window is Switched");
		
	    System.out.println(cs.SendUsMailText().getText());
	    System.out.println("This is the mailId for contacting :-  "+cs.mailIDText().getText());
	    Log.info("Mail ID is printed Successfully");
	    
	    System.out.println(cs.CallUsText().getText());
	    System.out.println("This is the Phone Number for contacting  :-  "+cs.NumberText().getText());
	    Log.info("Phone Number is printed Successfully");
	    
	    System.out.println(cs.AdressBar().getText());
	    System.out.println("This is the Address for contacting :-  "+cs.AdressDetailsText().getText());
	    Log.info("Address is printed Successfully");
		
	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		
	
}

