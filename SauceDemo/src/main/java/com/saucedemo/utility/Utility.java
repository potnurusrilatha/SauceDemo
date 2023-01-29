package com.saucedemo.utility;






import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.saucedemo.drivermanager.AllDriverManager;

public class Utility extends AllDriverManager {
	static WebDriver webDriver;

    //*****************BASIC WEBDRIVER METHODS******************************


    /**
     * This method will click on element
     *
     * @ param by
     */
    public void pmClickOnElement(By by) {
        WebElement loginLink = webDriver.findElement(by);
        loginLink.click();
    }

    public void pmClickOnElement(WebElement element) {
        element.click();
    }
    
    

    /**
     * This method will get text from element
     */
    public String pmGetTextFromElement(By by) {

        return webDriver.findElement(by).getText();
    }

    public String pmGetTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void pmSendTextToElement(By by, String text) {
    	webDriver.findElement(by).sendKeys(text);
    }
    public void pmSendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method will find the element and clear all the data from it
     *
     * @param by
     */
    public void pmFindElementAndClearText(By by) {
        WebElement elementToClear = webDriver.findElement(by);
        elementToClear.clear();
    }
    public void pmFindElementAndClearText(WebElement element) {
        element.clear();
    }

    /**
     * This method will extract the value of a particular attribute from an element
     *
     * @param by
     * @param attribute
     * @return
     */
    public String pmGetAttributeFromElement(By by, String attribute) {
        return webDriver.findElement(by).getAttribute(attribute);
    }
    public String pmGetAttributeFromElement(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }


//*************************** Alert Methods ***************************************//

    /**
     * This method will switch to alert
     */
//    public void pmSwitchToAlert() {
//        driver.switchTo().alert();
//    }

