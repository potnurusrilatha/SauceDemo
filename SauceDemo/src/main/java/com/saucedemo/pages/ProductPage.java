package com.saucedemo.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

//import com.saucedemo.drivermanager.WebDriverManager;
import com.saucedemo.utility.Utility;

public class ProductPage extends Utility {
    //logger defined to print logs
	 private static final Logger log = LogManager.getLogger(CheckOutOverViewPage.class.getName());

	    //logger defined to print logs
	  

	    public ProductPage(WebDriver webDriver) {
	        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
	    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement filterDropdown;

    @CacheLookup
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartButton;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    List<WebElement> products;


    public void selectingFromDropDown(String selection) {
        //pmClickOnElement(filterDropdown);
        log.info("Sorting the products by prices: " + selection);
        pmSelectByContainsTextFromDropDown(filterDropdown, selection);

    }

    public void addingToCart() throws InterruptedException {

       for (int i = 0; i < products.size(); i++) {
            if (i == 0 || i == products.size() - 1) {
                log.info("Adding product to the cart: " + products.get(i).toString());
                Thread.sleep(1000);
                pmClickOnElement(products.get(i));
            }
        }
    }

    public void clickOnCart() {
        log.info("Clicking on the cart button: " + cartButton.toString());
        pmClickOnElement(cartButton);
    }


}


