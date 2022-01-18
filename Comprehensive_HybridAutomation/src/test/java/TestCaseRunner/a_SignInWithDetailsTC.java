package TestCaseRunner;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.a_SignInDetails;
import Resources.Base;


public class a_SignInWithDetailsTC extends Base {       //Inheritating all the methods from base class

	
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(dataProvider =  "newdata")
	public void Sign_In_With_Wrong_Details_TC(String Email , String Password ) throws IOException, InterruptedException {
		
		Logger log = Logger.getLogger(a_SignInWithDetailsTC.class);
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(prop.getProperty("url"));      //This Step is put here because we have run testcase twice
		
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
	
	@AfterTest
	public void  teardown()
	{
		driver.quit();
		driver = null;
		
	}
	
	@DataProvider(name = "newdata")
	public static Object[][] getData() {
	    return new Object[][]{    	
	            {"Yaduvanshi@gmail.com" ,   "ZilaGajiyabad"},	          
	            {"tronner@gmail.com"    ,   "Tronner1234"  }      
	    };
	}
}

