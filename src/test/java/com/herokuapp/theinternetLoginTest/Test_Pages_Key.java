package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.KeyPageObject;
import com.herokuapp.Pages.LoginPage;
import com.herokuapp.Pages.SecureAreaPage;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Pages_Key extends TestUtilities {
    private By keylocator = By.xpath("//body");
    private By resultLocator =By.xpath("//*[@id='result']");
    @Test
    public void KeyTest() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on keyPress link ***/

        KeyPageObject key = welcomePage.KeyLink();

        /*** press Keys on locator ***/

        key.pressKey(keylocator, Keys.ENTER);
        sleep(2000);
        /*** get the text from result***/

        String result = key.getResultText(resultLocator);

        /*** Verifying our result message ***/

        Assert.assertTrue(result.equals("You entered: ENTER"),
                "Actual and expected result are different");

        /*** press Keys with actions ***/

        key.pressKeyWithActions(Keys.ARROW_LEFT);
        sleep(2000);

        /*** get the text from result***/

        String result2 = key.getResultText(resultLocator);

        /*** Verifying our result message ***/

        Assert.assertTrue(result2.equals("You entered: LEFT"),
                "Actual and expected result are different");

    }
}