package com.baomidou.mybatisplus.samples.generator.generate;

import com.baomidou.entity.RmsDriverEntity;
import com.baomidou.mybatisplus.samples.generator.utils.ListUtils;
import com.baomidou.mybatisplus.samples.generator.utils.ReflectUtil;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class GenerateModelCode {

    public static void printEntityAllSetMethod(Class<?> clazz){
        List<Field> listField = ReflectUtil.getListField(clazz);
        if(!ListUtils.anyList(listField)){
            return;
        }
        String entityName = GenerateUtils.getLastString(clazz.getName());
        System.out.println(GenerateUtils.generateModelNew(entityName));
        listField.stream().forEach(v->{
            if("createUser".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"\"admin\""));
            }else if("updateUser".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"\"admin\""));
            }else if("createTime".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"new Date()"));
            }else if("updateTime".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"new Date()"));
            }else if("tenantId".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"0L"));
            }else if("id".equals(v.getName())){
                System.out.println(GenerateUtils.generateSetFiledDefault(v.getName(),"generator.nextId()"));
            }else{
                System.out.println(GenerateUtils.generateSetFiled(v.getName()));
            }
        });
    }

    public static void main(String[] args) {
//        System.out.println(new Date().toString());
        printEntityAllSetMethod(RmsDriverEntity.class);
    }

}
