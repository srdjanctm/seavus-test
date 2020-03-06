package com.webdriver.tests.page;

import java.util.concurrent.TimeUnit;

import com.webdriver.helper.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class PageBase {
	
	private WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	protected WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);

		return wait;
	}

	public String getCurrentUrlWithoutWait() { return driver.getCurrentUrl(); }

	public void waitThenClick(WebElement element) {
		WaitHelper.getInstance(driver).waitForElementToBeClickable(element);
		element.click();
	}

	public void scrollToElement(WebElement element) {
		WebDriverWait wait = getWait();

		wait.until(ExpectedConditions.visibilityOf(element));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
}
