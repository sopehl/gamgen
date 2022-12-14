package com.gamgen.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RandomUtils {

    private static char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'
    };

    private static int counter = 0;

    private static final int COUNTER_MAX = 1000;

    private static final String INSTANCE_ID = getInstanceId();

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";

    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();

    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;

    private static SecureRandom random = new SecureRandom();

    public static synchronized String generateUnique() {
        counter++;
        if (counter >= COUNTER_MAX) {
            counter = 0;
        }
        long now = (Long.parseLong(System.currentTimeMillis() + INSTANCE_ID) * COUNTER_MAX) + counter;
        String id = longToBaseX(now, chars.length);
        return "000000000000".substring(id.length()) + id;
    }

    private static String getInstanceId() {
        try {
            int i = 123456789;
            NumberFormat format = new DecimalFormat("00");
            format.setMaximumIntegerDigits(2);
            return format.format(i);
        } catch (Exception ignored) {
        }
        return "00";
    }

    private static String longToBaseX(long value, int base) {
        StringBuilder buffer = new StringBuilder();
        while (value >= base) {
            buffer.append(chars[(int) (value % base)]);
            value = value / base;
        }
        buffer.append(chars[(int) (value % base)]);
        return buffer.reverse().toString();
    }

    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        return sb.toString();
    }

    public static String randomString(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public static String randomString() {
        return randomString(20);
    }
}
