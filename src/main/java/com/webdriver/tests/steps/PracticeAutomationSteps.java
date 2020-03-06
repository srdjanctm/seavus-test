package com.webdriver.tests.steps;

import com.webdriver.services.DriverServices;
import com.webdriver.tests.page.*;
import com.webdriver.utils.TestSettings;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PracticeAutomationSteps {

    private WebDriver driver;
    private DriverServices services;
    private TestSettings testSettings;

    public PracticeAutomationSteps(DriverServices services, TestSettings testSettings) {
        this.services = services;
        this.driver = services.getDriver();
        this.testSettings = testSettings;
    }

    @Given("^engineer has navigated to practice form$")
    public void engineerHasNavigatedToPracticeForm() {
        testSettings.practiceForm = new PracticeForm(driver);
        Assert.assertEquals(testSettings.practiceForm.getCurrentUrlWithoutWait(), services.getReader().getApplicationUrl());
    }

    @When("^engineer reads and prints message in practice form$")
    public void engineerReadsAndPrintsMessageInPracticeForm() {
        testSettings.practiceForm.printTextInConsole(testSettings.practiceForm.getPrintText());
    }

    @Then("^printed message in console is \"([^\"]*)\"$")
    public void printedMessageInConsoleIs(String message) {
        Assert.assertEquals(testSettings.practiceForm.getPrintText(), message);
    }

    @When("^engineer fills out first name as \"([^\"]*)\" and last name$")
    public void engineerFillsOutFirstNameAsAndLastName(String firstName) {
        testSettings.practiceForm.enterFirstName(firstName);
        testSettings.practiceForm.generateLastName();
    }

    @And("^engineer selects sex as \"([^\"]*)\"$")
    public void engineerSelectsSexAs(String sexOption) {
        testSettings.practiceForm.selectSex(sexOption);
    }

    @And("^engineer selects four years of experience$")
    public void engineerSelectsFourYearsOfExperience() {
        testSettings.practiceForm.selectFourYearsOfExperience();
    }

    @And("^engineer sets today date$")
    public void engineerSetsTodayDate() {
        testSettings.practiceForm.setTodayDate();
    }

    @And("^engineer checks both profession$")
    public void engineerChecksBothProfession() {
        testSettings.practiceForm.checkBothProfession();
    }

    @And("^engineer uploads profile picture \"([^\"]*)\"$")
    public void engineerUploadsProfilePicture(String picture) {
        testSettings.practiceForm.uploadPicture(picture);
    }

    @And("^engineer downloads files$")
    public void engineerDownloadsFiles() {
        testSettings.practiceForm.downloadFiles();
    }

    @And("^engineer checks automation tool \"([^\"]*)\"$")
    public void engineerChecksAutomationTool(String automationTool) {
        testSettings.practiceForm.selectAutomationTool(automationTool);
    }

    @And("^engineer selects continents as \"([^\"]*)\" from drop down$")
    public void engineerSelectsContinentsAsFromDropDown(String continent) {
        testSettings.practiceForm.selectContinentFromDropDown(continent);
    }

    @And("^engineer selects Europe in multiple select$")
    public void engineerSelectsEuropeInMultipleSelect() {
        testSettings.practiceForm.selectEuropeContientInMultipleSelect();
    }

    @And("^engineer selects Navigation Commands$")
    public void engineerSelectsNavigationCommands() {
        testSettings.practiceForm.selectNavigationCommandsOption();
    }

    @And("^engineer clicks on button (\\d+)$")
    public void engineerClicksOnButton(int buttonNumber) {
        testSettings.practiceForm.clickButton(buttonNumber);
    }

    @Then("^page scrolls to top$")
    public void pageScrollsToTop() {
        testSettings.practiceForm.waitForTitle();
    }

    @And("^engineer sees title \"([^\"]*)\"$")
    public void engineerSeesTitle(String titleText) {
        Assert.assertEquals(titleText, testSettings.practiceForm.getTitle());
    }
}
