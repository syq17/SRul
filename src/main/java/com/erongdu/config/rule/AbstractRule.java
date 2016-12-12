package com.erongdu.config.rule;

import com.erongdu.config.build.RuleBuilder;
import com.erongdu.config.build.RuleConfigurerAdapter;
import com.erongdu.config.condition.Condition;
import com.erongdu.utils.RulePolicy;

import java.util.List;

/**
 * Created by syq on 2016/12/12.
 */
public abstract class AbstractRule<T> implements Rule<T> {


    public AbstractRule(List<Condition<T, O, B, H>> conditions, RulePolicy policy) {
        this.conditions = conditions;
        this.policy = policy;
    }

    protected List<Condition<T, O , B, H>> conditions;


    protected RulePolicy policy;





    @Override
    public <O extends Rule<T>, B extends RuleBuilder<T, O>, H extends RuleConfigurerAdapter<T, O, B>> void conditions
            (List<Condition<T, O, B, H>> conditions) {
        this.conditions = conditions;
    }

    @Override
    public void policy(RulePolicy rulePolicy) {
        this.policy = rulePolicy;
    }

}
