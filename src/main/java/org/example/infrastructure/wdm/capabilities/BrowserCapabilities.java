package org.example.infrastructure.wdm.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilities {

    String Capabilities = "chrome";
    String Capabilities1 = "1920x1080";
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public static DesiredCapabilities chrome(){

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("VNC",  "true");
            capabilities.setCapability( "Video", "true");

        DesiredCapabilities Capabilities = capabilities;
        return new DesiredCapabilities();
    }
}
