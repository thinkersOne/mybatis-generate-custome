package com.baomidou.mybatisplus.samples.generator.utils;

import java.util.regex.Pattern;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   liuming
 * 创建时间: 14:31 2018/4/23
 * 功能描述:
 * 修改历史:
 */
public class MailRegex {
    public static boolean check(String email) {
        String regex = "[\\w\\.]+@[\\w-]+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    //测试数据
    public static void main(String[] args){
        String mail = "383673252@163.com.cn";
        if(!MailRegex.check(mail)){
            System.out.print("这是对的");
        }
    }
}
