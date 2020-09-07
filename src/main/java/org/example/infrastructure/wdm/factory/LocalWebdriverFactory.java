package org.example.infrastructure.wdm.factory;

import org.example.infrastructure.config.ConfigurationManager;
import org.example.infrastructure.wdm.enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalWebdriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        WebDriverType browserType = WebDriverType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        switch(browserType){
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case IE:
                return new InternetExplorerDriver();
            case SAFARI:
                return new SafariDriver();
            case OPERA:
                return new OperaDriver();
            default:
                throw new IllegalArgumentException("");
        }
    }
}
