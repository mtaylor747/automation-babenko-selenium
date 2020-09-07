package org.example.infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

public class TestUrl {

    private String protocol;
    private String domain;
    private String port;
    private String path;
    private Map<String, String> params = new HashMap<>();


    private TestUrl() {
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getParam() {
        return params;
    }

    public static class Builder {

        private TestUrl url;

        public Builder() {

            url = new TestUrl();

        }

        public Builder withProtocol(String protocol) {
            url.protocol = protocol;
            return this;
        }

        public Builder withDomain(String domain) {
            url.domain = domain;
            return this;
        }

        public Builder withPort(int port) {
            if (port < 0 && port > 65535)
                url.port = "";

            url.port = "" + port;
            return this;
        }

        public Builder withPath(String path) {
            url.path = path;
            return this;
        }

        public Builder withParam(String param) {
            url.params.put(param, "" );
            return this;
        }

        public Builder withParams(String key, String value) {
            url.params.put(key,value);
            return this;
        }

        public Builder withParams(Map<String,String> params){
            url.params.putAll(params);
            return this;
        }

        public Builder withParams(HashMap<String, String> params){
            return this;
        }

        public TestUrl build() {
            return url;
        }


        public String buildUrl() {

            String result = "";
            if (url.protocol != null && !url.protocol.isBlank())
                result += url.protocol.endsWith("://") ? url.protocol : url.protocol + "://";


            if (url.domain != null && !url.domain.isBlank())
                result += url.domain;

            if (url.port != null && !url.port.isBlank())
                result += ":" + url.port;

            if (url.path != null && !url.path.isBlank())
                result += !url.path.startsWith("/") ?
                        url.path :
                        "/" + url.path;

            if(url.params.isEmpty()){
                result += "?";

                for(String paramKey: url.params.keySet()){
                    String paramValue = url.params.get(paramKey);
                    if(paramValue.isBlank()){
                        result += paramKey + "&";

                    }else{
                        result += paramKey + "=" + paramValue + "&";
                    }
                }
            }

            return result;
        }


             public static class Common {
                public static String myAccountProduction() {
                    return new Builder().withDomain("myproject.com").withPath("/my-account").buildUrl();

                }
            }
        }





       @Override
        public String toString() {
            return "TestUrl{" +
                    "protocol='" + protocol + '\'' +
                    ", domain='" + domain + '\'' +
                    ", port='" + port + '\'' +
                    ", path='" + path + '\'' +
                    ", params='" + params + '\'' +
                   '}';
        }
    }


