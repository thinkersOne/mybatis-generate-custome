package com.baomidou.mybatisplus.samples.generator.utils;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class BigDecimalUtil {


    public static <T> BigDecimal add(List<T> list,String filedName){
        if(!ListUtils.anyList(list)){
            return BigDecimal.ZERO;
        }
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < list.size(); i++) {
            try {
                BigDecimal fieldValue = (BigDecimal)ReflectUtil.getFieldValueByName(filedName, list.get(i));
                result = add(result,fieldValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 比较两值大小
     * true: a 大于等于 b
     * false: a 小于 b
     * @param a
     * @param b
     * @return
     */
    public static boolean compare(BigDecimal a, BigDecimal b){
        if(a == null){
            a = BigDecimal.ZERO;
        }
        if(b == null){
            b = BigDecimal.ZERO;
        }
        return a.compareTo(b) > -1;
    }

    /**
     * 是否大于0
     * @param a
     * @return
     */
    public static boolean moreThanZero(BigDecimal a){
        if(isEmpty(a)){
            return false;
        }
        return a.compareTo(BigDecimal.ZERO) > -1;
    }

    public static BigDecimal add(BigDecimal a,BigDecimal b){
        if(a == null){
            a = BigDecimal.ZERO;
        }
        if(b == null){
            b = BigDecimal.ZERO;
        }
        return a.add(b);
    }

    public static Double convertToDouble(BigDecimal a){
        if(isEmpty(a)){
            return null;
        }
        return a.doubleValue();
    }

    public static BigDecimal subtract(BigDecimal a,BigDecimal b){
        if(a == null){
            a = BigDecimal.ZERO;
        }
        if(b == null){
            b = BigDecimal.ZERO;
        }
        return a.subtract(b);
    }

    public static BigDecimal multiply(BigDecimal a,Integer b){
        BigDecimal c = BigDecimal.ZERO;
        if(a== null || b == null){
            return BigDecimal.ZERO;
        }
        return a.multiply(new BigDecimal(b));
    }

    public static BigDecimal multiply(BigDecimal a,Long b){
        BigDecimal c = BigDecimal.ZERO;
        if(a== null || b == null){
            return BigDecimal.ZERO;
        }
        return a.multiply(new BigDecimal(b));
    }

    /**
     * BigDecimal相乘
     *
     * @param bigDecimals
     * @return bigDecimals 相加后的值
     */
    public static BigDecimal multiply(BigDecimal... bigDecimals) {
        if (bigDecimals==null||bigDecimals.length==0) {
            return null;
        }
        return multiply(Arrays.asList(bigDecimals));
    }

    /**
     * BigDecimal相乘
     *
     * @param bigDecimals
     * @return bigDecimals 相加后的值
     */
    public static BigDecimal multiply(List<BigDecimal> bigDecimals) {
        if (!ListUtils.anyList(bigDecimals)) {
            return null;
        }
        return bigDecimals.stream().filter(bigDecimal -> bigDecimal != null).reduce(BigDecimal::multiply).orElse(BigDecimal.ZERO);
    }

    /**
     * BigDecimal相乘
     *
     * @param scale        精度，小数保留位数
     * @param roundingMode 精度舍入模式 {@link RoundingMode}
     * @param bigDecimals
     * @return bigDecimals 相加保留进度后的值
     */
    public static BigDecimal multiply(int scale, RoundingMode roundingMode, BigDecimal... bigDecimals) {
        return multiply(scale, roundingMode,Arrays.asList(bigDecimals));
    }

    public static BigDecimal multiply(BigDecimal a,BigDecimal b){
         if(a== null){
             a = BigDecimal.ZERO;
         }
        if(b== null){
            b = BigDecimal.ZERO;
        }
        return a.multiply(b);
    }

    /**
     * BigDecimal相乘
     *
     * @param scale        精度，小数保留位数
     * @param roundingMode 精度舍入模式 {@link RoundingMode}
     * @param bigDecimals
     * @return bigDecimals 相加保留进度后的值
     */
    public static BigDecimal multiply(int scale, RoundingMode roundingMode, List<BigDecimal> bigDecimals) {
        BigDecimal multiplyResult = multiply(bigDecimals);
        if (roundingMode == null) {
            return multiplyResult;
        }
        return multiplyResult == null ? null : multiplyResult.setScale(scale, roundingMode);
    }

    /**
     * 除法
     * @param a
     * @param b
     * @return
     */
    public static BigDecimal divide(BigDecimal a,Integer b){
        if(IntegerUtil.isEmpty(b)){
            return BigDecimal.ZERO;
        }
        return a.divide(new BigDecimal(b),2);
    }

    public static Double convertDouble(BigDecimal a){
        if(isEmpty(a)){
            return 0d;
        }
        return a.doubleValue();
    }


    /**
     * 字符串转为 BigDecimal
     * @param a
     * @return
     */
    public static BigDecimal convertStringToBigDecimal(String a){
        if(StringUtils.isEmpty(a)){
            return BigDecimal.ZERO;
        }
        return new BigDecimal(a.trim());
    }

    public static boolean isEmpty(BigDecimal a){
        if(a == null || a.equals(BigDecimal.ZERO) || a.doubleValue() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(divide(new BigDecimal(15.12),100));
//        System.out.println(isEmpty(null));
//        System.out.println(isEmpty(new BigDecimal("0.0000")));
//        System.out.println(new BigDecimal(-1));
//        System.out.println(compare(new BigDecimal(-1),BigDecimal.ZERO));
//        System.out.println(moreThanZero(new BigDecimal(1)));
    }



}
