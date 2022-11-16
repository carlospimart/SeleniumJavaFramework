package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.HoverPageObject;
import com.herokuapp.Pages.SlidePageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Page_Slide extends TestUtilities {
    private By slideLocator = By.xpath("//*[@id='content']/div/div/input");
    private By result =  By.id("range");
    @Test
    public void Hover() throws InterruptedException {

        /*** Open The main page ***/
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        sleep(2000);

        /*** Click on Hover link ***/
        SlidePageObject slide = welcomePage.SlideLink();
        sleep(2000);

        /*** move the Slide Bar  ***/

        slide.SlideBar(slideLocator, "3.5");
        sleep(2000);

        /*** Verification ***/

        Assert.assertTrue(slide.getResultText(result).equals("3.5"),
                "The Texts are not the same");

    }
}
