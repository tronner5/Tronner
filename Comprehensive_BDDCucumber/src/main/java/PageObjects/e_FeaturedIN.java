package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class e_FeaturedIN {
	
	public WebDriver driver;
	
	By IndianExp = By.xpath("//img[@src='assets/img/indian-express.jpg']");
	By PageHeading = By.id("content_head");
	
	By Popup = By.xpath("//span[@title='Close']");
	
	
	public e_FeaturedIN(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement IndianExpressionIcon()
	{
		return driver.findElement(IndianExp);
	}
	
	public WebElement PageHeading()
	{
		return driver.findElement(PageHeading);
	}
	
	public WebElement PopupClose()
	{
		return driver.findElement(Popup);
	}
	
	
}
