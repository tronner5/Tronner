package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class i_SocialBlooger {
	
	public WebDriver driver;
	
	By BloggerIcon = By.className("bg-blog");
	
	By TravelGuide = By.id("menu-item-10093");
	
	By pondicherry = By.xpath("//a[@href='https://blog.savaari.com/pondicherry-travel-guide/']");
	
	By BlogTitle = By.className("entry-title");
	
	public i_SocialBlooger(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	
	public WebElement BloggerIconClick()
	{
		return driver.findElement(BloggerIcon);
	}
	
	
	public WebElement TravelGuideClick()
	{
		return driver.findElement(TravelGuide);
	}
	
	
	public WebElement pondicherryText()
	{
		return driver.findElement(pondicherry);
	}
	
	public WebElement BlogTitleValidate()
	{
		return driver.findElement(BlogTitle);
	}
	
	
}
