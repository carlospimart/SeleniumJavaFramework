package com.herokuapp.base;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners({com.herokuapp.base.TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({"browser", "chromeProfile", "deviceName"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile,
           @Optional String deviceName, ITestContext ctx) {
        System.out.println("Starting loginTest");
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        if(profile != null){
            driver = factory.createChromeWithProfile(profile);
        }else if(deviceName != null){
            driver = factory.createChromeWithMobileEmulation(deviceName);

        }else{
            driver = factory.CreateDriver();
        }


        /*** Maximize browser window ***/
        driver.manage().window().maximize();
        /*** Implicit wait ***/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        log.info("close driver");
        // Close Browser
        driver.quit();
    }

}