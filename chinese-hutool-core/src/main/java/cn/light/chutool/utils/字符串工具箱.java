package cn.light.chutool.utils;

import cn.hutool.core.util.StrUtil;

/**
 * ClassName: 字符串工具箱
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/

public class 字符串工具箱 {
    public final static String 填充字符_空格 = " ";
    public final static String 填充字符_零 = "0";
    public final static String 填充字符_空 = "";
    public final static String 填充字符_NULL = "null";

    public static String 填充字符串到右边(String 源字符串, char 填充字符, int 长度) {
        return StrUtil.fillBefore(源字符串, 填充字符, 长度);
    }

    public static String 填充字符串到左边(String 源字符串, char 填充字符, int 长度) {
        return StrUtil.fillAfter(源字符串, 填充字符, 长度);
    }

    public static String 填充字符串到两边(String 源字符串, char 填充字符, int 长度) {
        return 填充字符串到右边(填充字符串到左边(源字符串, 填充字符, 长度), 填充字符, 长度);
    }

    public static String 格式化通过占位符(String 源字符串, String 填充字符串, int 长度) {
        return StrUtil.padPre(源字符串, 长度, 填充字符串);
    }

}
