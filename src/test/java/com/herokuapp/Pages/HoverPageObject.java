package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverPageObject extends BasePageObject{

    private By avatarLocators = By.xpath("//div[@class='figure']");
    private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");
    /*** Constructor ***/
    public HoverPageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /*** Constructor ***/
    public void openUserProfile(int i) {
        List<WebElement> avatars = findAll(avatarLocators);
        WebElement specifiedAvatar = avatars.get(i-1);
        log.info("Hover information: "+specifiedAvatar);
        hoverOverElement(specifiedAvatar);
        specifiedAvatar.findElement(viewProfileLinkLocator).click();
}
}
