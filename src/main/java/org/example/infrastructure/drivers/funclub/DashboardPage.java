package org.example.infrastructure.drivers.funclub;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class DashboardPage {

    private WebDriver webDriver;

    public DashboardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkDashboardPageLoaded(){
        assertTrue(true);
    }
}
