package org.example.infrastructure.wdm.factory;

import org.example.infrastructure.config.ConfigurationManager;
import org.example.infrastructure.wdm.capabilities.BrowserCapabilities;
import org.example.infrastructure.wdm.enums.WebDriverType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebdriverFactory implements WebDriverFactory {

    DesiredCapabilities caps = new DesiredCapabilities();

    @Override
    public WebDriver create() {

        WebDriverType browserType = WebDriverType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        switch(browserType){
            case CHROME:
                caps.merge(BrowserCapabilities.chrome());
                break;
//            case FIREFOX:
//                return "REMOTE new FirefoxDriver()";
//            case EDGE:
//                return "REMOTE new EdgeDriver()";
//            case IE:
//                return "REMOTE new InternetExplorerDriver()";
//            case SAFARI:
//                return "REMOTE new SafariDriver()";
//            case OPERA:
//                return "REMOTE new OperaDriver()";
            default:
                throw new IllegalArgumentException("");
        }

        try {
           return new RemoteWebDriver(new URL(""),caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException();

            }

        }
    }

