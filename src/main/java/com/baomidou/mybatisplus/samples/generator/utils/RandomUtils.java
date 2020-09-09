package com.baomidou.mybatisplus.samples.generator.utils;

import java.util.Random;

public class RandomUtils {
    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String RANDOM_Number = "0123456789";

    private static final Random RANDOM = new Random();

    public RandomUtils() {
    }

    public static String getRandomStr(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }

    public static String getRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(RANDOM_Number.charAt(RANDOM.nextInt(RANDOM_Number.length())));
        }
        return sb.toString();
    }
}
