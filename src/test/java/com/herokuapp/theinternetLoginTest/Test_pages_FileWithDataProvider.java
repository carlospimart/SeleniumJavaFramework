package com.herokuapp.theinternetLoginTest;

import com.herokuapp.Pages.FUploadPageObject;
import com.herokuapp.Pages.WelcomePageObject;
import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_pages_FileWithDataProvider extends TestUtilities {

    private By ChooseFile = By.id("file-upload");
    @Test(dataProvider = "file_provider")
    public void UploadFileTest(int TestNumber, String fileName) throws InterruptedException {
        /*** Open The main page ***/

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);

        welcomePage.OpenPage();

        /*** Click on Upload link ***/

        FUploadPageObject FUpload = welcomePage.FileuploadLink();

        sleep(2000);

        /*** Select file ***/

        FUpload.SelectFile(fileName, ChooseFile);

        /*** Click on 'Upload file' button ***/

        FUpload.PushChooseButton();

        Assert.assertTrue(FUpload.GetPageText().equals(fileName),
                "fileName and text in page are not the same");
        sleep(1000);
    }
}
