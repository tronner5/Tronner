package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;

import PageObjects.a_SignInDetails;
import Resources.Base;



@RunWith(Cucumber.class)
public class a_SignInDetailsTC extends Base{

	@Given("^Initialize the browser with chrome$")
	   public void Initialize_the() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
	    
	}

	 @Given("^Navigate to Site from excel File$")
	    public void Navigate_to_Site() throws Throwable {
		 
			Logger Log = Logger.getLogger(a_SignInDetailsTC.class);
			PropertyConfigurator.configure("log4j.properties");
		   		 
		    FileInputStream fileInput = null;
			File search = new File("ExcelSheet\\TronnerDataReadBDD.xlsx");

			FileInputStream fis = new FileInputStream(search);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			String url = sheet.getRow(1).getCell(0).getStringCellValue();
				
		    driver.get(url);
		    Log.info("Driver is Initialized and Url is Opened");
		    
			
	 }
	 
	 
	 @Given("^Click on SignIn Icon and Sign In popUp Comes$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 
		 a_SignInDetails sd = new a_SignInDetails(driver);		 
		 sd.SignInClick().click();
		 		
	}
	 

	 @When("^User enters wrong (.+) and (.+) and try to Signs in$")
	public void User_enters_Wrong_Details(String email ,String password) throws Throwable {
		 
		 Logger Log = Logger.getLogger(a_SignInDetailsTC.class);
		 PropertyConfigurator.configure("log4j.properties");

		 a_SignInDetails sd = new a_SignInDetails(driver);
			
		 sd.EmailDetail().sendKeys(email);
		 sd.PasswordDetail().sendKeys(password);
		 sd.LoginButtonClick().click();
		 Log.info("Login Details Filled");
			
	}


    @Then("^Verify the error message is printing$")
    public void Verify_Error_msg() throws Throwable {
    	
		Logger Log = Logger.getLogger(a_SignInDetailsTC.class);
		PropertyConfigurator.configure("log4j.properties");
  	
    	a_SignInDetails sd = new a_SignInDetails(driver);
		System.out.println("Did Error Message is visible ? "+sd.ErrorMessagePrint().isDisplayed());
		System.out.println("This is the error message for wrong details = "+sd.ErrorMessagePrint().getText());
		Log.warn(sd.ErrorMessagePrint().getText());
		
              
    }
    
    @And("^Close browsers$")
    public void Close_browsers() throws Throwable {
		Logger Log = Logger.getLogger(a_SignInDetailsTC.class);
		PropertyConfigurator.configure("log4j.properties");

    	driver.quit();
		Log.info("Driver is Closed For a_SignInDetailsTC TestCase");

    }
	 
}