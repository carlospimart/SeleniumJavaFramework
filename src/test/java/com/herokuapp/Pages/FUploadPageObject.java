package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FUploadPageObject extends BasePageObject{
    private By UploadFile = By.id("file-submit");
    private By fileUploaded = By.id("uploaded-files");
    /*** Constructor***/
    public FUploadPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void PushChooseButton(){
        log.info("Clicking 'Choose File' ");
        click(UploadFile);
        log.info("Choose a file");
    }

    public String GetPageText(){
        log.info("Reading text from page");
        String Text = getResultText(fileUploaded);
        return Text;
    }
}
