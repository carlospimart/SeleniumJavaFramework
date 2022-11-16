package com.herokuapp.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUtilities extends BaseTest{
    public void sleep(long s) {
        try{
            Thread.sleep(s);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    protected void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")+
                File.separator +"src"+
                File.separator +"main"+
                File.separator +"resources"+
                File.separator + getTodaysDate() +
                File.separator + testSuiteName+
                File.separator +testName+
                File.separator +testMethodName+
                File.separator +getSystemTime()+
                " "+ fileName + ".png";

        try{
            FileUtils.copyFile(scrFile, new File(path));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        /*** Today date in yyyyMMdd ***/
    private static String getTodaysDate(){
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }
    /*** Today date in yyyyMMdd ***/
    private String getSystemTime(){
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    @DataProvider(name="file_provider")
    protected static Object[][] files(){

        return new Object[][]{

                {1, "index.html"},
                {2, "point_up.png"},
                {3, "text.txt"}
        };
    }

    /*** Verifying there are not JavaScripts errors in console  ***/
    protected List<LogEntry> getBrowserLogs() {

        /*** getting logs  ***/
        LogEntries log = driver.manage().logs().get("browser");

        List<LogEntry> logList = log.getAll();
        return logList;
    }

}
