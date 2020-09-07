package org.example.infrastructure.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeUtils {


    public static void wait(int time) {
        try{
            Thread.sleep(2000);
            WebDriver webDriver = new ChromeDriver();
            //var webDriver = new WebDriverWait(drv, 5);
            webDriver.switchTo().alert().accept();
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFrame1"));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("item"))).click();
        } catch(InterruptedException ex){

        }

    }
}
