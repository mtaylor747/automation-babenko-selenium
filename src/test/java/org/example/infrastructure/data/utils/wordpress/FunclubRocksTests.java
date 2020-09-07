package org.example.infrastructure.data.utils.wordpress;

import org.example.infrastructure.utils.SeleniumUtils;
import org.example.infrastructure.utils.TimeUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.WeakHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FunclubRocksTests {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 30);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        webDriver.manage().window().setSize(new Dimension(1920, 1280));

        System.out.println(webDriver.getWindowHandle());

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void frameTest(){
        webDriver.get("file://Users/maximk/Work/PERSONAL/test-site/exec.html");
        System.out.println(webDriver.findElement(By.tagName("body")).getText());
        System.out.println();

        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframeId")));

        System.out.println(webDriver.findElement(By.tagName("ul")).getText());

        webDriver.switchTo().parentFrame();
        webDriver.switchTo().defaultContent();


    }

    @Test
    public void test2() {
        SeleniumUtils seleniumUtils = new SeleniumUtils(webDriver);
        webDriver.get("file://Users/maximk/Work/PERSONAL/test-site/index.html");

        String initialWindow = webDriver.getWindowHandle();
        webDriver.findElement(By.tagName("a")).click();
        System.out.println(webDriver.getTitle());

        seleniumUtils.switchToWindow("EXEC");


        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());



        webDriver.close();
       seleniumUtils.returnToParentWindow();
        webDriver.switchTo().window(initialWindow);


    }


 //   @Test
    public void test() {

        webDriver.get("http//:jugris-course.fanclub.rocks/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("container")));


        WebElement metaBlock = webDriver.findElement(By.id("meta-2")).findElements(By.tagName("li")).get(3);

        TimeUtils.wait(2_000);

//        js.executeScript("arguments[0].scrollIntoView(true);", metaBlock);
//        Object str = js.executeScript("return document.querySelector('#threadguard').innerText");


        //   metaBlock.sendKeys(Keys.PAGE_DOWN);
        //  TimeUtils.wait(2_000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("meta-2")));


        List<WebElement> links = webDriver.findElement(By.id("meta-2")).findElements(By.tagName("li"));
        for (WebElement link : links) {
            if (link.getText().contains("Log in")) {
                link.findElement(By.tagName("a")).click();
                break;
            }
        }


        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("loginform")));

        WebElement loginForm = webDriver.findElement(By.name("loginform"));
        WebElement PasswordInput = loginForm.findElement(By.name("pwd"));
        PasswordInput.click();
        PasswordInput.sendKeys("password");

        loginForm.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_error")));

        assertTrue(webDriver.findElement(By.id("login_error")).getText().contains("The password you entered for the username admin is incorrect"));



    }
}



