package org.example.infrastructure.data.utils;

import org.example.infrastructure.base.TestBase;
import org.example.infrastructure.drivers.funclub.MainPage;

public abstract class  FunclubTestBase extends TestBase {

    protected MainPage mainPage;
    @Override
    protected void beforeTests() {
        logger.log("Open website");
        browser.get("http//:jugris-course.fanclub.rocks/");

        mainPage = new MainPage(browser);

    }
}
