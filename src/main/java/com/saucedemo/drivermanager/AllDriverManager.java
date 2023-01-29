package com.saucedemo.drivermanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


//import java.awt.desktop.SystemSleepEvent;
import java.util.concurrent.TimeUnit;
import Enums.DriverType;
import Enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllDriverManager {

    public static WebDriver webDriver;

    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public AllDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    private WebDriver createLocalDriver() {
        System.out.println("watch here");
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
               // chromeOptions.addArguments("--headless", "--window-size=1644,868");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
            	WebDriverManager.firefoxdriver().setup();
           	   System.setProperty("webdriver.gecko.driver", "C:\\Users\\Srilatha\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
//            	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Srilatha\\Downloads\\geckodriver.exe");
          	   //WebDriver driver=new FirefoxDriver();                  	   
           	     FirefoxOptions firefoxOptions = new FirefoxOptions();
                // firefoxOptions.addArguments("--headless");
               webDriver = new FirefoxDriver(firefoxOptions);
               webDriver.get("https://www.saucedemo.com/");
              // System.setProperty("webdriver.gecko.driver", "C:\Users\Srilatha\Downloads\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(time, TimeUnit.SECONDS);
        
        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("Remote web driver is not yet implemented");
    }

    private WebDriver createDriver() {
        System.out.println("Check here");
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }
    public WebDriver getDriver() {
        if (webDriver == null)
        	webDriver = createDriver();
        return webDriver;
    }

    public void closeDriver() {

       webDriver.close();
        webDriver.quit();
    }
}
