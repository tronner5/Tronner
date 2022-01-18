package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class c_LocalDetails {
	
	public WebDriver driver;
	
	By LocalTab = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[1]/div[2]/a/img");
	By FromCity = By.id("fromCityList");
	By PickUp  = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/div/p-calendar[1]/span/input");
	By DateSelection = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-local/div/form/div[2]/div/div/p-calendar[1]/span/div/div/div/div[2]/table/tbody/tr[5]/td[5]/span");
	By PickUpAt  = By.id("pickUpTime");
	By PickUpTime =  By.xpath("//*[@id='pickUpTime']/option[45]");
	By Summit = By.xpath("//button[@class='book-button btn']");
	
	By HrSelection = By.xpath("//button[@class='btn toggleButtonInActive']");
	By CarType = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/span");
	By SelectCar = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[2]/div/div[4]/div/button");
	
	By Title = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-booking/div[2]/app-booking-pickup-detail/div/div[1]");
	
	public c_LocalDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement LocalTabSelection()
	{
		return driver.findElement(LocalTab);
	}
	
	public WebElement FromCitySelection()
	{
		return driver.findElement(FromCity);
	}
	
	public WebElement PickUpDate()
	{
		return driver.findElement(PickUp);
	}
	
	public WebElement DateSelect()
	{
		return driver.findElement(DateSelection);
	}
	
	public WebElement PickUpAt()
	{
		return driver.findElement(PickUpAt);
	}
	
	public WebElement PickUpTime()
	{
		return driver.findElement(PickUpTime);
	}
	public WebElement SubmitDetails()
	{
		return driver.findElement(Summit);
	}
	
	
	
	public WebElement HrSelection()
	{
		return driver.findElement(HrSelection);
	}
	
	public WebElement CarTypeSelection()
	{
		return driver.findElement(CarType);
	}
	
	public WebElement SelectCar()
	{
		return driver.findElement(SelectCar);
	}
	
	
	
	
	
	public WebElement TitleRead()
	{
		return driver.findElement(Title);
	}
	
}
