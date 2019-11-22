package cn.teek.base.utils;

/**
 * 字符串工具类
 */
public class StringUtils {
    /**
     * 把输入转成非null的字符串
     * @param text 原始字符串
     * @return
     */
    public static String toNotNullStr(String text) {
        if (text == null)
            return "";
        return text;
    }
}
