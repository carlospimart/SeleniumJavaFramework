package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.DragDropPageObject;
import com.herokuapp.Pages.KeyPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Pages_DragDrop extends TestUtilities {

    @Test
    public void Drag_and_drop() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();
        sleep(2000);

        /*** Click on DragDrop link ***/

        DragDropPageObject dragdrop = welcomePage.DragDropLink();
        sleep(1000);

        /*** Drag and Drop ***/

        dragdrop.dragAtoB();
        sleep(2000);

        /*** getting text ***/
        String columnA = dragdrop.getTextColumn("A");
        log.info(columnA);

        Assert.assertTrue(columnA.equals("B"), "The two letters are not the same");

        /*** getting text ***/
        String columnB = dragdrop.getTextColumn("B");

        Assert.assertTrue(columnB.equals("A"), "The two letters are not the same");
    }
}