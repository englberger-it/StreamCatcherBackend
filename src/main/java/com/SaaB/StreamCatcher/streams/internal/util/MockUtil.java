package com.SaaB.StreamCatcher.streams.internal.util;

import java.util.Random;

public class MockUtil {

    public static String generateRandomString(int length) {
        Random random = new Random();
        char[] array = new char[length];
        for (int j = 0; j < array.length; j++) {
            array[j] = (char) ('a' + random.nextInt(26));
        }
        return new String(array);
    }
}