    /**
     * This method will accept alert
     */
//    public void pmAcceptAlert() {
//        driver.switchTo().alert().accept();
//    }
//
//    /**
//     * This method will dismiss alert
//     */
//    public void pmDismissAlert() {
//        driver.switchTo().alert().dismiss();
//    }
//
//    /**
//     * This method will get text from alert
//     */
//    public String pmGetTextFromAlert() {
//        return driver.switchTo().alert().getText();
//    }
//
//    /**
//     * This method will send text to alert
//     */
//    public void pmSendTextToAlert(String text) {
//        driver.switchTo().alert().sendKeys(text);
//    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void pmSelectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = webDriver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void pmSelectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void pmSelectByValueFromDropDown(By by, String value) {
        new Select(webDriver.findElement(by)).selectByValue(value);
    }
    public void pmSelectByValueFromDropDown(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void pmSelectByIndexFromDropDown(By by, int index) {
        new Select(webDriver.findElement(by)).selectByIndex(index);
    }
    public void pmSelectByIndexFromDropDown(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void pmSelectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(webDriver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    public void pmSelectByContainsTextFromDropDown(WebElement webElement, String text)  {
        List<WebElement> allOptions = new Select(webElement).getOptions();
        for (WebElement options : allOptions) {
           pmWaitWithThreadSleep(20);
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * THIS METHOD SELECTS A PARTICULAR MENU FROM THE MENU BAR
     *
     * @param by
     * @param menu
     * @throws InterruptedException
     */

    public void pmSelectMenu(By by, String menu)  {

        List<WebElement> names = webDriver.findElements(by);
        for (WebElement name : names) {

            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }
    public void pmSelectMenu(List<WebElement> element, String menu)  {


        for (WebElement name : element) {

            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }


//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void pmCloseAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
            	webDriver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void pmSwitchToParentWindow(String parentWindowId) {
    	webDriver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean pmSwitchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = webDriver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }

        }
        return false;
    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void pmMouseHoverNoClick(By by) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(by)).build().perform();
    }
    public void pmMouseHoverNoClick(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
    }


    /**
     * This method will hover the mouse over a particular element and click it
     *
     * @param by
     */
    public void pmMouseHoverAndClick(By by) {
        Actions hover = new Actions(webDriver);
        WebElement a = webDriver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }
    public void pmMouseHoverAndClick(WebElement element) {
        Actions hover = new Actions(webDriver);
        hover.moveToElement(element).click().build().perform();
    }

    /**
     * This Method will hover mouse on one element, then on second element
     * and click the second element
     */
    public void pmMouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(webDriver);
        WebElement destination1 = webDriver.findElement(by1);
        WebElement destination2 = webDriver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }
    public void pmMouseHoverOnFirstThenSecondAndClick(WebElement element1, WebElement element2) {
        Actions hover = new Actions(webDriver);
        hover.moveToElement(element1).moveToElement(element2).click().build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location
     *
     * @param by
     */
    public void doRightClick(By by) {
        Actions rightClick = new Actions(webDriver);
        WebElement a = webDriver.findElement(by);
        rightClick.contextClick(a).build().perform();
    }
    public void doRightClick(WebElement element) {
        Actions rightClick = new Actions(webDriver);
        rightClick.contextClick(element).build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse
     *
     * @param source
     * @param target
     */
    public void pmDragAndDrop(By source, By target) {
        Actions builder = new Actions(webDriver);
        WebElement draggable = webDriver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }
    public void pmDragAndDrop(WebElement draggable, WebElement droppable) {
        Actions builder = new Actions(webDriver);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position
     *
     *
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void pmSliderMovement( By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(webDriver);
        WebElement slider = webDriver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }
    public void pmSliderMovement( WebElement slider, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(webDriver);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }

//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement pmWaitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElement(by);
    }



    public String pmWaitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }

    /**
     * This method will wait for an element using Fluent Wait
     *
     * @param by
     * @param time
     * @param pollingTime
     * @return
     */
    public WebElement pmWaitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String pmTakeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/"; // path where screen shot needs to be saved
        TakesScreenshot screenshot = (TakesScreenshot) webDriver; // method to take screenshot
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * ******************VERIFICATION METHODS---ASSERT CLASS**********************
     */


    /******
     * This method verifies elements using locator directly as the second
     * instead of String
     * @param expectedMessage
     * @param by
     * @param displayMessage
     */

    public void pmVerifyElements(String expectedMessage, String displayMessage, By by) {
        Assert.assertEquals( displayMessage, expectedMessage,by);
    }

    public void pmVerifyElements( String displayMessage,String expectedMessage, WebElement element) {
        String actualMessage = pmGetTextFromElement(element);
        Assert.assertEquals( displayMessage,expectedMessage,actualMessage);
    }

    /**
     * This method is getting text from actual Message's WebElement using
     * the Explicit Wait Method. We will then use this as String actualMessage in Verification Method
     * We have used "waitUntilVisibilityOfElementLocated" Explicit Wait Method here
     *
     * @param actualMessage
     * @param timeout
     * @return
     */

    public String pmGetTextFromActualMessageForVerificationUsingWait(By actualMessage, int timeout) {
        String verify = pmWaitUntilVisibilityOfElementLocated(actualMessage, timeout).getText();
        return verify;
    }



    /**********************SORTING METHODS************************
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE LOW TO HIGH
     * @param dropDown
     */

    public void verifyTheSortingOrderOfPriceLowToHighIsCorrect(By beforeFilterElements, By dropDown, By lowToHigh) {
        List<WebElement> beforeFilterWebElementPrice = webDriver.findElements(beforeFilterElements);
        List<Double> beforeFilterDoublePriceList = new ArrayList<>();
        for (WebElement p : beforeFilterWebElementPrice) {
            beforeFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }
        //Select dropDownBox = new Select(driver.findElement(dropDown));
        //dropDownBox.selectByVisibleText("Price Low - High");
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(lowToHigh);

        List<WebElement> afterFilterWebElementPriceList = webDriver.findElements(beforeFilterElements);
        List<Double> afterFilterDoublePriceList = new ArrayList<>();

        for (WebElement p : afterFilterWebElementPriceList) {
            afterFilterDoublePriceList.add(Double.valueOf(p.getText().replace("$", " ")));
        }

        Collections.sort(beforeFilterDoublePriceList);
        Assert.assertEquals("List is not sorted according to price Low to High",afterFilterDoublePriceList,beforeFilterDoublePriceList );
    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF PRICE HIGH TO LOW
     *
     * @throws InterruptedException
     */

    public void verifyIfProductsAreSortedByPriceHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = webDriver.findElements(beforeFilterElements);

        List<Double> originalProductPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            originalProductPriceList.add(Double.valueOf(price.getText().replace("$", "")));
        }

        System.out.println(originalProductPriceList);

        Collections.sort(originalProductPriceList, Collections.reverseOrder());
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(hToLow);
        Thread.sleep(3000);

        List<WebElement> afterSortingList = webDriver.findElements(beforeFilterElements);
        List<Double> afterSortingProductPrice = new ArrayList<>();
        for (WebElement price1 : afterSortingList) {
            afterSortingProductPrice.add(Double.valueOf(price1.getText().replace("$", "")));
        }
        System.out.println(afterSortingProductPrice);
        Assert.assertEquals( "products are not sorted",afterSortingProductPrice,originalProductPriceList );

    }

    /**
     * THIS METHOD SORTS ELEMENTS IN THE ORDER OF STAR RATINGS HIGH TO LOW
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param hToLow
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedAccordingToRatingHighToLow(By beforeFilterElements, By dropDown, By hToLow) throws InterruptedException {
        List<WebElement> originalList = webDriver.findElements(beforeFilterElements);

        List<Integer> originalProductRating = new ArrayList<>();
        for (WebElement rating : originalList) {
            originalProductRating.add(rating.getAttribute("style").indexOf(3, 6));
        }

        Collections.sort(originalProductRating, Collections.reverseOrder());
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(hToLow);
        Thread.sleep(3000);
        List<WebElement> afterSortingList = webDriver.findElements(beforeFilterElements);
        List<Integer> afterSortingProductRating = new ArrayList<>();
        for (WebElement rating1 : afterSortingList) {
            afterSortingProductRating.add(rating1.getAttribute("style").indexOf(2, 6));
        }
        System.out.println(afterSortingProductRating);
        Assert.assertEquals("products are not sorted",afterSortingProductRating,originalProductRating);

    }


    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM A TO Z
     *
     * @param beforeFilterElements
     * @param dropDown
     * @param aToZ
     * @throws InterruptedException
     */
    public void verifyProductsAreSortedAlphabeticallyFromAToZ(By beforeFilterElements, By dropDown, By aToZ) throws InterruptedException {

        List<WebElement> originalList = webDriver.findElements(beforeFilterElements);
        List<String> originalProductRatingList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductRatingList.add(product.getText());
        }
        Collections.sort(originalProductRatingList);
        System.out.println(originalProductRatingList);

        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(aToZ);

        List<WebElement> afterSortingList = webDriver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product : afterSortingList) {
            afterSortingProductName.add(product.getText());
        }
        System.out.println(afterSortingProductName);
        Assert.assertEquals("Products are not sorted",afterSortingProductName,originalProductRatingList );
    }

    /**
     * THIS METHOD VERIFIES IF ELEMENTS ARE SORTED FROM BY TITLES FROM Z TO A
     *
     * @throws InterruptedException
     */

    public void verifyProductsAreSortedFromZtoA(By beforeFilterElements, By dropDown, By zToA) throws InterruptedException {
        List<WebElement> originalList = webDriver.findElements(beforeFilterElements);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());

        System.out.println("Expected Result is : " + originalProductNameList);
        pmMouseHoverNoClick(dropDown);
        pmMouseHoverAndClick(zToA);
        Thread.sleep(3000);


        List<WebElement> afterSortingList = webDriver.findElements(beforeFilterElements);
        List<String> afterSortingProductName = new ArrayList<>();
        for (WebElement product1 : afterSortingList) {
            afterSortingProductName.add(product1.getText());
        }
        System.out.println("actual result is : )" + afterSortingProductName);

        Assert.assertEquals("products are now sorted", afterSortingProductName, originalProductNameList);

    }

    public void pmSwitchToIframe(WebElement element){
    	webDriver.switchTo().frame(element);

    }




    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }



//Thread.sleep method with try and catch

    public void pmWaitWithThreadSleep(int seconds){
        seconds = 10*100;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



