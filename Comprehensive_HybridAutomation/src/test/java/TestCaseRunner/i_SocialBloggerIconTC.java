package TestCaseRunner;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.i_SocialBlooger;
import Resources.Base;


public class i_SocialBloggerIconTC extends Base {                                //Inheritating all the methods from base class

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}


	@Test()
	public void Social_Handle_Bloogger_TC() throws IOException, InterruptedException {
		
		Logger Log = Logger.getLogger(i_SocialBloggerIconTC.class);
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		i_SocialBlooger sb = new i_SocialBlooger(driver);
		sb.BloggerIconClick().click();
		Log.info("Blogger Icon is clicked Successfully");
		
		Set <String> ids = driver.getWindowHandles();                 //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		sb.TravelGuideClick().click();
		Log.info("Travel guide is Selected");
		
		System.out.println("The title of the blog is :-  "+sb.pondicherryText().getText());
		
		sb.pondicherryText().click();
		Log.info("Pondicherry Blog is Selected");
		
		System.out.println("Title of the Blog is :-  "+sb.BlogTitleValidate().getText());


	}
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
	}		

}
