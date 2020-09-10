package com.baomidou.mybatisplus.samples.generator.utils;

import java.util.List;
import java.util.Set;

public class ListUtils {

    public static <T> boolean anyList(List<T> list){
        return list != null && list.size() > 0;
    }
    public static <T> boolean isEmpty(List<T> list){
        return list == null || list.size() == 0;
    }
    public static <T> boolean anySet(Set<T> list){
        return list != null && list.size() > 0;
    }
    /**
     * 使用list自带的sort方法先进性排序，然后转成toString去判断两个集合是否相等
     * 方法6
     */
    public static boolean isListEqual(List l0, List l1) {
        if (l0 == l1)
            return true;
        if (l0 == null && l1 == null)
            return true;
        if (l0 == null || l1 == null)
            return false;
        if (l0.size() != l1.size())
            return false;
        if (l0.containsAll(l1) && l1.containsAll(l0)) {
            return true;
        }
        return false;
    }
}
