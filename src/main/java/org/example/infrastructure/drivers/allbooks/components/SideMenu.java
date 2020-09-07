package org.example.infrastructure.drivers.allbooks.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SideMenu {

    private WebElement element;

    public SideMenu(WebElement element) {
        this.element = element;
    }

    public WebElement get(){
        return this.element;
    }

    public WebElement category(String title){
       return element.findElements(By.tagName("li"))
                .stream()
                .filter(c -> c.getText().equals(title))
                .findFirst()
                .get()
                .findElement(By.tagName("a"));

    }



}
