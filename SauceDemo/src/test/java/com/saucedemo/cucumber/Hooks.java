package com.saucedemo.cucumber;

import java.io.IOException;

import com.cucumber.listener.Reporter;
import com.saucedemo.propertyreader.PropertyReader;
import com.saucedemo.utility.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Utility {

    //This will run before every scenario
    @Before
    public void setUp() {

        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("Chetan Patel");
    }

    //This will run after every scenario
    @After
    public void tearDown(Scenario scenario) {

        //Using isfailed() method from Scenario interface for taking screenshot if scenario fails
        if (scenario.isFailed()) {
            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            try {
                //add screenshot to the report
                Reporter.addScreenCaptureFromPath(screenShotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}


