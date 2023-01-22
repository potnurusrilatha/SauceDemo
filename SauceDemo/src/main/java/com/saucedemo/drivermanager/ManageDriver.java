package com.saucedemo.drivermanager;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.saucedemo.propertyreader.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageDriver {
	public static final Logger log = LogManager.getLogger(ManageDriver.class.getName());
    public static com.saucedemo.drivermanager.WebDriverManager driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");

    //Constructor to configure log4j
    public ManageDriver() {
        //PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/properties file/log4j2.properties");
    }


    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            log.info("Launching Chrome Browser");
            driver = new com.saucedemo.drivermanager.WebDriverManager();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            log.info("Launching Firefox Browser");
            driver = new com.saucedemo.drivermanager.WebDriverManager();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            log.info("Launching IE Browser");
            driver = new com.saucedemo.drivermanager.WebDriverManager();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            ((WebDriver) driver).quit();
        }
    }
}



