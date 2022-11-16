package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.*;
import com.herokuapp.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTest_With_DataProvider extends TestUtilities {


    @Test(priority = 1, dataProvider = "csvReader", dataProviderClass = BasePageObject.class)
    public void negativeLogInTest(Map<String, String> testData) {
        /*** Data ***/
        String no = testData.get("no");
        String username  = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");


        /*** open main page***/
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.OpenPage();
        sleep(2000);
        /*** Click on Form Authentication link ***/
        LoginPage loginPage = welcomePage.ClickAuthenticationLink();

        sleep(1000);
        /*** Fail Login ***/
        loginPage.LogIn(username,password);

        /*** verification ***/
        String actualMessage = loginPage.failLogin();

        sleep(1000);
        Assert.assertTrue(actualMessage.contains(expectedErrorMessage),
                "Actual and expected" +
                "message are different");
    }
}
