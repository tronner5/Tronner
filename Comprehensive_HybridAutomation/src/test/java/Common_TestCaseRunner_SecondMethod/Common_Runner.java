package Common_TestCaseRunner_SecondMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.a_SignInDetails;
import PageObjects.b_OutstationDetails;
import PageObjects.c_LocalDetails;
import PageObjects.d_AirportPickUp;
import PageObjects.e_FeaturedIN;
import PageObjects.f_AboutUsObjects;
import PageObjects.g_ServiceOneWay;
import PageObjects.h_ContactUs;
import PageObjects.i_SocialBlooger;
import PageObjects.j_CarRentalInCities;
import Resources.Base;
import TestCaseRunner.a_SignInWithDetailsTC;
import TestCaseRunner.b_OutstationCarBookingTC;
import TestCaseRunner.c_LocalCarBookingTC;
import TestCaseRunner.d_AirportCarBookingTC;
import TestCaseRunner.e_FeaturedInTestRunTC;
import TestCaseRunner.i_SocialBloggerIconTC;


public class Common_Runner extends Base{      
	
	

	
	@Test(dataProvider =  "newdata" , priority=1)
public void Sign_In_With_Wrong_Details_TC(String Email , String Password ) throws IOException, InterruptedException {
		
		driver = initializeDriver();
		
		Logger log = Logger.getLogger(a_SignInWithDetailsTC.class);
		PropertyConfigurator.configure("log4j.properties");
		driver.get(prop.getProperty("url"));               //This Step is put here because we have run testcase twice
		
		log.info("Url Opened Successfully");
		
		a_SignInDetails sign = new a_SignInDetails(driver);
		sign.SignInClick().click();
		
		log.info("Sign In Popup is Visible");		
		
		 //Taking data from excel file 
	/*	FileInputStream fileInput = null;
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Email = sheet.getRow(2).getCell(0).getStringCellValue();
		String Password = sheet.getRow(2).getCell(1).getStringCellValue();
     */
		
		sign.EmailDetail().sendKeys(Email);
		sign.PasswordDetail().sendKeys(Password);
		sign.LoginButtonClick().click();
		
		log.info("Details filled Successfully");
		
				
		System.out.println("Did Error Message is visible ? "+sign.ErrorMessagePrint().isDisplayed());
		System.out.println("This is the error message for wrong details = "+sign.ErrorMessagePrint().getText());
		log.warn(sign.ErrorMessagePrint().getText());
		
		
		
	}
	
	
	@DataProvider(name = "newdata")
	public static Object[][] getData() {
	    return new Object[][]{
	            {"Yaduvanshi@gmail.com" ,   "ZilaGajiyabad"},
	           {"tronner@gmail.com"    ,   "Tronner1234"  } 
	    };
	}
	
	
	@Test(priority=2)
	public void Out_Station_CarBooking_TC() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));  
		
		Logger log = Logger.getLogger(b_OutstationCarBookingTC.class);
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Url Opened Successfully");
		
		b_OutstationDetails l = new b_OutstationDetails(driver);
		l.RoundTripCheckBox().click();
		
		log.info("RoundTrip Check Box checked");

		
		 //Taking data from excel file 
		FileInputStream fileInput = null;
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String FromCity = sheet.getRow(2).getCell(3).getStringCellValue();
		String ToCity = sheet.getRow(2).getCell(4).getStringCellValue();
		   		
		
		WebElement FromLocation = l.InputFromLocation();
		FromLocation.sendKeys(FromCity);
		
		log.info("From City Data is read from Excel File");
		
		Thread.sleep(2000);
		FromLocation.sendKeys(Keys.ARROW_DOWN);
		FromLocation.sendKeys(Keys.ARROW_DOWN);
		FromLocation.sendKeys(Keys.ENTER);

		WebElement ToLocation = l.InputToLocation();
		ToLocation.sendKeys(ToCity);
		
		log.info("To City Data is read from Excel File");
		
		Thread.sleep(3000);
		ToLocation.sendKeys(Keys.ARROW_DOWN);
		ToLocation.sendKeys(Keys.ARROW_DOWN);
		ToLocation.sendKeys(Keys.ENTER);
		
		
		// l.ReturnDateCalender().click(); 
		// Thread.sleep(3000);
		// l.ReturnDateSelection().click();

		
		 l.PickupTimeBox().click();
		 l.PickUpTimingSelection().click();
		 
		 log.info("PickUp Time is selected");
		 
		 l.SelectCarButton().click();

		 log.info("Car details Summited Successfully");
		 
		  System.out.println("The Selected car is = "+l.SelectCar().getText()); 
		  l.SummitCarButton().click();
		  
		  log.info("Car selected sucessfully");
		  
	}
	
	@Test(priority=3)
	public void Local_Car_Booking_TC() throws IOException, InterruptedException
	{
		driver = initializeDriver();
	
		driver.get(prop.getProperty("url"));  
		Logger Log = Logger.getLogger(c_LocalCarBookingTC.class);       //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");		
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		c_LocalDetails lc = new c_LocalDetails(driver);
		
		System.out.println("This is the title of the Page =  "+driver.getTitle());   //Title of Current the page
		lc.LocalTabSelection().click();		
		Log.info("Local Cab selected Successfully");
		
		
		FileInputStream fileInput = null;                                      //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Fromcity = sheet.getRow(7).getCell(0).getStringCellValue();      //Data Read From Excel Read
		String CarName = sheet.getRow(7).getCell(1).getStringCellValue();
		String Title = sheet.getRow(7).getCell(2).getStringCellValue();
		
		
	    WebElement FromCity = lc.FromCitySelection();
	    lc.FromCitySelection().sendKeys(Fromcity);	    
	    Log.info("From City Name is read from excel Sheet");
	    
		Thread.sleep(3000);
		FromCity.sendKeys(Keys.ARROW_DOWN);
		FromCity.sendKeys(Keys.ENTER);
		
		
		lc.PickUpDate().click();
		lc.DateSelect().click();		
		Log.info("PickUp Date is selected Successfully");
		
		lc.PickUpAt().click();
		lc.PickUpTime().click();		
		Log.info("Pickup Time is Selected Successfully");
		
		lc.SubmitDetails().click();		
		Log.info("Details Summited Sucessfully");

		System.out.println("This is the title of Second Page =  "+driver.getTitle());
		lc.HrSelection().click();
		Log.info("Hour per KM Changed");
		
		System.out.println("The Selected Car is  =  "+lc.CarTypeSelection().getText());
		Assert.assertEquals(lc.CarTypeSelection().getText() ,CarName);		
		lc.SelectCar().click();
		Log.info("Car is selected Successfully");
		
		System.out.println("This is the title of the Third Page  =  "+driver.getTitle());
		
		System.out.println(lc.TitleRead().getText());		 
		Assert.assertEquals(lc.TitleRead().getText() ,Title);	
		Log.info("Title is Validated Successfully");
		
		
	}
	
	@Test(dataProvider = "airportData" , priority=4)
