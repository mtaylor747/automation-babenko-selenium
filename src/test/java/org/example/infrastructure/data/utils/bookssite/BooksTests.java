package org.example.infrastructure.data.utils.bookssite;

import org.example.infrastructure.base.TestBase;
import org.example.infrastructure.drivers.allbooks.BooksWebsite;
import org.example.infrastructure.utils.TimeUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class BooksTests extends TestBase {

    private BooksWebsite website;

    @Override
    protected void beforeTests() {
        logger.log("Open website");
        website = new BooksWebsite(browser);
        website.open();



    }

    @Test
    @Ignore
    public void testMainPageContainsAllBlocks(){
        logger.log("Check header is present");
        assertTrue(website.header().get().isDisplayed());

        logger.log("Check side menu is present");
        assertTrue(website.sideMenu().get().isDisplayed());

        logger.log("Check list of books is present and has 10 entries");
        assertEquals(10, website.booksListPage().books().size());

    }

//    @Test
//    public void testOpenCategory(){
//
//       // website.sideMenu().category("Programming").click();
//        website.header().categoriesNavLink().click();
//        WebElement ocCategory = website.header().categoryLink("Operating Systems");
//        website.mouseOver(osCategory);
//        website.header().subCategory(osCategory,"Android").click();
//
//
//    }

    @Test
    @Ignore
    public void testSearch(){


        logger.log("Enter 'Python' into search field");
        website.header().searchField().sendKeys("Python");

        logger.log("Click Search button");
        website.header().submitSearchButton().click();

        seleniumUtils.closeExtraWindow();
        logger.log("Check page header contains search criteria");

        assertTrue(website.booksListPage().pageHeader().getText().contains("Python"));




    }

    @Test
    @Ignore
    public void testBookPage(){
        logger.log("Enter 'Genetics Algorithms in Java Basics' into search field");
        website.header().searchField().sendKeys("Genetics Algorithms in Java Basics");

        logger.log("Click Search button");
        website.header().submitSearchButton().click();

        seleniumUtils.closeExtraWindow();

        logger.log("Open book by title");
        website.booksListPage().getBookByTitle("Genetics Algorithms in Java Basics").getTitle().click();

        //asserts
        website.bookPage();

    }

    @Test
    public void testPagination(){

    }

    @Test
    @Ignore
    public void testPaginationInSearch(){

    }
}
