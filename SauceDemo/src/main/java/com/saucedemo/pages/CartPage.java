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

public class CartPage extends Utility {
    private static final Logger log = LogManager.getLogger(CartPage.class.getName());

    //to initialise elements find by annotations for this page
    public CartPage() {
    	new WebDriverManager();
		WebDriver driver = WebDriverManager.chromedriver();
    	PageFactory.initElements(driver, new CartPage());
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;

    public void clickOnCheckOut() {
        log.info("Clicking on the check-out button: " + checkOutButton.getText());
        pmClickOnElement(checkOutButton);
    }
}



