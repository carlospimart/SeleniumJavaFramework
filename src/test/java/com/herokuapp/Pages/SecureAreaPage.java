package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject{

    private String pageUrl = "https://the-internet.herokuapp.com";

    private By logOutButton = By.xpath("//*[@id='content']/div/a/i");

    private By message = By.id("flash-messages");


    public SecureAreaPage(WebDriver driver, Logger log){

        super(driver, log);
    }

    /*** Get URL variable from PageObject ***/
    public String getPageUrl(){
        return pageUrl;
    }

    /*** Get URL variable from PageObject ***/
    public boolean isLogOutButtonVisible() {

        return find(logOutButton).isDisplayed();
    }

    /*** Return text from success message ***/

    public String getSuccessMessageText(){
        return find(message).getText();
    }

}


