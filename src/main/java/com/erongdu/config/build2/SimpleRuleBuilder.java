package com.erongdu.config.build2;

import com.erongdu.config.condition.AbstractCondition;
import com.erongdu.config.condition.Condition;
import com.erongdu.config.condition.ConditionItem;
import com.erongdu.config.rule.RuleInfo;
import com.erongdu.config.rule2.AbstractRule;
import com.erongdu.config.rule2.Rule;
import com.erongdu.config.rule2.RuleBasic;
import com.erongdu.exception.RuleValueException;
import com.erongdu.utils.ConditionOpt;
import com.erongdu.utils.RulePolicy;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by syq on 2016/12/17.
 */
public abstract class SimpleRuleBuilder<H, T extends Rule> extends AbstractRuleBuilder<H, T> {


    private Class<H> oClazz;


    private RuleConfigurerAdapter<H, T, SimpleRuleBuilder<H, T>> ruleConfigurer;


    @SuppressWarnings("All")
    public SimpleRuleBuilder() {
        super();
        Type type = getClass().getGenericSuperclass();
        this.oClazz = (Class<H>) ((ParameterizedType) type).getActualTypeArguments()[0];
        this.ruleConfigurer = new SimpleRuleConfigurer<H, T, SimpleRuleBuilder<H, T>>();
        this.ruleConfigurer.setBuilder(this);
    }


    @Override
    @SuppressWarnings("All")
    protected T doBuild() throws Exception {
        RuleBasic ruleBasic = threadLocalRules.get();
        return (T) ruleBasic;
    }


    @Override
    public ConditionItem<H> newConditionItems() {
        return new ConditionItem<>();
    }

    @Override
    public RuleConfigurer<H> init(long id, String column, ConditionItem<H> conditionItem) throws IllegalAccessException
            , InstantiationException {

        RuleBasic<H> ruleBasic = concrete();
        ruleBasic.setColumn(column);
        ruleBasic.setId(id);
        ruleBasic.setConditions(itemTolist(conditionItem));
        ruleBasic.setValueType(oClazz);
        threadLocalRules.set(ruleBasic);
        return ruleConfigurer;
    }


    @SuppressWarnings("All")
    private List<Condition<H>> itemTolist(ConditionItem<H> conditionItem) {
        List<Condition<H>> conditions = new ArrayList<>();
        while (conditionItem.hasNext()) {
            Object[] objs = conditionItem.next();
            AbstractCondition<H> condition = new AbstractCondition<>();
            condition.opt(ConditionOpt.getOpt((String) objs[0]));
            condition.value((H) objs[1]);
            conditions.add(condition);
        }
        return conditions;
    }
}


