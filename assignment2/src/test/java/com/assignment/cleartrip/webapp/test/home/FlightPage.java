package com.assignment.cleartrip.webapp.test.home;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.util.TimeUtils;

import com.assignment.cleartrip.webapp.test.search.flight.SearchedFlightPage;


public class FlightPage{
	WebDriver driver;
	WebDriverWait wait;
	
	public FlightPage(WebDriver driver) {
//		Reporter.log("FlightPage(WebDriver driver)");
		this.driver=driver;
		wait=new WebDriverWait(driver, 90);
	}
	
	@FindBy(how= How.ID, using="OneWay")
	private WebElement ONEWAYRADIOBUTTON;
	
	
	@FindBy(how=How.ID, using="RoundTrip")
	private WebElement ROUNDTRIPRADIOBUTTON;
	
	@FindBy(how= How.ID, using = "FromTag")
	private  WebElement FLIGHTSOURCEAIRPORT;
	
	@FindBy(how= How.ID, using = "ToTag")
	private WebElement FLIGHTDESTINATIONAIRPORT;
	
	@FindBy(how= How.XPATH, using ="//*[@id='DepartDate']")
	private WebElement DEPARTDATEINPUTBOX;
	
	@FindBy(how=How.XPATH, using="//*[@id='ReturnDate']")
	private WebElement RETURNDATEINPUTBOX;
	
	@FindBys({@FindBy(xpath="//div[@id='ui-datepicker-div']/div/div/div/span[1]")})
	private List<WebElement> CALENDARMONTHSELEMENTS;
	
	@FindBys({@FindBy(xpath="//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a")})
	private List<WebElement> CALENDARDAYSINAMONTH;
	
	@FindBy(how=How.XPATH, using=".//*[@id='ui-datepicker-div']/div[2]/div/a")
	private WebElement CALENDARNEXTMONTH;
	
	@FindBy(how=How.XPATH, using="//*[@id='Adults']")
	private WebElement ADULTPASSENGERDROPDOWN;
	
	@FindBy(how=How.XPATH, using="//*[@id='SearchBtn']")
	private WebElement SEARCHFLIGHTBUTTON;
	
	public FlightPage clickOnewayOption()
	{
		Reporter.log("clickOnewayOption()");
		ONEWAYRADIOBUTTON.click();
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage clickRoundTripOption()
	{
		Reporter.log("clickRoundTripOption()");
		if(ROUNDTRIPRADIOBUTTON.isDisplayed()==true)
		{
			ROUNDTRIPRADIOBUTTON.click();
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(ROUNDTRIPRADIOBUTTON)).click();
		}
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage enterSourceAirportName()
	{
		Reporter.log("enterSourceAirportName()");
		FLIGHTSOURCEAIRPORT.clear();
		FLIGHTSOURCEAIRPORT.sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage enterDestinationAirportName()
	{
		Reporter.log("enterDestinationAirportName");
		FLIGHTDESTINATIONAIRPORT.clear();
		FLIGHTDESTINATIONAIRPORT.sendKeys("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage clickDepartureDateInputBox()
	{
		Reporter.log("clickDepartureDateInputBox()");
		DEPARTDATEINPUTBOX.click();
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage clickReturnDateInputBox()
	{
		Reporter.log("clickReturnDateInputBox()");
		RETURNDATEINPUTBOX.click();
		
		return PageFactory.initElements(driver, FlightPage.class);
	}
	/**
	 * 
	 * @param date, Provide Date format as "String date = "10/October/2018";"
	 * @return
	 * @throws InterruptedException 
	 */
	public FlightPage selectDateForDeparture(String date) throws InterruptedException
	{
		Reporter.log("selectDateForDeparture(String date)");
		String splitter[] = date.split("/");
		String monthyear = splitter[1];
		String Selectday = splitter[0];	
		selectCalendarDate(monthyear, Selectday);
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage selectDateForReturn(String date) throws InterruptedException
	{
		Reporter.log("selectDateForReturn(String date)");
		String splitter[] = date.split("/");
		String monthyear = splitter[1];
		String Selectday = splitter[0];	
		selectCalendarDate(monthyear, Selectday);
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public FlightPage selectAduldPassenger()
	{
		Reporter.log("selectAduldPassenger()");
		Select sel=new Select(ADULTPASSENGERDROPDOWN);
		sel.selectByVisibleText("1");
		return PageFactory.initElements(driver, FlightPage.class);
	}
	
	public SearchedFlightPage clickFlightSearchButton()
	{
		Reporter.log("clickFlightSearchButton()");
		SEARCHFLIGHTBUTTON.click();
		return PageFactory.initElements(driver, SearchedFlightPage.class);
	}
	
	/**
	 * Utility method to select date from calendar
	 * @param monthyear
	 * @param Selectday
	 * @return
	 * @throws InterruptedException
	 */
	public FlightPage selectCalendarDate(String monthyear, String Selectday) throws InterruptedException
	{
		Reporter.log("selectCalendarDate(String monthyear, String Selectday)");
		wait.until(ExpectedConditions.visibilityOfAllElements(CALENDARMONTHSELEMENTS));
		for (int i=0; i<CALENDARMONTHSELEMENTS.size();i++)
		{
			System.out.println(CALENDARMONTHSELEMENTS.get(i).getText());
			if(CALENDARMONTHSELEMENTS.get(i).getText().equals(monthyear))
			{				
				for (WebElement d:CALENDARDAYSINAMONTH)
				{	
					System.out.println(d.getText());
					if(d.getText().equals(Selectday))
					{
						d.click();
						return PageFactory.initElements(driver, FlightPage.class);
					}
				}								
				
			}			
					
		}
		CALENDARNEXTMONTH.click();
		return selectCalendarDate(monthyear, Selectday);
	}
}
