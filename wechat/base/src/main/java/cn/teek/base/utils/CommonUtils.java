package cn.teek.base.utils;

import java.util.List;

/**
 * 常用工具类，一些不好归类的方法放到此处
 */
public class CommonUtils {
    /**
     * 判断list是否为空
     * @param list
     * @return
     */
    public static boolean isListEmpty(List list) {
        if (list == null || list.isEmpty()) return true;
        return false;
    }

}
