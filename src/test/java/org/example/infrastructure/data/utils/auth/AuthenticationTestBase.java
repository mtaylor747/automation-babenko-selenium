package org.example.infrastructure.data.utils.auth;

import org.example.infrastructure.data.utils.FunclubTestBase;

public abstract class AuthenticationTestBase extends FunclubTestBase {

    @Override
    protected void beforeTests() {
        super.beforeTests();

        logger.log("Open login page");
        mainPage.clickLogin();
    }
}
