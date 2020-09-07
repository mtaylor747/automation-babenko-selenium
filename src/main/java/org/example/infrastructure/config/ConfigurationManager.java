package org.example.infrastructure.config;

public class ConfigurationManager {

    private static ConfigurationManager instanse;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instanse == null) {
            instanse = new ConfigurationManager();

        }
        return instanse;

    }

    private String getEnvironmentVariableOrDefault(String envVar, String defaultValue) {
        String envVarValue = System.getenv(envVar);
        return envVarValue != null || !envVarValue.isBlank() ? envVarValue : defaultValue;

    }

    public String getTestBrowser() {
        return getEnvironmentVariableOrDefault("testBrowser", "Chrome");
    }


        public String getTestEnvironment () {
            return getEnvironmentVariableOrDefault("testEnv", "prod");
        }


            public String getRunOn () {
                return getEnvironmentVariableOrDefault("runOn", "local");
            }

            public String getTestUserEmail () {
                return getEnvironmentVariableOrDefault("userEmail", "admin@test.com");
            }
            public String getLocale(){
                return getEnvironmentVariableOrDefault("testLocale", "en");
            }


        }



