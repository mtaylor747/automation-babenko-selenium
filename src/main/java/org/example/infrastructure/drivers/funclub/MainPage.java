package org.example.infrastructure.drivers.funclub;

import org.example.infrastructure.utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ArticlePage openArticle(){
        webDriver.findElement(By.className("entry-title")).findElement(By.tagName("a")).click();

        return new ArticlePage(webDriver);
    }

    public LoginPage clickLogin(){
       WebElement metaBlock = webDriver.findElement(By.id("meta-2"));

        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].scrollIntoView(true)",metaBlock);
        TimeUtils.wait(2_000);

        for(WebElement el: metaBlock.findElements(By.tagName("li"))) {
            if(el.getText().equals("Log in")) {
                el.findElement(By.tagName("a")).click();
                break;


            }

        }

        return new LoginPage(webDriver);
    }
}
