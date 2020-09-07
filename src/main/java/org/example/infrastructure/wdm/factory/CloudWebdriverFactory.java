package org.example.infrastructure.wdm.factory;

import org.example.infrastructure.config.ConfigurationManager;
import org.example.infrastructure.wdm.enums.WebDriverType;
import org.openqa.selenium.WebDriver;

public class CloudWebdriverFactory implements WebDriverFactory {

    // SauceLabs || BrowserStack

    @Override
    public WebDriver create() {

        WebDriverType browserType = WebDriverType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
//        switch(browserType){
//            case CHROME:
//                return "CLOUD new ChromeDriver()";
//            case FIREFOX:
//                return "CLOUD new FirefoxDriver()";
//            case EDGE:
//                return "CLOUD new EdgeDriver()";
//            case IE:
//                return "CLOUD new IntertnetExplorerDriver()";
//            case SAFARI:
//                return "CLOUD new SafariDriver()";
//            case OPERA:
//                return "CLOUD new OperaDriver()";
//            default:
//                return "";
//        }
        return null;
    }
}
