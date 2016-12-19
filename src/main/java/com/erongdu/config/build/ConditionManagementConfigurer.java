//package com.erongdu.config.build;
//
//import com.erongdu.config.condition.AbstractCondition;
//import com.erongdu.config.condition.Condition;
//import com.erongdu.config.condition.ConditionItem;
//import com.erongdu.config.rule.Rule;
//import com.erongdu.utils.ConditionOpt;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Condition 管理配置类
// * 该类将对具体的condition进行配置
// * 每个condition都会包括：具体的操作符(">")，具体待匹配的字段名称("age")，条件值("30")
// * Created by syq on 2016/12/9.
// */
//
//public final class ConditionManagementConfigurer<H, O extends Rule<H>, B extends RuleBuilder<H, O>> extends RuleConfigurerAdapter<H, O, B> {
//
//
//    private List<Condition<H>> conditions = new ArrayList<>();
//
//
//    List<Condition<H>> getConditions() {
//        return conditions;
//    }
//
//    public B createCondition(ConditionOpt opt, H value) throws InstantiationException, IllegalAccessException {
//        AbstractCondition<H> condition = new AbstractCondition<>();
//        condition.opt(opt);
//        condition.value(value);
//        conditions.add(condition);
//        return getBuilder();
//    }
//
//
//    @SuppressWarnings("All")
//    public B createConditions(ConditionItem<H> conditionItem) {
//        while (conditionItem.hasNext()){
//            Object[] objs = conditionItem.next();
//            AbstractCondition<H> condition = new AbstractCondition<>();
//            condition.opt(ConditionOpt.getOpt((String) objs[0]));
//            condition.value((H) objs[1]);
//            conditions.add(condition);
//        }
//        return getBuilder();
//    }
//
//
//}