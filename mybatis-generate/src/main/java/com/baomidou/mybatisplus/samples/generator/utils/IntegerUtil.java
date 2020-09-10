package com.baomidou.mybatisplus.samples.generator.utils;

import org.springframework.util.StringUtils;

public class IntegerUtil {

    public static int add(Integer a,Integer b){
        if(a == null){
            a = 0;
        }
        if(b == null){
            b = 0;
        }
        return (a + b);
    }

    public static boolean isEmpty(Integer vaule) {
        return vaule == null || vaule == 0;
    }

    public static Integer convertStringToInteger(String str){
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {

    }

}
