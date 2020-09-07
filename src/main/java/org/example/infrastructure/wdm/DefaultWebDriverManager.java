package org.example.infrastructure.wdm;

import org.example.infrastructure.config.ConfigurationManager;
import org.example.infrastructure.wdm.enums.RunOn;
import org.example.infrastructure.wdm.factory.CloudWebdriverFactory;
import org.example.infrastructure.wdm.factory.LocalWebdriverFactory;
import org.example.infrastructure.wdm.factory.RemoteWebdriverFactory;
import org.example.infrastructure.wdm.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager {

    @Override
    public WebDriver getBrowser() {
       RunOn runOn = RunOn.valueOf(ConfigurationManager.getInstance().getRunOn().toUpperCase());


       WebDriverFactory factory;


       switch(runOn){
           case LOCAL:
               factory = new LocalWebdriverFactory();
               break;
           case REMOUTE:
               factory = new RemoteWebdriverFactory();
               break;
           case CLOUD:
               factory = new CloudWebdriverFactory();
               break;
               default:
                   throw new IllegalArgumentException("");

       }

       return factory.create();
    }

    public void cleanBrowseR(String browser){
        System.out.println("Clanig" + browser);
    }

    @Override
    public void destroyBrowser(WebDriver webDriver) {
        if(webDriver != null){
            webDriver.quit();

        }

    }
}
