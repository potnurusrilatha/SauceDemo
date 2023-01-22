package com.saucedemo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.drivermanager.WebDriverManager;
import com.saucedemo.utility.Utility;

public class CheckOutCompletePage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckOutCompletePage.class.getName());

    //to initialise webelements @findby annotations for this page
    public CheckOutCompletePage() {
    	new WebDriverManager();
		WebDriver driver = WebDriverManager.chromedriver();
    	PageFactory.initElements(driver, new CheckOutCompletePage());
    }

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='THANK YOU FOR YOUR ORDER']")
    WebElement thankYouMessageLink;

    public void verifyingMessage() {
        log.info("Verifying the message: " + thankYouMessageLink.getText());
        Assert.assertTrue(thankYouMessageLink.getText().equalsIgnoreCase("Thank you for your order"));
    }
}