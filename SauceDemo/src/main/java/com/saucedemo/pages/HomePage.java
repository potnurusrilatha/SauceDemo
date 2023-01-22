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

public class HomePage  extends Utility {

    //logger defined to print logs
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    //to initialise webelements @findby annotations for this page
    public HomePage() {
    	new WebDriverManager();
		WebDriver driver = WebDriverManager.chromedriver();
    	PageFactory.initElements(driver, new HomePage());;
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameLink;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordLink;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    public void enterUsernameAndPassword(String username, String password) {
        pmSendTextToElement(usernameLink, username);
        pmSendTextToElement(passwordLink, password);

        log.info("Entering username and password to login: " + username + " & " + password);
    }

    public void clickOnLogin() throws InterruptedException {
        log.info("Clicking on Login button: " + loginButton.toString());
        pmClickOnElement(loginButton);
        Thread.sleep(500);


    }

}



