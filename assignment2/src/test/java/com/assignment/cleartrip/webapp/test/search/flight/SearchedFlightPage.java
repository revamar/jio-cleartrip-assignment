package com.assignment.cleartrip.webapp.test.search.flight;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SearchedFlightPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	@FindBy(how=How.XPATH, using="//*[@id='GlobalNav']/div/div[1]/a/span")
	WebElement CLEARTRIPLOGOELEMENT;
	
	@FindBy(how=How.XPATH, using="/html/body/section[3]/div[2]/section[2]/section/div/div[2]/div")
	WebElement STRIPLOADERCONTAINERELEMENT;
	
	@FindBy(how=How.XPATH, using="//*[@id='Result']/div[1]/section[2]/section/div/div[2]/div/div/div/div/div")
	WebElement LOADERSTRIPBARELEMENT;
	
	@FindBy(how=How.XPATH, using="/html/body/section[3]/div[1]/section[2]/section/div/div[2]/div/p")
	WebElement LOOKINGFORFLIGHTELEMENTTEXT;
	
	@FindBy(how=How.ID, using="flightForm")
	WebElement FLIGHTFORMPAGEELEMENT;
	
	@FindBy(how=How.XPATH, using="//*[@id=flightForm']/section[2]/div[3]")
	WebElement FLIGHTLISTAVAILABLEINFORM;
	
	@FindBy(how=How.XPATH, using="//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div/div[1]/form/div/div[4]")
	WebElement STOPSELEMENTBUTTON;
	
	@FindBy(how=How.XPATH, using="//*[@id='1_1_1']")
	WebElement MULTISTOPSELEMENTFORONE;
	
	@FindBy(how=How.XPATH, using="//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div/div[1]/form/div/div[9]")
	WebElement LAYOVERPERIODBUTTON;
			
	@FindBy(how=How.XPATH, using="//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div/div[1]/form/div/div[9]/div/div/a[2]")
	WebElement LAYOVERSLIDERCIRCLE2;
	
	@FindBy(how=How.XPATH, using="//button[@type='button']")
	WebElement SUITABLEFLIGHTBOOKBUTTON;
	
	@FindBy(how=How.XPATH, using="//*[@id='BackToRtSpT']/a/strong[2]")
	WebElement ALLAIRLINESHEADERELEMENT;
	
	@FindBy(how=How.ID, using="Result")
	WebElement RESULTPAGEPARENTELEMENT;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ResultContainer_1_1\"]/section[2]/section/div/div[1]")
	WebElement FLIGHTSDETAILPAGEELEMENT;
	public SearchedFlightPage(WebDriver driver)
	{
		 this.driver=driver;
	}
	
	public SearchedFlightPage LoggingFlightLoadTime()
	{
				long start_time;
				long endtime;
				wait=new WebDriverWait(driver, 60, 1);
				wait.until(ExpectedConditions.visibilityOf(STRIPLOADERCONTAINERELEMENT));
				start_time=System.currentTimeMillis();
//				wait.until(ExpectedConditions.invisibilityOfElementWithText(By.
//						xpath("/html/body/section[3]/div[1]/section[2]/section/div/div[2]/div/p"), "Looking for flights..."));
				wait.until(ExpectedConditions.invisibilityOfElementWithText(By.
						xpath("/html/body/section[3]/div[1]/section[2]/section/div/div[2]/div/p"), "Your search results are ready."));
				endtime=System.currentTimeMillis();
				long total=endtime-start_time;
				Reporter.log("Start Time: "+start_time);
				Reporter.log("End Time: "+endtime);
				Reporter.log("Total Time taken to Load::" + total+"milli-seconds");
				Reporter.log("verifyTheFlightsPageIsVisible()");
				return PageFactory.initElements(driver, SearchedFlightPage.class);
	}
		
		public SearchedFlightPage chooseMultiStopOptionInJorney()
		{
			Reporter.log("chooseMultiStopOptionInJorney()");
			wait.until(ExpectedConditions.visibilityOf(MULTISTOPSELEMENTFORONE));
				if(MULTISTOPSELEMENTFORONE.isDisplayed()==true)
				{
					if(MULTISTOPSELEMENTFORONE.isSelected()==false)
					{
						MULTISTOPSELEMENTFORONE.click();
					}
					
				}
				else {
					STOPSELEMENTBUTTON.click();
					MULTISTOPSELEMENTFORONE.click();
				}
			return PageFactory.initElements(driver, SearchedFlightPage.class);
		}
		
		public SearchedFlightPage moveLayoverTime() {
			act=new Actions(driver);
			if(LAYOVERSLIDERCIRCLE2.isDisplayed()==true)
			{
				
			act.clickAndHold(LAYOVERSLIDERCIRCLE2).moveByOffset(0, 20).build().perform();
			
			}
			else {
				LAYOVERPERIODBUTTON.click();
				act.clickAndHold(LAYOVERSLIDERCIRCLE2).moveByOffset(0, 20).build().perform();
			}
			return PageFactory.initElements(driver, SearchedFlightPage.class);
		}
		
		public SearchedFlightPage clickBookButton() {
			Reporter.log("clickBookButton()");
			wait=new WebDriverWait(driver, 80);
			wait.until(ExpectedConditions.elementToBeClickable(SUITABLEFLIGHTBOOKBUTTON)).click();
			return PageFactory.initElements(driver, SearchedFlightPage.class);
		}
}
