package com.herokuapp.SakilaWebProject;

import com.herokuapp.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SakilaLanguageTest extends TestUtilities {
    @Test()
    public void AddLanguage() throws InterruptedException {
        WebElement frame;

        /*** Open Test Page ***/

        String url = "http://localhost:3000/";
        driver.get(url);
        System.out.println("Page is opened");
        sleep(5000);
        /*** Select Menu Frame***/
        frame= driver.findElement(By.xpath("//*[@id='root']/frameset/frameset/frame[1]"));
        driver.switchTo().frame(frame);
        /*** Press Language Button ***/
        WebElement LanguageButton = driver.findElement(By.xpath("//*[@id='root']/ul/li[3]/button"));
        LanguageButton.click();
        sleep(3000);
        /*** Unselect current frame and slect language frame***/
        driver.switchTo().defaultContent();

        frame= driver.findElement(By.xpath("//*[@id='root']/frameset/frameset/frame[2]"));
        driver.switchTo().frame(frame);
        /*** Press Add button ***/
        WebElement AddLanguageButton = driver.findElement(By.xpath("//*[@id='root']/dl[2]/button[2]"));
        AddLanguageButton.click();
        sleep(2000);

        /*** Type "Polish" in language box ***/
        WebElement Add_Language_Box = driver.findElement(By.xpath("//*[@id='name']"));
        Add_Language_Box.sendKeys("Polish");
        /*** submit ***/
        WebElement SubmitButton= driver.findElement(By.xpath("//*[@id='root']/div/form/button"));
        SubmitButton.click();

        sleep(2000);
        tearDown();

    }

}
