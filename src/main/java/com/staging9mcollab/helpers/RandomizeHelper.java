package com.staging9mcollab.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomizeHelper {
    public static String randomizeValue(String value) {
        String randomValue = RandomStringUtils.randomAlphanumeric(4);
        return value + randomValue;
    }
}
