package com.assignment.cleartrip.webapp.test.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarDatePicker {

	public static void selectCalendarDate(String monthyear, String Selectday, WebDriver driver) throws InterruptedException 
	{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div/div/div/span[1]"));
					
			for (int i=0; i<elements.size();i++)
			{
				System.out.println(elements.get(i).getText());
				//Selecting the month
				if(elements.get(i).getText().equals(monthyear))
				{				
					//Selecting the date				
					List<WebElement> days = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));
					
					for (WebElement d:days)
					{					
						System.out.println(d.getText());
						if(d.getText().equals(Selectday))
						{
							d.click();
							Thread.sleep(10000);
							return;
						}
					}								
					
				}			
						
			}
			driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/div/a")).click();
			
		}
}
