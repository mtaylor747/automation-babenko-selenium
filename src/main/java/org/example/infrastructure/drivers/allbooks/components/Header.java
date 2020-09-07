package org.example.infrastructure.drivers.allbooks.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Header {

    private WebElement webElement;

    public Header(WebElement webElement) {
        this.webElement = webElement;

    }

    public WebElement get() {
        return this.webElement;
    }

    public WebElement searchField() {
        return webElement.findElement(By.id("s"));

    }

    public WebElement submitSearchButton() {
        return webElement.findElement(By.id("searchsubmit"));

    }

    public WebElement allItEbooksNavLink() {
        return webElement.findElement(By.id("menu-item-4"));
    }

    public WebElement categoriesNavLink() {
        return webElement.findElement(By.id("menu-item-65"));

    }

    public WebElement categoryLink(String category) {
        categoriesNavLink().findElement(By.cssSelector("ul[style-'display: block;']"))
                .findElements(By.tagName("li"))
                .stream().filter(c -> c.getText().equals(category))
                .findFirst()
                .get();
        return null;

    }

    public WebElement subCategory(WebElement category, String subcategory) {

       return category.findElement(By.className("sub-menu"))
                .findElements(By.tagName("li"))
                .stream().filter(c -> c.getText().equals(subcategory))
                .findFirst()
                .get();

    }



    }

