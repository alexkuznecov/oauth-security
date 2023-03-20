package by.home.authservice.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static String generateAppCode() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static String generateAppSecret() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

}
