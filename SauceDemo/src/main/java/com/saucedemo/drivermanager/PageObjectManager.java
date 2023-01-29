package com.saucedemo.drivermanager;


import org.openqa.selenium.WebDriver;

import com.saucedemo.pages.HomePage;

public class PageObjectManager {

    private final WebDriver webDriver;
	HomePage sauPage;
       
	 public PageObjectManager(WebDriver webDriver) {
	        this.webDriver = webDriver;
	    }
    
	public HomePage getsaucePage() {
        return (sauPage == null) ? sauPage = new HomePage(webDriver) : sauPage;
    }

    //General If...Else
//    public LoginPage getLoginPage() {
//
//        if (loginPage == null) {
//            loginPage = new LoginPage(webDriver);
//        }
//        return loginPage;
//    }
    

}
