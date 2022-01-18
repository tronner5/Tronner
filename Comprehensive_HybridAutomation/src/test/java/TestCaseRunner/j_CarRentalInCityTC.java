package TestCaseRunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.j_CarRentalInCities;
import Resources.Base;


public class j_CarRentalInCityTC extends Base{                    //Inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();		
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Car_Rental_In_City_TC() throws IOException, InterruptedException
	{
		
		Logger Log = Logger.getLogger(j_CarRentalInCityTC.class);                                  //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
    
		j_CarRentalInCities cr = new j_CarRentalInCities(driver);
		cr.CitySelecation().click();
		Log.info("City Location Option is Selected");
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		System.out.println("The Selected City is :-  "+cr.FromCityText().getText());
		Log.info("City is Selected");
		
		cr.TravelGuideTab().click();
		Log.info("Travel Guide Option is Selected");
		
		System.out.println("Heading is :- "+cr.AboutPuneHeading().getText());
		System.out.println("The Inside Text about the Pune is :-  "+"/n"+cr.PuneTextBox().getText());
	
		
	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}			
}

