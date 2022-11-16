package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.AlertPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Pages_Alert_With_SoftAssert extends TestUtilities {

    SoftAssert softassert = new SoftAssert();

    @Test
    public void AlertAccept() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        AlertPageObject alert = welcomePage.AlertLink();

        sleep(2000);


        /*** Click JS Alert ***/
        alert.openJSalert();
        sleep(2000);
        String alertText = alert.getAlertText();
        alert.AcceptAlert();
        /*** Verifications ***/

        softassert.assertEquals("I am a JS Alert",alertText ,
                "Actual message and expected message are not the same ");
        softassert.assertTrue(alert.getResultText().equals("You successfully clicked an alert"),
                "result message and expected result  message are not the same ");

        softassert.assertAll();

    }

    @Test
    public void AlertDismiss() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        AlertPageObject alert = welcomePage.AlertLink();

        sleep(2000);

        /*** Click JS Confirm ***/
        alert.openJSconfirm();
        sleep(2000);
        String alertText = alert.getAlertText();
        alert.DismissAlert();
        /*** Verifications ***/
        Assert.assertEquals("I am a JS Confirm",alertText ,
                "Actual message and expected message are not the same ");
        Assert.assertTrue(alert.getResultText().equals("You clicked: Cancel"),
                "result message and expected result  message are not the same ");
    }
    @Test
    public void AlertTapping() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        AlertPageObject alert = welcomePage.AlertLink();

        sleep(2000);

        /*** Click JS Prompt ***/
        alert.openJSprompt();
        sleep(2000);
        String alertText = alert.getAlertText();
        alert.typeTextIntoAlert("Valar Morghulis");
        sleep(2000);
        alert.AcceptAlert();

        sleep(2000);
        /*** Verifications ***/
        Assert.assertEquals("I am a JS prompt", alertText ,
                "Actual message and expected message are not the same ");
        Assert.assertTrue(alert.getResultText().equals("You entered: Valar Morghulis"),
                "result message and expected result  message are not the same ");

    }
}
