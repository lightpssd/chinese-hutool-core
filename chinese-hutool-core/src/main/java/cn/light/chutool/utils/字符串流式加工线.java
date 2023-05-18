//package cn.light.chutool.utils;
//
//import cn.light.chutool.utils.core.字符串加工线;
//import cn.light.chutool.utils.core.字符序列加工模块接口;
//import cn.light.chutool.utils.core.字符序列加工线;
//
///**
// * ClassName: 字符串流式加工线
// * Author: 光子
// * Date:  2023/5/18
// * Project chutool
// **/
//public class 字符串流式加工线 extends 字符序列流式加工线 implements 字符串加工线 {
//    public 字符串流式加工线(String 加工字符序列) {
//        super(加工字符序列);
//    }
//    private 字符串流式加工线(字符串流式加工线 前置加工功能) {
//        super(前置加工功能);
//    }
//    public static 字符序列加工线 放入字符串(CharSequence 加工字符序列) {
//        return new 字符序列流式加工线(加工字符序列);
//    }
//    @Override
//    public 字符串加工线 填充字符到左边(char 填充字符, int 长度) {
//        return 建造字符串加工线(字符序列加工模块接口.填充字符到左边(填充字符, 长度));
//    }
//
//    @Override
//    public 字符串加工线 填充字符到两边(char 填充字符, int 长度) {
//        return 建造字符串加工线(字符序列加工模块接口.填充字符到两边(填充字符, 长度));
//    }
//    @Override
//    public 字符串加工线 填充字符到右边(char 填充字符, int 长度) {
//        return 建造字符串加工线(字符序列加工模块接口.填充字符到右边(填充字符, 长度));
//    }
//    protected 字符串加工线 建造字符串加工线(字符序列加工模块接口 字符序列加工模块) {
//        return new 字符序列流式加工线(this) {
//            @Override
//            public CharSequence 执行功能() {
//                assert this.前置加工功能 != null;
//                return 字符序列加工模块.加工(this.前置加工功能.加工字符序列);
//            }
//        };
//    }
//
//}
