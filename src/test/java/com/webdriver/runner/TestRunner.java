package com.webdriver.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/main/java/com/webdriver/tests/features/"},
        glue = {"com.webdriver.tests.steps","com.webdriver.generichook"},
        monochrome = true,
        plugin = {"pretty","junit:target/junitReport/junitreport.xml"},
        tags = {"@test"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}