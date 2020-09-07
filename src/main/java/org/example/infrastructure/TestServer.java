package org.example.infrastructure;

import org.example.infrastructure.config.ConfigurationManager;

public class TestServer {

    public String getUrl(){
        String testEnv = ConfigurationManager.getInstance().getTestEnvironment();

        switch (testEnv){
            case "production":
                return "http://mysite.com";
            case "staging":
                return "http://staging.site.com";
            case"test":
                return "http//test.site.com";
                default:
                    return "";
        }

    }
}


