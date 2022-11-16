package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ExceptionMethod{
    private WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public  void setUp(@Optional("chrome") String browser){
        System.out.println("Starting loginTest");
        switch(browser){

            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","C:/bin/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("We did not find a specified browser");
                break;
        }


        /*** Sleep for 3 seconds ***/
        sleep(3000);
        /*** Maximize browser window ***/
        driver.manage().window().maximize();
        /*** Implicit wait ***/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Parameters({"expectedMessage"})
    @Test(groups = {"smokeTests"})
    public void NoVisibleTest(String expectedMessage) {
        /*** Open Test Page ***/

        String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);
        sleep(5000);
        System.out.println("Page is opened");

        /*** Press Start Button ***/
        WebElement start = driver.findElement(By.xpath("//div[@id='start']/button[.='Start']"));

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(start));
        start.click();


        /*** Hello World! Message ***/
        WebElement Hello_World = driver.findElement(By.xpath("//div[@id='finish']/h4[.='Hello World!']"));
        try {
            wait.until(ExpectedConditions.visibilityOf(Hello_World));
        } catch (TimeoutException exception) {
            System.out.println("Exception catched: " + exception.getMessage());
            sleep(3000);
        }
        /*** Verification: Successful Message ***/

        String actualMessage = Hello_World.getText();

        Assert.assertEquals(expectedMessage,actualMessage, "Actual message is not the same as expected");

        tearDown();
    }

    @Parameters({"expectedMessage"})
    @Test(groups = {"smokeTests"})
    public void NoSuchElementTest(String expectedMessage) {
        /*** Open Test Page ***/

        String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
        driver.get(url);
        sleep(5000);
        System.out.println("Page is opened");

        /*** Press Start Button ***/
        WebElement start = driver.findElement(By.xpath("//div[@id='start']/button[.='Start']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(start));
        start.click();


        /*** Hello World! Message ***/
        WebElement Hello_World = driver.findElement(By.xpath("//div[@id='finish']/h4[.='Hello World!']"));

        wait.until(ExpectedConditions.visibilityOf(Hello_World));

        /*** Verification: Successful Message ***/

        String actualMessage = Hello_World.getText();

        Assert.assertEquals(expectedMessage,actualMessage, "Actual message is not the same as expected");

        tearDown();
    }
    @Parameters({"expectedMessage"})
    @Test(groups = {"smokeTests"})
    public void staleElementTest(String expectedMessage) {
        /*** Open Test Page ***/

        String url = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(url);
        sleep(5000);
        System.out.println("Page is opened");

        /*** Press remove Button ***/
        WebElement remove = driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']"));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id='checkbox']"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        remove.click();

        /*** Verification: CkeckBox disappears***/

        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkbox)),
                    "Checkbox is still visible but it shoudn't be" );

        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkbox)),
                "Checkbox is still visible but it shoudn't be" );
        // Both above are asserting the same thing


        WebElement add = driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']"));
        wait.until(ExpectedConditions.elementToBeClickable(add));
        add.click();
        checkbox = driver.findElement(By.xpath("//*[@id='checkbox']"));
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        Assert.assertTrue(checkbox.isDisplayed());
        tearDown();
    }

    @Parameters({"Message"})
    @Test(groups = {"smokeTests"})
    public void disabledElementTest(String Message) {
        /*** Open Test Page ***/

        String url = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(url);
        sleep(5000);
        System.out.println("Page is opened");

        /*** Press enable Button ***/
        WebElement enable = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));


        WebDriverWait wait = new WebDriverWait(driver, 10);

        enable.click();

        /*** Type some text in textbox ***/
        sleep(5000);
        WebElement textbox = driver.findElement(By.xpath("//form[@id='input-example']/input[@type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        textbox.sendKeys(Message);
        wait.until(ExpectedConditions.elementToBeClickable(textbox));


        /*** Verification: CkeckBox disappears***/
        String actualMessage = textbox.getAttribute("value");

        Assert.assertEquals(Message,actualMessage, "Actual message is not the same as expected");

        /*** Press disable Button ***/
        sleep(2000);
        WebElement disable = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));

        wait.until(ExpectedConditions.elementToBeClickable(disable));

        disable.click();
        sleep(3000);
        enable = driver.findElement(By.xpath("//form[@id='input-example']/button[@type='button']"));
        wait.until(ExpectedConditions.elementToBeClickable(enable));
        tearDown();
    }
    private void sleep(long s) {
        try{
            Thread.sleep(s);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        // Close Browser
        driver.quit();
    }
}
