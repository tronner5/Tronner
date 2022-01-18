package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class g_ServiceOneWay {
	
	public WebDriver driver;
	
	By ServiceOneWay = By.xpath("//a[@routerlink='/one-way-cabs']");
	
	
	By Ahmedabad  = By.id("tabAhmedabad");
	By AhmToVad  = By.xpath("//a[@href='/ahmedabad/ahmedabad-to-vadodara-one-way-cabs\']");

	By Title = By.xpath("//*[@id=\"headingHolder\"]/span[2]");
	
	public g_ServiceOneWay(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement ServiceOneWayClick()
	{
		return driver.findElement(ServiceOneWay);
	}
	
	
	
	public WebElement AhmedabadCitySelect()
	{
		return driver.findElement(Ahmedabad);
	}
	public WebElement AhmedabadToVadodara()
	{
		return driver.findElement(AhmToVad);
	}
	
	
	
	public WebElement TitleOfThePage()
	{
	    return driver.findElement(Title);
	}
	
	 
	
	
	
}
