package com.webdriver.tests.page;

import com.github.javafaker.Faker;
import com.webdriver.utils.ResourceUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PracticeForm extends PageBase {

    private WebDriver driver;
    private WebDriverWait wait = getWait();
    private Faker faker = new Faker();

    public PracticeForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='demo-frame']//span/em")
    private WebElement greyPrintingText;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@value='4']")
    private WebElement fourYearsOfExperience;

    @FindBy(id = "datepicker")
    private WebElement datepickerInput;

    @FindBy(id = "profession-0")
    private WebElement manualProfessionCheckBox;

    @FindBy(id = "profession-1")
    private WebElement automationProfessionCheckBox;

    @FindBy(id = "photo")
    private WebElement profilePictureButton;

    @FindBy(id = "continents")
    private WebElement continentDropDown;

    @FindBy(xpath = "//select[@id='continentsmultiple']/option[@value='EU']")
    private WebElement europeOptionMultiselect;

    @FindBy(xpath = "//select[@id='selenium_commands']/option[contains(., 'Navigation Commands')]")
    private WebElement navigationCommandsOption;

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement hOneTitle;

    @FindBy(linkText = "Selenium Automation Hybrid Framework")
    private WebElement frameworkLinkText;

    @FindBy(linkText = "Test File to Download")
    private WebElement testFileLinkText;


    public String getPrintText() {
        return greyPrintingText.getText();
    }

    public void printTextInConsole(String text) {
        System.out.println("\n" + text);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void generateLastName() {
        lastNameInput.sendKeys(faker.name().lastName());
    }

    public void selectSex(String sex) {
        String sexRadioOption = "//input[@value='%s']";
        WebElement sexRadioInput = driver.findElement(By.xpath(String.format(sexRadioOption, sex)));

        waitThenClick(sexRadioInput);
    }

    public void selectFourYearsOfExperience() {
        waitThenClick(fourYearsOfExperience);
    }

    public void setTodayDate() {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        Date today = Calendar.getInstance().getTime();

        String todayAsString = df.format(today);

        datepickerInput.sendKeys(todayAsString);
    }

    public void checkBothProfession() {
        waitThenClick(manualProfessionCheckBox);
        waitThenClick(automationProfessionCheckBox);
    }

    public void uploadPicture(String picture) {
        profilePictureButton.sendKeys(ResourceUtils.getResourcePath(picture));
    }

    public void selectAutomationTool(String automationTool) {
        String automationToolOption = "//input[@value='%s']";
        WebElement automationToolInput = driver.findElement(By.xpath(String.format(automationToolOption, automationTool)));

        waitThenClick(automationToolInput);
    }

    public void selectContinentFromDropDown(String continentFullName) {

        String continentShortName = "";
        switch (continentFullName) {
            case "Asia":
                continentShortName = "AS";
                break;

            case "Europe":
                continentShortName = "EU";
                break;

            case "Africa":
                continentShortName = "AF";
                break;

            case "Australia":
                continentShortName = "AUS";
                break;

        }

        String continentSelector = "//select[@id='continents']/option[@value='%s']";
        WebElement continentOption = driver.findElement(By.xpath(String.format(continentSelector, continentShortName)));

        waitThenClick(continentDropDown);
        waitThenClick(continentOption);
    }

    public void selectEuropeContientInMultipleSelect() {
        waitThenClick(europeOptionMultiselect);
    }

    public void selectNavigationCommandsOption() {
        waitThenClick(navigationCommandsOption);
    }

    public void clickButton(int buttonNumber) {
        String buttonSelector = "//button[contains(., 'Button %s')]";
        WebElement buttonElement = driver.findElement(By.xpath(String.format(buttonSelector, buttonNumber)));

        waitThenClick(buttonElement);
    }

    public void waitForTitle() {
        wait.until(ExpectedConditions.visibilityOf(hOneTitle));
    }

    public String getTitle() {
        return hOneTitle.getText();
    }

    public void downloadFiles() {
        waitThenClick(frameworkLinkText);
        waitThenClick(testFileLinkText);
    }


}