package org.example.infrastructure.drivers.funclub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ArticlePage {

    private WebDriver webDriver;

    public ArticlePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ArticlePage checkArticleTitle(){
       assertEquals("Some test post", webDriver.findElement(By.className("entry-title")).getText());
       return this;
    }

    public ArticlePage checkArticleWriter(){
        assertEquals("admin", webDriver.findElement(By.cssSelector(".author.vcard")).getText());
        return this;
    }


}
