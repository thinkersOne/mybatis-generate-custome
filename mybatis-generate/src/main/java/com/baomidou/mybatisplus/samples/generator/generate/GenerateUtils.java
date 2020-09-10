package com.baomidou.mybatisplus.samples.generator.generate;

import com.baomidou.mybatisplus.samples.generator.utils.StringUtil;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateUtils {


    /**
     * 驼峰转  -
     * @param humpString
     * created by hbd 20160722
     * @return
     */
    public static String humpToUnderline(String humpString) {
        if(StringUtils.isEmpty(humpString)) return "";
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(humpString);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "-" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 获取 最后一个点后面 的对象
     * 如：com.chengju.common.dao.model.DictItem
     * 调用方法后获取 DictItem
     * @param name
     * @return
     */
    public static String getLastString(String name){
        if(StringUtils.isEmpty(name)){
            return "";
        }
        String[] strings = name.split("\\.");
        if(strings == null || strings.length == 0){
            return "";
        }
        return strings[strings.length - 1];
    }

    /**
     * 获取 对象new的过程
     * @param modelName
     * @return
     */
    public static String generateModelNew(String modelName){
        if(StringUtils.isEmpty(modelName)){
            return "";
        }
        return modelName+" "+ "entity" + " " +"=" + " "+ "new" + " "+ modelName +"();";
    }

    public static String generateSetFiled(String fieldName){
        if(StringUtils.isEmpty(fieldName)){
            return "";
        }
        return "entity.set"+ StringUtil.firstStringToUpper(fieldName)+"();";
    }

    public static String generateSetFiledDefault(String fieldName,String value){
        if(StringUtils.isEmpty(fieldName)){
            return "";
        }
        return "entity.set"+ StringUtil.firstStringToUpper(fieldName)+"("+ value +");";
    }



    public static void main(String[] args) {
//        System.out.println(humpToUnderline("importOuterCode"));
//        System.out.println(captureName("importOuterCode"));

//        System.out.println(getLastString("com.chengju.common.dao.model.DictItem"));

        System.out.println(generateModelNew("DictItem"));
//        System.out.println("id".toUpperCase());
        System.out.println(generateSetFiled("sysOrgRegionId"));

    }
}
