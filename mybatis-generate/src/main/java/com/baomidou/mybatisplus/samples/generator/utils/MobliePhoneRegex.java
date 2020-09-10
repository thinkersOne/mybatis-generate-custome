package com.baomidou.mybatisplus.samples.generator.utils;

import java.util.regex.Pattern;


public class MobliePhoneRegex {

    public static boolean check(String mobile) {
        String regex = "(\\+\\d+)?[0-9]{11}$";
        return Pattern.matches(regex, mobile);
    }
}
