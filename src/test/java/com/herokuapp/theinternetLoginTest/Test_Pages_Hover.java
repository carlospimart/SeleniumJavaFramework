package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.HoverPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Pages_Hover extends TestUtilities {
    protected By result = By.xpath("/html//h1[.='Not Found']");

    @Test
    public void Hover() throws InterruptedException {
        /*** Open The main page ***/
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        sleep(2000);

        /*** Click on Hover link ***/
        HoverPageObject hover = welcomePage.HoverLink();
        sleep(2000);

        /*** Hovering over elements ***/

        hover.openUserProfile(2);

        sleep(2000);

        /*** Verification ***/

        Assert.assertTrue(hover.getResultText(result).equals("Not Found"),
                "The Texts are not the same");

    }
}
