package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePageObject{


    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By buttonLocator = By.className("radius");
    private By message = By.id("flash");

    /*** Method to open the page ***/
    public LoginPage(WebDriver driver, Logger log){
        super(driver, log);
    }
    /*** Execute Login ***/
    public SecureAreaPage LogIn(String username, String password ){
        log.info("Executing LogIn with username [" + usernameLocator + "] and password [" +
                passwordLocator + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(buttonLocator);
        log.info("Page is opened");
        return new SecureAreaPage(driver, log);

    }

    /*** Return text from unsuccessful message ***/

    public String failLogin(){

        return find(message).getText();
    }

}

