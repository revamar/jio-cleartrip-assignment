package com.assignment.cleartrip.webapp.test.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage{

	WebDriver driver;
	WebDriverWait wait; 
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, 50);
	}
	
	@FindBy(how = How.XPATH, using ="//*[@id='Home']/section/div/aside[1]/nav/ul[1]/li[1]/a[1]")
	private WebElement flight_menu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Home']/div/aside[1]/nav/ul[1]/li[2]/a[1]")
	private WebElement hotel_button;
	
	public FlightPage clickFlightMenu()
	{
		Reporter.log("clickFlightMenu()");
		wait.until(ExpectedConditions.visibilityOf(flight_menu)).click();
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public HomePage clickHotelMenu()
	{
		Reporter.log("clickHotelMenu()");
		hotel_button.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	

}
