package org.example.infrastructure.drivers.allbooks.pages;

import org.example.infrastructure.drivers.allbooks.components.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BooksListPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    public BooksListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver,30);

    }
    public WebElement pageHeader(){
        return webDriver.findElement(By.className("page-header"));
    }

    public List<Book> books(){

        List<Book> bookItems = new ArrayList<>();

       for(WebElement article: webDriver.findElements(By.tagName("article"))){
           bookItems.add(
                   new Book(article.findElement(By.className(".entry-thumbnail.hover-thumb")),
                           article.findElement(By.className("entry-title")),
                           article.findElement(By.className("entry-meta")),
                           article.findElement(By.className("entry-summary"))
           )

           );
       }

        return bookItems;
    }

    public Book getBookByTitle(String title){
        for(Book b: books()){
            if(b.getTitle().getText().equals(title)){
                return b;
            }
        }

        throw new RuntimeException();

//       return books()
//               .stream()
//               .filter(book -> book.getTitle().getText().equals(title))
//               .findFirst()
//               .get();

    }



    public WebElement  getFirstPage(){
        try{
          return webDriver.findElement(By.className(".pagination.clearfix")).findElement(By.linkText("1"));

        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


    public WebElement getPageByNumber(int number){
        try{
            return webDriver
                    .findElement(By.className(".pagination.clearfix"))
                    .findElement(By.cssSelector("a[title ='"+ number + "']"));

        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }

}
