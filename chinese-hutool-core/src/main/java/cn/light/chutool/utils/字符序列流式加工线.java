package cn.light.chutool.utils;

import cn.hutool.core.collection.CollUtil;
import cn.light.chutool.utils.core.字符序列加工模块接口;
import cn.light.chutool.utils.core.字符序列加工线;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: 字符序列流式加工线
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/
public class 字符序列流式加工线 implements 字符序列加工线 {

    public CharSequence 加工字符序列;
    protected final 字符序列流式加工线 前置加工功能;

    public 字符序列流式加工线(CharSequence 加工字符序列) {
        this.前置加工功能 = null;
        this.加工字符序列 = 加工字符序列;
    }

    private 字符序列流式加工线(字符序列流式加工线 前置加工功能) {
        this.前置加工功能 = 前置加工功能;
    }

    public static 字符序列加工线 放入字符序列(CharSequence 加工字符序列) {
        return new 字符序列流式加工线(加工字符序列);
    }

    public 字符序列加工线 添加前缀当前缀不存在(CharSequence 前缀){
        return 建造字符序列加工线(字符序列加工模块接口.添加前缀当前缀不存在(前缀));
    }
    public 字符序列加工线 添加后缀当后缀不存在(CharSequence 前缀){
        return 建造字符序列加工线(字符序列加工模块接口.添加后缀当后缀不存在(前缀));
    }
    public 字符序列加工线 重复动作(int 重复之前多少个步骤, int 重复次数) {
        return new 字符序列流式加工线(this) {
            @Override
            public CharSequence 执行功能(CharSequence 加工字符序列) {
                assert this.前置加工功能 != null;
                ArrayList<字符序列流式加工线> 历史步骤 = new ArrayList<>();
                字符序列流式加工线 前加工 = this.前置加工功能;
                for (int j = 0; j < 重复之前多少个步骤; j++) {
                    if (前加工 == null) {
                        break;
                    }
                    历史步骤.add(前加工);
                    前加工 = 前加工.前置加工功能;
                }
                List<字符序列流式加工线> reverse = CollUtil.reverse(历史步骤);
                for (int i = 0; i < 重复次数; i++) {
                    for (字符序列流式加工线 加工线 : reverse) {
                        加工字符序列 = 加工线.执行功能(加工字符序列);

                    }
                }
                return 加工字符序列;
            }
        };
    }

    @Override
    public 字符序列加工线 执行加工当条件满足时(Predicate<CharSequence> 条件方法, 字符序列加工模块接口 加工模块) {
        return new 字符序列流式加工线(this) {
            @Override
            public CharSequence 执行功能(CharSequence 加工字符序列) {
                if (条件方法.test(加工字符序列)) {
                    return 加工模块.加工(加工字符序列);
                }
                return 加工字符序列;
            }
        };
    }

    @Override
    public 字符序列加工线 执行加工(字符序列加工模块接口 加工模块) {
        return new 字符序列流式加工线(this) {
            @Override
            public CharSequence 执行功能(CharSequence 加工字符序列) {
                return 加工模块.加工(加工字符序列);
            }
        };
    }


    字符序列加工线 建造字符序列加工线(字符序列加工模块接口 字符序列加工模块) {
        return new 字符序列流式加工线(this) {
            @Override
            public CharSequence 执行功能(CharSequence 加工字符序列) {

                return 字符序列加工模块.加工(加工字符序列);
            }
        };
    }


    /**
     * Description:
     * 对字符序列进行之前预定的操作
     */
    public 字符序列加工线 执行() {
        if (this.前置加工功能 != null) {
            this.前置加工功能.执行();
            this.加工字符序列 = 执行功能(this.前置加工功能.加工字符序列);
        } else {
            this.加工字符序列 = 执行功能(this.加工字符序列);
        }
        return this;
    }

    public CharSequence 拿出字符序列() {
        if (this.加工字符序列 == null) {
            return null;
        }
        return this.加工字符序列;
    }

    public CharSequence 执行然后拿出字符序列() {
        return 执行().拿出字符序列();
    }

    public 字符序列加工线 快照() {
        System.out.println(执行然后拿出字符序列());
        return this;
    }

    public List<CharSequence> 拿到加工历史() {
        字符序列流式加工线 前加工 = this;
        List<CharSequence> 加工历史 = new ArrayList<>();
        while (前加工 != null) {
            加工历史.add(前加工.加工字符序列);
            前加工 = 前加工.前置加工功能;
        }
        return CollUtil.reverse(加工历史);
    }

    public CharSequence 执行功能(CharSequence 加工字符序列) {
        return 加工字符序列;
    }
}
