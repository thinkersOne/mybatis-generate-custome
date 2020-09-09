package com.baomidou.mybatisplus.samples.generator.utils;

public class LongUtil {

    public static boolean isEmpty(Long vaule) {
        return vaule == null || vaule == 0;
    }

    public static boolean equals(Long a, Long b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    public static void main(String[] args) {
        Long a = 1L;
        System.out.println(a == 1L);

    }
}
