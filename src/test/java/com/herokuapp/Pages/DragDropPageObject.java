package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragDropPageObject extends BasePageObject{
    private By columnALocator = By.id("column-a");
    private By columnBLocator = By.id("column-b");
    /*** Constructor ***/
    public DragDropPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void dragAtoB(){
        log.info("Dragging A to B and vice versa");
        performDragAndDrop(columnALocator, columnBLocator);
    }

    public String getTextColumn(String letter){
        By locator=  By.id("");
        switch(letter) {
            case "A":
                locator = columnALocator;
                break;
            case "B":
                locator = columnBLocator;
                break;
            default:
                break;
        }
        log.info("Getting text from column");
        String text = find(locator).getText();
        log.info("Column " + letter + " Text: " +  text );

        return text;
    }
}
