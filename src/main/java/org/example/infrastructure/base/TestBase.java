package org.example.infrastructure.base;

import org.example.infrastructure.config.ConfigurationManager;
import org.example.infrastructure.data.FileUserDataMapper;
import org.example.infrastructure.data.UserDataMapper;
import org.example.infrastructure.logging.FileTestLogger;
import org.example.infrastructure.logging.StdTestLogger;
import org.example.infrastructure.logging.TestLogger;
import org.example.infrastructure.utils.SeleniumUtils;
import org.example.infrastructure.wdm.DefaultWebDriverManager;
import org.example.infrastructure.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {
    private WebDriverManager wdm;
    protected WebDriver browser;
    protected SeleniumUtils seleniumUtils;

    protected TestLogger logger;
    protected UserDataMapper users;

    @Before

    public void setup() {
        users = new FileUserDataMapper();
        wdm = new DefaultWebDriverManager();

        logger = getLogger();
        browser = wdm.getBrowser();
        seleniumUtils = new SeleniumUtils(browser);

        beforeTests();

    }

    @After

    public void cleanup() {

        afterTests();
        wdm.destroyBrowser(browser);

    }

    protected void beforeTests() {
    }

    protected void afterTests() {
    }

    private TestLogger getLogger() {
       return ConfigurationManager.getInstance().getRunOn().equals("local") ?
                new StdTestLogger() : new FileTestLogger();
    }

    public abstract void testOne();
}
