package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends BasePageObject {

    protected By dropdown = By.xpath("//*[@id='dropdown']");


    public DropdownPageObject(WebDriver driver, Logger log) {

        super(driver, log);
    }
    /*** This Method Selects one of the option in dropdown ***/
    public void selectOption(int n){

        log.info("Selecting Option: " + n + " from Dropdown");
        WebElement dropDownElement = find(dropdown);
        Select dropdown = new Select(dropDownElement);

        dropdown.selectByIndex(n);

    }
    /*** This Method returns selected option in dropdown as string ***/
    public String getSelectedOption(){

        WebElement dropDownElement = find(dropdown);
        Select dropdown = new Select(dropDownElement);
        String SelectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(SelectedOption + " is selected in dropdown");
        return SelectedOption;

    }


}
