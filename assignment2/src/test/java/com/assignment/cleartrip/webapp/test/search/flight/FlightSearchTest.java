package com.assignment.cleartrip.webapp.test.search.flight;

import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.assignment.cleartrip.webapp.test.base.BrowserTest;
import com.assignment.cleartrip.webapp.test.home.FlightPage;
import com.assignment.cleartrip.webapp.test.home.HomePage;

@Test
public class FlightSearchTest extends BrowserTest {
	
	private HomePage home;
	SearchedFlightPage flightSearchTest;
	FlightPage flightPage;
	 Date date;
//	private FlightSearchPage flight;
	
	@BeforeClass
	public void beforeClassMethod()
	{
		home=PageFactory.initElements(driver, HomePage.class);
		flightSearchTest=PageFactory.initElements(driver, SearchedFlightPage.class);
		flightPage=PageFactory.initElements(driver, FlightPage.class);
	}
	
	@Test
	public void search_flightfromdeltomum() throws InterruptedException
	{
		
		flightPage.clickRoundTripOption()
			 .enterSourceAirportName()
			 .enterDestinationAirportName()
			 .clickDepartureDateInputBox()
			 .selectDateForDeparture("10/April/2020")
			 .clickReturnDateInputBox()
			 .selectDateForReturn("10/April/2020")
			 .selectAduldPassenger()
			 .clickFlightSearchButton()
			 .verifyTheFlightsPageIsVisible()
			 .clickBookButton();
		Thread.sleep(10000);
		
	}

}