package com.rccode.service.util;

import java.util.UUID;

public class RandomUtil {

    public static String getRandomId() {
        return UUID.randomUUID().toString();
    }

}
