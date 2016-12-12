package com.erongdu.config.rule;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.condition.Condition;
import com.erongdu.utils.RulePolicy;

import java.util.List;

/**
 * 规则类总接口
 * Created by syq on 2016/12/11.
 */
public interface Rule<T> {


    /**
     * 传入待验证的值，由实现类来决定是否匹配规则
     *
     * @return
     */
    public boolean result();


    /**
     * 需要去验证的值
     *
     * @param t
     */
    public void match(T t);


    /**
     * 设置所有的条件
     *
     * @param conditions
     */
    public <O extends Rule<T>, B extends RuleBuilder<T, O>, H extends RuleConfigurerAdapter<T, O, B>> void conditions
    (List<Condition<T, O, B, H>> conditions);


    /**
     * 设置匹配策略
     *
     * @param rulePolicy
     */
    public void policy(RulePolicy rulePolicy);


}
