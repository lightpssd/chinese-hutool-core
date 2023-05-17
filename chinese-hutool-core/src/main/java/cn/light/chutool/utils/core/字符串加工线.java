package cn.light.chutool.utils.core;

import java.util.function.Function;

/**
 * ClassName: 字符串加工线
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/
public interface 字符串加工线  {

    字符串加工线 填充字符到右边(char 填充字符,int 长度);
    字符串加工线 填充字符到左边(char 填充字符,int 长度);
    字符串加工线 填充字符到两边(char 填充字符,int 长度);

    字符串加工线 执行功能当条件满足时(Function<CharSequence,Boolean> 条件方法, 字符串加工模块接口 加工模块);


    void 执行();
}
