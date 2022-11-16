package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPageObject extends BasePageObject {

    protected By checkbox = By.xpath("//input[@type='checkbox']");

    /*** Method to open the page ***/
    public CheckBoxPageObject(WebDriver driver, Logger log) {

        super(driver, log);
    }

    /*** Get list of all checkboxes and check if unchecked ***/
    public void selectAllCheckBoxes() {
        log.info("Checking all unchecked checkboxes");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    /*** Get list of all checkboxes and check if unchecked ***/
    public boolean areAllCheckBoxesChecked() {
        log.info("Verifying that all checkboxes are checked");
        List<WebElement> checkboxes = findAll(checkbox);
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}



