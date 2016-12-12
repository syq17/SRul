package com.erongdu.config.condition;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.rule.Rule;
import com.erongdu.utils.ConditionOpt;

/**
 * Created by syq on 2016/12/11.
 */
public interface Condition<T> {

    /**
     * 设置操作符
     *
     * @param opt
     * @return
     */
    Condition<T> opt(ConditionOpt opt);


    /**
     * 设置条件的值
     *
     * @param t
     * @return
     */
    Condition<T> value(T t);


    ConditionOpt getOpt();


    T getValue();

    /**
     * 返回构造器实例
     *
     * @return
     */
//    B finish();


    /**
     * 返回configurer实例
     *
     * @return
     */
//    H then();

}
