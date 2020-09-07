package org.example.infrastructure.drivers.allbooks.components;

import org.openqa.selenium.WebElement;

public class Book {

    private WebElement thumbnail;
    private WebElement title;
    private WebElement meta;
    private WebElement summary;

    public Book(WebElement thumbnail, WebElement title, WebElement meta, WebElement summary) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.meta = meta;
        this.summary = summary;
    }

    public WebElement getThumbnail() {
        return thumbnail;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getMeta() {
        return meta;
    }

    public WebElement getSummary() {
        return summary;
    }
}
