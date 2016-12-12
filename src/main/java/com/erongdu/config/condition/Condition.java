package com.erongdu.config.condition;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.rule.Rule;
import com.erongdu.utils.ConditionOpt;

/**
 * Created by syq on 2016/12/11.
 */
public interface Condition<T, O extends Rule<T>, B extends RuleBuilder<T, O>, H extends RuleConfigurerAdapter<T, O, B>> {

    /**
     * 设置操作符
     *
     * @param opt
     * @return
     */
    Condition<T, O, B, H> opt(ConditionOpt opt);


    /**
     * 设置条件的值
     *
     * @param t
     * @return
     */
    Condition<T, O, B, H> value(T t);


    /**
     * 返回构造器实例
     *
     * @return
     */
    B finish();


    /**
     * 返回configurer实例
     *
     * @return
     */
    H then();

}
