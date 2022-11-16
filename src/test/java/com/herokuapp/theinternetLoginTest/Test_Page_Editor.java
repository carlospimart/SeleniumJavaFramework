package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.AlertPageObject;
import com.herokuapp.Pages.EditorPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Page_Editor extends TestUtilities {
    private By frame = By.xpath("//*[@id='mce_0_ifr']");
    @Test
    public void Editor() throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();
        sleep(2000);
        /*** Scroll down ***/
        welcomePage.scrollToBotton();
        sleep(1000);
        welcomePage.scrollToY_cord("90");
        sleep(2000);
        /*** Click on form Authentication link ***/

        EditorPageObject editor = welcomePage.EditorLink();


        sleep(2000);
        /*** Switch to frame ***/

        editor.SwitchToFrame(frame);

        /*** Get Text by default in editor ***/

        String editorText = editor.getEditorText();

        sleep(2000);

        log.info("Your default message is: " + editorText);

        Assert.assertTrue(editorText.equals("Your content goes here."),
                "This message is different than expected");
    }

}
