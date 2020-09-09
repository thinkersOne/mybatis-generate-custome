package com.baomidou.mybatisplus.samples.generator.utils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtil {

    public static boolean isNullOrEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    public static String camelhumpToUnderline(String str) {
        char[] chars = str.toCharArray();
        int size = chars.length;
        StringBuilder sb = new StringBuilder(size * 3 / 2 + 1);
        for (int i = 0; i < size; ++i) {
            char c = chars[i];
            if (isUppercaseAlpha(c)) {
                sb.append('_').append(toLowerAscii(c));
            } else {
                sb.append(c);
            }
        }
        return sb.charAt(0) == '_' ? sb.substring(1) : sb.toString();
    }

    public static boolean isUppercaseAlpha(char c) {
        return c >= 'A' && c <= 'Z';
    }
    public static char toLowerAscii(char c) {
        if (isUppercaseAlpha(c)) {
            c = (char) (c + 32);
        }

        return c;
    }
    /**
     * 转换unicode字符集
     *
     * @param s 包含unicode的字符串
     * @return 格式化后的字符串
     */
    public static String toUnicodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                sb.append("\\u" + Integer.toHexString(c));
            }
        }
        return sb.toString();
    }

    /**
     * 获取中划线格式的名称
     * @param inputString
     * @return
     */
    public static String getMiddleLineName(String inputString) {
        return inputString.replace("_", "-");
    }

    public static String getPackage(String inputString){
        return inputString.replace("_",".");
    }

    /**
     * <p>
     * 拼接字符串第二个字符串第一个字母大写
     * </p>
     *
     * @param concatStr
     * @param str
     * @return
     */
    public static String concatCapitalize(String concatStr, final String str) {
        if (StringUtils.isBlank(concatStr)) {
            concatStr = "";
        }
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        final char firstChar = str.charAt(0);
        if (Character.isTitleCase(firstChar)) {
            // already capitalized
            return str;
        }

        StringBuilder sb = new StringBuilder(strLen);
        sb.append(concatStr);
        sb.append(Character.toTitleCase(firstChar));
        sb.append(str.substring(1));
        return sb.toString();
    }

    /**
     * 格式化驼峰命名字符串
     *
     * @param inputString             未格式化的字符串
     * @param firstCharacterUppercase 首字母是否大写
     * @return 格式化后的字符串
     */
    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
                case '_':
                case '-':
                case '@':
                case '$':
                case '#':
                case ' ':
                case '/':
                case '&':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;

                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    /**
     * 字符串首字母大写
     * @param str
     * @return
     */
    public static String firstStringToUpper(String str){
        if(StringUtil.isNullOrEmpty(str)){
            return "";
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String filterEmoji(String source) {
        if (StringUtils.isNotBlank(source)) {
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
        } else {
            return source;
        }
    }

    /**
     * 将 字符串 转化为 集合 ，专门处理 字符串中 用"," 或 "，" 分割的
     * @param keyword
     * @return
     */
    public static List<String> convertToList(String keyword){
        if(org.springframework.util.StringUtils.isEmpty(keyword)){
            return new ArrayList<>();
        }
        return Arrays.asList(keyword.split("[,，]"));
    }

    /**
     * 转大写
     * @param str
     * @return
     */
    public static String toUpperCase(String str){
        if(StringUtil.isNullOrEmpty(str)){
            return "";
        }
        return str.toUpperCase();
    }

    /**
     * 校验 字符 s是否超过指定 len长度
     * @param s
     * @param len
     * @return
     */
    public static boolean checkLen(String s,int len){
        if(StringUtil.isNullOrEmpty(s)){
            return false;
        }
        return s.length() > len;
    }

    /**
     * 校验燃油车
     * 车牌号 是否 合规
     * true： 合规
     * false： 不合规
     * @param license
     * @return
     */
    public static boolean checkFuelVehicle(String license) {
        if (org.springframework.util.StringUtils.isEmpty(license)) {
            return false;
        }
        //车牌号 不得出现 字母 I 和 O
        if(license.indexOf("I") > -1 || license.indexOf("O") > -1){
            return false;
        }
        String regex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂]{1}$";
        return Pattern.matches(regex, license);
    }

    /**
     * 校验新能源车
     * @param license
     * @return
     */
    public static boolean checkNewEnergyVehicle(String license) {
        if (org.springframework.util.StringUtils.isEmpty(license)) {
            return false;
        }
        //车牌号 不得出现 字母 I 和 O
        if(license.indexOf("I") > -1 || license.indexOf("O") > -1){
            return false;
        }
        String regex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领]{1}[A-Z]{1}[A-Z0-9]{5}[A-Z0-9挂]{1}$";
        return Pattern.matches(regex, license);
    }

    public static void main(String[] args) {
//        String license = "沪WKJ2225";
//        System.out.println(checkFuelVehicle(license));
//        System.out.println(checkNewEnergyVehicle(license));

//        String id = getCamelCaseString("iphone", true);
//        System.out.println(id);

        System.out.println(firstStringToUpper("sysOrgRegionId"));

    }

}
