package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class a_SignInDetails {

	public WebDriver driver;
	
	By SignInClick = By.xpath("//*[@id=\"sv_header\"]/div/div[3]/div/a[3]/div");
	By Email = By.xpath("//input[@placeholder='Email']");
	By Password = By.xpath("//input[@placeholder='Password']");
	By Login = By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/div[2]/button[1]/div/span");	
	By error = By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/div[3]/div");
			
	public a_SignInDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}


	public WebElement SignInClick()
	{
		return driver.findElement(SignInClick);
	}
	public WebElement EmailDetail()
	{
		return driver.findElement(Email);
	}
	public WebElement PasswordDetail()
	{
		return driver.findElement(Password);
	}
	public WebElement LoginButtonClick()
	{
		return driver.findElement(Login);
	}
	public WebElement ErrorMessagePrint()
	{
		return driver.findElement(error);
	}
	
}
