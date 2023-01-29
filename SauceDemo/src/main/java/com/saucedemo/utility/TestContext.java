package com.saucedemo.utility;

import com.saucedemo.drivermanager.AllDriverManager;
import com.saucedemo.drivermanager.PageObjectManager;

public class TestContext {

    private  static AllDriverManager driverManager;
    public PageObjectManager pageObjectManager;
//    public ScenarioContext scenarioContext;

    public TestContext() {
        driverManager = new AllDriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
//        scenarioContext = new ScenarioContext();
    }

    public static AllDriverManager getDriverManager() {
        return driverManager;
    }

    public  PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

//    public ScenarioContext getScenarioContext() {
//        return scenarioContext;
    }

