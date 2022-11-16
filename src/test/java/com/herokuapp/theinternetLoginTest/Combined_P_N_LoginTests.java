package com.herokuapp.theinternetLoginTest;

        import com.herokuapp.base.TestUtilities;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;
        import org.testng.annotations.*;

// This test automation is based on base package, what is used to ease the process of reading,
// and make cleaner our code.

public class Combined_P_N_LoginTests extends TestUtilities {


    @Test(groups = {"positiveTest"})
    public void loginTest() throws InterruptedException {


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

        WebDriverWait wait = new WebDriverWait(driver, 10);

        /*** Press LogIn Button ***/
        WebElement button_in = driver.findElement(By.className("radius"));
        wait.until(ExpectedConditions.elementToBeClickable(button_in));
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

        tearDown();

    }

        @Parameters({"username", "password", "expectedMessage"})
        @Test(priority = 2, groups = {"negativeTest", "smokeTests"})
        public void login_error_test(String username, String password, String expectedMessage) {


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

            tearDown();

        }


}
