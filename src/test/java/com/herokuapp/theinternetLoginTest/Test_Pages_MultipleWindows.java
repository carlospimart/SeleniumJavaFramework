package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.AlertPageObject;
import com.herokuapp.Pages.MultipleWindowsPageObject;
import com.herokuapp.Pages.NewWindowPage;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Test_Pages_MultipleWindows extends TestUtilities {
    @Test
    public void MultipleWindows() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on Multiple Windows link ***/

        MultipleWindowsPageObject MWindows = welcomePage.MWindowsLink();
        sleep(1000);

        /*** Click on "Click Here" Link ***/
        MWindows.openNewWindow();
        sleep(2000);

        NewWindowPage newWindowPage =   MWindows.SwitchToNewWindowsPage();
        sleep(2000);
        String pageSource = newWindowPage.getCurrentPageSource();
        sleep(1000);

        Assert.assertEquals(pageSource.contains("New Window"),
                "New Page Source does not contain 'New Window' ");


    }
}