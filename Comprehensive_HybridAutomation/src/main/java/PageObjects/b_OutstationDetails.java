package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class b_OutstationDetails {

	public WebDriver driver;
	By RoundTrip = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/div[2]/label");
	By FromText = By.id("fromCityList");
	By ToText = By.xpath("//input[@placeholder='Start typing city - e.g. Mysore']");
	By ReturnDateCalender = By.xpath("//p-calendar[@formcontrolname='returnDateControl']");
	By ReturnDateSelection = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/div/div/div/div[2]/table/tbody/tr[5]/td[6]/span");
	By PickupTimeBox = By.id("pickUpTime");
	By PickUpTimingSelection = By.xpath("//*[@id=\"pickUpTime\"]/option[23]");
	By DetailSummit = By.xpath("//button[@class='book-button btn']");
    
	By SelectCar = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[1]/span");
    By SummitCarButton = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-select-car/div[2]/div/div/div[3]/div/div[4]/div/button");
	
    By NameFill = By.xpath("//input[@placeholder='Name *']");
	By EmailFill = By.xpath("//input[@placeholder='Email address *']");
	By MobileNumber = By.xpath("//input[@placeholder='Mobile Number *']");
	By WhatsappNoti = By.xpath("//input[@type='checkbox']");
	By ProceedButton = By.xpath("//div[@class='hori-vertical-center']");
	
	By PaymentTab = By.xpath("//input[@placeholder='Coupon Code']");
	By BookingDetails = By.xpath("//div[@class='contentLayer ng-star-inserted']");
	
	public b_OutstationDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement RoundTripCheckBox()
	{
		return driver.findElement(RoundTrip);
	}
	
	public WebElement InputFromLocation()
	{
		return driver.findElement(FromText);
	}
	
	public WebElement InputToLocation()
	{
		return driver.findElement(ToText);
	}
	public WebElement ReturnDateCalender()
	{
		return driver.findElement(ReturnDateCalender);
	}
	public WebElement ReturnDateSelection()
	{
		return driver.findElement(ReturnDateSelection);
	}
	
	public WebElement PickupTimeBox()
	{
		return driver.findElement(PickupTimeBox);
	}
	
	public WebElement PickUpTimingSelection()
	{
		return driver.findElement(PickUpTimingSelection);
	}
	
	public WebElement SelectCarButton()
	{
		return driver.findElement(DetailSummit);
	}
	
	
	
	
	
	public WebElement SelectCar()
	{
		return driver.findElement(SelectCar);
	}
	public WebElement SummitCarButton()
	{
		return driver.findElement(SummitCarButton);
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


