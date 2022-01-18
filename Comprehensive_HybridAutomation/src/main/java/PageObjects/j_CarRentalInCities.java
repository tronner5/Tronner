package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class j_CarRentalInCities {
	
	public WebDriver driver;
	
	By city = By.xpath("//a[@href='/pune/car-rental']");
	
	By FromCity = By.xpath("//*[@id=\"headingHolder\"]/span[2]");
	By TravelGuide = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[3]/div[2]/div/div[1]/div[2]");
	By AboutPune = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[3]/div[2]/div/div[3]/div/h2[1]/strong");
	By PuneText = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[3]/div[2]/div/div[3]/div/p[1]");
	
	public j_CarRentalInCities(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement CitySelecation()
	{
		return driver.findElement(city);
	}
	
	
	public WebElement FromCityText()
	{
		return driver.findElement(FromCity);
	}
	
	
	public WebElement TravelGuideTab()
	{
		return driver.findElement(TravelGuide);
	}
	public WebElement AboutPuneHeading()
	{
		return driver.findElement(AboutPune);
	}
	public WebElement PuneTextBox()
	{
		return driver.findElement(PuneText);
	}
	
	
	
}
