package org.example.infrastructure.wdm;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

    WebDriver getBrowser();

    void destroyBrowser(WebDriver browser);
}

