package com.herokuapp.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.lang.ref.PhantomReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private String browser;
    private Logger log;
    public BrowserDriverFactory (String browser, Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;

    }

    public WebDriver CreateDriver(){

        log.info("Create Driver: " + browser);

        switch (browser) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:/bin/msedgedriver.exe");
                driver.set(new EdgeDriver());
                break;
            case "chromeheadless":
                System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "htmlunit":
                driver.set(new HtmlUnitDriver());
                break;
            default:
                System.out.println("We did not find a specified browser");
                break;
        }
        return driver.get();
    }

    public WebDriver createChromeWithProfile(String profile){
        log.info("Starting Chrome with profile: " + profile);
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=scr/main/resources/Profiles/" + profile);
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        driver.set(new ChromeDriver(chromeOptions));
        return driver.get();
    }

    public WebDriver createChromeWithMobileEmulation(String deviceName){
        log.info("Starting driver with: " + deviceName + " Emulation");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);

        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        driver.set(new ChromeDriver(chromeOptions));
        return driver.get();
    }
}
