package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.LoginPage;
import com.herokuapp.Pages.SecureAreaPage;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLoginTest_Reduced extends TestUtilities {
    @Test
    public void loginTest() throws InterruptedException {
    /*** Open The main page ***/

    WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
    sleep(1000);
    welcomePage.OpenPage();

    takeScreenshot("WelcomePageObject opened");



    /*** Click on form Authentication link ***/

    LoginPage loginTest = welcomePage.ClickAuthenticationLink();

    takeScreenshot("LoginPage opened");

        /*** Adding a new cookie***/

        Cookie ck = new Cookie("username", "tomsmith",
                "the-internet.herokuapp.com", "/", null);

        loginTest.setCookie(ck);

    /*** push login button ***/

    SecureAreaPage secureAreaPage = loginTest.LogIn("tomsmith",
            "SuperSecretPassword!");

    takeScreenshot("SecureAreaPage opened");

    /*** getting cookie ***/

    String username_cookie = secureAreaPage.getCookie("username");

    log.info("username Cookie value: " + username_cookie);

    String session = secureAreaPage.getCookie("rack.session");

    log.info("Session Cookie: " + session);

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
}
