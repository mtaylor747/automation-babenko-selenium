package org.example.infrastructure.drivers.funclub;

import org.example.infrastructure.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  private final String userLoginSelector = "user_login";


    @FindBy(id = userLoginSelector)
    private WebElement loginField;

    @FindBy(id = "user_pass")
    private WebElement passwordField;

    @FindBy(id = "wp-submit")
    private WebElement submit;

    @FindBy(id = "login_error")
    private WebElement errorMsg;


    private WebDriver webDriver;
    private WebDriverWait wait;




    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, 30);


        PageFactory.initElements(webDriver, this);
    }

    public void fillLoginField (String email) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userLoginSelector")));
            loginField.click();
            loginField.sendKeys(email);
        }catch (Exception ex) {
            new SeleniumUtils(webDriver).makeScreenshot();
            //..fail test

        }
    }

    public void fillPassword (String password) {
        passwordField.click();
        passwordField.sendKeys(password);

    }

    public void clickSubmit() {
        submit.click();
    }

    public String getErrorMessage(){
        return errorMsg.getText();
    }

}
