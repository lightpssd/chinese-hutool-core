package cn.light.chutool.utils.core;

/**
 * ClassName: 字符串加工线
 * Author: 光子
 * Date:  2023/5/18
 * Project chutool
 **/
public interface 字符串加工线 extends 字符序列加工线{
    字符串加工线 填充字符到左边(char 填充字符, int 长度);
    字符串加工线 填充字符到两边(char 填充字符, int 长度);
    字符串加工线 填充字符到右边(char 填充字符, int 长度);
}
