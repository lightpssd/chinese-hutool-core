package cn.light.chutool.utils;

/**
 * ClassName: Main
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/
public class Main {


    public static void main(String[] args) {
        Object a = 字符序列流式加工线.放入字符序列("1234")
                .执行加工当条件满足时(r -> true, r->r+"A")
                .执行加工当条件满足时(r -> true, r->r+"B")
                .重复动作(4,20)
                .执行().拿到加工历史();

        System.out.println(a);

    }
}