public void Airport_Car_Booking_TC(String Name , String email ,  int number ) throws IOException, InterruptedException {
		
		driver = initializeDriver();
				
		driver.get(prop.getProperty("url"));
		
		Logger Log = Logger.getLogger(d_AirportCarBookingTC.class);                            //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(prop.getProperty("url"));
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		d_AirportPickUp air = new d_AirportPickUp(driver);                            
		air.AirportClickForDetails().click();
		Log.info("Airport Box is selcted");
		

		FileInputStream fileInput = null;                                               //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String Fromcity = sheet.getRow(7).getCell(4).getStringCellValue();              //Data Read From Excel Read
		String pickUpLocation = sheet.getRow(7).getCell(5).getStringCellValue();
		String CarName = sheet.getRow(7).getCell(6).getStringCellValue();
		//String UserName = sheet.getRow(7).getCell(7).getStringCellValue();
		//String Email = sheet.getRow(7).getCell(8).getStringCellValue();
		
		
		air.FromCityDetail().sendKeys(Fromcity);
		Log.info("From City Name is read from excel Sheet");
		
		Thread.sleep(2000);                                              //Wait time for Getting City Suggestion DropDown
		air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
		air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
		air.FromCityDetail().sendKeys(Keys.ENTER);
		
		air.TripTypeSelection().click();
		Thread.sleep(2000);                                              //Wait time for Getting TripType Suggestion DropDown
		air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
		air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
		air.TripTypeSelection().sendKeys(Keys.ENTER);
		
		air.PickUpLocation().sendKeys(pickUpLocation);
		Log.info("PickUp Location is Selected");
		
		Thread.sleep(7000);                                             //Wait time for Getting PickupLocation Suggestion DropDown
		air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
		air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
		air.PickUpLocation().sendKeys(Keys.ENTER);
		
		air.PickupTime().click();
		Log.info("Pickup Time is Selected Successfully");
		
		Thread.sleep(2000);                                           //Wait time for Getting Time DropDown
		air.PickupTime().sendKeys(Keys.ARROW_DOWN);
		air.PickupTime().sendKeys(Keys.ARROW_DOWN);
		air.PickupTime().sendKeys(Keys.ENTER);
		
		air.SummitButton().click();
		Log.info("Details Summited Sucessfully");
		
	    System.out.println("The Selected Car is  =  "+air.SelectedCarName().getText());
	    Assert.assertEquals(air.SelectedCarName().getText(), CarName);
	    air.SelectButton().click();
	    Log.info("Car is selected Successfully");
	    
	  
	    String Number = String.valueOf(number);
	    
	    air.NameDetailsFill().sendKeys(Name);	    
	    air.EmailFillDetails().sendKeys(email);	   
	    air.MobileNumber().sendKeys(Number);
	    Log.info("Login Details Filled");
	    
	    air.WhatsappNotiCheckBox().click();
	    Log.info("Whatsapp CheckBox UnChecked");
	    
	    air.ProceedButton().click();
	    Log.info("Details Summited Successfully");
	    Log.error(Number+"  Wrong Phone number is summited successfully");
	    
	    System.out.println("Did payment tab visible ?  "+air.PaymentTabCheck().isDisplayed());
	    System.out.println("Details of Journey is  "+air.BookingDetailsDisplay().getText());
	  
		
	}
	
	@DataProvider(name = "airportData")
	public static Object[][] getTheData() {
	    return new Object[][]{
	    	
	            {"Tronner"   ,   "tronner@gmail.com"  ,   1224355047 },
	            {"Derick"    ,   "DerickOP@gmail.com" ,   1233444730 } 
	    };
	}
	
	@Test(priority=5)
	public void Featured_In_TC() throws IOException, InterruptedException
	{
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));  
    
		Logger Log = Logger.getLogger(e_FeaturedInTestRunTC.class);                      //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		e_FeaturedIN fea = new e_FeaturedIN(driver);
		fea.IndianExpressionIcon().click();
		Log.info("Indian Express Icon is selcted");
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		 
		FileInputStream fileInput = null;                                     //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);                                          //Data Read From Excel Read
		String PageHeading = sheet.getRow(12).getCell(0).getStringCellValue();
	
		
		
	     System.out.println("This is the title of the next Window =  "+driver.getTitle());	
	     
	     System.out.println("Page Heading is  = "+ fea.PageHeading().getText());
	     Assert.assertEquals(fea.PageHeading().getText(),PageHeading);
	     Log.info("Page Heading varified");
	     
	     fea.PopupClose().click();
	     
	  
			
	    
	}
	
	@Test(priority=6)
	public void About_US_TC() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));  
		
		Logger Log = Logger.getLogger(Base.class);                                 //Configuration for log4j
		PropertyConfigurator.configure("log4j.properties");
		Log.info("Driver Initialized Sucessfully and Url opened Succesfully");
		
		f_AboutUsObjects Abu = new f_AboutUsObjects(driver);
		Abu.aboutUsClick().click();
		Log.info("About us is selcted");
		
		Set <String> ids = driver.getWindowHandles();                             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		
		System.out.println("Printing the Whole text of the page \n"+Abu.InnerText().getText());
		
		FileInputStream fileInput = null;                                          //Configuring the Excel file data read
		File search = new File("ExcelSheet\\TronnerDataRead.xlsx");

		FileInputStream fis = new FileInputStream(search);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);                                    //Data Read From Excel Read
		String CEOName = sheet.getRow(17).getCell(0).getStringCellValue();
		
		System.out.println("The CEO of the company is = " +Abu.CEONameDisplay().getText());
		
		Assert.assertEquals(Abu.CEONameDisplay().getText(), CEOName);
		Log.info("CEO Name is Varified Successfully");

		

		
	}
	
	@Test(priority=7)
	public void Service_One_Way_TC() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));  
		
		Logger Log = Logger.getLogger(Base.class);
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
	
	@Test(priority=8)
	public void Contact_US_TC() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));  
		
		Logger Log = Logger.getLogger(Base.class);                   //Configuration for log4j
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
	
	@Test(priority=9)
	public void Social_Handle_Bloogger_TC() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));  
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
	
	@Test(priority=10)
	public void Car_Rental_In_City_TC() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));  
		
		Logger Log = Logger.getLogger(Base.class);                                  //Configuration for log4j
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
		
}

