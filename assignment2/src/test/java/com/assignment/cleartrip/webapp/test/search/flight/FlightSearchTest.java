package com.assignment.cleartrip.webapp.test.search.flight;

import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.assignment.cleartrip.webapp.test.base.BrowserTest;
import com.assignment.cleartrip.webapp.test.home.FlightPage;
import com.assignment.cleartrip.webapp.test.home.HomePage;

@Test
public class FlightSearchTest extends BrowserTest {
	
	private HomePage home;
	private SearchedFlightPage searchedFlightsPage;
	private FlightPage flightPage;
	 Date date;
	
	@BeforeClass
	public void beforeClassMethod()
	{
		flightPage=PageFactory.initElements(driver, FlightPage.class);
	}
	
	@Test
	public void search_flightfromdeltomum() throws InterruptedException
	{
		
		flightPage.clickRoundTripOption()
			 .enterSourceAirportName()
			 .enterDestinationAirportName()
			 .clickDepartureDateInputBox()
			 .selectDateForDeparture("20/June/2020")
			 .clickReturnDateInputBox()
			 .selectDateForReturn("20/June/2020")
			 .selectAduldPassenger()
			 .clickFlightSearchButton()
			 .LoggingFlightLoadTime();
		
	}

}
