package com.assignment.cleartrip.webapp.test.passenger;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IteneryDetailPage {
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(how=How.ID, using = "itineraryBtn")
	WebElement CONTINUEBOOKINGELEMENT;
	
	IteneryDetailPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public EmailAddressPage clickContinueBookingWIthDefault()
	{
		new WebDriverWait(driver, 90).pollingEvery(Duration.ofMillis(1)).until(ExpectedConditions.elementToBeClickable(CONTINUEBOOKINGELEMENT)).click();
		return PageFactory.initElements(driver, EmailAddressPage.class);
	}
	
}

