package org.example.infrastructure.utils;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {

    private WebDriver webDriver;
    private String initialWindow;

    public SeleniumUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
        initialWindow = webDriver.getWindowHandle();
    }

    public void switchToWindow(String windowTitle){
        for (String handle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(handle);

            if (webDriver.getTitle().equals(windowTitle)) {
                break;
            }
        }

    }
    public void returnToParentWindow(){
        webDriver.switchTo().window(initialWindow);

    }
    public void closeExtraWindow() {
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(initialWindow)) {
                webDriver.switchTo().window(handle);
                webDriver.close();
            }
        }

        webDriver.switchTo().window(initialWindow);
    }

        public void acceptPopUp(){
            webDriver.switchTo().alert().accept();
        }
        public void discardPopUp(){
            webDriver.switchTo().alert().dismiss();
        }

        public void makeScreenshot(){
        try {
            //...

        }catch (Exception ex) {
            System.out.println("Screenshot was not taked due to exception: " + ex);
        }
        }

    }

