package com.assignment.cleartrip.webapp.test.browsers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeConfig {
	

	public ChromeConfig() {
		WebDriverManager.chromedriver().setup();
	}
	
	public ChromeOptions setCapabilitiesOfChrome()
	{
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-notifications");
		options.addArguments("start-maximized");
		options.addArguments("--no-sandbox");
		return options;
	}
}
