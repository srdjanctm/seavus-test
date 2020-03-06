package com.webdriver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.remote.BrowserType;

public class ReadConfigProperties implements IReader {
	
	// ReadConfigFromExcel implement IReader
	
	private Properties properties;
	
	
	private void initPropertiesFile(String fileName) {
		if(isDefaultPropertiesFile(fileName)){
			properties = getDataFromProperties("config.properties");
		}else{
			properties = getDataFromProperties(fileName);
		}
	}
	
	public ReadConfigProperties(String fileName){
		initPropertiesFile(fileName);
	}
	
	public ReadConfigProperties() {
		initPropertiesFile("");
	}

	private Properties getDataFromProperties(String fileName) {
		String path = ResourceUtils.getResourcePath(fileName);
		Properties prop = new Properties();
		
		try {
			InputStream stream = new FileInputStream(new File(path));
			prop.load(stream);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return prop;
	}

	private boolean isDefaultPropertiesFile(String fileName) {
		if("".equalsIgnoreCase(fileName))
			return true;
		return false;
	}

	@Override
	public String getApplicationUrl() {
		return properties.getProperty("ApplicationUrl");
	}
	
	@Override
	public int getExplicitWait() {
		return Integer.parseInt(properties.getProperty("ExplicitWait"));
	}

	@Override
	public String getBrowserType() {
		return properties.getProperty("BrowserName");
	}

	@Override
	public String getJasonStathamLounge() { return properties.getProperty("jasonStathamLounge"); }

	@Override
	public String getTomHanksLounge() { return properties.getProperty("tomHanksLounge"); }

	@Override
	public String getTeslaCompany() { return properties.getProperty("teslaCompany"); }

	@Override
	public String getRenaultCompany() { return properties.getProperty("renaultCompany"); }

	@Override
	public String getHondaCompany() { return properties.getProperty("hondaCompany"); }

	@Override
	public String getPostmanLimitedCompany() { return properties.getProperty("postmanLimitedCompany"); }

	@Override
	public String getDealFL93431() { return properties.getProperty("dealFL93431"); }

	@Override
	public void setBrowserType() {
		String browserName = properties.getProperty("BrowserName");
		
		if(null == browserName || browserName.isEmpty())
			browserName = "chrome";
		
		properties.setProperty("BrowserName", browserName);
		
	}


}
