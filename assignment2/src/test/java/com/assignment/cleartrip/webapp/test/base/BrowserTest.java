package com.assignment.cleartrip.webapp.test.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.assignment.cleartrip.webapp.test.browsers.ChromeConfig;
import com.assignment.cleartrip.webapp.test.browsers.FirefoxConfig;

public class BrowserTest {

	public static WebDriver driver;
	
	@BeforeSuite(alwaysRun=true)
	public void launch_webdriver()
	{
		
		System.setProperty("browser", "firefox");
		String browser_name=System.getProperty("browser");
		
		switch (browser_name) {
		
		case "chrome":
			ChromeConfig ch=new ChromeConfig();
			driver=new ChromeDriver(ch.setCapabilitiesOfChrome());
			break;
			
		case "firefox":
			FirefoxConfig ff=new FirefoxConfig();
			driver=new FirefoxDriver();
			break;

		default:
			driver=null;
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@BeforeSuite(dependsOnMethods="launch_webdriver", alwaysRun=true)
	public void load_base_url()
	{
		System.setProperty("url", "https://cleartrip.com");
		String base_url=System.getProperty("url");
		driver.navigate().to(base_url);
	}
	
	@Test
	public void verify_load_time()
	{
		Reporter.log(driver.getCurrentUrl());
	}
	
	@AfterSuite
	public void tear_down_webdriver() throws IOException
	{
		if(driver!=null)
		{
			if(driver.getClass().getSimpleName().equalsIgnoreCase("chrome"))
			{
				driver.quit();
				ProcessBuilder builder = new ProcessBuilder("taskkill /F / chrome.exe");
				Process process = builder.start();
				process.destroy();
				if (process.isAlive()) {
				    process.destroyForcibly();
				}
			}
		}
			driver.quit();
	}
}
