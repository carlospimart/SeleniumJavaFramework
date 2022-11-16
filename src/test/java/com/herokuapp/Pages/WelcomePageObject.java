package com.herokuapp.Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WelcomePageObject extends BasePageObject{


    private String pageUrl = "https://the-internet.herokuapp.com";
    private By longinLinkLocator = By.linkText("Form Authentication");
    private By checkboxLinkLocator = By.linkText("Checkboxes");
    private By DropdownLinkLocator = By.linkText("Dropdown");
    private By AlertLinkLocator = By.linkText("JavaScript Alerts");
    private By MultWindowsLinkLocator = By.linkText("Multiple Windows");
    private By EditLocator = By.linkText("WYSIWYG Editor");

    private By KeyLocator = By.linkText("Key Presses");
    private By FUploadLocator = By.linkText("File Upload");

    private By DragDropLocator = By.linkText("Drag and Drop");

    private By HoverLocator = By.linkText("Hovers");

    private By SlideLocator = By.linkText("Horizontal Slider");


    private By ErrorLocator = By.linkText("JavaScript onload event error");
    /*** Method to open the page ***/
    public WelcomePageObject(WebDriver driver, Logger log){

        super(driver,log);
    }

    /*** Open WelcomePage with it's url ***/
    public void OpenPage(){
        log.info("Opening Page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page is opened");
    }

    /*** Click the link to login page ***/
    public LoginPage ClickAuthenticationLink(){
        log.info("Clicking Form authentication link");
        click(longinLinkLocator);
        log.info("Page is opened");
        return new LoginPage(driver, log);

    }

    /*** Click the link to CheckBox page ***/
    public CheckBoxPageObject ClickCheckBoxLink(){
        log.info("Clicking CheckBox link");
        click(checkboxLinkLocator);
        log.info("Page is opened");
        return new CheckBoxPageObject(driver, log);

    }

    /*** Click the link to Dropdown page ***/
    public DropdownPageObject DropdownBoxLink(){
        log.info("Clicking Dropdown link");
        click(DropdownLinkLocator);
        log.info("Page is opened");
        return new DropdownPageObject(driver, log);

    }

    /*** Click the link to AlertLink page ***/
    public AlertPageObject AlertLink(){
        log.info("Clicking Alert link");
        click(AlertLinkLocator);
        log.info("Page is opened");
        return new AlertPageObject(driver, log);

    }
        /*** Click the link to Multiple Windows page ***/
    public MultipleWindowsPageObject MWindowsLink(){
        log.info("Clicking Multiple Windows link");
        click(MultWindowsLinkLocator);
        log.info("Page is opened");
        return new MultipleWindowsPageObject(driver, log);

    }

    /*** Click the link to Editor page ***/
    public EditorPageObject EditorLink(){
        log.info("Clicking WYSIWYG Editor link");
        click(EditLocator);
        log.info("Page is opened");
        return new EditorPageObject(driver, log);

    }

    /*** Click the link to Key page ***/
    public KeyPageObject KeyLink(){
        log.info("Clicking Key link");
        click(KeyLocator);
        log.info("Page is opened");
        return new KeyPageObject(driver, log);

    }
    /*** Click the link to File Upload page ***/
    public FUploadPageObject FileuploadLink(){
            log.info("Clicking Upload link");
        click(FUploadLocator);
        log.info("Page is opened");
        return new FUploadPageObject(driver, log);

    }

    /*** Click the link to DragDrop page ***/
    public  DragDropPageObject DragDropLink(){
        log.info("Clicking Drag and Drop link");
        click(DragDropLocator);
        log.info("Page is opened");
            return new DragDropPageObject(driver, log);

    }

    /*** Click the link to Hover page ***/
    public  HoverPageObject HoverLink(){
        log.info("Clicking Hover link");
        click(HoverLocator);
        log.info("Page is opened");
        return new HoverPageObject(driver, log);

    }

    /*** Click the link to Hover page ***/
    public  SlidePageObject SlideLink(){
        log.info("Clicking Slide link");
        click(SlideLocator);
        log.info("Page is opened");
        return new SlidePageObject(driver, log);

    }
    /*** Click the link to Hover page ***/
    public JSErrorPageObject ErrorLink(){
        log.info("Clicking Error link");
        click(ErrorLocator);
        log.info("Page is opened");
        return new JSErrorPageObject(driver, log);

    }

}
