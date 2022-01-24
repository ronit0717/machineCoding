package com.rccode.service.util;

import java.util.UUID;

public class RandomUtil {

    public static String getRandomId() {
        return UUID.randomUUID().toString();
    }

    public static int getRandomInRange(int min, int max) {
        return min + (int)(Math.random() * max);
    }

}
