package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class d_AirportPickUp {

	public WebDriver driver;
	
	By airport = By.xpath("//img[@class='bg-airport']");
	By FromCity = By.id("fromCityList");
	By TripType = By.xpath("//select[@formcontrolname='frmLocalSubTripType']");
	By PickUpLocation = By.id("search_places");
	By PickupTime = By.xpath("//select[@formcontrolname='pickUpTimeControl']");
	By Summit = By.xpath("//button[@type='button']");


	By SelectedCarName  = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[1]/span");
	By SelectButton = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[3]/div/div[4]/div/button");
	
	
	By NameFill = By.xpath("//input[@placeholder='Name *']");
	By EmailFill = By.xpath("//input[@placeholder='Email address *']");
	By MobileNumber = By.xpath("//input[@placeholder='Mobile Number *']");
	By WhatsappNoti = By.xpath("//input[@type='checkbox']");
	By ProceedButton = By.xpath("//div[@class='hori-vertical-center']");
	
	By PaymentTab = By.xpath("//input[@placeholder='Coupon Code']");
	By BookingDetails = By.xpath("//div[@class='contentLayer ng-star-inserted']");
	
	public d_AirportPickUp(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement AirportClickForDetails()
	{
		return driver.findElement(airport);
	}
	public WebElement FromCityDetail()
	{
		return driver.findElement(FromCity);
	}
	public WebElement TripTypeSelection()
	{
		return driver.findElement(TripType);
	}
	public WebElement PickUpLocation()
	{
		return driver.findElement(PickUpLocation);
	}
	public WebElement PickupTime()
	{
		return driver.findElement(PickupTime);
	}
	public WebElement SummitButton()
	{
		return driver.findElement(Summit);
	}
	
	
	
	
	public WebElement SelectedCarName()
	{
		return driver.findElement(SelectedCarName);
	}
	public WebElement SelectButton()
	{
		return driver.findElement(SelectButton);
	}
	
	
	
	public WebElement NameDetailsFill()
	{
		return driver.findElement(NameFill);
	}
	public WebElement EmailFillDetails()
	{
		return driver.findElement(EmailFill);
	}
	public WebElement MobileNumber()
	{
		return driver.findElement(MobileNumber);
	}
	public WebElement WhatsappNotiCheckBox()
	{
		return driver.findElement(WhatsappNoti);
	}
	public WebElement ProceedButton()
	{
		return driver.findElement(ProceedButton);
	}
	
	
	
	public WebElement PaymentTabCheck()
	{
		return driver.findElement(PaymentTab);
	}
	public WebElement BookingDetailsDisplay()
	{
		return driver.findElement(BookingDetails);
	}
	
}
