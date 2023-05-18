package cn.light.chutool.utils.core;

import cn.hutool.core.util.StrUtil;

/**
 * ClassName: 字符序列加工模块接口
 * Author: 光子
 * Date:  2023/5/17
 * Project chutool
 **/
public interface 字符序列加工模块接口 {


    static 字符序列加工模块接口 填充字符到两边(char 填充字符, int 长度) {
        return 源字符串 -> {
            if (长度 < 源字符串.length()) return 源字符串.toString();
            int 长度一半 = (长度 - 源字符串.length()) / 2;
            return StrUtil.fillAfter(StrUtil.fillBefore(源字符串.toString(), 填充字符, 长度一半 + 源字符串.length()), 填充字符, 长度);
        };
    }


    String 加工(CharSequence 源字符串);

    static 字符序列加工模块接口 填充字符到右边(char 填充字符, int 长度) {
        return 源字符串 -> StrUtil.fillAfter(源字符串.toString(), 填充字符, 长度);
    }

    static 字符序列加工模块接口 填充字符到左边(char 填充字符, int 长度) {
        return 源字符串 -> StrUtil.fillBefore(源字符串.toString(), 填充字符, 长度);
    }
    static 字符序列加工模块接口 添加前缀当前缀不存在(CharSequence 前缀) {
        return 源字符串 -> StrUtil.addPrefixIfNot(源字符串.toString(), 前缀);
    }
    static 字符序列加工模块接口 添加后缀当后缀不存在(CharSequence 后缀) {
        return 源字符串 -> StrUtil.addSuffixIfNot(源字符串.toString(), 后缀);
    }
}
