package com.herokuapp.Pages;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;


public class BasePageObject {
    protected WebDriver driver;
    protected Logger log;
    /*** Constructor ***/
    public BasePageObject(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }
    /*** Opening URL ***/
    protected void openUrl(String url){

        driver.get(url);
    }
    /*** find by locator ***/
    protected WebElement find(By locator){
        return driver.findElement(locator);

    }
    /*** find all elements by locator ***/
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);

    }
    /*** click on element with given locator when it's visible ***/
    protected void click(By locator){
        waitForVisibilityOf(locator,5);
        find(locator).click();

    }
    /*** type given text into element with given locator ***/
    protected void type(String text, By locator){
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(text);

    }
    /*** Get URL of current page from browser ***/
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    /*** Get URL of current page from browser ***/
    public String getCurrentPageTitle(){

        return driver.getPageSource();
    }

    /*** Get source of current page ***/
    public String getCurrentPageSource(){

        return driver.getPageSource();
    }

    /*** Method to wait for visibility ***/
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /*** Method to wait for visibility ***/
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attends = 0;
        while (attends < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }

            attends++;
        }

    }
    /*** Method to switch to Alert ***/
    protected Alert switchToAlert(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();

    }


    /*** Switch to frame ***/
    public void SwitchToFrame(By frame){

        driver.switchTo().frame(find(frame));

    }
    /*** press a key ***/
    public void pressKey(By locator, Keys key){
        log.info("You pressed: " + key.name());
        find(locator).sendKeys(key);

    }
    /*** press a key ***/
    public void pressKeyWithActions(Keys key){
        log.info("You pressed: " + key.name() + " Using Actions class");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();

    }
    /*** Method to get results text ***/
    public String getResultText (By resultLocator){
        String result = find(resultLocator).getText();
        log.info("Result: " + result);
        return result;
    }
    /*** Method to Switch to page***/
    protected void switchToNewWindowsWithTitle(String expectedTitle){
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (!windowsIterator.hasNext()){

            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }
        }

    }
    /*** Select a file from browser ***/
    public void SelectFile(String fileName, By ChoseFileFieldLocator){
        log.info("Selecting file: " + fileName);
        String filePath = System.getProperty("user.dir") + "//src//main//resources//" + fileName;
        type(filePath, ChoseFileFieldLocator);
        log.info("File Selected");

    }

    public void scrollToBotton(){

        log.info("Scrolling down from page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
    public void scrollToY_cord(String y){

        log.info("Scrolling down from page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("window.scrollTo(0, "+ y +")");

    }
    /** Drag 'from' element to 'to' element */
    protected void performDragAndDrop(By from, By to) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));
    }

    /*** Method for Hover ***/
    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /*** Method for Slide ***/
    public void SlideBar(By sliderLocator, String value) {
        log.info("Moving Slider to: " + value);
        int steps = (int) (Double.parseDouble(value)/0.5);

        //Performs steps
        pressKey(sliderLocator, Keys.ENTER);
        for (int i=0; i<steps;i++){
            pressKey(sliderLocator, Keys.ARROW_RIGHT);
        }
    }
    /*** Method to read data from a file ***/
    @DataProvider(name = "csvReader")
    public static Iterator<Object[]> csvReader(Method method) {
        List<Object[]> list = new ArrayList<Object[]>();
        String pathname = System.getProperty("user.dir") +
               "//src//main//resources//DataProvider//dataNegativeTestProvider.csv";
        File file = new File(pathname);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null) {
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[] { testData });
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
        } catch (IOException e) {
            throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

        return list.iterator();
    }

    /*** Method to add cookies ***/
    public void setCookie(Cookie ck) {
        log.info("Adding cookie " + ck.getName());
        driver.manage().addCookie(ck);
        log.info("Cookie added");
    }

    /*** Method to get cookie value using cookie name ***/
    public String getCookie(String name) {
        log.info("Getting value of cookie " + name);
        return driver.manage().getCookieNamed(name).getValue();
    }

}
