package com.webdriver.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private static WaitHelper waitHelper;
    private static WebDriver driver;
    private static WebDriverWait wait;

    private WaitHelper(WebDriver driver){
        WaitHelper.driver = driver;
        WaitHelper.wait = getWait();
    }

    public static WaitHelper getInstance(WebDriver driver){
        if(waitHelper == null || WaitHelper.driver.hashCode() != driver.hashCode())
            waitHelper = new WaitHelper(driver);
        return waitHelper;
    }

    protected WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);

        return wait;
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
