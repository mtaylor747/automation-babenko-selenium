package org.example.infrastructure.data.utils.auth;

import org.example.infrastructure.data.User;
import org.example.infrastructure.drivers.funclub.DashboardPage;
import org.example.infrastructure.drivers.funclub.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public abstract class LoginTests extends AuthenticationTestBase {

    protected LoginPage loginPage;
    private User admin;


    @Override
    protected void beforeTests() {
        super.beforeTests();

        loginPage = new LoginPage(browser);

        admin = users.findUserByUserName("admin");

    }

    @Test
    public void testSuccessLogin(){

        logger.log("Enter correct login email");
        loginPage.fillLoginField(admin.getEmail());

        logger.log("Enter correct password");
        loginPage.fillPassword(admin.getPassword());

        logger.log("Click Submit");
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage(browser);
        assertTrue(true);


    }
    @Test
    public void testLoginWithIncorrectPassword(){

        logger.log("Enter correct login email");
        loginPage.fillLoginField("admin@gmail.com");

        logger.log("Enter incorrect password");
        loginPage.fillPassword("djfskdjsjks");

        logger.log("Click Submit");
        loginPage.clickSubmit();

        logger.log("Check error message");
        assertTrue(loginPage.getErrorMessage().equals(""));
    }
    @Test
    public void testLoginFormWithEmptyFields(){


        logger.log("Click Submit");
        loginPage.clickSubmit();

        logger.log("Check error message");
        assertTrue(loginPage.getErrorMessage().equals(""));

    }
    @Test
    public void testLoginWithoutPassword(){

        logger.log("Fill login form with empty password and submit");

    }
}
