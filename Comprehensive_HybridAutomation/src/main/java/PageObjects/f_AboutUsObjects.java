package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class f_AboutUsObjects {
	
	public WebDriver driver;
	
	By aboutUs = By.xpath("//a[@routerlink='/aboutus']");
	By InnerText = By.xpath("//div[@class='float-left margin-top-20px ng-star-inserted']");
	By CeoName = By.xpath("//div[@class='ceoName']");
	
	
	public f_AboutUsObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement aboutUsClick()
	{
		return driver.findElement(aboutUs);
	}
	public WebElement InnerText()
	{
		return driver.findElement(InnerText);
	}
	public WebElement CEONameDisplay()
	{
		return driver.findElement(CeoName);
	}
	
	
}
