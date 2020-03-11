package com.assignment.cleartrip.webapp.test.passenger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmailAddressPage {

	WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[@id='username']")
	private WebElement EMAILINPUTBOXELEMENT;
	
	@FindBy(how=How.XPATH, using = "//*[@id='LoginContinueBtn_1']")
	private WebElement EMAILPAGECONTINUEBUTTONELEMENT;
	
		EmailAddressPage(WebDriver driver)
			{
				this.driver=driver;
			}
		
		
		public EmailAddressPage enterEmailId(String email) {
			EMAILINPUTBOXELEMENT.clear();
			EMAILINPUTBOXELEMENT.sendKeys(email);
			return PageFactory.initElements(driver, EmailAddressPage.class);
		}
		
		public EmailAddressPage clickContinueButton()
		{
			EMAILPAGECONTINUEBUTTONELEMENT.click();
			return PageFactory.initElements(driver, EmailAddressPage.class);
		}
}
