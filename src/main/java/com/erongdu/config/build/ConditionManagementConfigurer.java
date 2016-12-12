package com.erongdu.config.build;

import com.erongdu.config.condition.AbstractCondition;
import com.erongdu.config.condition.Condition;
import com.erongdu.config.rule.Rule;
import com.erongdu.exception.RuleBuildException;
import com.erongdu.utils.ConditionOpt;
import com.erongdu.utils.RulePolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Condition 管理配置类
 * 该类将对具体的condition进行配置
 * 每个condition都会包括：具体的操作符(">")，具体待匹配的字段名称("age")，条件值("30")
 * Created by syq on 2016/12/9.
 */
//public final class ConditionManagementConfigurer<H extends RuleBuilder<H>>
//        extends AbstractConditionConfigurer<ConditionManagementConfigurer<H>, H> {
//
//
//    public ConditionManagementConfigurer() {
//
//    }
//
//
//    public ConditionManagementConfigurer<H> sessionCreationPolicy(SessionCreationPolicy sessionCreationPolicy) {
//        Assert.notNull(sessionCreationPolicy, "sessionCreationPolicy cannot be null");
//        this.sessionPolicy = sessionCreationPolicy;
//        return this;
//    }
//
//
//}


public final class ConditionManagementConfigurer<H, O extends Rule<H>, B extends RuleBuilder<H, O>> extends RuleConfigurerAdapter<H, O, B> {


    private List<Condition<H, O, B, ConditionManagementConfigurer<H, O, B>>> conditions = new ArrayList<>();


    List<Condition<H, O, B, ConditionManagementConfigurer<H, O, B>>> getConditions() {
        return conditions;
    }

    public Condition<H, O, B, ConditionManagementConfigurer<H, O, B>> createCondition() throws InstantiationException, IllegalAccessException {
        AbstractCondition<H, O, B, ConditionManagementConfigurer<H, O, B>> condition = new AbstractCondition<>();
        condition.setRuleBuilder(getBuilder());
        condition.setConfigurer(this);
        conditions.add(condition);
        return condition;
    }


    public B createConditions(Map<String, H> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            AbstractCondition<H, O, B, ConditionManagementConfigurer<H, O, B>> condition = new AbstractCondition<>();
            condition.setRuleBuilder(getBuilder());
            condition.setConfigurer(this);
            condition.opt(ConditionOpt.getOpt(key));
            condition.value(map.get(key));
            conditions.add(condition);
        }
        return getBuilder();
    }


}