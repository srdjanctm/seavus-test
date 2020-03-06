package com.webdriver.generichook;

import org.openqa.selenium.WebDriver;
import com.webdriver.services.DriverServices;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GeneralHook {
	
	private DriverServices services;
	private WebDriver driver;
	
	public GeneralHook(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@Before(order = 1)
	public void setup() {

		String environment = services.getReader().getApplicationUrl();
		if (environment.equals("https://demoqa.com/automation-practice-form/")) {
			driver.get(services.getReader().getApplicationUrl());
		} else {
			System.out.println("Can't read environment type");
		}
		driver.manage().window().maximize();
		System.out.println("Scenario starts");

		System.out.println(" This is normal hook");
	}
	
	@After
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()){
			captureScreenShot(scenario);
			System.out.println("Scenario failed");
		}
		if(driver != null){
	    	driver.quit();
	    }
	}

	private void captureScreenShot(Scenario scenario) {
		String scenarioName = scenario.getName();
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());

		services.getGenericHelper().takeScrenShot("Screenshot", ""+ scenarioName +"("+ timeStamp +").png");
		scenario.embed(services.getGenericHelper().takeScrenShot(), "image/png");
	}

}
