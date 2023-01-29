package com.saucedemo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.saucedemo.drivermanager.AllDriverManager;
//import com.saucedemo.drivermanager.WebDriverManager;
import com.saucedemo.utility.Utility;

public class CheckOutCompletePage extends AllDriverManager {

    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public CheckOutCompletePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement thankYouMessageLink;

    public void verifyingMessage() {
        log.info("Verifying the message: " + thankYouMessageLink.getText());
        Assert.assertTrue(thankYouMessageLink.getText().equalsIgnoreCase("Thank you for your order"));
    }
}