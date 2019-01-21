package com.staging9mcollab.helpers;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Helper class that gives us random values
 *
 * @author Zoran Dragovic
 */
public class Randomizer {

    /**
     * <p>
     * This method attaches random alphanumeric value to selected string
     * </p>
     *
     * @param value String value that will be randomized
     * @return randomized String value
     */
    public static String randomizeValue(String value) {
        String randomValue = RandomStringUtils.randomAlphanumeric(4);
        return value + randomValue;
    }
}