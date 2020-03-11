package com.assignment.cleartrip.webapp.test.browsers;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeConfig {

	public EdgeConfig(){
		WebDriverManager.edgedriver().setup();
	}
	public EdgeOptions setEdgeBrowserOption()
	{
		
		
		EdgeOptions options=new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.BROWSER_NAME, "Microsoft.WebDriver");
//		options.setCapability(CapabilityType.SUPPORTS_ALERTS, false);
//		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, false);
		return options;
	}
}
