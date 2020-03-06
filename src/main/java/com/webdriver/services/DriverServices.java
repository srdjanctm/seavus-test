package com.webdriver.services;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.webdriver.helper.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import com.webdriver.browser.BrowserConfiguration;
import com.webdriver.browser.CustomChromeDriver;
import com.webdriver.browser.CustomFirefoxDriver;
import com.webdriver.utils.IReader;
import com.webdriver.utils.ReadConfigProperties;

public class DriverServices implements Closeable {
	
	private WebDriver driver;
	private BrowserConfiguration browserConfiguration;
	
	public BrowserConfiguration getBrowserConfiguration() {
		return browserConfiguration;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CustomChromeDriver getChromeDriver() {
		return chromeDriver;
	}

	public BrowserHelper getBrowserHelper() {
		return browserHelper;
	}

	public WindowHelper getWindowHelper() {
		return windowHelper;
	}

	public AlertHelper getAlertHelper() {
		return alertHelper;
	}

	public WaitHelper getWaitHelper() {return waitHelper; }

	private CustomChromeDriver chromeDriver;
	private BrowserHelper browserHelper;
	private WindowHelper windowHelper;
	private AlertHelper alertHelper;
	private WaitHelper waitHelper;
	private GenericHelper genericHelper;
	public GenericHelper getGenericHelper() {
		return genericHelper;
	}

	private IReader reader;
	
	public IReader getReader() {
		return reader;
	}

	public void launchBrowser(){
		//chromeDriver = new CustomChromeDriver();
		reader = new ReadConfigProperties();
		reader.setBrowserType();
		//driver = chromeDriver.getChromeDriver();
		driver = getBrowserDriver();
		browserHelper = BrowserHelper.getInstance(driver);
		windowHelper = WindowHelper.getInstance(driver);
		alertHelper = AlertHelper.getInstance(driver);
		waitHelper = WaitHelper.getInstance(driver);
		genericHelper = GenericHelper.getInstance(driver);
		driver.manage().timeouts().pageLoadTimeout(reader.getExplicitWait(), TimeUnit.SECONDS); //Page load time out
		browserHelper.maximize();
	}
	
	private WebDriver getBrowserDriver() {

		// Use this code if you want to be able to pass browser parameter in terminal : mvn test -Dbrowser=chrome

//		String browser = System.getProperty("browser.type");
//		System.out.println(" ============== > " + browser);
//		if(browser.isEmpty())
//			browser = "chrome";
//		switch (browser) {
//
//			case BrowserType.CHROME:
//				CustomChromeDriver chromeDriver = new CustomChromeDriver();
//				return chromeDriver.getChromeDriver();
//
//			case BrowserType.FIREFOX:
//				CustomFirefoxDriver firefoxDriver = new CustomFirefoxDriver();
//				return firefoxDriver.getFirefoxDriver();
//
//		}

		switch (reader.getBrowserType()) {

		case BrowserType.CHROME:
			browserConfiguration = new CustomChromeDriver();
			return browserConfiguration.getBrowserDriver();

		case BrowserType.FIREFOX:
			browserConfiguration = new CustomFirefoxDriver();
			return browserConfiguration.getBrowserDriver();

		default:
			throw new RuntimeException("Invalid Browser Type : " + reader.getBrowserType());
		}
	}

	public DriverServices() {
		launchBrowser();
	}

	@Override
	public void close() throws IOException {
		
	}

}
