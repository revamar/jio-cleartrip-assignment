package com.assignment.cleartrip.webapp.test.browsers;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxConfig {

	public FirefoxConfig()
	{
		WebDriverManager.firefoxdriver().setup();
	}

	public FirefoxOptions setOptionsForFirefox()
	{
		FirefoxOptions options=new FirefoxOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addPreference("dom.webnotifications.enabled", false);
		options.addArguments("start-maximized");
		return options;
		
	}
	
}
