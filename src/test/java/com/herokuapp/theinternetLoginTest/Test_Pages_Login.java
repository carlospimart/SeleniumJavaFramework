package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.LoginPage;
import com.herokuapp.Pages.SecureAreaPage;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Pages_Login extends TestUtilities {

    @Test
    public void loginTest() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        LoginPage loginTest = welcomePage.ClickAuthenticationLink();

        /*** push login button ***/

        SecureAreaPage secureAreaPage = loginTest.LogIn("tomsmith",
                "SuperSecretPassword!");

        /*** Verifications ***/

        /*** New Page URL is expected ***/

        Assert.assertEquals(secureAreaPage.getCurrentUrl(),
                secureAreaPage.getPageUrl() + "/secure", "Actual page is not the same as expected");

        /*** Log Out button is visible ***/

        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
                "LogOut Button  button is not visible");


        /*** Verification: Unsuccessful Message ***/
        String expectedNoSuccessMessage = "You logged into a secure area!";
        String actualNoSuccessMessage = secureAreaPage.getSuccessMessageText();


        Assert.assertTrue(actualNoSuccessMessage.contains(expectedNoSuccessMessage),
                "Actual message" +
                        " does not contain expected message.\nActual Message: " + actualNoSuccessMessage +
                        "\nExpected Message: " + expectedNoSuccessMessage);

    }

    @Test()
    public void login_error_test() {


        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        LoginPage loginTest = welcomePage.ClickAuthenticationLink();


        /*** Sleep for 2 seconds ***/
        sleep(2000);

        /*** push login button ***/

        SecureAreaPage secureAreaPage = loginTest.LogIn("tomsmith",
                "Bad Password");


        /*** Sleep for 2 seconds ***/
        sleep(2000);

        /*** Verifications ***/

        /*** New Page URL is expected ***/

        Assert.assertEquals(secureAreaPage.getCurrentUrl(),
                secureAreaPage.getPageUrl() + "/login",
                "Actual page is not the same as expected");



        /*** Verification: Successful Message ***/
        String expectedSuccessMessage = "Your password is invalid!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();


        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "Actual message" +
                        " does not contain expected message.\nActual Message: " + actualSuccessMessage +
                        "\nExpected Message: " + expectedSuccessMessage);

    }

}
