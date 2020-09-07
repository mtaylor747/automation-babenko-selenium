package org.example.infrastructure.drivers.allbooks;

import org.example.infrastructure.drivers.allbooks.components.Header;
import org.example.infrastructure.drivers.allbooks.components.SideMenu;
import org.example.infrastructure.drivers.allbooks.pages.BookPage;
import org.example.infrastructure.drivers.allbooks.pages.BooksListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksWebsite {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private WebElement element;

    public BooksWebsite(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver,60);

    }

    public void open(){
        try {
            webDriver.get("http://www.allitebooks.org/");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("masthead")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("primary")));


        }catch (Exception ex){
            throw new RuntimeException(ex);

            }
        }


    public Header header(){
        return new Header(webDriver.findElement(By.id("masthead")));

    }

    public SideMenu sideMenu(){
        return  new SideMenu(webDriver.findElement(By.id("menu-categories")));
    }

    public BooksListPage booksListPage(){
        return new BooksListPage(webDriver);

    }

    public BookPage bookPage(){
        return new BookPage(webDriver);

//        public void mouseOver(WebElement element){
//       new Actions(webDriver)
//               .moveToElement(element)
//               .perform();
//
//
//
//
//        }
    }
}
