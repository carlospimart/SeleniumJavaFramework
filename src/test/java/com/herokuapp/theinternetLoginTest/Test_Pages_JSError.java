package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.JSErrorPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Test_Pages_JSError extends TestUtilities {
    SoftAssert softassert = new SoftAssert();
    @Test
    public void Error() throws InterruptedException {

        /*** Open The main page ***/
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        sleep(2000);

        JSErrorPageObject JSerror = welcomePage.ErrorLink();

        sleep(1000);

        List<LogEntry> logs = getBrowserLogs();
        System.out.println("Error: " + logs);

        /*** Verifying there are not JavaScripts errors in console  ***/
        for (LogEntry logEntry: logs){
            System.out.println("Error log Entry: " + logEntry.getMessage());
            if(logEntry.getLevel().toString().equals("SEVERE")){
                softassert.fail("Severe fail: "+ logEntry.getMessage());
            }
        }

    }
}
