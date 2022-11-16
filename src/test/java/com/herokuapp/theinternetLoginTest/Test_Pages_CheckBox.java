package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.CheckBoxPageObject;
import com.herokuapp.Pages.LoginPage;
import com.herokuapp.Pages.SecureAreaPage;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Pages_CheckBox extends TestUtilities {

    @Test
    public void CkeckBoxTest() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        CheckBoxPageObject checkboxTest = welcomePage.ClickCheckBoxLink();

        /*** Select All Checkboxes ***/
        checkboxTest.selectAllCheckBoxes();

        sleep(2000);
        /*** Verifications ***/
        Assert.assertTrue(checkboxTest.areAllCheckBoxesChecked(),
                "Not all boxes are checked");


    }

}
