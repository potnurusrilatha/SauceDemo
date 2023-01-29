package com.saucedemo.cucumber.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.saucedemo.drivermanager.FileReaderManager;
import com.saucedemo.utility.ScenarioContext;
import com.saucedemo.utility.TestContext;

public class Hooks {

    TestContext testContext;
    WebDriver webDriver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @org.junit.Before
    public void setUp() {
        webDriver = TestContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @org.junit.After
    public void tearDown(ScenarioContext scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
       testContext.getDriverManager().closeDriver();
    }
}
