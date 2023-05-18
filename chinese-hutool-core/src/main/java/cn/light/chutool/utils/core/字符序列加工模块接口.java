package cn.light.chutool.utils.core;

import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.DesensitizedUtil;
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


    CharSequence 加工(CharSequence 源字符串);

    static 字符序列加工模块接口 填充字符到右边(char 填充字符, int 长度) {
        return 源字符串 -> StrUtil.fillAfter(源字符串.toString(), 填充字符, 长度);
    }

    static 字符序列加工模块接口 填充字符到左边(char 填充字符, int 长度) {
        return 源字符串 -> StrUtil.fillBefore(源字符串.toString(), 填充字符, 长度);
    }

    static 字符序列加工模块接口 添加前缀当前缀不存在(CharSequence 前缀) {
        return 源字符串 -> StrUtil.addPrefixIfNot(源字符串, 前缀);
    }

    static 字符序列加工模块接口 添加后缀当后缀不存在(CharSequence 后缀) {
        return 源字符串 -> StrUtil.addSuffixIfNot(源字符串, 后缀);
    }

    static 字符序列加工模块接口 添加后缀当后缀不属于后缀列表(CharSequence 后缀, boolean 忽略大小写, CharSequence... 后缀列表) {
        return 源字符串 -> StrUtil.appendIfMissing(源字符串, 后缀, 忽略大小写, 后缀列表);
    }

    static 字符序列加工模块接口 添加后缀当后缀不属于后缀列表(CharSequence 后缀, CharSequence... 后缀列表) {
        return 源字符串 -> StrUtil.appendIfMissing(源字符串, 后缀, 后缀列表);
    }

    static 字符序列加工模块接口 添加后缀当忽略大小写的后缀不属于后缀列表(CharSequence 后缀, CharSequence... 后缀列表) {
        return 源字符串 -> StrUtil.appendIfMissingIgnoreCase(源字符串, 后缀, 后缀列表);
    }

    static 字符序列加工模块接口 返回默认值当源字符串为空或空白(String 默认值) {
        return 源字符串 -> StrUtil.blankToDefault(源字符串, 默认值);
    }

    static 字符序列加工模块接口 返回默认值当源字符串为空(String 默认值) {
        return 源字符串 -> StrUtil.emptyToDefault(源字符串, 默认值);
    }

    static 字符序列加工模块接口 转换字符串为短形式(int 最大长度) {
        return 源字符串 -> StrUtil.brief(源字符串, 最大长度);
    }

    static 字符序列加工模块接口 居中字符串(int 长度) {
        return 源字符串 -> StrUtil.center(源字符串, 长度);
    }

    static 字符序列加工模块接口 居中字符串(int 长度, char 填充字符) {
        return 源字符串 -> StrUtil.center(源字符串, 长度, 填充字符);
    }

    static 字符序列加工模块接口 清理空白字符() {
        return StrUtil::cleanBlank;
    }

    static 字符序列加工模块接口 公共前缀(CharSequence 目标字符串) {
        return 源字符串 -> StrUtil.commonPrefix(源字符串, 目标字符串);
    }

    static 字符序列加工模块接口 公共后缀(CharSequence 目标字符串) {
        return 源字符串 -> StrUtil.commonSuffix(源字符串, 目标字符串);
    }

    static 字符序列加工模块接口 连接字符串(boolean 是否转换null为空白, CharSequence... 目标字符串) {
        return 源字符串 -> {
            CharSequence[] charSequences = new CharSequence[目标字符串.length + 1];
            ArrayUtil.copy(目标字符串, 0, charSequences, 1, 目标字符串.length);
            charSequences[0] = 源字符串;
            return StrUtil.concat(是否转换null为空白, charSequences);
        };
    }

    static 字符序列加工模块接口 脱敏(DesensitizedUtil.DesensitizedType 脱敏策略) {
        return 源字符串 -> StrUtil.desensitized(源字符串, 脱敏策略);
    }

    static 字符序列加工模块接口 转换null为空() {
        return StrUtil::emptyIfNull;
    }
    static 字符序列加工模块接口 转换空或空白为默认(String 默认值) {
        return 源字符串 -> StrUtil.emptyToDefault(源字符串,默认值);
    }
    static 字符序列加工模块接口 转换空为null() {
        return StrUtil::emptyToNull;
    }
    static 字符序列加工模块接口 过滤字符串( Filter<Character> 字符过滤器) {
        return 源字符串 -> StrUtil.filter(源字符串,字符过滤器);
    }



}
