package com.saucedemo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.drivermanager.WebDriverManager;
import com.saucedemo.utility.Utility;

public class CheckOutInformationPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckOutInformationPage.class.getName());

    //to initialise webelements @findby annotations for this page
    public CheckOutInformationPage() {
    	new WebDriverManager();
		WebDriver driver = WebDriverManager.chromedriver();
    	PageFactory.initElements(driver, new CheckOutInformationPage());
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    public void enteringTheDetails(String firstName, String lastName, String zipPostalCode) {
        pmSendTextToElement(firstNameField, firstName);
        log.info("Entering first name: " + firstName);
        pmSendTextToElement(lastNameField, lastName);
        log.info("Entering last name: " + lastName);
        pmSendTextToElement(zipField, zipPostalCode);
        log.info("Entering Zip information: " + zipPostalCode);
    }

    public void clickOnContinue() {
        log.info("Clicking on continue button: " + continueButton.toString());
        pmClickOnElement(continueButton);


    }
}

