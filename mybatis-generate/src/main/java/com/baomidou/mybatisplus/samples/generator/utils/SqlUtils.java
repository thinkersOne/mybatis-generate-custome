package com.baomidou.mybatisplus.samples.generator.utils;


public class SqlUtils {

    public static String fullLikeValue(String key){
        if(key == null) return key;
        return "%" + key + "%";
    }

    public static String leftLikeValue(String key){
        if(key == null) return key;
        return "%" + key;
    }

    public static String rightLikeValue(String key){
        if(key == null) return key;
        return key + "%";
    }

}
