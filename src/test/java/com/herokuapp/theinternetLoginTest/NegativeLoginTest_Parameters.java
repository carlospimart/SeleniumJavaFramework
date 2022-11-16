package com.herokuapp.theinternetLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTest_Parameters {
    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 2, groups = {"negativeTest", "smokeTests"})
    public void login_error_test(String username, String password, String expectedMessage) {

        System.out.println("Starting loginTest with...\nUsername: " + username + "\nPassword: "
                + password);
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


        /*** Sleep for 2 seconds ***/
        sleep(2000);
        /*** Enter Username 1 ***/
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.sendKeys(username);
        /*** Enter Password 1 ***/
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
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
        expectedMessage = expectedMessage+ "\n" +
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

