package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPageObject extends BasePageObject{

    protected By JSalert = By.xpath("//*[@id='content']/div/ul/li[1]/button");
    protected By JSconfirm = By.xpath("//*[@id='content']/div/ul/li[2]/button");
    protected By JSprompt = By.xpath("//*[@id='content']/div/ul/li[3]/button");
    protected By resultLocator = By.id("result");

    public AlertPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /*** This Methods is used to open a JS Alert ***/
    public void openJSalert(){

        log.info("Clicking JS Alert");
        click(JSalert);

    }

    /*** This Methods is used to open a JS Confirm ***/
    public void openJSconfirm(){

        log.info("Clicking JS Confirm");
        click(JSconfirm);

    }

    /*** This Methods is used to open a JS Prompt ***/
    public void openJSprompt(){

        log.info("Clicking JS Prompt");
        click(JSprompt);

    }
    /*** Method to accept alerts ***/
    public void AcceptAlert(){
        log.info("Clicking ok");

        switchToAlert().accept();

    }
    /*** Method to dismiss alerts ***/
    public void DismissAlert(){
        log.info("Clicking cancel");

        switchToAlert().dismiss();

    }
    /*** Method to type into alerts ***/
    public void typeTextIntoAlert (String text){
        log.info("Typing some text into alert ");

        switchToAlert().sendKeys(text);


    }
    /*** Method to get results text ***/
    public String getResultText (){
        String result = find(resultLocator).getText();
        log.info("Result: " + result);
        return result;
    }
    /*** Method to get alert text ***/
    public String getAlertText (){
        String AlertText = switchToAlert().getText();
        log.info("Alert Text: " + AlertText);
        return AlertText;
    }
}
