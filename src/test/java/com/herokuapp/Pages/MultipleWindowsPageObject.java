package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPageObject extends BasePageObject{
    private By clickherelocator = By.linkText("Click Here");
    /*** Constructor ***/
    public MultipleWindowsPageObject(WebDriver driver, Logger log) {

        super(driver, log);
    }
    /*** Click Here Link ***/
    public void openNewWindow(){
        log.info("Clicking 'Click here' link");
        click(clickherelocator);

    }

    /*** Find Page with title "New Window" and switch to it***/
    public NewWindowPage SwitchToNewWindowsPage(){
        log.info("Looking for 'New Window' Page");
        switchToNewWindowsWithTitle("New Window");
        return new NewWindowPage(driver,log);
    }
}
