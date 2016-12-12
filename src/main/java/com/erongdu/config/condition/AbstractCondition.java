package com.erongdu.config.condition;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.rule.Rule;
import com.erongdu.utils.ConditionOpt;

/**
 * Created by syq on 2016/12/12.
 */
public class AbstractCondition<T, O extends Rule<T>, B extends RuleBuilder<T, O>, H extends RuleConfigurerAdapter<T, O, B>> implements Condition<T, O, B, H> {


    protected ConditionOpt conditionOpt;


    protected T value;

    private B builder;

    private H configurer;


    @Override
    public Condition<T, O, B, H> opt(ConditionOpt opt) {
        this.conditionOpt = opt;
        return this;
    }


    @Override
    public Condition<T, O, B, H> value(T t) {
        this.value = t;
        return this;
    }

    @Override
    public B finish() {
        return builder;
    }

    @Override
    public H then() {
        return null;
    }

    public void setRuleBuilder(B builder) {
        this.builder = builder;
    }

    public void setConfigurer(H configurer) {
        this.configurer = configurer;
    }


    public ConditionOpt getConditionOpt() {
        return conditionOpt;
    }


    public T getValue() {
        return value;
    }
}
