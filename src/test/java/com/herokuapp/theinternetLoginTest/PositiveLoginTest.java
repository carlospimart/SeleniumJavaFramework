package com.herokuapp.theinternetLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest {
    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Starting loginTest");
        /*** create browser ***/
        System.setProperty("webdriver.chrome.driver","C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*** Sleep for 3 seconds ***/

        sleep(3000);

        /*** Maximize browser window ***/

        driver.manage().window().maximize();

        /*** Open Test Page ***/

        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        /*** Sleep for 3 seconds ***/
        sleep(3000);
        /*** Enter Username ***/
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        /*** Enter Password ***/
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        /*** Press LogIn Button ***/
        WebElement button_in = driver.findElement(By.className("radius"));
        button_in.click();

        /*** Verification: URL ***/
        String expectedURL = "https://the-internet.herokuapp.com/secure";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL, "Actual url page is not the same as expected");

        /*** Press LogOut Button ***/
        WebElement button_out = driver.findElement(By.xpath("//*[@id='content']/div/a/i"));
        /*** Verification button ***/
        Assert.assertTrue(button_out.isDisplayed(), "Log Out button is not visible");
        button_out.click();
        /*** Successful Login Message ***/
        WebElement SuccessMessage = driver.findElement(By.xpath("//*[@id='flash']"));

        /*** Verification: Successful Message ***/
        String expectedMessage = "You logged out of the secure area!\n" +
                "×";
        String actualMessage = SuccessMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message" +
                " does not contain expected message.\nActual Message: " + actualMessage +
                "\nExpected Message: " + expectedMessage);

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