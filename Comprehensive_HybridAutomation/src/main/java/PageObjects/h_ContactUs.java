package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class h_ContactUs {
	
	public WebDriver driver;

	By ContactUs = By.xpath("//a[@routerlink='/contact-us']");
	
	By SendUsMail = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[1]/div[1]");
	By mailID   = By.xpath("//a[@href='info@savaari.com']");
	
	By CallUs = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[2]/div[1]");
	By Number = By.xpath("//a[@href='tel:90 4545 0000\']");
	
	By Adress = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[3]/div[1]");
	By AdressDetails =   By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[3]/div[2]/p");
	
	
	public h_ContactUs(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement ContactUsClick()
	{
		return driver.findElement(ContactUs);
	}
	
	
	
	
	public WebElement SendUsMailText()
	{
		return driver.findElement(SendUsMail);
	}
	public WebElement mailIDText()
	{
		return driver.findElement(mailID);
	}
	
	
	
	
	public WebElement CallUsText()
	{
		return driver.findElement(CallUs);
	}
	public WebElement NumberText()
	{
		return driver.findElement(Number);
	}
	
	
	public WebElement AdressBar()
	{
		return driver.findElement(Adress);
	}
	public WebElement AdressDetailsText()
	{
		return driver.findElement(AdressDetails);
	}
	
}
