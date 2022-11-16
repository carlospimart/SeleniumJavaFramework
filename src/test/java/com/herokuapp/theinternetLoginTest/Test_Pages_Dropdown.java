package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.DropdownPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_Pages_Dropdown extends TestUtilities {

    @Test
    public void dropdown() throws InterruptedException {

        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on form Authentication link ***/

        DropdownPageObject dropDown = welcomePage.DropdownBoxLink();

        sleep(2000);


        /*** select option 2 ***/
        dropDown.selectOption(2);

        sleep(2000);

        /*** Verifications ***/
        String selectedOption = dropDown.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "Option 2 is not selected. instead selected: " + selectedOption);

    }



}

