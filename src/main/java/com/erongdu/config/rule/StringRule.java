package com.erongdu.config.rule;

import com.erongdu.config.condition.Condition;
import com.erongdu.utils.RulePolicy;

import java.util.List;

/**
 * 一个简单的字符串规则实体表达类
 * 该规则中只能对一个字符串含义的规则字段进行设置
 * 只有
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by syq on 2016/12/11.
 */
public final class StringRule extends AbstractRule<String>{


    @Override
    public boolean result() {
        return false;
    }

    @Override
    public void match(String s) {

    }
}
