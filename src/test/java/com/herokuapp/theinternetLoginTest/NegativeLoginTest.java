package com.herokuapp.theinternetLoginTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test(priority = 2, groups = {"negativeTest", "smokeTests"})
    public void login_error_test() throws InterruptedException {

        System.out.println("Starting loginTest");
        /*** create browser ***/
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*** Sleep for 1 second ***/

        sleep(1000);

        /*** Maximize browser window ***/

        driver.manage().window().maximize();

        /*** Open Test Page ***/

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //FIRST ATTEMPT

        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Enter Username 1 ***/
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("WrongUsername");
        /*** Enter Password 1 ***/
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("BadPassword!");
        /*** Press LogIn Button 1 ***/
        WebElement button_in = driver.findElement(By.className("radius"));
        button_in.click();
        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Verification: URL ***/
        String expectedURL = "https://the-internet.herokuapp.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL, "Actual url page is not the same as expected");

        /*** Unsuccessful Login Message ***/
        WebElement unsuccessMessage = driver.findElement(By.xpath("//*[@id='flash']"));

        /*** Verification: Unsuccessful Message ***/
        String expectedMessage = "Your username is invalid!\n" +
                "×";

        String actualMessage = unsuccessMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message" +
                " does not contain expected message.\nActual Message: " + actualMessage +
                "\nExpected Message: " + expectedMessage);

        /*** Sleep for 2 seconds ***/
        sleep(2000);

        //SECOND ATTEMPT
        /*** Enter Username 2 ***/
        WebElement username2 = driver.findElement(By.id("username"));
        username2.sendKeys("tomsmith");
        /*** Enter Password 2 ***/
        WebElement password2 = driver.findElement(By.id("password"));
        password2.sendKeys("BadPassword2!");
        /*** Press LogIn Button 1 ***/
        WebElement button_in2 = driver.findElement(By.className("radius"));
        button_in2.click();

        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Unsuccessful Login Message ***/
        WebElement unsuccessMessage2 = driver.findElement(By.xpath("//*[@id='flash']"));

        /*** Verification: Unsuccessful Message ***/
        String expectedMessage2 = "Your password is invalid!\n" +
                "×";
        String actualMessage2 = unsuccessMessage2.getText();
        Assert.assertEquals(expectedMessage2,actualMessage2, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage2.contains(expectedMessage2), "Actual message" +
                " does not contain expected message.\nActual Message: " + actualMessage2 +
                "\nExpected Message: " + expectedMessage2);

        /*** Close Browser ***/
        driver.quit();

    }
    @Test(priority = 1 , enabled = true, groups = {"negativeTest"})
    public void login_error_test2() throws InterruptedException {

        System.out.println("Starting loginTest");
        /*** create browser ***/
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*** Sleep for 1 second ***/

        sleep(1000);

        /*** Maximize browser window ***/

        driver.manage().window().maximize();

        /*** Open Test Page ***/

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //FIRST ATTEMPT

        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Enter Username 1 ***/
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("WreckUsername");
        /*** Enter Password 1 ***/
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("WorstPassword!");
        /*** Press LogIn Button 1 ***/
        WebElement button_in = driver.findElement(By.className("radius"));
        button_in.click();
        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Verification: URL ***/
        String expectedURL = "https://the-internet.herokuapp.com/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL, "Actual url page is not the same as expected");

        /*** Unsuccessful Login Message ***/
        WebElement unsuccessMessage = driver.findElement(By.xpath("//*[@id='flash']"));

        /*** Verification: Unsuccessful Message ***/
        String expectedMessage = "Your username is invalid!\n" +
                "×";

        String actualMessage = unsuccessMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message" +
                " does not contain expected message.\nActual Message: " + actualMessage +
                "\nExpected Message: " + expectedMessage);

        /*** Sleep for 2 seconds ***/
        sleep(2000);

        /*** Close Browser ***/
        driver.quit();


    }


    private void sleep(long s) {
        try{
            Thread.sleep(s);
        } catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


