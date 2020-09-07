package org.example.infrastructure.utils;

import java.util.Random;

public class StringUtils {

    public enum StringType{
        ALPHA, NUMERIC, ALPHANUMERIC, HEX
    }
    public static String randomString(StringType type, int lenght) {

        String alphabet;


        switch (type) {
            case ALPHA:
                alphabet = "abcdefghijklmnopqrstuvwxyz";
                break;

            case NUMERIC:
                alphabet = "0123456789";
                break;

            case ALPHANUMERIC:
                alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
                break;

            case HEX:
                alphabet = "0123456789abcdef";
                break;
            default:
                return null;

        }

        Random r = new Random();
        String result = "";

        for (int i = 0; i < lenght; i++) {
            result += alphabet.charAt(r.nextInt(alphabet.length()));

        }
        return result;

    }

    public static String getRandomGuid() {
        String result = "";
        result += randomString(StringType.HEX, 8) + "-";
        for (int i = 0; i < 3; i++) {
            result += randomString(StringType.HEX, 4) + "-";

        }
        return result += randomString(StringType.HEX, 12);

    }


}














