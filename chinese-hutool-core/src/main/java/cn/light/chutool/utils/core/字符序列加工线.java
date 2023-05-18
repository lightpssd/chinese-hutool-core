package cn.light.chutool.utils.core;

import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: 字符序列加工线
 * Author: 光子
 * Date:  2023/5/17
 * Project chinese-hutool
 **/
public interface 字符序列加工线 {

    字符序列加工线 执行加工当条件满足时(Predicate<CharSequence> 条件方法, 字符序列加工模块接口 加工模块);
    字符序列加工线 执行加工(字符序列加工模块接口 加工模块);
    字符序列加工线 执行();
    字符序列加工线 重复动作(int 重复之前多少个步骤, int 重复次数);
    字符序列加工线 添加前缀当前缀不存在(CharSequence 前缀);
    CharSequence 执行然后拿出字符序列();
    CharSequence 拿出字符序列();
    字符序列加工线 快照();
    List<CharSequence> 拿到加工历史();

}
