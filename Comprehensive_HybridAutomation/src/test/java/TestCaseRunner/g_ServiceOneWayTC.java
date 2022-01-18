package TestCaseRunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.g_ServiceOneWay;
import Resources.Base;


public class g_ServiceOneWayTC extends Base {             //Inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void Service_One_Way_TC() throws IOException, InterruptedException {
		
		Logger Log = Logger.getLogger(g_ServiceOneWayTC.class);
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		g_ServiceOneWay srv = new g_ServiceOneWay(driver);
		srv.ServiceOneWayClick().click();
		Log.info("Airport Box is selcted");
			
		  Set <String> ids = driver.getWindowHandles();              //Handling multi windows
		  Iterator<String> it = ids.iterator();
		  it.next();
		  String ChildId = it.next();
		  driver.switchTo().window(ChildId);
		 
		  System.out.println("This is the title of the next Window :-  "+ driver.getTitle());
		
		  srv.AhmedabadCitySelect().click();
		  srv.AhmedabadToVadodara().click();
		  Log.info("The Trip route is Selected");
	  
		  Set <String> idss = driver.getWindowHandles();             //Handling multi windows
		  Iterator<String> its = idss.iterator();
		  its.next();
		  its.next();
		  String ChildIds = its.next();
		  driver.switchTo().window(ChildIds);
		  
		  Thread.sleep(3000);                                    //Putting some wait for loading the Windows
		  
		  System.out.println("This si the title of the #rd Window :-  "+driver.getTitle());
		  Log.info("Window is switched");
		  
		  System.out.println(srv.TitleOfThePage().getText());
		  Assert.assertEquals(srv.TitleOfThePage().getText(), "/\n"+"Ahmedabad To Vadodara Cabs");  
		  Log.info("Trip Route Varified Successfully");
		
	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
		
	}

}
