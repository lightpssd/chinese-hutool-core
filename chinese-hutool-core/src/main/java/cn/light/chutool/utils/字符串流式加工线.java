package cn.light.chutool.utils;

import cn.light.chutool.utils.core.字符串加工模块接口;
import cn.light.chutool.utils.core.字符串加工线;

import java.util.function.Function;

/**
 * ClassName: 字符串流式加工线
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/
public class 字符串流式加工线 implements 字符串加工线 {

    public CharSequence 加工字符串;
    protected final 字符串流式加工线 前置加工功能;
    private 字符串流式加工线(CharSequence 加工字符串){
        this.前置加工功能 = null;
        this.加工字符串 =加工字符串;
    }
    private 字符串流式加工线(字符串流式加工线 前置加工功能){
        this.前置加工功能 = 前置加工功能;
    }
    public static 字符串加工线 放入字符串(CharSequence 加工字符串){
        return new 字符串流式加工线(加工字符串);
    }

    @Override
    public 字符串加工线 填充字符到右边(char 填充字符, int 长度) {
        return 建造字符串加工线(字符串加工模块接口.填充字符到右边(填充字符,长度));
    }

    @Override
    public 字符串加工线 填充字符到左边(char 填充字符, int 长度) {
        return 建造字符串加工线(字符串加工模块接口.填充字符到左边(填充字符,长度));
    }

    @Override
    public 字符串加工线 填充字符到两边(char 填充字符, int 长度) {
        return 建造字符串加工线(字符串加工模块接口.填充字符到两边(填充字符,长度));
    }

    @Override
    public 字符串加工线 执行功能当条件满足时(Function<CharSequence, Boolean> 条件方法, 字符串加工模块接口 加工模块) {
        return new 字符串流式加工线(this){
            @Override
            public CharSequence 执行功能() {
                assert this.前置加工功能 != null;
                if (条件方法.apply(this.前置加工功能.加工字符串)){
                    return 加工模块.加工(this.前置加工功能.加工字符串);
                }
                    return 加工模块.加工(this.前置加工功能.加工字符串);
                }

            };
        };


    public 字符串加工线 建造字符串加工线(字符串加工模块接口 字符串加工模块){
        return new 字符串流式加工线(this){
            @Override
            public CharSequence 执行功能() {
                assert this.前置加工功能 != null;
                return 字符串加工模块.加工(this.前置加工功能.加工字符串);
            }
        };
    }


    /**
     * Description:
     * 对字符串进行之前预定的操作
     */
    public void 执行() {
        if (this.前置加工功能 != null) {
            this.前置加工功能.执行();
        }
        this.加工字符串 =执行功能();
        System.out.println(加工字符串);
    }
    public CharSequence 执行功能() {
        return this.加工字符串;
    }
}
