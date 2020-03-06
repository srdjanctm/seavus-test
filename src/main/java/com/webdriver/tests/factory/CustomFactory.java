package com.webdriver.tests.factory;

import com.webdriver.tests.page.*;
import org.openqa.selenium.WebDriver;

public class CustomFactory {
	
	public static PageBase getInstance(PageName name, WebDriver driver) {
		
		switch (name) {
			case PracticeForm:
				return new PracticeForm(driver);
		default:
			throw new RuntimeException("Invalid Page Name");
		}
		
	}

}
